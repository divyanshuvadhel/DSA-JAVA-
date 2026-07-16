# 📘 Assignment 2: Java Programming & DSA — Part II

> **Prerequisites:** Completion of Assignment 1 (Functions, Arrays, Linear/Binary Search, Bubble/Cyclic Sort)
> **Topics Covered:** String Manipulation, Recursion, Merge Sort, Bitwise Operators, Time & Space Complexity, Maths for DSA

---

## Section A: String Manipulation (Warm-up) — 15 Marks

### Q1. String Analyzer [5 Marks]
Write a Java program that takes a string input and performs the following operations:
- Count the total number of vowels and consonants
- Count the frequency of each character (case-insensitive)
- Check if the string is a palindrome
- Reverse the string without using built-in reverse methods

**Sample Input:** `"Hello World"`
**Sample Output:**
```
Vowels: 3, Consonants: 7
Frequency: h:1, e:1, l:3, o:2, w:1, r:1, d:1
Palindrome: false
Reversed: dlroW olleH
```

### Q2. String Compression [5 Marks]
Implement a method `compressString(String str)` that performs basic string compression using counts of repeated characters. For example, `"aabcccccaaa"` becomes `"a2b1c5a3"`. If the compressed string is not smaller than the original, return the original string.

### Q3. Anagram Checker [5 Marks]
Write a function `areAnagrams(String s1, String s2)` that determines if two strings are anagrams of each other (contain the same characters with the same frequencies). Optimize your solution to run in **O(n)** time.

---

## Section B: Recursion Fundamentals — 20 Marks

### Q4. Recursive Patterns [5 Marks]
Write a recursive method to print the following pattern for a given `n`:
```
n = 4:
****
***
**
*
```

Then write another recursive method to print:
```
n = 4:
*
**
***
****
```

### Q5. Recursive Array Operations [5 Marks]
Implement the following using **only recursion** (no loops):
- Find the sum of all elements in an array
- Find the maximum element in an array
- Check if an array is sorted in ascending order

### Q6. Advanced Recursion [10 Marks]
**a) Power Function:** Write `power(int base, int exp)` that calculates base^exp in **O(log n)** time using recursion.

**b) Tower of Hanoi:** Implement the Tower of Hanoi puzzle solver. Given `n` disks, print all the moves required and count the total number of moves. Prove that the minimum moves required is **2ⁿ - 1**.

**c) Subset Sum:** Given an array of integers and a target sum, determine if there exists a subset whose sum equals the target. Return all such subsets.

---

## Section C: Merge Sort & Divide and Conquer — 20 Marks

### Q7. Merge Sort Implementation [8 Marks]
Implement Merge Sort from scratch in Java with the following requirements:
- Sort an integer array in ascending order
- Count the number of **inversions** in the array during the merge process
- An inversion is a pair `(i, j)` where `i < j` and `arr[i] > arr[j]`

**Example:** For `[2, 4, 1, 3, 5]`, inversions are: `(2,1), (4,1), (4,3)` → **3 inversions**

**Time Complexity Analysis:** Explain why Merge Sort is **O(n log n)** in all cases and why it requires **O(n)** auxiliary space.

### Q8. Merge Two Sorted Arrays [4 Marks]
Given two sorted arrays, merge them into a single sorted array **without using extra space** (modify the first array if it has enough capacity). This is the core operation of Merge Sort—master it!

### Q9. Merge Sort Variations [8 Marks]
**a) Merge Sort for Linked List:** Implement Merge Sort for a singly linked list. Explain why Merge Sort is preferred over Quick Sort for linked lists.

**b) Counting Smaller Numbers:** Given an array `nums`, for each element `nums[i]`, count how many elements to its right are smaller than it. Use a modified Merge Sort approach to solve this in **O(n log n)** time.

---

## Section D: Time & Space Complexity Analysis — 15 Marks

### Q10. Complexity Analysis [8 Marks]
Analyze the time and space complexity for the following code snippets. Provide Big-O notation and briefly justify your answer.

**a)**
```java
void mystery(int n) {
    for (int i = 1; i <= n; i *= 2) {
        for (int j = 1; j <= n; j++) {
            System.out.println(i + ", " + j);
        }
    }
}
```

**b)**
```java
void recursiveMystery(int n) {
    if (n <= 1) return;
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
    recursiveMystery(n / 2);
    recursiveMystery(n / 2);
}
```

