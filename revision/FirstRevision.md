# 📚 Java Revision Notes
## Complete Revision for 7-8 Day Learning Track

---

## Chapter 0: Programming & Basics

### What is Programming?
Programming is the process of writing instructions (code) that a computer can execute to perform specific tasks.

### Key Terms
| Term | Definition |
|------|------------|
| **Algorithm** | Step-by-step procedure to solve a problem |
| **Syntax** | Rules of writing code in a language |
| **Semantics** | Meaning of the code |
| **Compiler** | Translates entire source code to machine code at once |
| **Interpreter** | Translates code line-by-line during execution |
| **Source Code** | Human-readable code written by programmer |
| **Machine Code** | Binary code that computer hardware understands |

### Compilation vs Interpretation
| Feature | Compiler | Interpreter |
|---------|----------|-------------|
| Speed | Faster execution | Slower execution |
| Error detection | All errors at once | One error at a time |
| Examples | C, C++, Java (partial) | Python, JavaScript |
| Output | Machine code / Bytecode | Direct execution |

### Java Execution Flow
```
.java file → javac (Compiler) → .class (Bytecode) → JVM → Machine Code
```

### Why Java is Platform-Independent?
Java follows **WORA** — Write Once, Run Anywhere. The same `.class` bytecode file can run on any OS that has a JVM installed (Windows, Linux, Mac).

---

## Chapter 1: Types of Programming Languages

### Classification by Level
| Type | Examples | Characteristics |
|------|----------|-----------------|
| **Low-Level** | Machine code, Assembly | Hardware-specific, very fast, hard to write |
| **High-Level** | Java, Python, C++ | Human-readable, portable, easier to debug |

### Classification by Paradigm
| Type | Examples | Key Feature |
|------|----------|-------------|
| **Procedural** | C, Pascal | Functions/procedures, top-down |
| **Object-Oriented** | Java, C++, Python | Classes, objects, inheritance |
| **Functional** | Haskell, Lisp | Pure functions, no side effects |
| **Scripting** | JavaScript, Python | Interpreted, rapid development |

### Java Characteristics
- ✅ **High-level** — Easy to read and write
- ✅ **Object-Oriented** — Everything is in classes
- ✅ **Compiled + Interpreted** — Compiled to bytecode, interpreted by JVM
- ✅ **Platform-independent** — Runs on any JVM
- ✅ **Strongly typed** — Every variable must have a type
- ✅ **Statically typed** — Type checked at compile time

### Static vs Dynamic Typing
| Static (Java) | Dynamic (Python) |
|---------------|------------------|
| `int x = 10;` | `x = 10` |
| Type declared explicitly | Type inferred at runtime |
| Errors caught early | Errors may appear at runtime |
| Faster execution | More flexible |

---

## Chapter 2: Flow of a Program — Flowcharts

### Flowchart Symbols
| Symbol | Shape | Purpose |
|--------|-------|---------|
| **Start/End** | Oval | Beginning and end of program |
| **Process** | Rectangle | Action or operation |
| **Input/Output** | Parallelogram | Reading or displaying data |
| **Decision** | Diamond | Yes/No or True/False condition |
| **Flow Line** | Arrow | Direction of flow |
| **Connector** | Circle | Connects different parts |

### Control Structures
1. **Sequential**: Statements execute one after another
2. **Conditional**: Decision making
    - `if` — single condition
    - `if-else` — two choices
    - `if-else if-else` — multiple choices
    - `switch` — multiple fixed choices
3. **Iterative**: Repetition
    - `for` — known number of iterations
    - `while` — condition-based (check before)
    - `do-while` — condition-based (check after, runs at least once)

### `for` vs `while` vs `do-while`
| Loop | Use When | Check Condition |
|------|----------|-----------------|
| `for` | Number of iterations known | Before each iteration |
| `while` | Condition-based, may not run | Before each iteration |
| `do-while` | Must run at least once | After each iteration |

---

## Chapter 3: Architecture of Java

### JVM (Java Virtual Machine)
JVM is the engine that runs Java bytecode. It makes Java platform-independent.

