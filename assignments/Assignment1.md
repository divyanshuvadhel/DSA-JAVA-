# 📝 Java Deep Assignment
## Practice Problems for 7-8 Day Learning Track

---

## SECTION A: Datatypes, Input, Functions (Problems 1-5)

---

### Problem 1: Temperature Converter ⭐
Write a program with separate functions to convert temperature between Celsius, Fahrenheit, and Kelvin.

**Formulas:**
- C = (F - 32) × 5/9
- F = (C × 9/5) + 32
- K = C + 273.15

**Requirements:**
- Create `celsiusToFahrenheit()`, `fahrenheitToCelsius()`, `celsiusToKelvin()`, `kelvinToCelsius()`
- Take user input: temperature value and current unit
- Display converted values in all other units
- Use `double` for precision

**Example:**
```
Input: 100 C
Output: 212.0 F, 373.15 K

Input: 32 F
Output: 0.0 C, 273.15 K
```

---

### Problem 2: Advanced Calculator ⭐⭐
Build a calculator supporting multiple operations using method overloading.

**Requirements:**
- Overloaded `add()`, `subtract()`, `multiply()`, `divide()` for both `int` and `double`
- `modulo(int a, int b)` — remainder
- `power(double base, int exp)` — base^exp (without using Math.pow)
- `squareRoot(double n)` — using Newton's method or built-in
- Handle division by zero gracefully (print error, return 0)
- Menu-driven program

**Example:**
```
Choose operation:
1. Add  2. Subtract  3. Multiply  4. Divide
5. Modulo  6. Power  7. Square Root  8. Exit

Input: 1
Enter two numbers: 5 3
Result: 8
```

---

### Problem 3: Number System Converter ⭐⭐
Implement conversion between number systems.

**Requirements:**
- `String decimalToBinary(int n)` — convert decimal to binary string
- `int binaryToDecimal(String binary)` — convert binary string to decimal
- `String decimalToHex(int n)` — convert decimal to hexadecimal
- `int hexToDecimal(String hex)` — convert hex string to decimal
- Validate input (e.g., binary string should only contain 0 and 1)

**Example:**
```
Input: 255
Binary: 11111111
Hex: FF

Input: 1010 (binary)
Decimal: 10
```

**Hint:** For decimal to binary, repeatedly divide by 2 and store remainders. For binary to decimal, multiply each digit by 2^position.

---

### Problem 4: Grade Calculator ⭐
Calculate student grade based on marks.

**Requirements:**
- Input marks for 5 subjects (each out of 100)
- Validate marks (0-100 range)
- Functions:
    - `int calculateTotal(int[] marks)`
    - `double calculatePercentage(int total)`
    - `char calculateGrade(double percentage)`
        - A: >= 90%
        - B: 80-89%
        - C: 70-79%
        - D: 60-69%
        - F: < 60%
    - `void displayResult(int total, double percentage, char grade)`
- Handle invalid input gracefully

**Example:**
```
Enter marks for 5 subjects: 85 92 78 88 95
Total: 438
Percentage: 87.6%
Grade: B
```

---

### Problem 5: Prime Number Toolkit ⭐⭐
Create a comprehensive prime number utility.

**Requirements:**
- `boolean isPrime(int n)` — check if n is prime (handle n <= 1)
- `void printPrimes(int start, int end)` — print all primes in range [start, end]
- `int nthPrime(int n)` — find the nth prime number (1st prime = 2)
- `int countPrimes(int[] arr)` — count prime numbers in array
- `void printPrimeFactors(int n)` — print all prime factors of n
    - Example: 12 → 2, 2, 3

**Optimization:** Check divisibility only up to √n, not n.

**Example:**
```
Input: 50
Is Prime: false
Prime Factors: 2, 5, 5
Primes up to 50: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
```

---

## SECTION B: Arrays & Manipulation (Problems 6-10)

---

### Problem 6: Array Statistics ⭐⭐
Perform comprehensive analysis on an integer array.

