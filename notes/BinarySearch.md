> # Binary Search

## 1. What is Binary Search?
- A **search algorithm** used to find the position of a target element in a **sorted** array.
- Works by repeatedly dividing the search space in half.
- Much faster than Linear Search for large, sorted datasets.

## 2. Why Binary Search?
- **Linear Search**: worst case O(n) comparisons (e.g., 1 million elements → up to 1 million comparisons).
- **Binary Search**: worst case O(log₂ n) comparisons (e.g., 1 million elements → only ~20 comparisons).
- Massive performance gain as input size grows — the time grows logarithmically, not linearly.

## 3. Pre-requisite
- The array **must be sorted** (ascending or descending). Binary search does not work on unsorted data.

## 4. Algorithm Steps (Ascending Order)
1. Set `start = 0`, `end = n - 1`.
2. While `start <= end`:
    - Compute `middle = start + (end - start) / 2` (avoids integer overflow vs. `(start+end)/2`).
    - If `arr[middle] == target` → return `middle` (found).
    - If `target > arr[middle]` → search the **right half**: `start = middle + 1`.
    - If `target < arr[middle]` → search the **left half**: `end = middle - 1`.
3. If the loop ends without finding the target → return `-1` (not found).

## 5. Pseudocode / Java-style Code
```java
static int binarySearch(int[] arr, int target) {
    int start = 0, end = arr.length - 1;

    while (start <= end) {
        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;          // found
        } else if (target > arr[middle]) {
            start = middle + 1;     // search right half
        } else {
            end = middle - 1;       // search left half
        }
    }
    return -1; // not found
}
```

## 6. Order-Agnostic Binary Search
- A variant that works whether the array is sorted in **ascending or descending** order.
- First check the order by comparing `arr[start]` and `arr[end]`:
    - If `arr[start] < arr[end]` → ascending order logic.
    - Else → descending order logic (comparisons are flipped).

```java
static int orderAgnosticBinarySearch(int[] arr, int target) {
    int start = 0, end = arr.length - 1;
    boolean isAscending = arr[start] < arr[end];

    while (start <= end) {
        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (isAscending) {
            if (target > arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        } else { // descending order
            if (target < arr[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }
    return -1;
}
```

## 7. Time & Space Complexity
| Aspect | Complexity |
|---|---|
| Best Case | O(1) — target is the middle element on first check |
| Average / Worst Case | O(log n) |
| Space Complexity | O(1) — iterative version uses no extra space |

## 8. Number of Levels / Comparisons Intuition
- Each comparison halves the search space: `n → n/2 → n/4 → ... → 1`.
- Number of halving steps `k` satisfies: `n / 2^k = 1` → `k = log₂(n)`.
- This is why binary search is described as O(log n).

## 9. Key Interview Points
- Always confirm the array is **sorted** before applying binary search.
- Use `start + (end - start) / 2` instead of `(start + end) / 2` to avoid overflow in languages with fixed-size integers.
- Common variants to know:
    - Find first/last occurrence of an element.
    - Find ceiling/floor of a number in a sorted array.
    - Search in a sorted array with duplicates.
    - Order-agnostic search (ascending or descending).
    - Search in infinite/unbounded sorted array.
- A full set of **Binary Search interview questions** is typically covered in a follow-up video/lecture (as referenced in the source video).

## 10. Quick Summary
- **Goal**: Find target in sorted array efficiently.
- **Technique**: Divide and conquer — repeatedly check the middle, discard half.
- **Complexity**: O(log n) time, O(1) space (iterative).
- **Requirement**: Array must be sorted.