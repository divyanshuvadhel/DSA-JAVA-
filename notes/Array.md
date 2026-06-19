# Arrays in Java — Lecture Notes

---

## 1. Why do we even need arrays ? 

Imagine the problem: **"Store a roll number."**
Easy — just one variable:
```java
int a = 19;
```

Now: **"Store 5 roll numbers."**
```java
int rollNumber1 = 23;
int rollNumber2 = 55;
int rollNumber3 = 18;
...
```
Fine for 5. But what if the question said **store 500 roll numbers**? Are we going to write 500 lines of variables? No way.

👉 This is exactly why we need a data structure that can hold a **collection of values together** — that's an **Array**.

---

## 2. What is an Array?

> An array is a **collection of data of the same type** — can be primitives (int, char, boolean...) or even objects/complex types.

**Two golden rules (write these down):**
1. The data type defines what kind of data the array can store.
2. **All elements must be of the SAME type.** You can't mix int, String, boolean in one array.

---

## 3. Syntax of an Array

```java
dataType[] variableName = new dataType[size];
```

Example:
```java
int[] rollNumbers = new int[5];          // empty array of size 5
int[] rollNumbers2 = {23, 12, 45, 32, 15}; // direct initialization
```

- `int[]` → this is the **reference variable's type** (it's an array of int)
- `new int[5]` → this actually **creates the array object** in memory

---

## 4. How Array Works Internally (Stack vs Heap)

This is the **most important conceptual part** of the whole lecture.

```java
int[] arr = new int[5];
```

Break it into 2 steps:

| Step | What happens | When |
|------|--------------|------|
| `int[] arr` | Declaration — just creates a reference variable in **Stack**, pointing to nothing yet | **Compile time** |
| `= new int[5]` | Actual array object gets created in **Heap** memory | **Runtime** |

This creation of memory *while the program is running* is called:

> ### Dynamic Memory Allocation
> Assigning memory space during execution (runtime), not before.

**Picture it like this:**
```
STACK                HEAP
-----                ----------------
arr  ---------->     [3][18][9][2]...
```
- `arr` lives in the Stack.
- The actual array (the boxes of data) lives in the Heap.

---

## 5. Is an Array's memory continuous?

- In **C/C++** → YES, arrays are stored in continuous memory blocks.
- In **Java** → **NOT guaranteed.** It depends on the JVM.

**Why?**
1. We know all objects (including arrays) live in the **Heap**.
2. Java Language Specification (JLS) says **Heap memory is not guaranteed continuous**.
3. Since arrays are Heap objects → **array elements in Java may not be stored continuously**, even though the textbook definition of "array" says it should be continuous.

So if anyone asks *"is an array continuous in Java?"* → answer: **"It depends on the JVM — Heap memory isn't guaranteed to be continuous."**

---

## 6. Index of an Array

- Indexing **starts from 0**.
- `arr[0]` → first element
- `arr[2]` → third element
- Updating: `arr[3] = 99;` → changes the value at index 3.

⚠️ If array size is 5, valid indices are `0,1,2,3,4`. Trying `arr[5]` → **ArrayIndexOutOfBoundsException**.

---

## 7. The `new` Keyword

> `new` is used to **create an object** in memory (specifically in the Heap).

```java
int[] arr = new int[5];
```
This creates an integer array object of size 5 in the Heap.

Even when you write `int[] arr = {1,2,3};` (without explicitly using `new`), Java does this internally anyway.

**Default values when array is empty:**
- `int[]` → all elements default to **0**
- `String[]` (or any object type) → all elements default to **null**

---

## 8. What is `null` in Java?

- `null` is **not a data type**, not an object — it's a **special literal**.
- It is the **default value of any reference variable** that hasn't been assigned anything yet.
- Comparable to `None` in Python.
- You **cannot** assign `null` to a primitive (`int`, `char`, etc.) — only to reference types (String, arrays, custom objects).

```java
String str = null;   // ✅ valid
int num = null;       // ❌ compile error
```

---

## 9. Primitives vs Objects (Memory-wise)