**Requirements:**
- Input array of n integers
- Functions (all must be separate methods):
    - `int findMax(int[] arr)`
    - `int findMin(int[] arr)`
    - `int findSum(int[] arr)`
    - `double findAverage(int[] arr)`
    - `int findSecondLargest(int[] arr)` — without sorting
    - `int findSecondSmallest(int[] arr)` — without sorting
    - `int countEven(int[] arr)`
    - `int countOdd(int[] arr)`
- Display all results

**Example:**
```
Input: 5
Array: 45 12 78 23 67
Max: 78, Min: 12
Sum: 225, Average: 45.0
Second Largest: 67, Second Smallest: 23
Even: 1, Odd: 4
```

**Challenge:** Find second largest/smallest in a single pass (O(n)).

---

### Problem 7: Matrix Operations ⭐⭐⭐
Implement 2D array (matrix) operations.

**Requirements:**
- Input two 3x3 matrices
- Functions:
    - `int[][] addMatrices(int[][] a, int[][] b)`
    - `int[][] subtractMatrices(int[][] a, int[][] b)`
    - `int[][] transpose(int[][] matrix)`
    - `int diagonalSum(int[][] matrix)` — primary + secondary diagonal
    - `boolean isSymmetric(int[][] matrix)` — matrix equals its transpose
    - `void printMatrix(int[][] matrix)` — formatted output
- Display all results with proper formatting

**Example:**
```
Matrix A:
1 2 3
4 5 6
7 8 9

Matrix B:
9 8 7
6 5 4
3 2 1

A + B:
10 10 10
10 10 10
10 10 10

Transpose of A:
1 4 7
2 5 8
3 6 9

Diagonal Sum: 25 (1+5+9+3+7, but 5 counted once = 25)
```

**Bonus:** Implement matrix multiplication.

---

### Problem 8: Array Rotation & Reversal ⭐⭐⭐
Manipulate array order.

**Requirements:**
- `void leftRotate(int[] arr, int k)` — rotate left by k positions
    - Example: [1,2,3,4,5], k=2 → [3,4,5,1,2]
- `void rightRotate(int[] arr, int k)` — rotate right by k positions
    - Example: [1,2,3,4,5], k=2 → [4,5,1,2,3]
- `void reverseArray(int[] arr)` — reverse in-place (no extra array)
- `boolean isPalindrome(int[] arr)` — check if array reads same forwards and backwards
- `void rotateMatrix90(int[][] matrix)` — bonus: rotate 2D matrix 90° clockwise

**Example:**
```
Original: [1, 2, 3, 4, 5]
Left rotate by 2: [3, 4, 5, 1, 2]
Right rotate by 2: [4, 5, 1, 2, 3]
Reversed: [5, 4, 3, 2, 1]
Is Palindrome: false

Original: [1, 2, 3, 2, 1]
Is Palindrome: true
```

**Hint for in-place reversal:** Swap arr[i] with arr[n-1-i] for i from 0 to n/2.

---

### Problem 9: Frequency & Duplicates ⭐⭐⭐
Analyze array elements.

**Requirements:**
- `void printFrequency(int[] arr)` — print each element and its frequency
    - Example: [1,2,2,3,3,3] → 1:1, 2:2, 3:3
- `void printDuplicates(int[] arr)` — print all duplicate elements (each once)
- `int[] removeDuplicates(int[] arr)` — return new array without duplicates
- `int findMaxFrequency(int[] arr)` — element that appears most
- `void printUnique(int[] arr)` — elements that appear exactly once

**Example:**
```
Input: [4, 3, 2, 4, 2, 3, 4, 5]
Frequency:
4: 3 times
3: 2 times
2: 2 times
5: 1 time

Duplicates: 4, 3, 2
Unique: 5
Max Frequency: 4 (appears 3 times)
Without Duplicates: [4, 3, 2, 5]
```

**Note:** Do not use HashMap (not learned yet). Use nested loops or sorting.

---

### Problem 10: Merge, Sort & Search ⭐⭐⭐
Combine arrays and perform operations.