**c)**
```java
void fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);
}
```

### Q11. Sorting Algorithm Comparison [7 Marks]
Create a comparison table for all sorting algorithms you've learned so far:
- Bubble Sort, Selection Sort, Insertion Sort, Cyclic Sort, Merge Sort

Include: Best Case, Average Case, Worst Case, Space Complexity, and Stability.

**Discussion Question:** When would you choose Merge Sort over Quick Sort, and vice versa? Consider factors like stability, space constraints, and data characteristics.

---

## Section E: Bitwise Operators & Number System — 15 Marks

### Q12. Bitwise Operations [8 Marks]
**a) Odd or Even:** Write a method using bitwise operators to check if a number is odd or even.

**b) Find Unique:** Given an array where every element appears twice except one, find the unique element using XOR.

**c) Find Two Uniques:** Given an array where every element appears twice except two elements, find those two unique elements.

**d) Set Bit Count:** Write a function to count the number of set bits (1s) in the binary representation of a number. Optimize it using Brian Kernighan's algorithm.

### Q13. Number System Conversions [4 Marks]
Write functions to:
- Convert decimal to binary (return as string)
- Convert binary to decimal
- Convert decimal to any base (2-16)

### Q14. Bit Manipulation Tricks [3 Marks]
**a)** Check if a number is a power of 2 using bitwise operators.

**b)** Swap two numbers without using a temporary variable.

**c)** Find the rightmost set bit of a number.

---

## Section F: Maths for DSA — 10 Marks

### Q15. Mathematical Fundamentals [10 Marks]
**a) GCD & LCM:** Implement Euclidean algorithm for GCD. Then derive LCM from GCD. Find GCD of 48 and 18 step-by-step.

**b) Prime Numbers:** Implement Sieve of Eratosthenes to find all primes up to `n`. Optimize it to run in **O(n log log n)** time.

**c) Fast Exponentiation:** Implement modular exponentiation: `(base^exp) % mod` efficiently. This is crucial for competitive programming.

**d) Factorial Trailing Zeroes:** Given an integer `n`, return the number of trailing zeroes in `n!`. Do NOT compute the factorial directly.

---

## Section G: Integration Challenge — 5 Marks

### Q16. Final Challenge: The Ultimate Sorter
Build a Java program that:

1. **Input:** Takes an array of strings where each string represents a large number (up to 100 digits).
2. **Sorts** them using Merge Sort (since numbers are strings, standard comparison won't work directly)
3. **Searches:** After sorting, implement a recursive binary search to find if a given large number exists
4. **Analyzes:** Print the time complexity of your sorting and searching operations

**Constraints:**
- You cannot use `BigInteger` for sorting comparison
- Must handle numbers with leading zeros correctly
- Must be case-insensitive for any alphabetic characters

---

## 📋 Submission Guidelines

| Item | Details |
|------|---------|
| **Format** | Single Java file per question OR one project with multiple classes |
| **Naming** | `Assignment2_Q1.java`, `Assignment2_Q2.java`, etc. |
| **Comments** | Explain your approach and time/space complexity for each solution |
| **Test Cases** | Include at least 3 test cases per coding question |
| **Deadline** | As per course schedule |

---

## 🎯 Learning Objectives Checklist

By completing this assignment, you should be able to:
- [ ] Manipulate strings efficiently without built-in shortcuts
- [ ] Think recursively and identify base cases
- [ ] Implement and analyze Merge Sort thoroughly
- [ ] Calculate time/space complexity for any algorithm
- [ ] Use bitwise operators for optimization
- [ ] Apply mathematical concepts to solve DSA problems

---

## 💡 Hints & Tips

1. **For Q7 (Inversions):** Modify the merge step to count whenever an element from the right half is placed before elements remaining in the left half.

2. **For Q12 (Bitwise):** Remember that `n & (n-1)` clears the rightmost set bit. This is the foundation of Brian Kernighan's algorithm.

3. **For Q15d (Trailing Zeroes):** Count the number of times 5 appears in the prime factorization of numbers from 1 to n.

4. **For Q16:** Compare string numbers by length first, then lexicographically if lengths are equal.

---

> **"The only way to learn recursion is to learn recursion."** — Every CS Professor Ever

**Good luck! 🚀**