### JVM Components
```
┌─────────────────────────────────────────┐
│           JVM Architecture              │
├─────────────────────────────────────────┤
│  Class Loader Subsystem                 │
│  ├── Loading → Linking → Initialization │
├─────────────────────────────────────────┤
│  Runtime Data Areas                     │
│  ├── Method Area (class info, static)   │
│  ├── Heap (objects, arrays)             │
│  ├── Stack (local vars, method calls)   │
│  ├── PC Register (current instruction)  │
│  └── Native Method Stack                │
├─────────────────────────────────────────┤
│  Execution Engine                       │
│  ├── Interpreter (line-by-line)         │
│  ├── JIT Compiler (hotspot compilation) │
│  └── Garbage Collector (memory cleanup) │
└─────────────────────────────────────────┘
```

### Memory Areas Detail
| Area | Stores | Shared? |
|------|--------|---------|
| **Method Area** | Class structures, static variables, method code | Yes |
| **Heap** | All objects and arrays | Yes |
| **Stack** | Local variables, method calls, return addresses | No (per thread) |
| **PC Register** | Address of current instruction | No (per thread) |
| **Native Method Stack** | Native (C/C++) method calls | No (per thread) |

### JDK vs JRE vs JVM
```
┌─────────────────────────────────────┐
│              JDK                    │
│  ┌─────────────────────────────┐    │
│  │            JRE              │    │
│  │  ┌─────────────────────┐    │    │
│  │  │        JVM          │    │    │
│  │  │  + Libraries        │    │    │
│  │  └─────────────────────┘    │    │
│  │  + Other runtime files       │    │
│  └─────────────────────────────┘    │
│  + Compiler (javac)                 │
│  + Debugger (jdb)                     │
│  + Other dev tools                    │
└─────────────────────────────────────┘
```

| Component | Contains | Purpose |
|-----------|----------|---------|
| **JVM** | Runtime engine | Executes bytecode |
| **JRE** | JVM + Libraries + Runtime files | Run Java programs |
| **JDK** | JRE + Compiler + Development tools | Develop Java programs |

### Class Loader Process
1. **Loading**: Reads `.class` file into memory
2. **Linking**: Verifies, prepares, and resolves references
3. **Initialization**: Executes static initializers and static blocks

### JIT Compiler
- **JIT** = Just-In-Time Compiler
- Monitors frequently executed code ("hotspots")
- Compiles hotspots to native machine code for faster execution
- Why faster than interpreter? Native code runs directly on CPU

---

## Chapter 4: Java Program Explained

### Basic Structure
```java
// 1. Package declaration (optional)
package com.example;

// 2. Import statements
import java.util.Scanner;

// 3. Class declaration
public class Main {
    // 4. Main method — entry point
    public static void main(String[] args) {
        // 5. Statements
        System.out.println("Hello, World!");
    }
}
```

### `main()` Method Breakdown
```java
public static void main(String[] args)
```
| Keyword | Meaning |
|---------|---------|
| `public` | Accessible from anywhere (JVM needs to access it) |
| `static` | Belongs to class, not object (JVM calls without creating object) |
| `void` | Returns nothing |
| `main` | Special name recognized by JVM as entry point |
| `String[] args` | Array to store command-line arguments |

### Output Methods
```java
System.out.print("No newline");      // Prints without newline
System.out.println("With newline");  // Prints with newline
System.out.printf("Format: %d", 10); // Formatted output (C-style)
```

### Command Line Arguments
```java
// Run: java Main Hello World
public static void main(String[] args) {
    System.out.println(args[0]); // "Hello"
    System.out.println(args[1]); // "World"
}
```

### Important Points
- File name must match public class name (`Main.java` for `public class Main`)
- Only one public class per file
- Java is case-sensitive: `main` ≠ `Main`
- `main()` must be exactly `public static void main(String[] args)`

---

## Chapter 5: Primitive Datatypes, Input, Type Casting, Automatic Conversion