**Requirements:**
- `int[] mergeSorted(int[] a, int[] b)` — merge two sorted arrays into one sorted array (O(n+m))
- `int[] mergeAndSort(int[] a, int[] b)` — merge two unsorted arrays, then sort using bubble sort
- `int[] intersection(int[] a, int[] b)` — common elements (no duplicates)
- `int[] union(int[] a, int[] b)` — all unique elements from both
- `int kthSmallest(int[] arr, int k)` — find kth smallest element using sorting

**Example:**
```
A (sorted): [1, 3, 5, 7]
B (sorted): [2, 3, 6, 8]
Merged: [1, 2, 3, 3, 5, 6, 7, 8]

A (unsorted): [5, 1, 3]
B (unsorted): [2, 4, 1]
Merged & Sorted: [1, 1, 2, 3, 4, 5]
Intersection: [1, 3]
Union: [1, 2, 3, 4, 5]
3rd Smallest: 3
```

---

## SECTION C: Searching Algorithms (Problems 11-13)

---

### Problem 11: Linear Search Variations ⭐⭐⭐
Implement different linear search patterns.

**Requirements:**
- `int firstOccurrence(int[] arr, int target)` — index of first match
- `int lastOccurrence(int[] arr, int target)` — index of last match
- `int[] allOccurrences(int[] arr, int target)` — return array of all indices
    - Return `[-1]` if not found
- `int countOccurrences(int[] arr, int target)` — total count
- `boolean search2D(int[][] matrix, int target)` — search in 2D array row-wise
- `boolean search2DSorted(int[][] matrix, int target)` — bonus: each row is sorted

**Example:**
```
Array: [2, 4, 4, 4, 6, 8, 4, 10]
Target: 4
First: 1
Last: 6
All: [1, 2, 3, 6]
Count: 4

Matrix:
1  2  3
4  5  6
7  8  9
Search 5: true
Search 10: false
```

---

### Problem 12: Binary Search Deep Dive ⭐⭐⭐⭐
Master binary search with variations.

**Requirements:**
- `int binarySearchIterative(int[] arr, int target)` — standard iterative
- `int binarySearchRecursive(int[] arr, int target, int left, int right)` — recursive
- `int firstOccurrenceBS(int[] arr, int target)` — first occurrence in sorted array with duplicates
    - Example: [1,2,2,2,3,4], target=2 → index 1
- `int lastOccurrenceBS(int[] arr, int target)` — last occurrence
    - Example: [1,2,2,2,3,4], target=2 → index 3
- `int countOccurrencesBS(int[] arr, int target)` — count using binary search (not linear!)
- `int findFloor(int[] arr, int target)` — largest element <= target
    - Example: [1,3,5,7], target=6 → 5
- `int findCeiling(int[] arr, int target)` — smallest element >= target
    - Example: [1,3,5,7], target=6 → 7

**Example:**
```
Sorted Array: [1, 2, 2, 2, 3, 4, 4, 5, 6]
Target: 2
Standard: 4 (any occurrence)
First: 1
Last: 3
Count: 3

Target: 6
Floor of 6: 6
Ceiling of 6: 6

Target: 4.5 (conceptually)
Floor: 4
Ceiling: 5
```

**Hint for first/last occurrence:** When found, don't return immediately. Continue searching in the appropriate half.

---

### Problem 13: Search Performance Comparison ⭐⭐⭐
Compare linear search vs binary search empirically.

**Requirements:**
- Generate a sorted array of 100,000 elements (1 to 100,000)
- Generate 1000 random targets
- Time linear search for all targets (use `System.nanoTime()`)
- Time binary search for all targets
- Calculate and display:
    - Average time per search for each
    - Total time for each
    - Speedup factor (linear time / binary time)
- Also test with:
    - Target at beginning (best case for linear)
    - Target at end (worst case for linear)
    - Target not present

**Example Output:**
```
Array Size: 100,000
Number of Searches: 1000

Linear Search:
  Total Time: 45,230,000 ns
  Average: 45,230 ns per search

Binary Search:
  Total Time: 120,000 ns
  Average: 120 ns per search

Speedup: 377x faster!

Best Case (target at index 0):
  Linear: 50 ns
  Binary: 100 ns

Worst Case (target not present):
  Linear: 89,000 ns
  Binary: 150 ns
```

