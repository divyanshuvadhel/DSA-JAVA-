# Java String Advanced Notes 

---

## 1. String Internals & Memory

### String Class Internals
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    private final byte[] value;      // Java 9+: byte[] + coder
    private final byte coder;        // LATIN1 (1 byte) or UTF16 (2 bytes)
    private int hash;                // Cached hash code
}
```

### Java 9+ Compact Strings
- Before Java 9: `char[]` (2 bytes per char)
- Java 9+: `byte[]` + `coder` flag
    - LATIN1 = 1 byte (ASCII)
    - UTF16 = 2 bytes (non-ASCII)
- Benefit: ~50% memory reduction for ASCII strings

### Memory Layout
```
String Object: 12 bytes header + 4 ref + 4 hash + 4 padding = 24 bytes
byte[] Object: 16 bytes header + length * 1 or 2 bytes
```

### Key Interview Points
- String is reference type but behaves like value type
- Stored in Heap (not stack)
- Empty string "" is valid object with length 0

---

## 2. Why String is Immutable?

| Reason | Explanation |
|--------|-------------|
| String Pool | Enables reuse; mutable strings would corrupt pool |
| Security | Used in class loading, network connections, file paths |
| Hash Caching | hashCode() computed once, reused (critical for HashMap keys) |
| Thread Safety | No synchronization needed |
| Performance | Safe to pass around without defensive copies |

### Security Example
```java
// If String were mutable, this would be dangerous:
String filePath = "/safe/path";
// Another thread could modify it -> security breach
openFile(filePath);
```

### Interview Tip
> "String immutability is a design choice, not a language limitation. It trades write performance for read performance, security, and correctness."

---

## 3. StringBuilder vs StringBuffer

| Feature | StringBuilder | StringBuffer |
|---------|--------------|--------------|
| Thread-Safe | No | Yes (synchronized) |
| Performance | Faster | Slower (lock overhead) |
| Introduced | Java 5 | Java 1.0 |
| Default Capacity | 16 chars | 16 chars |

### Internal Working
```java
abstract class AbstractStringBuilder {
    byte[] value;
    int count;

    // Capacity doubles: (oldCapacity * 2) + 2
    private int newCapacity(int minCapacity) {
        int newCapacity = (value.length << 1) + 2;
        return newCapacity - minCapacity < 0 ? minCapacity : newCapacity;
    }
}
```

### Critical Interview Code
```java
// BAD: O(n^2) time, creates n StringBuilder objects
String result = "";
for (String s : list) {
    result += s;  // Each loop: new StringBuilder, append, toString()
}

// GOOD: O(n) with single buffer
StringBuilder sb = new StringBuilder();
for (String s : list) {
    sb.append(s);
}
String result = sb.toString();
```

### StringJoiner (Java 8+)
```java
String joined = String.join(", ", list);

StringJoiner sj = new StringJoiner(", ", "[", "]");
sj.add("a").add("b");
// Output: [a, b]
```

---

## 4. String Methods - Time Complexity

| Method | Time | Space | Notes |
|--------|------|-------|-------|
| charAt(i) | O(1) | O(1) | Direct array access |
| length() | O(1) | O(1) | Stored in field |
| substring(begin, end) | O(1) | O(1) | Java 7+ (shares array copy) |
| indexOf(String) | O(n*m) | O(1) | Naive search |
| contains(String) | O(n*m) | O(1) | Uses indexOf |
| split(String) | O(n) | O(n) | Uses regex; be careful |
| replace(char, char) | O(n) | O(n) | Creates new String |
| toLowerCase() | O(n) | O(n) | Locale-sensitive! |
| trim() | O(n) | O(n) | Removes <= U+0020 |
| strip() | O(n) | O(n) | Java 11; Unicode whitespace |
| isBlank() | O(n) | O(1) | Java 11; empty/whitespace |
| lines() | O(n) | O(1) | Java 11; Stream<String> |
| repeat(int) | O(n*count) | O(n*count) | Java 11 |

### Danger Zone: split() with Regex
```java
// DANGER: split uses regex!
"a.b.c".split("\\.");        // ["a", "b", "c"] - need to escape
"a:b:".split(":");           // ["a", "b"] - trailing empty DISCARDED!
"a:b:".split(":", -1);       // ["a", "b", ""] - keep all
```

### Turkish Locale Bug (Famous!)
```java
// BUG: Turkish locale changes 'I' to dotless i
String title = "TITLE";
title.toLowerCase(new Locale("tr", "TR")); // "title" [WRONG]