### Primitive Datatypes
| Type | Size | Range | Default Value | Example |
|------|------|-------|---------------|---------|
| `byte` | 1 byte | -128 to 127 | 0 | `byte b = 10;` |
| `short` | 2 bytes | -32,768 to 32,767 | 0 | `short s = 1000;` |
| `int` | 4 bytes | -2,147,483,648 to 2,147,483,647 | 0 | `int i = 100000;` |
| `long` | 8 bytes | -9×10¹⁸ to 9×10¹⁸ | 0L | `long l = 10000000000L;` |
| `float` | 4 bytes | ~7 decimal digits | 0.0f | `float f = 3.14f;` |
| `double` | 8 bytes | ~15 decimal digits | 0.0d | `double d = 3.14159;` |
| `char` | 2 bytes | 0 to 65,535 (Unicode) | `'\u0000'` | `char c = 'A';` |
| `boolean` | 1 bit | `true` or `false` | `false` | `boolean flag = true;` |

### Why `char` is 2 bytes in Java?
Java uses **Unicode** (UTF-16) to support international characters. C/C++ use ASCII (1 byte = 256 characters). Unicode supports 65,535+ characters including emojis, Chinese, Arabic, etc.

### Input using Scanner
```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

int num = sc.nextInt();        // Integer input
long bigNum = sc.nextLong();   // Long input
float f = sc.nextFloat();      // Float input
double d = sc.nextDouble();    // Double input
String word = sc.next();       // Single word (stops at space)
String line = sc.nextLine();   // Full line (including spaces)
char c = sc.next().charAt(0);  // Single character
boolean b = sc.nextBoolean();  // true/false input

sc.close(); // Good practice to close scanner
```

### Type Casting

#### Implicit Casting (Widening) — Automatic, No Data Loss
```java
byte b = 10;
short s = b;      // byte → short
int i = s;        // short → int
long l = i;       // int → long
float f = l;      // long → float
double d = f;     // float → double
```
**Direction**: `byte` → `short` → `int` → `long` → `float` → `double`

#### Explicit Casting (Narrowing) — Manual, May Lose Data
```java
double d = 10.99;
int i = (int) d;      // 10 (decimal part lost)

float f = 3.7f;
int j = (int) f;      // 3 (decimal part lost)

int big = 130;
byte b = (byte) big;  // -126 (overflow, wraps around)
```

### Automatic Type Promotion in Expressions
```java
byte a = 10;
byte b = 20;
// byte c = a + b;  // ERROR! a + b promoted to int
int c = a + b;       // Correct

int x = 10;
float y = 20.5f;
// Result is float (higher type)
float result = x + y; // 30.5
```

### Important Casting Examples
```java
// Example 1: Different outputs!
int result1 = (int) 7.8 + (int) 3.2;  // 7 + 3 = 10
int result2 = (int) (7.8 + 3.2);      // (int) 11.0 = 11

// Example 2: Integer division
int a = 5, b = 2;
double c = a / b;        // 2.0 (integer division first!)
double d = (double) a / b; // 2.5 (correct)
```

---

## Chapter 6: Functions (Methods)

### Function Definition
```java
returnType functionName(parameterType param1, parameterType param2) {
    // body
    return value; // if returnType is not void
}
```

### Example
```java
// Function with return value
public static int add(int a, int b) {
    return a + b;
}

// Function without return value
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

// Calling functions
public static void main(String[] args) {
    int sum = add(5, 3);        // sum = 8
    greet("Alice");             // Prints: Hello, Alice
}
```

### Terminology
| Term | Definition | Example |
|------|------------|---------|
| **Parameter** | Variable in function definition | `int a, int b` in `add(int a, int b)` |
| **Argument** | Actual value passed | `5, 3` in `add(5, 3)` |
| **Return type** | What function gives back | `int` in `int add(...)` |
| **Void** | No return value | `void greet(...)` |

### Method Overloading
Same method name, different parameters (type, number, or order).
```java
int add(int a, int b) { return a + b; }
double add(double a, double b) { return a + b; }
int add(int a, int b, int c) { return a + b + c; }
```
**Rules for overloading:**
- ✅ Different number of parameters
- ✅ Different types of parameters
- ✅ Different order of parameters
- ❌ Only changing return type is NOT allowed (causes ambiguity)