---

## SECTION D: Sorting & Advanced (Problems 14-16)

---

### Problem 14: Bubble Sort Variations ⭐⭐⭐
Implement and compare bubble sort variants.

**Requirements:**
- `void bubbleSortStandard(int[] arr)` — standard version
- `void bubbleSortOptimized(int[] arr)` — with `swapped` flag
- `int bubbleSortCountSwaps(int[] arr)` — return total swaps made
- `void bubbleSortDescending(int[] arr)` — sort in descending order
- `void bubbleSortStrings(String[] arr)` — sort strings alphabetically
- Compare number of comparisons and swaps for:
    - Already sorted array
    - Reverse sorted array
    - Random array

**Example:**
```
Original: [64, 34, 25, 12, 22, 11, 90]
Standard Bubble Sort:
  Comparisons: 21
  Swaps: 15
  Sorted: [11, 12, 22, 25, 34, 64, 90]

Optimized Bubble Sort:
  Comparisons: 18 (stopped early)
  Swaps: 15

Descending: [90, 64, 34, 25, 22, 12, 11]

Strings: ["banana", "apple", "cherry"]
Sorted: ["apple", "banana", "cherry"]
```

---

### Problem 15: Sorting Comparison ⭐⭐⭐⭐
Implement and compare multiple sorting algorithms.

**Requirements:**
Implement these algorithms and compare:
- **Bubble Sort** (already learned)
- **Selection Sort**: Find minimum and swap with first unsorted
- **Insertion Sort**: Build sorted array one element at a time

For each algorithm, on arrays of size 10, 100, 1000, 5000:
- Count number of comparisons
- Count number of swaps/shifts
- Measure time taken (nanoseconds)
- Display results in a formatted table

**Example Output:**
```
Array Size: 1000

Algorithm        | Comparisons | Swaps | Time (ms)
-----------------|-------------|-------|----------
Bubble Sort      | 499,500     | 245,000 | 12.5
Selection Sort   | 499,500     | 999     | 8.3
Insertion Sort   | 250,000     | 245,000 | 6.2

Conclusion: For random data, Insertion Sort is fastest.
For nearly sorted data, Bubble Sort (optimized) is best.
```

**Selection Sort Algorithm:**
```java
for i from 0 to n-2:
    minIndex = i
    for j from i+1 to n-1:
        if arr[j] < arr[minIndex]:
            minIndex = j
    swap arr[i] and arr[minIndex]
```

**Insertion Sort Algorithm:**
```java
for i from 1 to n-1:
    key = arr[i]
    j = i - 1
    while j >= 0 and arr[j] > key:
        arr[j+1] = arr[j]
        j--
    arr[j+1] = key
```

---

### Problem 16: Cyclic Sort & Missing Number Problems ⭐⭐⭐⭐
Solve problems using sorting concepts.

**Requirements:**

**A) Cyclic Sort:**
Given an array containing numbers from 1 to N (each appearing once), sort it in O(n) time.
- `void cyclicSort(int[] arr)` — place each number at its correct index (number i at index i-1)
- Example: [3,1,2,5,4] → [1,2,3,4,5]

**B) Missing Number:**
Given array of size n containing numbers from 1 to n+1 with one missing, find the missing number.
- `int findMissingNumber(int[] arr)` — use cyclic sort concept
- Example: [3,1,4,5] → missing is 2

**C) Find Duplicate:**
Given array of size n+1 containing numbers from 1 to n (one number repeats), find the duplicate.
- `int findDuplicate(int[] arr)` — use cyclic sort concept
- Example: [1,3,4,2,2] → duplicate is 2

**D) First Missing Positive:**
Given unsorted array, find the smallest missing positive integer.
- `int firstMissingPositive(int[] arr)`
- Example: [3,4,-1,1] → 2
- Example: [1,2,0] → 3

**E) Find Missing and Repeating:**
Given array of size n containing numbers from 1 to n, one number is missing and one repeats twice.
- `void findMissingAndRepeating(int[] arr)` — return both
- Example: [4,3,6,2,1,1] → Missing: 5, Repeating: 1

