# Merge Sort 

> **Prerequisites:** Recursion, Arrays, Basic Time Complexity (Big-O)  
> **Difficulty:** Intermediate

---

## Table of Contents

1. [Core Concept](#1-core-concept)
2. [The Algorithm](#2-the-algorithm)
3. [Standard (Recursive) Merge Sort](#3-standard-recursive-merge-sort)
4. [In-Place Merge Sort](#4-in-place-merge-sort)
5. [Time & Space Complexity Analysis](#5-time--space-complexity-analysis)
6. [Stability & Properties](#6-stability--properties)
7. [Visual Walkthrough](#7-visual-walkthrough)
8. [Code Implementations](#8-code-implementations)
9. [Common Mistakes & Edge Cases](#9-common-mistakes--edge-cases)
10. [Comparison with Other Sorts](#10-comparison-with-other-sorts)
11. [Real-World Applications](#11-real-world-applications)
12. [Practice Problems](#12-practice-problems)
13. [What the Lecture Missed (Added by AI)](#13-what-the-lecture-missed-added-by-ai)

---

## 1. Core Concept

Merge Sort is a **Divide and Conquer** algorithm that works by recursively dividing an array into smaller subarrays, sorting them, and then merging them back together.

### The Three Steps of Divide and Conquer

| Step | Action | Merge Sort Example |
|------|--------|-------------------|
| **Divide** | Break the problem into smaller subproblems | Split array into two halves |
| **Conquer** | Solve subproblems recursively | Sort each half recursively |
| **Combine** | Merge solutions of subproblems | Merge two sorted halves into one |

### Key Insight
> **If you can merge two sorted arrays efficiently, you can sort any array by recursively splitting it until each piece has 1 element (which is already sorted), then merging back up.**

---

## 2. The Algorithm

### Pseudocode

```
MergeSort(arr, left, right):
    if left < right:
        mid = left + (right - left) / 2   // Avoid overflow

        MergeSort(arr, left, mid)         // Sort first half
        MergeSort(arr, mid + 1, right)    // Sort second half
        Merge(arr, left, mid, right)      // Merge sorted halves
```

### Merge Process

```
Merge(arr, left, mid, right):
    Create temporary array temp[right - left + 1]
    i = left        // Pointer for left half
    j = mid + 1     // Pointer for right half
    k = 0           // Pointer for temp array

    // Compare and copy smaller element
    while i <= mid AND j <= right:
        if arr[i] <= arr[j]:
            temp[k] = arr[i]
            i++
        else:
            temp[k] = arr[j]
            j++
        k++

    // Copy remaining elements from left half
    while i <= mid:
        temp[k] = arr[i]
        i++; k++

    // Copy remaining elements from right half
    while j <= right:
        temp[k] = arr[j]
        j++; k++

    // Copy temp back to original array
    for p from 0 to k-1:
        arr[left + p] = temp[p]
```

---

## 3. Standard (Recursive) Merge Sort

### How Recursion Works Here

```
Original: [38, 27, 43, 3, 9, 82, 10]

Level 0:              [38, 27, 43, 3, 9, 82, 10]
                     /                      \
Level 1:      [38, 27, 43]              [3, 9, 82, 10]
              /         \                /           \
Level 2:  [38, 27]    [43]         [3, 9]        [82, 10]
          /     \                    /    \          /     \
Level 3: [38]  [27]              [3]   [9]     [82]   [10]
          \     /                  \    /        \     /
Level 2: [27, 38]    [43]         [3, 9]        [10, 82]
              \       /              \           /
Level 1:      [27, 38, 43]              [3, 9, 10, 82]
                     \                  /
Level 0:              [3, 9, 10, 27, 38, 43, 82]  ✅ SORTED
```

### Base Case
- When `left >= right` (single element or empty), the array is already sorted
- This is the termination condition for recursion

---

## 4. In-Place Merge Sort

### The Problem with Standard Merge Sort
Standard Merge Sort uses **O(n)** extra space for the temporary array during merging. For very large datasets, this can be prohibitive.

### In-Place Approaches

#### Approach 1: Shifting Elements (Simple but O(n²))
- Maintain two pointers at start of each half
- If left element is smaller, advance left pointer
- If right element is smaller, shift all elements between pointers right by 1, insert the smaller element
- **Time:** O(n² log n) | **Space:** O(1)

#### Approach 2: Shell Sort / Gap Method (Better)
- Use gap-based comparison (like Shell Sort) to merge
- Start with gap = ceil(n/2), reduce by half each iteration
- Compare and swap elements at gap distance
- **Time:** O(n log² n) | **Space:** O(1)

#### Approach 3: Mathematical Encoding (Clever)
- Encode two values into one using: `A = A + B * max_element`
- Recover original: `A % max_element` and `B = A / max_element`
- **Time:** O(n log n) | **Space:** O(1) but modifies values temporarily

> ⚠️ **Trade-off:** True in-place merge sort either sacrifices time complexity or requires complex implementations. The standard O(n) space version is preferred in practice.

---

## 5. Time & Space Complexity Analysis

### Time Complexity

| Case | Complexity | Explanation |
|------|------------|-------------|
| **Best Case** | O(n log n) | Always divides and merges, no early exit |
| **Average Case** | O(n log n) | Consistent performance regardless of input order |
| **Worst Case** | O(n log n) | Guaranteed upper bound, unlike QuickSort |

#### Why O(n log n)?

**Recurrence Relation:**
```
T(n) = 2T(n/2) + O(n)
```
- `2T(n/2)`: Two recursive calls on half the array
- `O(n)`: Merge operation takes linear time

**Using Master Theorem:**
```
a = 2, b = 2, f(n) = n
n^(log_b(a)) = n^(log_2(2)) = n^1 = n
Since f(n) = Θ(n^(log_b(a))), Case 2 applies:
T(n) = Θ(n log n)
```

**Level-by-Level Analysis:**

| Level | Number of Subproblems | Size of Each | Work per Level |
|-------|----------------------|--------------|----------------|
| 0 | 1 | n | n |
| 1 | 2 | n/2 | 2 × n/2 = n |
| 2 | 4 | n/4 | 4 × n/4 = n |
| ... | ... | ... | ... |
| log n | n | 1 | n × 1 = n |

**Total levels:** log₂(n) + 1  
**Work per level:** n  
**Total work:** n × log₂(n) = **O(n log n)**

### Space Complexity

| Implementation | Space | Usage |
|---------------|-------|-------|
| **Standard** | O(n) | Temporary array for merging + O(log n) recursion stack |
| **In-Place (Gap)** | O(1) | No extra arrays (only recursion stack) |
| **In-Place (Shift)** | O(1) | No extra arrays |

> **Note:** The recursion stack uses O(log n) space in all cases, but we typically express this as O(n) for standard merge sort due to the dominant temporary array.

---

## 6. Stability & Properties

### Stability: ✅ YES

Merge Sort is **stable** — equal elements maintain their relative order.

**Why?** During merge, when `arr[i] == arr[j]`, we take from the left half first, preserving original ordering.

```python
# Stable merge
if arr[i] <= arr[j]:    # <= ensures stability
    temp[k] = arr[i]
    i += 1
else:
    temp[k] = arr[j]
    j += 1
```

### Key Properties

| Property | Value | Significance |
|----------|-------|--------------|
| **Stable** | Yes | Important for multi-key sorting |
| **In-Place** | No (standard) | Requires extra memory |
| **Adaptive** | No | Same performance on sorted/reverse data |
| **Online** | No | Needs entire array upfront |
| **Parallelizable** | Yes | Left and right halves can be sorted concurrently |

---

## 7. Visual Walkthrough

### Example: Sort [6, 5, 12, 10, 9, 1]

**Step 1: Divide**
```
[6, 5, 12, 10, 9, 1]
       /        \
[6, 5, 12]  [10, 9, 1]
  /     \     /      \
[6,5]  [12] [10,9]  [1]
/  \          /  \
[6][5]        [10][9]
```

**Step 2: Conquer (Base Cases)**
```
[6] [5] [12] [10] [9] [1]  ← All size 1, already sorted
```

**Step 3: Merge Up**
```
Merge [6] and [5]:     [5, 6]
Merge [10] and [9]:    [9, 10]

Merge [5, 6] and [12]: [5, 6, 12]
Merge [9, 10] and [1]: [1, 9, 10]

Final Merge:
  [5, 6, 12] + [1, 9, 10]

  Compare 5 vs 1 → take 1
  Compare 5 vs 9 → take 5
  Compare 6 vs 9 → take 6
  Compare 12 vs 9 → take 9
  Compare 12 vs 10 → take 10
  Take remaining 12

Result: [1, 5, 6, 9, 10, 12] ✅
```

---

## 8. Code Implementations

### Python - Standard Merge Sort

```python
def merge_sort(arr):
    """
    Standard Merge Sort - O(n log n) time, O(n) space
    Stable sorting algorithm
    """
    if len(arr) <= 1:
        return arr

    # Divide
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    # Conquer (Merge)
    return merge(left, right)

def merge(left, right):
    """Merge two sorted arrays into one sorted array"""
    result = []
    i = j = 0

    # Compare and append smaller element
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:  # <= for stability
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    # Append remaining elements
    result.extend(left[i:])
    result.extend(right[j:])

    return result

# Usage
arr = [38, 27, 43, 3, 9, 82, 10]
sorted_arr = merge_sort(arr)
print(sorted_arr)  # [3, 9, 10, 27, 38, 43, 82]
```

### Python - In-Place (Efficient Version)

```python
def merge_sort_inplace(arr, left=0, right=None):
    """
    In-Place Merge Sort using index-based approach
    Modifies original array, uses O(n) auxiliary space for merge
    """
    if right is None:
        right = len(arr) - 1

    if left < right:
        mid = left + (right - left) // 2

        merge_sort_inplace(arr, left, mid)
        merge_sort_inplace(arr, mid + 1, right)
        merge_inplace(arr, left, mid, right)

def merge_inplace(arr, left, mid, right):
    """Merge two sorted subarrays [left..mid] and [mid+1..right]"""
    # Create temporary array
    temp = []
    i, j = left, mid + 1

    while i <= mid and j <= right:
        if arr[i] <= arr[j]:
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            j += 1

    # Copy remaining elements
    while i <= mid:
        temp.append(arr[i])
        i += 1
    while j <= right:
        temp.append(arr[j])
        j += 1

    # Copy back to original array
    for idx, val in enumerate(temp):
        arr[left + idx] = val

# Usage
arr = [38, 27, 43, 3, 9, 82, 10]
merge_sort_inplace(arr)
print(arr)  # [3, 9, 10, 27, 38, 43, 82]
```

### C++ - Standard Implementation

```cpp
#include <vector>
using namespace std;

void merge(vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    vector<int> leftArr(n1), rightArr(n2);

    // Copy data to temp arrays
    for (int i = 0; i < n1; i++)
        leftArr[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        rightArr[j] = arr[mid + 1 + j];

    // Merge temp arrays back
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i];
            i++;
        } else {
            arr[k] = rightArr[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements
    while (i < n1) arr[k++] = leftArr[i++];
    while (j < n2) arr[k++] = rightArr[j++];
}

void mergeSort(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;  // Avoid overflow
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}
```

---

## 9. Common Mistakes & Edge Cases

### ❌ Mistake 1: Integer Overflow in Mid Calculation

```cpp
// WRONG - can overflow for large arrays
int mid = (left + right) / 2;

// CORRECT - avoids overflow
int mid = left + (right - left) / 2;
```

### ❌ Mistake 2: Off-by-One in Merge Bounds

```cpp
// WRONG
for (int i = left; i <= right; i++)  // If using < in loop conditions

// CORRECT - ensure all elements are covered
while (i <= mid)     // Include mid
while (j <= right)   // Include right
```

### ❌ Mistake 3: Not Handling Empty Subarrays

```python
# Always check base case
if len(arr) <= 1:
    return arr  # 0 or 1 element is already sorted
```

### Edge Cases to Test

| Case | Example | Expected Behavior |
|------|---------|-------------------|
| Empty array | `[]` | Return empty |
| Single element | `[5]` | Return `[5]` |
| Already sorted | `[1, 2, 3, 4]` | O(n log n) still, no optimization |
| Reverse sorted | `[4, 3, 2, 1]` | O(n log n), same as average |
| All duplicates | `[5, 5, 5, 5]` | Stable, maintain order |
| Two elements | `[2, 1]` | Correctly swap |
| Large numbers | `[INT_MAX, INT_MIN]` | Handle without overflow |

---

## 10. Comparison with Other Sorts

| Algorithm | Best | Average | Worst | Space | Stable | Notes |
|-----------|------|---------|-------|-------|--------|-------|
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ | Guaranteed performance, great for linked lists |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ | Usually faster in practice, cache-friendly |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | ❌ | In-place but not stable |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ | Good for small arrays |
| **Tim Sort** | O(n) | O(n log n) | O(n log n) | O(n) | ✅ | Hybrid (Merge + Insertion), used in Python/Java |
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ | Educational only |

### When to Choose Merge Sort?

✅ **Use Merge Sort when:**
- You need **guaranteed** O(n log n) performance
- **Stability** is required (e.g., sorting by multiple keys)
- Sorting **linked lists** (O(1) extra space possible)
- **External sorting** (data doesn't fit in memory)
- **Parallel processing** is available

❌ **Avoid Merge Sort when:**
- Memory is extremely constrained (use Heap Sort instead)
- Average-case speed matters more than worst-case (Quick Sort is faster)
- Array is nearly sorted (Insertion Sort or Tim Sort better)

---

## 11. Real-World Applications

### 1. Database Systems
- External sorting for large datasets that don't fit in RAM
- Merge join operations in SQL

### 2. Programming Language Runtimes
- **Python's `sorted()` and `list.sort()`** use Tim Sort (hybrid of Merge Sort + Insertion Sort)
- **Java's `Arrays.sort()`** for objects uses Tim Sort
- **JavaScript's `Array.prototype.sort()`** (V8 engine) uses a hybrid approach

### 3. File Processing
- Sorting large log files
- Merging sorted files (log merge)

### 4. Scientific Computing
- Stable sorting for numerical simulations
- Sorting in parallel computing frameworks

### 5. Version Control
- Git merge algorithm uses similar merge concepts

---

## 12. Practice Problems

### Easy
1. Implement Merge Sort for a linked list (O(1) space possible)
2. Count inversions in an array using Merge Sort (modification)
3. Merge two sorted arrays without extra space

### Medium
4. **Inversion Count:** Modify merge sort to count how many pairs (i, j) exist where i < j and arr[i] > arr[j]
5. **Merge K Sorted Arrays:** Use a min-heap or divide-and-conquer approach
6. **External Sort:** Sort a 100GB file with only 4GB RAM

### Hard
7. **Parallel Merge Sort:** Implement using multi-threading (OpenMP/C++ threads)
8. **In-Place Merge Sort:** Implement with O(1) space and O(n log n) time
9. **Tim Sort:** Implement the hybrid algorithm used in Python

### LeetCode Recommendations
- [912. Sort an Array](https://leetcode.com/problems/sort-an-array/)
- [315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)
- [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)

---

## 13. What the Lecture Missed (Added by AI)

### 🔍 Missing Topic 1: Master Theorem Proof
The lecture mentioned O(n log n) but didn't derive it using the Master Theorem. Understanding the recurrence `T(n) = 2T(n/2) + O(n)` is crucial for interview settings.

### 🔍 Missing Topic 2: Linked List Merge Sort
Merge Sort is the **ideal** sorting algorithm for linked lists because:
- No random access needed (unlike QuickSort)
- Can be done in O(1) extra space
- No shifting required during merge

```python
class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None

def merge_sort_linked_list(head):
    if not head or not head.next:
        return head

    # Find middle using slow/fast pointers
    slow, fast = head, head.next
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    mid = slow.next
    slow.next = None  # Split the list

    left = merge_sort_linked_list(head)
    right = merge_sort_linked_list(mid)

    return merge_linked_lists(left, right)
```

### 🔍 Missing Topic 3: Bottom-Up (Iterative) Merge Sort
Eliminates recursion overhead — useful for extremely deep recursion or stack-limited environments.

```python
def merge_sort_bottom_up(arr):
    n = len(arr)
    width = 1
    while width < n:
        for i in range(0, n, 2 * width):
            left = i
            mid = min(i + width - 1, n - 1)
            right = min(i + 2 * width - 1, n - 1)
            merge_inplace(arr, left, mid, right)
        width *= 2
    return arr
```

### 🔍 Missing Topic 4: Natural Merge Sort
Takes advantage of existing "runs" (already sorted sequences) in the data. If the data has long runs, performance approaches O(n).

### 🔍 Missing Topic 5: Multi-threaded / Parallel Merge Sort
Since left and right halves are independent, they can be sorted in parallel:

```cpp
// Conceptual parallel version
void parallel_merge_sort(vector<int>& arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        #pragma omp parallel sections
        {
            #pragma omp section
            parallel_merge_sort(arr, left, mid);
            #pragma omp section
            parallel_merge_sort(arr, mid + 1, right);
        }
        merge(arr, left, mid, right);
    }
}
```

### 🔍 Missing Topic 6: Inversion Count (Important Interview Problem)
The number of inversions indicates how "out of order" an array is. Merge Sort naturally counts inversions during the merge step:

```python
def count_inversions(arr):
    """Count inversions using modified merge sort"""
    count = [0]  # Use list for mutable reference

    def merge_count(arr, temp, left, mid, right):
        i, j, k = left, mid + 1, left
        inv_count = 0

        while i <= mid and j <= right:
            if arr[i] <= arr[j]:
                temp[k] = arr[i]
                i += 1
            else:
                temp[k] = arr[j]
                inv_count += (mid - i + 1)  # All remaining in left half form inversions
                j += 1
            k += 1

        # Copy remaining and back
        while i <= mid: temp[k] = arr[i]; i += 1; k += 1
        while j <= right: temp[k] = arr[j]; j += 1; k += 1

        for i in range(left, right + 1):
            arr[i] = temp[i]

        return inv_count

    def merge_sort_count(arr, temp, left, right):
        inv_count = 0
        if left < right:
            mid = (left + right) // 2
            inv_count += merge_sort_count(arr, temp, left, mid)
            inv_count += merge_sort_count(arr, temp, mid + 1, right)
            inv_count += merge_count(arr, temp, left, mid, right)
        return inv_count

    temp = [0] * len(arr)
    return merge_sort_count(arr, temp, 0, len(arr) - 1)
```

### 🔍 Missing Topic 7: Stability Deep Dive
The lecture didn't explain WHY stability matters:
- **Example:** Sorting people first by age, then by name
- If unstable, people with same age might lose their name-ordering
- Merge Sort preserves this because we use `<=` (not `<`) during comparison

### 🔍 Missing Topic 8: External Sorting
When data is too large for memory:
1. Divide file into chunks that fit in memory
2. Sort each chunk using Merge Sort
3. Merge sorted chunks using k-way merge

This is exactly how database systems handle large table sorting.

### 🔍 Missing Topic 9: Comparison with QuickSort
The lecture didn't contrast with QuickSort:
- QuickSort is generally faster in practice due to cache locality
- But MergeSort guarantees O(n log n) worst case
- MergeSort is stable; QuickSort is not (without extra space)
- MergeSort works well on linked lists; QuickSort does not

### 🔍 Missing Topic 10: Mathematical Induction Proof
A formal proof that Merge Sort works:

**Base Case:** Array of size 0 or 1 is trivially sorted.  
**Inductive Hypothesis:** Assume Merge Sort correctly sorts arrays of size < n.  
**Inductive Step:** For array of size n:
- Split into two halves of size < n
- By IH, both halves are sorted correctly
- Merge procedure correctly combines two sorted arrays into one sorted array
- Therefore, full array is sorted. ∎

---

## Quick Reference Card

```
┌─────────────────────────────────────────┐
│           MERGE SORT CHEAT SHEET        │
├─────────────────────────────────────────┤
│ Time:  O(n log n) - all cases          │
│ Space: O(n) - standard                  │
│        O(1) - in-place variants         │
│ Stable: YES                             │
│ In-Place: NO (standard)                 │
│ Method: Divide and Conquer              │
├─────────────────────────────────────────┤
│ Best For:                               │
│ • Linked lists                          │
│ • External sorting                      │
│ • Stable sort requirement               │
│ • Guaranteed performance                │
│ • Parallel processing                   │
├─────────────────────────────────────────┤
│ Avoid When:                             │
│ • Memory is extremely limited           │
│ • Average speed > worst-case guarantee  │
│ • Array is nearly sorted                │
└─────────────────────────────────────────┘
```

---

## Summary

Merge Sort is a fundamental algorithm that exemplifies the **Divide and Conquer** paradigm. Its predictable O(n log n) performance, stability, and natural parallelizability make it indispensable in systems programming, database engines, and language runtimes. While not always the fastest in practice (QuickSort typically wins there), its guarantees make it the go-to choice when reliability matters.

The key insight to remember: **If you can efficiently merge two sorted arrays, you can efficiently sort any array by recursively breaking it down.**

---

*Notes compiled from lecture transcript analysis with additional depth, proofs, implementations, and real-world context added by AI.*