| Type | Where stored |
|------|--------------|
| Primitives (int, char, boolean, float...) | **Stack** |
| Objects (String, Array, custom classes, HashMap...) | **Heap** |

**Important Insight:**
For an array of objects (e.g., `String[]`), the array itself is just a bunch of **reference variables**, each pointing to its own object somewhere in the Heap. That's why they default to `null` — references with nothing assigned yet.

```
STACK            HEAP (array of refs)        HEAP (actual objects)
-----            --------------------        ----------------------
strArr  ----->   [ref0][ref1][ref2][ref3]     "AA" "BB" "CC" "DD"
                    |     |    |     |          ↑    ↑    ↑    ↑
                    -------------------------------------
```

---

## 10. Taking Input in an Array

### Manual way (repetitive, bad for big arrays):
```java
arr[0] = 23;
arr[1] = 45;
```

### Using a `for` loop:
```java
Scanner in = new Scanner(System.in);
for (int i = 0; i < arr.length; i++) {
    arr[i] = in.nextInt();
}
```
> `arr.length` gives the size of the array — use this instead of hardcoding numbers.

### Using `for-each` loop (only for reading/printing, not for input by index):
```java
for (int num : arr) {
    System.out.println(num);
}
```
Read it as: *"for every element `num` of type int in array `arr`, print num."*

---

## 11. Printing an Array — 3 Ways

1. **Manual for loop with index**
```java
for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
```

2. **for-each loop**
```java
for (int num : arr) System.out.print(num + " ");
```

3. **Best way — `Arrays.toString()`**
```java
System.out.println(Arrays.toString(arr));
```
This internally uses a for loop too, but neatly formats it with `[ ]` and commas.

---

## 12. Mutability of Arrays (Passing Array to a Function)

Java passes everything by **value** — but for objects/arrays, the "value" passed is a **copy of the reference**, which still points to the **same object**.

```java
static void change(int[] arr) {
    arr[0] = 99;
}

public static void main(String[] args) {
    int[] nums = {3, 4, 5, 12};
    change(nums);
    System.out.println(nums[0]); // prints 99!
}
```

Because both `nums` (outside) and `arr` (inside function) point to the **same array object** in Heap, changing it inside the function changes the original too.

> 🔑 **Arrays are mutable in Java.** (Strings are immutable — covered separately.)

---

## 13. 2D Arrays (Multi-Dimensional Arrays)

Think of it as a **matrix**:
```java
int[][] arr = new int[3][3]; // 3 rows, 3 columns
```
or directly:
```java
int[][] arr = {
    {1,2,3},
    {4,5,6},
    {7,8,9}
};
```

**Important rule:** Specifying number of **rows is mandatory**, columns is NOT mandatory.

### Internal Working
> A 2D array in Java is actually an **"array of arrays"**.

```
HEAP (outer array)        HEAP (inner arrays — can be anywhere)
-----------------         --------------------------------------
[ref0][ref1][ref2]  ---->  [1,2,3]   [4,5,6]   [7,8,9]
```
- Each row is its own separate array object, possibly stored in different memory locations.
- That's why each row can have a **different number of columns** (jagged arrays):
```java
int[][] arr = {
    {1,2,3},
    {4,5},
    {6,7,8,9}
};
```

### Accessing elements:
```java
arr[1]       // gives entire row → {4,5}
arr[1][0]    // gives first element of that row → 4
```

---

## 14. 2D Array — Input

```java
for (int row = 0; row < arr.length; row++) {
    for (int col = 0; col < arr[row].length; col++) {
        arr[row][col] = in.nextInt();
    }
}
```
> Use `arr[row].length` (not a fixed number) because each row can have a different size.

## 15. 2D Array — Output

```java
for (int row = 0; row < arr.length; row++) {
    for (int col = 0; col < arr[row].length; col++) {
        System.out.print(arr[row][col] + " ");
    }
    System.out.println(); // new line after each row
}
```

**Shortcut using `Arrays.toString()`:**
```java
for (int[] row : arr) {
    System.out.println(Arrays.toString(row));
}
```
Here `int[] row` makes sense because **each element of a 2D array is itself a 1D array (int[])**.

---

## 16. ArrayList — Why do we need it?