**Approach:** Use cyclic sort for all. Each number should be at index = value - 1.

---

## SECTION E: Combined & Real-World Projects (Problems 17-20)

---

### Problem 17: Student Management System ⭐⭐⭐⭐
Build a complete student management system using arrays and functions.

**Requirements:**
- Create a `Student` class (or use parallel arrays: names[], rolls[], marks[][])
- Support up to 50 students
- Menu-driven program with options:
    1. Add Student (name, roll, marks in 5 subjects)
    2. Display All Students
    3. Search by Roll Number (linear search)
    4. Search by Name (linear search, case-insensitive)
    5. Sort by Total Marks (bubble sort, descending)
    6. Sort by Name (bubble sort, alphabetical)
    7. Find Topper
    8. Display Students Above Average
    9. Display Students Below Average
    10. Update Marks
    11. Delete Student
    12. Exit

**Functions to implement:**
- `void addStudent(...)`
- `void displayAll()`
- `int searchByRoll(int roll)` — return index or -1
- `void sortByMarks()` — bubble sort on total marks
- `void findTopper()`
- `double calculateClassAverage()`
- `void displayAboveAverage()`
- `void displayBelowAverage()`

**Example:**
```
=== Student Management System ===
1. Add Student
2. Display All
3. Search by Roll
4. Sort by Marks
5. Find Topper
6. Exit

Choice: 1
Name: Rahul
Roll: 101
Marks (5 subjects): 85 92 78 88 95
Student added!

Choice: 3
Enter Roll: 101
Name: Rahul, Roll: 101, Total: 438, Percentage: 87.6%, Grade: B
```

---

### Problem 18: Library Management System ⭐⭐⭐⭐
Manage a library's book collection.

**Requirements:**
- Book data: Title, Author, ISBN (unique), Available Copies, Total Copies
- Support up to 100 books
- Menu options:
    1. Add Book
    2. Display All Books
    3. Search by ISBN (binary search — maintain sorted order by ISBN)
    4. Search by Title (linear search)
    5. Sort by Title (bubble sort)
    6. Sort by Author (bubble sort)
    7. Issue Book (decrement available copies)
    8. Return Book (increment available copies)
    9. Display Available Books
    10. Display Overdue Books (bonus: track due dates)
    11. Exit

**Important:**
- Maintain array sorted by ISBN for binary search
- When adding new book, insert in correct position (or sort after)
- Validate: cannot issue if available copies = 0

**Example:**
```
=== Library Management ===
1. Add Book
2. Search by ISBN
3. Issue Book
4. Return Book
5. Display Available
6. Exit

Choice: 1
Title: Java Programming
Author: Herbert Schildt
ISBN: 9780071809252
Copies: 5
Book added!

Choice: 2
Enter ISBN: 9780071809252
Found: Java Programming by Herbert Schildt
Available: 5/5

Choice: 3
Enter ISBN: 9780071809252
Book issued! Available: 4/5
```

---

### Problem 19: Pattern Printing with Functions ⭐⭐⭐
Print various patterns using nested loops and functions.

**Requirements:**
Implement each as a separate function taking `int n` as parameter:

**A) Right Triangle:**
```
n=5
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

**B) Inverted Right Triangle:**
```
n=5
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
```

**C) Pyramid:**
```
n=5
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
```

**D) Diamond:**
```
n=5
    1
   1 2
  1 2 3
 1 2 3 4
1 2 3 4 5
 1 2 3 4
  1 2 3
   1 2
    1
