# Cycle Sort 

## 1. What is Cycle Sort?

Cycle Sort is an **in-place**, **unstable** comparison-based sorting algorithm. It is theoretically optimal in terms of the number of writes to the original array — it minimizes memory writes. Unlike Bubble Sort or Selection Sort, Cycle Sort is not a general-purpose algorithm you reach for by default, but it is **conceptually powerful** and appears in problems where **write operations are expensive** (e.g., flash memory, EEPROM, or certain constrained environments).

---

## 2. Core Intuition

Imagine every element in an unsorted array has a **"correct position"** it wants to go to. If the array were sorted, each value would sit at a specific index.

Cycle Sort works by:
1. Picking an element.
2. Finding its **correct position** in the sorted array.
3. **Placing it there** (swapping or overwriting).
4. Taking the element that was displaced and repeating the process until we come back to the starting position — completing a **"cycle."**

This is why it's called *Cycle* Sort. You follow a cycle of displaced elements until everyone is home.

---

## 3. Algorithm Steps (Detailed)

Given an array `arr[]` of size `n`:

### For each position `i` from `0` to `n-2`:

1. **Find the correct position** of `arr[i]` in the sorted array.
    - For a general array (duplicates allowed), the correct position is the **count of elements smaller than `arr[i]`**.
    - If duplicates exist, we must handle them carefully to avoid infinite loops.

2. **If `arr[i]` is already at its correct position**, move to the next `i`.

3. **Otherwise**, place `arr[i]` at its correct position. The element previously at that position is now displaced.

4. **Repeat** the process for the displaced element until the displaced element wants to go back to position `i` — the cycle is complete.

---

## 4. Java Implementation

### 4.1 Basic Version (Distinct Elements)

```java
public class CycleSort {

    public static void cycleSort(int[] arr) {
        int n = arr.length;

        for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
            int item = arr[cycleStart];

            // Find the correct position for 'item'
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // If item is already at correct position
            if (pos == cycleStart) {
                continue;
            }

            // Skip duplicates (find the rightmost position for duplicates)
            while (item == arr[pos]) {
                pos++;
            }

            // Place the item at its correct position
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;

            // Rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;

                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                while (item == arr[pos]) {
                    pos++;
                }

                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 9, 10, 10, 2, 4};
        cycleSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 1 2 3 4 8 9 10 10
    }
}
```

### 4.2 Optimized Version for Range `[1, n]` (No Duplicates)

A common interview variant: when elements are in range `[1, n]` and all distinct, Cycle Sort becomes **O(n)** and extremely elegant:

```java
public class CycleSortOptimized {

    public static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1; // Because values are 1 to n

            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        cycleSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 1 2 3 4 5
    }
}
```

> **This pattern is GOLD.** It appears in problems like:
> - Find the Missing Number
> - Find the Duplicate Number
> - Find All Duplicates in an Array
> - First Missing Positive

---

## 5. Step-by-Step Trace

Array: `[5, 2, 4, 1, 3]` (values are 1 to 5, distinct)

| Step | Array State | Action |
|------|-------------|--------|
| Start | `[5, 2, 4, 1, 3]` | `i = 0`, `arr[0] = 5`, correct index = `4` |
| 1 | `[3, 2, 4, 1, 5]` | Swap `5` with `arr[4]` |
| 2 | `[3, 2, 4, 1, 5]` | `arr[0] = 3`, correct index = `2` |
| 3 | `[4, 2, 3, 1, 5]` | Swap `3` with `arr[2]` |
| 4 | `[4, 2, 3, 1, 5]` | `arr[0] = 4`, correct index = `3` |
| 5 | `[1, 2, 3, 4, 5]` | Swap `4` with `arr[3]` |
| 6 | `[1, 2, 3, 4, 5]` | `arr[0] = 1`, correct index = `0`. Correct! Move `i` |
| 7 | `[1, 2, 3, 4, 5]` | `i = 1`, `arr[1] = 2`, already correct. Done. |

**Total swaps:** 3. Each element is written at most once to its correct position.

---

## 6. Complexity Analysis

| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n²) | O(1) |
| Average | O(n²) | O(1) |
| Worst | O(n²) | O(1) |

### Why O(n²)?
Finding the correct position for each element requires scanning the remaining elements. In the worst case, we do this for every element.

### But what about the optimized `[1, n]` version?
When values are in range `[1, n]` with no duplicates, the "correct position" is computed in O(1), and each element is swapped at most once.

| Optimized Case | Time Complexity |
|----------------|-----------------|
| `[1, n]`, distinct | **O(n)** |

---

## 7. Key Properties

| Property | Value | Notes |
|----------|-------|-------|
| **In-place** | ✅ Yes | No extra array needed |
| **Stable** | ❌ No | Relative order of equal elements is not preserved |
| **Adaptive** | ❌ No | Doesn't benefit from partially sorted input |
| **Online** | ❌ No | Needs the full array upfront |
| **Minimizes writes** | ✅ Yes | Optimal for write-expensive memory |

---

## 8. Deep Learning Notes

### 8.1 The "Correct Index" Formula
For an array of size `n` containing values in range `[1, n]`:
```
correctIndex = value - 1
```
This is because in a sorted array, `1` goes to index `0`, `2` goes to index `1`, etc.

### 8.2 Why This Works for Finding Missing/Duplicate Numbers
If the array is supposed to contain `[1, n]` but something is wrong:
- If `arr[i]` is not at `arr[i] - 1`, the value at `arr[i] - 1` is either:
    - A duplicate (same value already there)
    - The wrong value (meaning something is missing)

### 8.3 Comparison with Other Sorts

| Algorithm | Best Use Case | Write Minimization |
|-----------|--------------|-------------------|
| Cycle Sort | Write-expensive memory, range `[1,n]` problems | **Optimal** |
| Selection Sort | Small arrays, minimal swaps | Good |
| Insertion Sort | Nearly sorted data | Poor |
| Quick Sort | General purpose | Poor |
| Counting Sort | Integers in small range | N/A (not in-place) |

### 8.4 Common Interview Patterns

**Pattern 1: Find Missing Number**
```java
// After cycle sort, the first index where arr[i] != i+1 is the missing number
```

**Pattern 2: Find Duplicate**
```java
// After cycle sort, the index where arr[i] != i+1 contains a duplicate
// OR where swapping finds arr[i] == arr[correctIndex]
```

**Pattern 3: Find All Missing/Duplicates**
```java
// After cycle sort, scan the array. 
// Missing: index i where arr[i] != i+1 → missing number is i+1
// Duplicate: value arr[i] where arr[i] != i+1
```

---

## 9. Practice Problems (LeetCode / GFG)

1. **LeetCode 268** — Missing Number
2. **LeetCode 287** — Find the Duplicate Number
3. **LeetCode 448** — Find All Numbers Disappeared in an Array
4. **LeetCode 442** — Find All Duplicates in an Array
5. **LeetCode 41** — First Missing Positive
6. **GFG** — Cycle Sort (basic implementation)

---

## 10. Quick Reference Card

```java
// Cycle Sort for range [1, n] — THE PATTERN
while (i < n) {
    int correct = arr[i] - 1;
    if (arr[i] != arr[correct]) {
        swap(arr, i, correct);
    } else {
        i++;
    }
}
```

**Mental Model:**
> "Every number wants to go home. If it's not home, kick whoever is there out and send them to their home. Repeat until everyone is home."

---

## 11. Summary

- **Cycle Sort** is a write-optimal sorting algorithm.
- Its **real power** is not general sorting but the **pattern** it provides for problems involving arrays with values in range `[1, n]`.
- The **O(n)** optimized version is a **must-know** pattern for coding interviews.
- It is **in-place** but **unstable**.
- Master the "correct index" intuition and you can solve an entire family of array problems.

---

> **Pro Tip:** In interviews, when you see "array of size n with values in range [1, n]" or "find missing/duplicate," your brain should immediately think: **"Can I use Cycle Sort pattern here?"**

---

*Happy Learning! 🚀*
