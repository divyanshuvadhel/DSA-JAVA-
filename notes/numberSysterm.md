# Number Systems & Bitwise Operators 

> **Topics Covered:** Number Systems, Bitwise Operators, Conversions, Negative Numbers, Range Calculation, Bit Manipulation Tricks

---

## 1. Introduction to Number Systems

### Why Number Systems Matter in Computing
- Computers internally use **Binary (Base-2)** because they operate using electrical signals (ON = 1, OFF = 0).
- Programming languages convert human-readable code into machine language (binary).
- Understanding number systems is essential for:
    - Low-level programming
    - Memory optimization
    - Bitwise operations
    - Technical interviews

### Common Number Systems

| System | Base | Digits Used | Example |
|--------|------|-------------|---------|
| **Binary** | 2 | 0, 1 | `1010` |
| **Octal** | 8 | 0-7 | `17` |
| **Decimal** | 10 | 0-9 | `25` |
| **Hexadecimal** | 16 | 0-9, A-F | `1F` |

**Key Insight:** Any number can be represented in any base. The value depends on the position (place value) of each digit.

---

## 2. Bitwise Operators

Bitwise operators work directly on the binary representation of numbers at the bit level. They are extremely fast because they operate at the hardware level.

### 2.1 Basic Bitwise Operators

| Operator | Symbol | Name | Description |
|----------|--------|------|-------------|
| **AND** | `&` | Bitwise AND | Result is `1` only if BOTH bits are `1` |
| **OR** | `|` | Bitwise OR | Result is `1` if AT LEAST ONE bit is `1` |
| **XOR** | `^` | Bitwise XOR | Result is `1` if bits are DIFFERENT |
| **NOT** | `~` | Bitwise Complement | Inverts all bits (`0` -> `1`, `1` -> `0`) |
| **Left Shift** | `<<` | Left Shift | Shifts bits to the left (multiplies by 2) |
| **Right Shift** | `>>` | Right Shift | Shifts bits to the right (divides by 2) |

### 2.2 Truth Table

| A | B | A & B | A OR B | A ^ B | ~A |
|---|---|-------|--------|-------|-----|
| 0 | 0 | 0 | 0 | 0 | 1 |
| 0 | 1 | 0 | 1 | 1 | 1 |
| 1 | 0 | 0 | 1 | 1 | 0 |
| 1 | 1 | 1 | 1 | 0 | 0 |

### 2.3 Important Properties

- **AND with 1:** Preserves the bit (used for masking/checking specific bits)
- **AND with 0:** Clears the bit
- **OR with 1:** Sets the bit to 1
- **OR with 0:** Preserves the bit
- **XOR with 1:** Toggles (flips) the bit
- **XOR with 0:** Preserves the bit
- **XOR with itself:** Results in 0 (`a ^ a = 0`)
- **XOR is commutative & associative:** `a ^ b ^ a = b`

### 2.4 Shift Operators Explained

**Left Shift (`<<`)**
- Shifts all bits to the left by specified positions
- Equivalent to multiplying by `2^n`
- Example: `5 << 1` -> `101` -> `1010` = `10` (5 * 2)
- Example: `5 << 2` -> `101` -> `10100` = `20` (5 * 4)

**Right Shift (`>>`)**
- Shifts all bits to the right by specified positions
- Equivalent to integer division by `2^n`
- Example: `10 >> 1` -> `1010` -> `101` = `5` (10 / 2)
- Example: `10 >> 2` -> `1010` -> `10` = `2` (10 / 4)

---

## 3. Number System Conversions

### 3.1 Decimal to Binary (Division Method)
To convert decimal to any base:
1. Divide the number by the base
2. Record the **remainder**
3. Update the number to the **quotient**
4. Repeat until quotient becomes 0
5. Read remainders in **reverse order**

**Example: Convert 17 to Binary**
```
17 / 2 = 8 remainder 1
8  / 2 = 4 remainder 0
4  / 2 = 2 remainder 0
2  / 2 = 1 remainder 0
1  / 2 = 0 remainder 1

Reading remainders bottom-up: 10001
So, 17 in decimal = 10001 in binary
```