### Pass by Value in Java
Java is **always pass-by-value**.
```java
public static void modify(int x) {
    x = x + 10;  // Changes local copy only
}

public static void main(String[] args) {
    int a = 5;
    modify(a);
    System.out.println(a); // Still 5! Not changed
}
```
For objects, the reference (memory address) is passed by value — so object contents can be modified.

### Scope of Variables
```java
public static void demo() {
    int local = 10;        // Local variable — only in this method
    // local cannot be accessed outside this method
}

public class Example {
    static int global = 20; // Static/class variable
    int instance = 30;      // Instance variable (needs object)
}
```

---

## Chapter 7: Arrays

### 1D Array
```java
// Declaration
int[] arr1;                    // Preferred style
int arr2[];                    // Also valid (C-style)

// Allocation
int[] arr = new int[5];        // 5 elements, all initialized to 0

// Initialization
int[] arr = {10, 20, 30, 40, 50};

// Access
arr[0] = 100;                  // Modify first element
int x = arr[2];                // Get third element
int length = arr.length;       // Get size (5)
```

### 2D Array (Matrix)
```java
// Declaration & Allocation
int[][] matrix = new int[3][3];  // 3x3 matrix

// Initialization
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Access
matrix[0][0] = 10;             // First row, first column
int rows = matrix.length;      // Number of rows (3)
int cols = matrix[0].length;   // Number of columns (3)
```

### Jagged Arrays
Rows can have different lengths.
```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];  // Row 0 has 2 elements
jagged[1] = new int[4];  // Row 1 has 4 elements
jagged[2] = new int[3];  // Row 2 has 3 elements
```

### Array Traversal
```java
// For loop
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// Enhanced for loop (for-each)
for (int num : arr) {
    System.out.println(num);
}
```

### Array Class Methods (`java.util.Arrays`)
```java
import java.util.Arrays;

Arrays.sort(arr);              // Sort in ascending order
Arrays.toString(arr);          // Convert to string: "[1, 2, 3]"
Arrays.binarySearch(arr, key); // Binary search (array must be sorted!)
Arrays.fill(arr, 5);           // Fill all with 5
Arrays.copyOf(arr, 10);        // Copy to new array of length 10
Arrays.equals(arr1, arr2);     // Check if arrays are equal
```

### Important Array Properties
- Arrays are **objects** in Java (stored in heap memory)
- **Zero-indexed**: First element at index 0, last at `length - 1`
- **Fixed size**: Cannot resize after creation
- **Default values**: Numeric = 0, boolean = false, objects = null
- `ArrayIndexOutOfBoundsException`: Accessing index < 0 or >= length

---

## Chapter 8: Linear Search

### Algorithm
```java
int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;  // Found at index i
        }
    }
    return -1;  // Not found
}
```

### How It Works
1. Start from the first element (index 0)
2. Compare target with current element
3. If match found, return index
4. If not, move to next element
5. If end reached without match, return -1

### Time Complexity
| Case | Time | Explanation |
|------|------|-------------|
| **Best** | O(1) | Target is at first position |
| **Average** | O(n) | Target is somewhere in middle |
| **Worst** | O(n) | Target is at last position or not present |

### Space Complexity: O(1) — only uses a loop variable

### Characteristics
- ✅ Works on **sorted and unsorted** arrays
- ✅ Simple to implement
- ✅ Good for small datasets
- ❌ Slow for large datasets
- ✅ Can find first occurrence easily

### Variations
```java
// Find last occurrence
int lastOccurrence(int[] arr, int target) {
    int lastIndex = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            lastIndex = i;  // Keep updating
        }
    }
    return lastIndex;
}

// Find all occurrences
void allOccurrences(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            System.out.print(i + " ");
        }
    }
}
```

---

## Chapter 9: Binary Search

### Algorithm (Iterative)
```java
int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;  // Prevents overflow!

        if (arr[mid] == target) {
            return mid;  // Found!
        } else if (arr[mid] < target) {
            left = mid + 1;  // Search right half
        } else {
            right = mid - 1;  // Search left half
        }
    }
    return -1;  // Not found
}
```