// ALWAYS specify Locale.ROOT for internal operations
title.toLowerCase(Locale.ROOT); // "title" [CORRECT]
```

### Java 11+ Modern Methods
```java
"  \t  ".isBlank();              // true
"\u2003hello\u2003".strip();    // "hello" (Unicode aware)
"line1\nline2".lines().count();  // 2
"-".repeat(10);                   // "----------"
```

---

## 5. String Comparison

```java
String a = new String("hello");
String b = new String("hello");
String c = "hello";
String d = "hello";

a == b;     // false (different heap objects)
a == c;     // false (heap vs pool)
c == d;     // true (same pool reference)
a.equals(b); // true (content same)

// Null-safe comparison
Objects.equals(str1, str2);  // Safe even if null
```

---

## 6. String Pool & Interning

```java
// Literal -> automatically interned
String a = "hello";

// new -> heap only, NOT interned
String b = new String("hello");

// Manual interning
String c = b.intern();  // Returns pool reference

a == c;  // true
b == a;  // false
```

### When to Use intern()?
- Pros: Saves memory for many duplicate strings
- Cons:
    - Pool in Metaspace (can cause OOM)
    - Native call (synchronized, slow)
    - Only beneficial with MANY duplicates

### Interview Trap
```java
String s1 = "ja" + "va";        // Compile-time constant -> "java" in pool
String s2 = "java";
s1 == s2;  // true (compiler optimizes literal concatenation)

String s3 = new String("ja") + new String("va"); // Runtime
String s4 = "java";
s3 == s4;  // false (s3 is heap object)
s3.intern() == s4;  // true
```

---

## 7. Performance Optimization

### 1. Avoid Unnecessary String Creation
```java
// BAD - creates 2 objects
String s = new String("literal");

// GOOD - 1 object, pooled
String s = "literal";
```

### 2. Use StringBuilder for Loops
```java
// BAD: O(n^2)
String result = "";
for (int i = 0; i < n; i++) result += items[i];

// GOOD: O(n)
StringBuilder sb = new StringBuilder(n * avgLength);
for (String item : items) sb.append(item);
```

### 3. Pre-size Your Builder
```java
StringBuilder sb = new StringBuilder(
    list.stream().mapToInt(String::length).sum()
);
```

### 4. Use charAt() Instead of substring() for Single Chars
```java
// BAD: creates new String
char c = str.substring(5, 6).charAt(0);

// GOOD: O(1), no allocation
char c = str.charAt(5);
```

### 5. Avoid String.format() in Hot Paths
```java
// SLOW: parses format string every time
String s = String.format("%s=%s", key, value);

// FAST: direct concatenation
String s = key + "=" + value;
```

---

## 8. Common Patterns & Algorithms

### Pattern 1: Two Pointers
```java
// Reverse string in-place
public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right) {
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
    }
}
```

### Pattern 2: Sliding Window
```java
// Longest substring without repeating characters
public int lengthOfLongestSubstring(String s) {
    int[] map = new int[128];
    int left = 0, maxLen = 0;
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        left = Math.max(left, map[c]);
        maxLen = Math.max(maxLen, right - left + 1);
        map[c] = right + 1;
    }
    return maxLen;
}
```

### Pattern 3: KMP Algorithm
```java
// O(n + m) string matching
public int[] computeLPS(String pat) {
    int[] lps = new int[pat.length()];
    int len = 0, i = 1;
    while (i < pat.length()) {
        if (pat.charAt(i) == pat.charAt(len)) {
            lps[i++] = ++len;
        } else if (len != 0) {
            len = lps[len - 1];
        } else {
            lps[i++] = 0;
        }
    }
    return lps;
}
```

### Pattern 4: Trie (Prefix Tree)
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
}
```

### Pattern 5: Rolling Hash (Rabin-Karp)
```java
public boolean rabinKarp(String text, String pattern) {
    int d = 256, q = 101;
    int h = 1, tHash = 0, pHash = 0;

    for (int i = 0; i < pattern.length() - 1; i++)
        h = (h * d) % q;

    for (int i = 0; i < pattern.length(); i++) {
        pHash = (d * pHash + pattern.charAt(i)) % q;
        tHash = (d * tHash + text.charAt(i)) % q;
    }

    for (int i = 0; i <= text.length() - pattern.length(); i++) {
        if (pHash == tHash && text.substring(i, i + pattern.length()).equals(pattern))
            return true;
        if (i < text.length() - pattern.length()) {
            tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + pattern.length())) % q;
            if (tHash < 0) tHash += q;
        }
    }
    return false;
}
```