### 3.2 Binary to Decimal (Expansion Method)
Multiply each bit by `2^position` (starting from 0 on the right) and sum.

**Example: Convert 1010 to Decimal**
```
1*2^3 + 0*2^2 + 1*2^1 + 0*2^0
= 8 + 0 + 2 + 0
= 10
```

### 3.3 Any Base to Decimal
General formula: `(d_n ... d_2 d_1 d_0)_b = d_n*b^n + ... + d_1*b^1 + d_0*b^0`

**Example: Convert (101) base 5 to Decimal**
```
1*5^2 + 0*5^1 + 1*5^0 = 25 + 0 + 1 = 26
```

### 3.4 Decimal to Any Base
Continuously divide by the target base and collect remainders.

---

## 4. Negative Numbers in Binary

Computers need to represent negative numbers. Three main methods exist, but **2's Complement** is the standard.

### 4.1 1's Complement
- Simply invert all bits
- Problem: Has two representations for zero (`+0` and `-0`)
- Not used in modern systems

### 4.2 2's Complement (Standard Method)
- Step 1: Find binary representation of the positive number
- Step 2: Invert all bits (1's complement)
- Step 3: Add `1` to the result

**Example: Represent -10 in 8-bit binary**
```
+10 in binary:  00001010
1's complement: 11110101
Add 1:          11110101 + 1 = 11110110

So, -10 in 2's complement (8-bit) = 11110110
```

### 4.3 Most Significant Bit (MSB) as Sign Bit
- In signed number representation, the **leftmost bit** indicates the sign:
    - `0` = Positive number
    - `1` = Negative number
- The remaining bits represent the magnitude.

---

## 5. Range of Numbers

### 5.1 Formula for n-bit Signed Numbers (2's Complement)
For an **n-bit** signed integer using 2's complement:

```
Range = [ -2^(n-1) , 2^(n-1) - 1 ]
```

| Bits | Min Value | Max Value | Total Unique Numbers |
|------|-----------|-----------|----------------------|
| 8-bit | -128 | +127 | 256 |
| 16-bit | -32,768 | +32,767 | 65,536 |
| 32-bit | -2,147,483,648 | +2,147,483,647 | 4,294,967,296 |
| 64-bit | -9.2 * 10^18 | +9.2 * 10^18 | ~1.8 * 10^19 |

### 5.2 Why Asymmetric Range?
- Total numbers with n bits = `2^n`
- One pattern (`100...0`) is used for `-2^(n-1)` (most negative)
- Zero occupies one pattern in the positive side
- Therefore: one more negative number than positive numbers

### 5.3 Unsigned Range
For **n-bit unsigned** numbers: `[0, 2^n - 1]`

---

## 6. Bit Manipulation Interview Tricks & Problems

### 6.1 Check if Number is Power of 2
A number that is a power of 2 has exactly **one bit set** in binary.
```
Powers of 2: 1(1), 2(10), 4(100), 8(1000), 16(10000)...
```

**Trick:** `n & (n - 1) == 0` (for n > 0)
- Example: `n = 8` (1000), `n-1 = 7` (0111)
- `1000 & 0111 = 0000` -> Yes, power of 2!

```python
def is_power_of_two(n):
    return n > 0 and (n & (n - 1)) == 0
```

### 6.2 Find the Single Number (Odd Occurrence)
Given an array where every number appears **twice** except one, find the unique number.

**Trick:** XOR all elements. Since `a ^ a = 0` and XOR is commutative:
```python
def find_single(arr):
    result = 0
    for num in arr:
        result ^= num
    return result
# Time: O(n), Space: O(1)
```

### 6.3 Find Rightmost Set Bit
**Trick:** `n & (-n)` isolates the rightmost set bit.
- Example: `n = 12` (1100), `-n` in 2's complement
- `n & (-n)` gives `4` (0100) - the value of the rightmost set bit

### 6.4 Reset Rightmost Set Bit
**Trick:** `n & (n - 1)` clears the rightmost set bit.
- Example: `n = 12` (1100), `n-1 = 11` (1011)
- `1100 & 1011 = 1000` (8)

### 6.5 Count Set Bits (Population Count)
Repeatedly clear the rightmost set bit:
```python
def count_set_bits(n):
    count = 0
    while n:
        n = n & (n - 1)
        count += 1
    return count
```

### 6.6 Swap Two Numbers Without Temporary Variable
Using XOR:
```python
a = a ^ b
b = a ^ b  # b becomes original a
a = a ^ b  # a becomes original b
```

### 6.7 Check if i-th Bit is Set
```python
def check_bit(n, i):
    return (n & (1 << i)) != 0
```

### 6.8 Set i-th Bit
```python
def set_bit(n, i):
    return n | (1 << i)
```

### 6.9 Clear i-th Bit
```python
def clear_bit(n, i):
    return n & ~(1 << i)
```

### 6.10 Toggle i-th Bit
```python
def toggle_bit(n, i):
    return n ^ (1 << i)
```

---

## 7. Advanced Interview Problems

### 7.1 Find Number Appearing Once (Others Appear Thrice)
When every number appears 3 times except one, we need to count bits across all numbers.
- Sum bits at each position across all numbers
- If a bit sum is not divisible by 3, that bit belongs to the unique number
- Time: O(32 * n) = O(n), Space: O(1)

### 7.2 Magic Numbers
A magic number is defined as a number that can be expressed as a sum of unique powers of 5, where each power can be used at most once (similar to binary representation but with base 5).

**Sequence:** 5, 25, 30(25+5), 125, 130(125+5), 150(125+25), 155(125+25+5)...

### 7.3 Pascal's Triangle & Combinatorics
Pascal's triangle row `n` gives coefficients of `(a+b)^n`.
- Each entry = `nCk` (n choose k)
- Connection to bit manipulation: Counting subsets, combinations

### 7.4 Finding Position of Rightmost Set Bit
```python
import math

def position_of_rightmost_set_bit(n):
    if n == 0:
        return 0
    return int(math.log2(n & -n)) + 1
```

### 7.5 Divide Two Integers Without Using / or *
Use bit manipulation (exponential search / binary division):
- Keep subtracting the largest possible multiple of divisor from dividend
- Track how many times you subtract

---

## 8. Quick Reference: Binary Patterns

| Decimal | Binary | Pattern Note |
|---------|--------|--------------|
| 0 | 0000 | All zeros |
| 1 | 0001 | Only LSB |
| 2 | 0010 | Single 1 at position 1 |
| 3 | 0011 | 2 + 1 |
| 4 | 0100 | Single 1 at position 2 |
| 7 | 0111 | Three consecutive 1s |
| 8 | 1000 | Single 1 at position 3 |
| 15 | 1111 | Four consecutive 1s (2^4 - 1) |
| 16 | 10000 | Single 1 at position 4 |
| 31 | 11111 | Five consecutive 1s (2^5 - 1) |
| 2^n - 1 | 111...1 | n consecutive 1s |
| 2^n | 100...0 | 1 followed by n zeros |

---

## 9. Key Takeaways for Interviews

1. **Bitwise operations are O(1)** - constant time at hardware level
2. **XOR is your friend** for "paired" problems
3. **Left shift = multiply by 2**, **Right shift = divide by 2**
4. **`n & (n-1)`** clears the rightmost set bit (useful for counting bits, checking power of 2)
5. **2's complement** is how negative numbers are stored; MSB is the sign bit
6. **Range formula** for n-bit signed: `[-2^(n-1), 2^(n-1) - 1]`
7. **Always consider edge cases:** n = 0, n = 1, negative numbers, integer overflow

---

## 10. Practice Problems

1. Check if a number is power of 2
2. Find the single non-duplicate number in an array
3. Count the number of 1s in binary representation
4. Reverse bits of an integer
5. Find the missing number in a sequence (0 to n)
6. Determine if two integers have opposite signs
7. Find the position of the rightmost set bit
8. Check if a number is a power of 4
9. Swap odd and even bits
10. Find the maximum XOR of two numbers in an array

---

*Happy Learning! Master these fundamentals before diving into advanced algorithms.*