### Algorithm (Recursive)
```java
int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1;

    int mid = left + (right - left) / 2;

    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) 
        return binarySearch(arr, target, mid + 1, right);
    else 
        return binarySearch(arr, target, left, mid - 1);
}
```

### How It Works
1. Find middle element of current range
2. If middle == target, return index
3. If middle < target, search right half (ignore left)
4. If middle > target, search left half (ignore right)
5. Repeat until found or range is empty

### Time Complexity
| Case | Time | Explanation |
|------|------|-------------|
| **Best** | O(1) | Target is at middle |
| **Average** | O(log n) | Halving the search space each time |
| **Worst** | O(log n) | Target not present, keep halving |

### Space Complexity
- Iterative: O(1) — only uses a few variables
- Recursive: O(log n) — function call stack

### Why `mid = left + (right - left) / 2`?
Instead of `(left + right) / 2` which can cause **integer overflow** when `left` and `right` are very large (close to `Integer.MAX_VALUE`).

### Characteristics
- ✅ Extremely fast for large datasets
- ❌ **Requires sorted array**
- ✅ O(log n) is much better than O(n)
    - n = 1,000,000 → linear = 1M steps, binary = ~20 steps!

### Practical Example
For array of 1,000,000 elements:
- Linear search worst case: 1,000,000 comparisons
- Binary search worst case: log₂(1,000,000) ≈ 20 comparisons

---

## Chapter 10: Bubble Sort

### Algorithm
```java
void bubbleSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;

        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }

        // Optimization: if no swaps, array is sorted
        if (!swapped) break;
    }
}
```

### How It Works
1. Compare adjacent elements (index j and j+1)
2. If out of order (left > right), swap them
3. After each pass, the largest element "bubbles up" to the end
4. Next pass ignores the last element (already sorted)
5. Repeat until no swaps needed (array is sorted)

### Why "Bubble" Sort?
Larger elements gradually "bubble up" to the end of the array, like bubbles rising in water.

### Time Complexity
| Case | Time | Explanation |
|------|------|-------------|
| **Best** | O(n) | Already sorted (with optimization flag) |
| **Average** | O(n²) | Random order |
| **Worst** | O(n²) | Reverse sorted |

### Space Complexity: O(1) — sorting in-place

### Characteristics
- ✅ **Stable sort**: Maintains relative order of equal elements
- ✅ **In-place**: No extra memory needed
- ❌ **Slow** for large datasets
- ✅ Simple to understand and implement
- ✅ Good for nearly sorted data (with optimization)

### Pass-by-Pass Visualization
```
Initial: [5, 3, 8, 4, 2]

Pass 1: [3, 5, 4, 2, 8]  → 8 is at correct position
Pass 2: [3, 4, 2, 5, 8]  → 5 is at correct position
Pass 3: [3, 2, 4, 5, 8]  → 4 is at correct position
Pass 4: [2, 3, 4, 5, 8]  → 3 is at correct position
Sorted:  [2, 3, 4, 5, 8]
```

### Comparison with Other Sorts
| Algorithm | Best | Average | Worst | Stable | In-Place |
|-----------|------|---------|-------|--------|----------|
| Bubble Sort | O(n) | O(n²) | O(n²) | Yes | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | No | Yes |
| Insertion Sort | O(n) | O(n²) | O(n²) | Yes | Yes |

---

## Quick Reference: Time & Space Complexity

| Algorithm | Best Time | Average Time | Worst Time | Space |
|-----------|-----------|--------------|------------|-------|
| Linear Search | O(1) | O(n) | O(n) | O(1) |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) |

---

## Common Errors to Avoid
1. `ArrayIndexOutOfBoundsException` — accessing index >= length or < 0
2. Integer overflow in `(left + right) / 2` — use `left + (right - left) / 2`
3. Forgetting `break` in optimized bubble sort — causes unnecessary passes
4. Binary search on unsorted array — gives wrong results
5. `Scanner` not closed — resource leak
6. Integer division: `5 / 2 = 2` not `2.5` — cast to double first
7. `String` vs `char`: `"A"` is String, `'A'` is char
8. Array length is `arr.length` (property), String length is `str.length()` (method)

---

*End of Revision Notes — Master these before attempting the assignment!*