Arrays have a **fixed size**. Once declared, you can't grow/shrink them.

But what if you don't know the size in advance?
👉 Use **ArrayList** — Java handles resizing automatically for you.
(Similar to `vector` in C++.)

ArrayList is part of the **Collection Framework** (`java.util` package).

### Syntax
```java
ArrayList<Integer> list = new ArrayList<>();
```
- Must use **wrapper classes** (`Integer`, `String`, etc.) — NOT primitives (`int`, `char`) directly. (Reason tied to Generics — covered in OOP.)
- You can optionally pass an initial capacity: `new ArrayList<>(10);` — but this is just a starting hint, NOT a hard limit.

- When you create an ArrayList without passing a size, Java initializes it with a default initial capacity of 10 elements.
---

## 17. Common ArrayList Operations

```java
list.add(67);                  // add element
list.get(0);                   // get element at index
list.set(0, 99);                // update element at index
list.remove(2);                 // remove element at index
list.contains(654);             // check if value exists -> true/false
System.out.println(list);       // print entire list
```

### Iterating + Taking Input
```java
Scanner in = new Scanner(System.in);
for (int i = 0; i < 5; i++) {
    list.add(in.nextInt());
}
```

---

## 18. How does ArrayList grow automatically? (Internal Working)

**Key fact:** Internally, the size IS fixed at any given moment — but here's the trick:

1. When the internal array gets close to full,
2. Java **creates a NEW, bigger array** (roughly double-ish, calculated via a growth formula),
3. **Copies** all old elements into this new array,
4. **Deletes** the old array.

```
Old array (size 4, full) → [1][2][3][4]
                                  ↓ grow
New array (bigger)       → [1][2][3][4][_][_][_][_]
```

This is why adding elements to an ArrayList "feels" unlimited — Java keeps quietly resizing behind the scenes.

> This growth strategy gives **amortized constant time complexity O(1)** for `add()` on average (explained in detail in Time Complexity sessions).

---

## 19. Multi-Dimensional ArrayList

```java
ArrayList<ArrayList<Integer>> list = new ArrayList<>();
```
⚠️ Unlike arrays, this does **NOT auto-create inner lists.** You must manually add them:
```java
list.add(new ArrayList<>());
list.add(new ArrayList<>());
list.add(new ArrayList<>());
```
Otherwise calling `list.get(0).add(5)` throws an error because there's no list at index 0 yet.

---

## 20. Practice Questions Covered

### Q1. Swap two elements in an array
```java
static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```
Since arrays are passed by reference (copy of reference), changes reflect in the original array.

---

### Q2. Find Maximum element in an array
```java
static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) max = arr[i];
    }
    return max;
}
```

**Variation — Maximum in a range [start, end]:**
```java
static int maxRange(int[] arr, int start, int end) {
    int max = arr[start];
    for (int i = start; i <= end; i++) {
        if (arr[i] > max) max = arr[i];
    }
    return max;
}
```
👉 Add edge case checks: array null, array empty, end < start → return -1.

---

### Q3. Reverse an Array (Two-Pointer Technique)
**Idea:** Use a `start` pointer and an `end` pointer. Swap them, then move `start` forward and `end` backward, until they cross.

```java
static void reverse(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
        swap(arr, start, end);
        start++;
        end--;
    }
}
```

This is your first taste of the **Two-Pointer Method** — a very common pattern in DSA, used heavily in array/subarray questions.

---

## Quick Summary Cheat Sheet 📝

| Concept | One-liner |
|---|---|
| Array | Fixed-size collection of same-type elements |
| Declaration | `int[] arr;` → Stack, compile time |
| Initialization | `arr = new int[5];` → Heap, runtime |
| Index | Starts from 0 |
| Default value | 0 for primitives, null for objects |
| Continuity | Not guaranteed in Java (depends on JVM) |
| Mutability | Arrays ARE mutable (passed by reference copy) |
| 2D Array | Array of arrays — rows can have different lengths |
| ArrayList | Dynamic-size array, auto-resizes internally |
| Two-pointer | start & end pointers moving towards each other (used in reverse, swap-type problems) |

---