```

**E) Floyd's Triangle:**
```
n=5
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
```

**F) Pascal's Triangle:**
```
n=5
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
```

**G) Number Pyramid:**
```
n=5
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
```

**H) Hollow Diamond:**
```
n=5
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *
```

**Menu:** Let user choose pattern and input n.

---

### Problem 20: Final Challenge — Competitive Programming Style ⭐⭐⭐⭐⭐
**"Find the Missing and Repeating"**

**Problem Statement:**
Given an unsorted array of size n containing numbers from 1 to n, but:
- One number from 1 to n is **missing**
- One number from 1 to n appears **twice** (repeating)

Find both the missing and repeating numbers.

**Requirements:** Solve using THREE different approaches:

**Approach 1: Using Sorting (Bubble Sort) + Linear Scan**
- Sort the array using bubble sort
- Scan to find where consecutive numbers differ by more than 1 (missing)
- Scan to find where same number appears twice (repeating)
- Time: O(n²), Space: O(1)

**Approach 2: Using Mathematical Approach (Sum & Sum of Squares)**
- Let S = sum of 1 to n = n(n+1)/2
- Let S2 = sum of squares of 1 to n = n(n+1)(2n+1)/6
- Let actualSum = sum of array elements
- Let actualSumSq = sum of squares of array elements
- Let missing = x, repeating = y
- Equation 1: S - actualSum = x - y
- Equation 2: S2 - actualSumSq = x² - y² = (x-y)(x+y)
- Solve for x and y
- Time: O(n), Space: O(1)

**Approach 3: Using Cyclic Sort (Most Optimal)**
- Place each number at its correct index (number i at index i-1)
- The number that doesn't match its index is the repeating one
- The index that doesn't have the correct number indicates the missing one
- Time: O(n), Space: O(1)

**Input Format:**
```
First line: n (size of array)
Second line: n space-separated integers
```

**Example:**
```
Input:
6
4 3 6 2 1 1

Output:
Approach 1 (Sorting): Missing: 5, Repeating: 1
Approach 2 (Math): Missing: 5, Repeating: 1
Approach 3 (Cyclic Sort): Missing: 5, Repeating: 1
```

**Constraints:**
- 2 ≤ n ≤ 10⁵
- Array contains integers from 1 to n
- Exactly one missing and one repeating

**Bonus:**
- What if there are multiple missing/repeating numbers?
- Can you solve it using XOR (bit manipulation)?

---

## BONUS CHALLENGES (Optional)

### Challenge 1: Sorting Visualizer Concept
Write a program that prints the array after each pass of bubble sort, showing how elements "bubble up".

### Challenge 2: Binary Search on Rotated Array
Array was sorted then rotated. Find target without sorting first.
- Example: [4,5,6,7,0,1,2], target=0 → index 4

### Challenge 3: Merge Sort Implementation
Implement merge sort (divide and conquer) and compare with bubble sort.

### Challenge 4: Two Sum Problem
Given sorted array and target sum, find pair that adds to target using binary search concept.

### Challenge 5: Maximum Subarray (Kadane's Algorithm)
Find contiguous subarray with maximum sum.

---

## SUBMISSION GUIDELINES

1. **Code Quality:**
    - Use meaningful variable names
    - Add comments explaining logic
    - Handle edge cases (empty arrays, invalid input, etc.)
    - Use proper indentation

2. **Testing:**
    - Test with minimum values (n=1, n=2)
    - Test with maximum values (large arrays)
    - Test with edge cases (all same, already sorted, reverse sorted)
    - Test with negative numbers where applicable

3. **Documentation:**
    - Add a brief comment at top explaining the problem
    - Mention time and space complexity for algorithms

4. **Organization:**
    - Create separate files for each problem or section
    - Name files clearly: `Problem1_TemperatureConverter.java`

---

## SELF-EVALUATION CHECKLIST

Before moving to next topics, ensure you can:
- [ ] Write `main()` method and explain each keyword without notes
- [ ] Convert between any two primitive types with correct casting
- [ ] Take all types of input using Scanner
- [ ] Write any function with correct parameters and return type
- [ ] Create and manipulate 1D and 2D arrays confidently
- [ ] Write linear search from scratch in under 2 minutes
- [ ] Write binary search (iterative) from scratch in under 3 minutes
- [ ] Write optimized bubble sort from scratch in under 3 minutes
- [ ] Trace through any of these algorithms mentally on paper
- [ ] Solve combined problems using multiple concepts together

**Time Targets:**
- Simple function: 2 minutes
- Array input/output: 1 minute
- Linear Search: 2 minutes
- Binary Search: 3 minutes
- Bubble Sort: 3 minutes

---

*Good luck! Solve at least 15 problems before moving to the next topics.* 🚀
