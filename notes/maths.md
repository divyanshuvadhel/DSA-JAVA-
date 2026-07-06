# Number Theory & Algorithms - Complete Learning Notes

> **Source:** DSA Bootcamp Lecture  
> **Topics:** Prime Numbers, Sieve, Square Root, GCD/LCM, Modular Arithmetic, Diophantine Equations

---

## Table of Contents
1. [Prime Numbers](#1-prime-numbers)
2. [Sieve of Eratosthenes](#2-sieve-of-eratosthenes)
3. [Square Root Algorithms](#3-square-root-algorithms)
4. [Factors](#4-factors)
5. [GCD and HCF](#5-gcd-and-hcf)
6. [LCM](#6-lcm)
7. [Modular Arithmetic](#7-modular-arithmetic)
8. [Diophantine Equations](#8-diophantine-equations)
9. [Problem Solving Framework](#9-problem-solving-framework)

---

## 1. Prime Numbers

### What is a Prime Number?
A prime number is a natural number greater than 1 that has exactly two distinct positive divisors: **1 and itself**.

```
Examples: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47...
```

**Important:** 1 is NOT prime. It has only one divisor.

### 1.1 Naive Approach - Check all numbers from 2 to n-1

```java
boolean isPrime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i < n; i++) {
        if (n % i == 0) {
            return false;  // Found a divisor, not prime
        }
    }
    return true;  // No divisors found, it's prime
}
```

**Time Complexity:** O(n)  
**Space Complexity:** O(1)

**Why this is slow:** For n = 100, we check 98 numbers. For n = 1,000,000, we check ~1 million numbers.

---

### 1.2 Optimized Approach - Check up to Square Root of n

**Key Insight:** If n has a factor greater than sqrt(n), the other factor must be less than sqrt(n).

Example: For n = 36
- Factors: (1,36), (2,18), (3,12), (4,9), (6,6)
- Notice: After 6 (sqrt(36)), pairs just repeat in reverse

So we only need to check up to sqrt(n).

```java
boolean isPrime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i * i <= n; i++) {  // i goes up to sqrt(n)
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
```

**Time Complexity:** O(sqrt(n))  
**Space Complexity:** O(1)

**Example Walkthrough for n = 37:**
- Check i = 2: 37 % 2 = 1 (not divisible)
- Check i = 3: 37 % 3 = 1 (not divisible)
- Check i = 4: 37 % 4 = 1 (not divisible)
- Check i = 5: 37 % 5 = 2 (not divisible)
- Check i = 6: 6*6 = 36 <= 37, so check: 37 % 6 = 1 (not divisible)
- Next i = 7: 7*7 = 49 > 37, stop loop
- Return true - 37 is prime!

---

### 1.3 Further Optimization - 6k +/- 1 Pattern

**Observation:** All prime numbers greater than 3 can be written as either `6k + 1` or `6k - 1` (which is `6k + 5`).

Why? Consider numbers modulo 6:
- 6k + 0 = divisible by 6
- 6k + 1 = could be prime
- 6k + 2 = divisible by 2
- 6k + 3 = divisible by 3
- 6k + 4 = divisible by 2
- 6k + 5 = could be prime (same as 6k - 1)

So primes > 3 must be of form 6k +/- 1.

```java
boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;       // 2 and 3 are prime
    if (n % 2 == 0 || n % 3 == 0)  // Eliminate multiples of 2 and 3
        return false;

    // Check only numbers of form 6k +/- 1
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;
}
```

**Time Complexity:** O(sqrt(n)) - but about 3x faster in practice since we skip 2/3 of numbers.

---

## 2. Sieve of Eratosthenes

### What is it?
The Sieve of Eratosthenes is an ancient algorithm for finding **all prime numbers up to a given limit n**.

### How it works
1. Create a list of all numbers from 2 to n
2. Start with the first number (2) - it's prime
3. Mark all multiples of 2 as composite (not prime)
4. Move to the next unmarked number - it's prime
5. Mark all its multiples as composite
6. Repeat until you reach sqrt(n)
7. All unmarked numbers are prime

### Visualization
```
Initial:  [2] [3] [4] [5] [6] [7] [8] [9] [10] [11] [12] [13] [14] [15] [16] [17] [18] [19] [20]

Step 1: Mark multiples of 2
          [2] [3] [X] [5] [X] [7] [X] [9] [X]  [11] [X]  [13] [X]  [15] [X]  [17] [X]  [19] [X]

Step 2: Mark multiples of 3
          [2] [3] [X] [5] [X] [7] [X] [X] [X]  [11] [X]  [13] [X]  [X]  [X]  [17] [X]  [19] [X]

Step 3: Mark multiples of 5 (next unmarked after 3)
          (5*5=25 > 20, so we stop)

Primes found: 2, 3, 5, 7, 11, 13, 17, 19
```

### Code Implementation

```java
void sieveOfEratosthenes(int n) {
    // Create boolean array, initialize all as true
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);

    // 0 and 1 are not prime
    isPrime[0] = false;
    isPrime[1] = false;

    // Main algorithm
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            // Mark all multiples of i starting from i*i
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    // Print all primes
    System.out.print("Primes up to " + n + ": ");
    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) {
            System.out.print(i + " ");
        }
    }
}
```

### Why start marking from i*i?
All smaller multiples of i (like 2i, 3i, ..., (i-1)i) have already been marked by smaller primes.

Example for i = 5:
- 5*2 = 10 was marked by 2
- 5*3 = 15 was marked by 3
- 5*4 = 20 was marked by 2
- So we start from 5*5 = 25

### Time and Space Complexity

| Complexity | Value | Explanation |
|-----------|-------|-------------|
| Time | O(n log log n) | Sum of reciprocals of primes approximates log log n |
| Space | O(n) | Boolean array of size n+1 |

**Why O(n log log n)?**
The total work done is approximately:
```
n/2 + n/3 + n/5 + n/7 + ... (sum over all primes p <= n)
= n * (1/2 + 1/3 + 1/5 + 1/7 + ...)
= n * log(log n)   [by Mertens' theorem]
```

### Segmented Sieve (For Very Large n)
When n is extremely large (e.g., 10^12), normal sieve uses too much memory.

**Approach:**
1. Find all primes up to sqrt(n) using normal sieve
2. Divide range [1, n] into segments of size ~sqrt(n)
3. For each segment, mark multiples of primes found in step 1

---

## 3. Square Root Algorithms

### 3.1 Binary Search Approach

**Problem:** Find the largest integer x such that x^2 <= n

**Idea:** Use binary search on the answer.

```java
int integerSqrt(int n) {
    if (n == 0 || n == 1) return n;

    int start = 1;
    int end = n;
    int ans = 0;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        // Use division to avoid overflow (instead of mid * mid <= n)
        if (mid <= n / mid) {
            ans = mid;        // mid is a candidate, try for larger
            start = mid + 1;
        } else {
            end = mid - 1;    // mid is too large
        }
    }

    return ans;
}
```

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

**Example for n = 37:**
```
start=1, end=37, mid=19: 19 > 37/19(=1) -> too big, end=18
start=1, end=18, mid=9:  9 > 37/9(=4)  -> too big, end=8
start=1, end=8,  mid=4:  4 <= 37/4(=9) -> candidate, ans=4, start=5
start=5, end=8,  mid=6:  6 <= 37/6(=6) -> candidate, ans=6, start=7
start=7, end=8,  mid=7:  7 <= 37/7(=5) -> wait, 7 > 5, so end=6
Loop ends. Return ans = 6. (Since 6^2=36 <= 37, but 7^2=49 > 37)
```

---

### 3.2 Newton-Raphson Method

**Formula:**
```
x_{n+1} = 0.5 * (x_n + N / x_n)
```

**Intuition:** If your guess x is too big (x > sqrt(N)), then N/x is too small (N/x < sqrt(N)). Their average is closer to the true square root.

```java
double sqrtNewton(double n, double tolerance) {
    if (n == 0) return 0;

    double x = n;  // Initial guess
    double root;

    while (true) {
        root = 0.5 * (x + n / x);

        if (Math.abs(root - x) < tolerance) {
            break;  // Converged
        }
        x = root;
    }

    return root;
}
```

**Convergence: Quadratic!**
The number of correct digits roughly **doubles** with each iteration.

| Iteration | Guess for sqrt(2) | Correct Digits |
|-----------|------------------|----------------|
| x0 | 1.0 | 1 |
| x1 | 1.5 | 1 |
| x2 | 1.4167 | 3 |
| x3 | 1.4142157 | 7 |
| x4 | 1.41421356237 | 14 |

**Time Complexity:** O(log n) iterations (extremely fast in practice)  
**Space Complexity:** O(1)

**Historical Note:** This method was known to the ancient Babylonians (~1000 BCE) and is still used in calculators today.

---

## 4. Factors

### 4.1 Finding All Factors

**Key Insight:** If i is a factor of n, then n/i is also a factor. We only need to check up to sqrt(n).

```java
List<Integer> getFactors(int n) {
    List<Integer> factors = new ArrayList<>();

    for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
            factors.add(i);              // i is a factor
            if (i != n / i) {            // Avoid duplicates for perfect squares
                factors.add(n / i);      // n/i is also a factor
            }
        }
    }

    Collections.sort(factors);
    return factors;
}
```

**Time Complexity:** O(sqrt(n))  
**Space Complexity:** O(sqrt(n)) to store factors

**Example for n = 36:**
- i=1: 36%1=0, add 1 and 36
- i=2: 36%2=0, add 2 and 18
- i=3: 36%3=0, add 3 and 12
- i=4: 36%4=0, add 4 and 9
- i=5: 36%5=1, skip
- i=6: 36%6=0, add 6 (don't add 6 again since 6==36/6)
- i=7: 7*7=49 > 36, stop

Result: [1, 2, 3, 4, 6, 9, 12, 18, 36]

---

### 4.2 Prime Factorization

Breaking a number into its prime components.

```java
void primeFactorize(int n) {
    // Check divisibility by 2
    while (n % 2 == 0) {
        System.out.print(2 + " ");
        n /= 2;
    }

    // Check odd numbers from 3 to sqrt(n)
    for (int i = 3; i * i <= n; i += 2) {
        while (n % i == 0) {
            System.out.print(i + " ");
            n /= i;
        }
    }

    // If n is still > 1, it's a prime number
    if (n > 1) {
        System.out.print(n);
    }
}
```

**Example for n = 84:**
```
84 / 2 = 42
42 / 2 = 21
21 / 3 = 7
7 is prime

Prime factorization: 2 * 2 * 3 * 7 = 84
```

---

## 5. GCD and HCF

### What is GCD?
**GCD (Greatest Common Divisor)** or **HCF (Highest Common Factor)** is the largest number that divides both numbers.

```
GCD(12, 18) = 6
GCD(100, 35) = 5
GCD(7, 13) = 1     (coprime - no common factors except 1)
GCD(48, 18) = 6
```

### 5.1 Euclidean Algorithm

**Key Insight:** GCD(a, b) = GCD(b, a % b)

**Why this works:**
If g divides both a and b, then g also divides (a - b). By extension, g divides (a % b).

```java
// Recursive version
int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

// Iterative version (preferred - avoids stack overflow)
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
```

**Example: GCD(48, 18)**
```
gcd(48, 18)
  = gcd(18, 48 % 18) = gcd(18, 12)
  = gcd(12, 18 % 12) = gcd(12, 6)
  = gcd(6, 12 % 6)   = gcd(6, 0)
  = 6
```

**Time Complexity:** O(log(min(a, b)))  
**Space Complexity:** O(1) iterative, O(log(min(a,b))) recursive

**Why O(log n)?** The remainder reduces by at least half every two steps (Lame's Theorem).

---

### 5.2 Extended Euclidean Algorithm

Finds GCD(a, b) AND integers x, y such that:
```
a*x + b*y = GCD(a, b)
```

This is called **Bezout's Identity**.

```java
// Returns [g, x, y] where g = gcd(a,b) and a*x + b*y = g
int[] extendedGcd(int a, int b) {
    if (b == 0) {
        return new int[]{a, 1, 0};  // gcd = a, x = 1, y = 0
    }

    int[] vals = extendedGcd(b, a % b);
    int g = vals[0];
    int x1 = vals[1];
    int y1 = vals[2];

    int x = y1;
    int y = x1 - (a / b) * y1;

    return new int[]{g, x, y};
}
```

**Example: Extended GCD(30, 12)**
```
extendedGcd(30, 12):
  extendedGcd(12, 6):
    extendedGcd(6, 0) -> returns [6, 1, 0]

    For (12, 6): x = 0, y = 1 - (12/6)*0 = 1
    returns [6, 0, 1]

  For (30, 12): x = 1, y = 0 - (30/12)*1 = 0 - 2 = -2
  returns [6, 1, -2]

Verification: 30*1 + 12*(-2) = 30 - 24 = 6 = GCD(30, 12) ✓
```

---

## 6. LCM

### What is LCM?
**LCM (Least Common Multiple)** is the smallest positive number that is divisible by both numbers.

```
LCM(4, 6) = 12
LCM(5, 7) = 35
LCM(12, 18) = 36
```

### Formula
```
LCM(a, b) = (a * b) / GCD(a, b)
```

**Why this works:** The product a*b contains all factors of both numbers, but common factors are counted twice. Dividing by GCD removes the duplicate count.

```java
long lcm(int a, int b) {
    return ((long)a * b) / gcd(a, b);
}
```

**Important - Avoid Overflow:**
```java
// Better: divide before multiply
long lcm(int a, int b) {
    return ((long)a / gcd(a, b)) * b;
}
```

**Time Complexity:** O(log(min(a, b))) - same as GCD  
**Space Complexity:** O(1)

### LCM of an Array
```java
long lcmOfArray(int[] arr) {
    long result = arr[0];
    for (int i = 1; i < arr.length; i++) {
        result = lcm((int)result, arr[i]);
    }
    return result;
}
```

---

## 7. Modular Arithmetic

### 7.1 Basic Properties

For any integers a, b and positive integer m:

| Operation | Formula |
|-----------|---------|
| Addition | `(a + b) % m = ((a % m) + (b % m)) % m` |
| Subtraction | `(a - b) % m = ((a % m) - (b % m) + m) % m` |
| Multiplication | `(a * b) % m = ((a % m) * (b % m)) % m` |
| Division | Requires multiplicative inverse |

**Why add m in subtraction?** To ensure the result is non-negative.

Example: (3 - 7) % 5
- Direct: -4 % 5 = -4 (wrong in some languages)
- Correct: ((3 % 5) - (7 % 5) + 5) % 5 = (3 - 2 + 5) % 5 = 6 % 5 = 1

---

### 7.2 Multiplicative Inverse

The **modular multiplicative inverse** of a modulo m is a number x such that:
```
(a * x) % m = 1
```

**Denoted as:** a^(-1) mod m

**Condition:** Inverse exists if and only if GCD(a, m) = 1 (a and m are coprime)

---

#### Method 1: Extended Euclidean Algorithm (General)

```java
int modInverse(int a, int m) {
    int[] vals = extendedGcd(a, m);
    int g = vals[0];  // GCD
    int x = vals[1];  // Coefficient for a

    if (g != 1) {
        return -1;  // Inverse doesn't exist
    }

    // Ensure positive result
    return (x % m + m) % m;
}
```

**Example: Find inverse of 3 mod 11**
```
extendedGcd(3, 11):
  11 = 3*3 + 2
  3 = 2*1 + 1
  2 = 1*2 + 0

  Working backwards:
  1 = 3 - 2*1
  1 = 3 - (11 - 3*3)*1
  1 = 3*4 - 11*1

  So x = 4, y = -1
  Verification: (3 * 4) % 11 = 12 % 11 = 1 ✓

  Inverse of 3 mod 11 is 4.
```

---

#### Method 2: Fermat's Little Theorem (When m is prime)

If m is prime and a is not divisible by m:
```
a^(m-2) mod m = a^(-1) mod m
```

```java
int modInverseFermat(int a, int m) {
    // m must be prime
    return (int)power(a, m - 2, m);
}
```

**Why this works:** Fermat's Little Theorem states a^(m-1) ≡ 1 (mod m) when m is prime. Multiplying both sides by a^(-1): a^(m-2) ≡ a^(-1) (mod m).

---

### 7.3 Fast Exponentiation (Binary Exponentiation)

Compute (base^exp) % mod efficiently.

**Idea:** Break exponent into powers of 2 using binary representation.

```java
long power(long base, long exp, long mod) {
    long result = 1;
    base = base % mod;

    while (exp > 0) {
        // If exp is odd, multiply result by base
        if ((exp & 1) == 1) {
            result = (result * base) % mod;
        }

        // Square the base and halve the exponent
        base = (base * base) % mod;
        exp >>= 1;  // exp = exp / 2
    }

    return result;
}
```

**Example: Compute 3^13 % 7**
```
13 in binary: 1101

Step 1: exp=13 (1101), exp is odd
  result = 1 * 3 = 3
  base = 3*3 = 9 % 7 = 2
  exp = 6

Step 2: exp=6 (110), exp is even
  result = 3 (unchanged)
  base = 2*2 = 4
  exp = 3

Step 3: exp=3 (11), exp is odd
  result = 3 * 4 = 12 % 7 = 5
  base = 4*4 = 16 % 7 = 2
  exp = 1

Step 4: exp=1 (1), exp is odd
  result = 5 * 2 = 10 % 7 = 3
  base = 2*2 = 4
  exp = 0

Final result: 3
Verification: 3^13 = 1594323, 1594323 % 7 = 3 ✓
```

**Time Complexity:** O(log exp)  
**Space Complexity:** O(1)

---

## 8. Diophantine Equations

### What are they?
Equations where we seek **integer solutions**.

### 8.1 Linear Diophantine Equation
```
a*x + b*y = c
```

**Has integer solutions if and only if:** GCD(a, b) divides c.

### 8.2 Finding Solutions

**Step 1:** Find g = GCD(a, b) using Extended Euclidean Algorithm

**Step 2:** Check if c % g == 0. If not, no solution exists.

**Step 3:** Get initial solution (x0, y0) from Extended GCD for a*x + b*y = g, then multiply by c/g.

**Step 4:** General solution:
```
x = x0 + (b/g)*t
y = y0 - (a/g)*t
```
where t is any integer.

```java
// Returns true if solution exists, fills x and y with one solution
boolean solveDiophantine(int a, int b, int c, int[] solution) {
    int[] vals = extendedGcd(Math.abs(a), Math.abs(b));
    int g = vals[0];
    int x0 = vals[1];
    int y0 = vals[2];

    if (c % g != 0) {
        return false;  // No solution
    }

    // Scale to get solution for a*x + b*y = c
    x0 *= (c / g);
    y0 *= (c / g);

    // Adjust signs if a or b were negative
    if (a < 0) x0 = -x0;
    if (b < 0) y0 = -y0;

    solution[0] = x0;
    solution[1] = y0;
    return true;
}
```

---

### 8.3 Classic Application: Water Jug Problem

**Problem:** You have two jugs with capacities a and b. Can you measure exactly c liters?

**Solution:** Possible if and only if:
1. c is a multiple of GCD(a, b)
2. c <= max(a, b)

```java
boolean canMeasure(int a, int b, int c) {
    if (c == 0) return true;
    if (c > a && c > b) return false;
    return c % gcd(a, b) == 0;
}
```

**Example: Die Hard 3 (3-gallon and 5-gallon jugs, measure 4 gallons)**
```
GCD(3, 5) = 1, and 4 % 1 = 0, so YES it's possible!

One way:
1. Fill 5-gallon jug: (0, 5)
2. Pour into 3-gallon: (3, 2)
3. Empty 3-gallon: (0, 2)
4. Pour 5-gallon into 3-gallon: (2, 0)
5. Fill 5-gallon: (2, 5)
6. Pour into 3-gallon until full: (3, 4)
7. Done! 5-gallon jug has exactly 4 gallons.
```

---

## 9. Problem Solving Framework

### 9.1 Quick Reference Table

| Problem Type | Algorithm | Time Complexity |
|-------------|-----------|----------------|
| Is N prime? (single query) | Check up to sqrt(n) | O(sqrt(n)) |
| All primes up to N | Sieve of Eratosthenes | O(n log log n) |
| Find sqrt(N) | Binary Search | O(log n) |
| Precise sqrt(N) | Newton-Raphson | O(log n) |
| GCD of two numbers | Euclidean Algorithm | O(log min(a,b)) |
| ax + by = c (integer solutions) | Extended GCD | O(log min(a,b)) |
| a^b % mod | Fast Exponentiation | O(log b) |
| a^(-1) % mod (inverse) | Extended GCD or Fermat | O(log mod) |
| LCM of two numbers | (a*b)/GCD(a,b) | O(log min(a,b)) |

---

### 9.2 Common Mistakes to Avoid

1. **Integer Overflow**
   ```java
   // WRONG: a * b might overflow
   long lcm = (a * b) / gcd(a, b);

   // CORRECT: divide first
   long lcm = ((long)a / gcd(a, b)) * b;
   ```

2. **Negative Modulo Results**
   ```java
   // WRONG in some languages
   int result = (a - b) % mod;  // Might be negative

   // CORRECT
   int result = ((a % mod) - (b % mod) + mod) % mod;
   ```

3. **Edge Cases**
   - n = 0, n = 1 for prime checks
   - a = 0 or b = 0 for GCD
   - mod = 1 (everything is 0)

4. **Forgetting to Precompute**
   - If you have multiple prime queries, use Sieve instead of checking each number individually

---

### 9.3 Practice Problems

| Problem | Concept |
|---------|---------|
| Count primes in range [L, R] | Segmented Sieve |
| Find kth prime | Sieve + Binary Search |
| Modular exponentiation | Fast Exponentiation |
| Compute nCr % mod | Modular inverse + factorial precomputation |
| Water jug problem | Diophantine equation |
| GCD of array | Iterative GCD |
| LCM of array | Iterative LCM |

---

## Summary

This lecture covered the fundamental building blocks of number theory used in competitive programming and technical interviews:

1. **Prime checking** is O(sqrt(n)) for single queries, but use Sieve for ranges
2. **Square roots** can be found via Binary Search or Newton-Raphson (very fast convergence)
3. **GCD** is the workhorse - learn Euclidean algorithm by heart
4. **Extended GCD** unlocks modular inverses and Diophantine equations
5. **Modular arithmetic** is essential for handling large numbers and cryptography
6. **Diophantine equations** model real problems like the water jug puzzle

Master these before moving to advanced topics like Segment Trees, Graph Algorithms, or Dynamic Programming.