### Pattern 6: Expand Around Center (Palindrome)
```java
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expand(s, i, i);      // Odd
        int len2 = expand(s, i, i + 1);  // Even
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--; right++;
    }
    return right - left - 1;
}
```

---

## 9. LeetCode Practice - One Question Per Topic

### Topic 1: Two Pointers
**LeetCode 344 - Reverse String**
- Reverse string in-place using char array
- Pattern: Two pointers from ends

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
```

### Topic 2: Sliding Window
**LeetCode 3 - Longest Substring Without Repeating Characters**
- Find longest substring with all unique chars
- Pattern: Expand right, contract left when duplicate found

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, map[c]);
            maxLen = Math.max(maxLen, right - left + 1);
            map[c] = right + 1;
        }
        return maxLen;
    }
}
```

### Topic 3: String Matching (KMP)
**LeetCode 28 - Find the Index of the First Occurrence in a String**
- Implement strstr() / indexOf()
- Pattern: KMP for O(n+m) or brute force O(n*m)

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeLPS(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if (j == needle.length()) return i - j;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    private int[] computeLPS(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0, i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
```

### Topic 4: Trie
**LeetCode 208 - Implement Trie (Prefix Tree)**
- Insert, search, startsWith operations
- Pattern: Tree with 26 children per node

```java
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }
}
```

### Topic 5: Palindrome
**LeetCode 5 - Longest Palindromic Substring**
- Find longest palindrome substring
- Pattern: Expand around center (O(n^2)) or Manacher's (O(n))

```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }
        return right - left - 1;
    }
}
```

### Topic 6: Anagram / Frequency Count
**LeetCode 49 - Group Anagrams**
- Group strings that are anagrams
- Pattern: Sort string as key OR frequency count as key

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
```

### Topic 7: Backtracking
**LeetCode 17 - Letter Combinations of a Phone Number**
- Generate all letter combinations from digits
- Pattern: DFS with mapping

```java
class Solution {
    private static final String[] MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder sb, List<String> result) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = MAPPING[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

### Topic 8: Dynamic Programming
**LeetCode 72 - Edit Distance**
- Minimum operations to convert word1 to word2
- Pattern: 2D DP table

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
                                   Math.min(dp[i][j - 1],     // insert
                                            dp[i - 1][j]));   // delete
                }
            }
        }
        return dp[m][n];
    }
}
```

### Topic 9: Stack
**LeetCode 20 - Valid Parentheses**
- Check if string has valid bracket pairs
- Pattern: Stack for matching

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
```

### Topic 10: Greedy
**LeetCode 316 - Remove Duplicate Letters**
- Remove duplicates so every letter appears once, result is smallest lexicographical
- Pattern: Monotonic stack + frequency count

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (inStack[c - 'a']) continue;

            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        return sb.toString();
    }
}
```

### Topic 11: String Parsing / Math
**LeetCode 227 - Basic Calculator II**
- Evaluate expressions with +, -, *, /
- Pattern: Stack or single pass with last number

```java
class Solution {
    public int calculate(String s) {
        int num = 0, last = 0, result = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (op == '+') {
                    result += last;
                    last = num;
                } else if (op == '-') {
                    result += last;
                    last = -num;
                } else if (op == '*') {
                    last = last * num;
                } else if (op == '/') {
                    last = last / num;
                }
                op = c;
                num = 0;
            }
        }
        return result + last;
    }
}
```

### Topic 12: Rabin-Karp / Rolling Hash
**LeetCode 1044 - Longest Duplicate Substring**
- Find longest substring that appears at least twice
- Pattern: Binary search + rolling hash

```java
class Solution {
    private static final long MOD = (1L << 31) - 1;
    private static final long BASE = 256;

    public String longestDupSubstring(String s) {
        int left = 1, right = s.length();
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = search(s, mid);
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private String search(String s, int len) {
        long hash = 0, power = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + s.charAt(i)) % MOD;
            if (i > 0) power = (power * BASE) % MOD;
        }

        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(hash, new ArrayList<>(Arrays.asList(0)));

        for (int i = len; i < s.length(); i++) {
            hash = ((hash - s.charAt(i - len) * power % MOD + MOD) % MOD * BASE + s.charAt(i)) % MOD;
            if (map.containsKey(hash)) {
                String sub = s.substring(i - len + 1, i + 1);
                for (int idx : map.get(hash)) {
                    if (s.substring(idx, idx + len).equals(sub)) {
                        return sub;
                    }
                }
            }
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(i - len + 1);
        }
        return null;
    }
}
```

---

## 10. FAANG Interview Questions

### Q1: Why is String immutable in Java?
**Answer:**
1. **String Pool**: Enables reuse; mutable strings would corrupt the pool
2. **Security**: Used in class loading, network connections, file paths
3. **Hash Caching**: hashCode() computed once, reused (critical for HashMap keys)
4. **Thread Safety**: No synchronization needed
5. **Performance**: Safe to pass around without defensive copies

### Q2: What is the difference between String, StringBuilder, and StringBuffer?
**Answer:**
- **String**: Immutable, thread-safe (by immutability), stored in pool
- **StringBuilder**: Mutable, NOT thread-safe, faster (no synchronization)
- **StringBuffer**: Mutable, thread-safe (synchronized), slower

### Q3: What happens when you do `String s = new String("hello")`?
**Answer:**
- Creates 2 objects: one in String Pool ("hello" literal), one in Heap (new String)
- `s` references the heap object
- `s.intern()` returns the pool reference

### Q4: How does `substring()` work in Java 7+ vs Java 6?
**Answer:**
- **Java 6**: Shared the original char[] (caused memory leaks for large strings)
- **Java 7+**: Creates a new char[] copy (O(n) time, O(n) space, but no memory leak)

### Q5: What is the output of:
```java
String s1 = "ja" + "va";
String s2 = "java";
System.out.println(s1 == s2);

String s3 = new String("ja") + new String("va");
String s4 = "java";
System.out.println(s3 == s4);
```
**Answer:**
- `true` - compile-time constant optimization
- `false` - runtime concatenation creates heap object

### Q6: How to reverse a String in Java?
**Answer:**
```java
// Using StringBuilder
new StringBuilder(s).reverse().toString();

// In-place (char array)
char[] chars = s.toCharArray();
for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
    char temp = chars[i]; chars[i] = chars[j]; chars[j] = temp;
}
```

### Q7: How to check if two Strings are anagrams?
**Answer:**
```java
// O(n) time, O(1) space (for fixed charset)
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) count[c - 'a']--;
    for (int n : count) if (n != 0) return false;
    return true;
}
```

### Q8: What is the time complexity of `String.indexOf()`?
**Answer:**
- O(n * m) where n = text length, m = pattern length
- Uses naive search (not KMP)
- For repeated searches, use KMP or Rabin-Karp

### Q9: How does `String.hashCode()` work?
**Answer:**
```java
// s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        for (int i = 0; i < value.length; i++) {
            h = 31 * h + value[i];
        }
        hash = h;
    }
    return h;
}
```
- Uses 31 because it's prime and `31 * i == (i << 5) - i` (fast)
- Cached after first computation

### Q10: What is String Deduplication?
**Answer:**
- JVM flag: `-XX:+UseStringDeduplication`
- G1GC feature (Java 8u20+)
- Automatically removes duplicate char[] arrays during GC
- Different from interning - doesn't change String references

---

## Quick Reference Cheat Sheet

```
String Creation:
  "literal"     -> Pool (interned)
  new String()  -> Heap (not interned)
  .intern()     -> Move to pool

Concatenation:
  + (compile-time)  -> Optimized by compiler
  + (runtime)       -> StringBuilder internally
  Loop +            -> O(n^2) - NEVER DO THIS
  StringBuilder     -> O(n) - USE THIS

Comparison:
  ==        -> Reference equality
  .equals() -> Content equality
  .compareTo() -> Lexicographic order

Key Methods:
  charAt(i)     -> O(1)
  substring()   -> O(1) Java 7+, O(n) Java 6
  indexOf()     -> O(n*m)
  split()       -> O(n), uses regex
  replace()     -> O(n)
  toLowerCase() -> O(n), locale-sensitive

Patterns:
  Two Pointers     -> Reverse, Palindrome
  Sliding Window   -> Substring problems
  KMP              -> String matching
  Trie             -> Prefix problems
  Rolling Hash     -> Duplicate substring
  DP               -> Edit distance, interleaving
  Stack            -> Parentheses, duplicates
  Greedy           -> Remove duplicates, reorganize
```
