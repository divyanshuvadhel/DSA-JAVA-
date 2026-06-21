# Bubble Sort 

## 1. What is Bubble Sort?

Bubble Sort is the simplest **comparison-based sorting algorithm**. Like every comparison sort, it works by comparing adjacent elements of an array and swapping them if they are in the wrong order. Over repeated passes through the array, the largest (or smallest) elements "bubble up" to their correct position — hence the name.

> **Goal:** Arrange elements of an array in ascending or descending order.

Example array: `[5, 1, 4, 2, 8]` → after sorting (ascending): `[1, 2, 4, 5, 8]`

---

## 2. Core Idea

In **every pass**, we compare **adjacent elements** of the array:
- If `arr[j] > arr[j+1]` (for ascending order), **swap** them.
- If not, leave them as is.

After **one full pass**, the largest unsorted element gets pushed to its correct (rightmost) position.

So:
- After **Pass 1** → the largest element is in its correct final position (last index).
- After **Pass 2** → the 2nd largest element is in its correct position (2nd-last index).
- After **Pass 3** → the 3rd largest element is in its correct position.
- … and so on.

This means: to fully sort `n` elements, we need at most `n - 1` passes.

---

## 3. Dry Run Example

Array: `[5, 1, 4, 2, 8]`, ascending order.

**Pass 1:**
| Compare | Action | Array |
|---|---|---|
| 5,1 | swap | [1,5,4,2,8] |
| 5,4 | swap | [1,4,5,2,8] |
| 5,2 | swap | [1,4,2,5,8] |
| 5,8 | no swap | [1,4,2,5,8] |

→ Largest element `8` is now at the last index. ✅

**Pass 2:**
| Compare | Action | Array |
|---|---|---|
| 1,4 | no swap | [1,4,2,5,8] |
| 4,2 | swap | [1,2,4,5,8] |
| 4,5 | no swap | [1,2,4,5,8] |

→ Second largest `5` settled.

**Pass 3:**
| Compare | Action | Array |
|---|---|---|
| 1,2 | no swap | [1,2,4,5,8] |
| 2,4 | no swap | [1,2,4,5,8] |

→ No swaps happened → array is **already sorted**. We can stop early (this is the basis of the optimization in Section 6).

**Final sorted array:** `[1, 2, 4, 5, 8]`

---

## 4. Pseudocode

```
BubbleSort(arr, n):
    for i = 0 to n-2:                  # outer loop: n-1 passes
        for j = 0 to n-2-i:             # inner loop: shrinks each pass
            if arr[j] > arr[j+1]:
                swap(arr[j], arr[j+1])
```

### Why does the inner loop shrink (`n - 1 - i`)?
Because after each pass `i`, the last `i` elements are already sorted and in their final position — there's no need to compare them again. This small detail is itself an optimization built into the basic algorithm.

---

---

## 6. Optimization: Early Exit Using a Flag

If during a pass **no swaps** occur, it means the array is already sorted — we don't need any further passes. This is a key optimization interviewers expect you to mention.



This optimization is what makes Bubble Sort's **best case** complexity `O(n)` instead of `O(n²)` (see below).

---

## 7. Other Names for Bubble Sort

- **Sinking Sort**
- **Exchange Sort**
- Sometimes informally called **"comparison swap sort"**

(All names refer to the same comparison-and-swap mechanism.)

---

## 8. Time Complexity

| Case | Condition | Complexity | Explanation |
|---|---|---|---|
| **Worst Case** | Array sorted in reverse order | **O(n²)** | Every element must be compared and swapped in every pass |
| **Average Case** | Random order | **O(n²)** | On average, about half the comparisons result in swaps |
| **Best Case** | Array already sorted | **O(n)** | Only ONE pass needed (with early-exit optimization); without optimization, still O(n²) |

### Number of comparisons (without optimization)
Total comparisons = `(n-1) + (n-2) + (n-3) + ... + 1`
= `n(n-1)/2`
= `O(n²)`

This sum is the classic arithmetic series, which is why Bubble Sort is quadratic.

---

## 9. Space Complexity

**O(1)** — Bubble Sort is an **in-place** sorting algorithm. It does not require any extra array or data structure; it only uses a constant amount of extra space (for the temporary swap variable).

---

## 10. Stability

Bubble Sort is a **stable sorting algorithm**.

> **Stable** means: if two elements have equal values, their **relative order is preserved** after sorting.

Example: if two elements with the same key appear in the original array at positions `i` and `j` (`i < j`), they will still appear in that same relative order after sorting. This matters in real-world use cases — e.g., sorting student records by marks while keeping students with equal marks in their original (e.g., alphabetical or roll-number) order.

Bubble Sort achieves stability because it **only swaps elements when one is strictly greater than the next** (`arr[j] > arr[j+1]`) — equal elements are never swapped, so their order never changes.

---

## 11. Advantages and Disadvantages

**Advantages:**
- Very simple to understand and implement
- In-place (no extra memory)
- Stable
- Good for nearly-sorted or small datasets (with the optimized version)

**Disadvantages:**
- Inefficient for large datasets — O(n²) in average/worst case
- Generally outperformed in practice by Insertion Sort even though both are O(n²), because Bubble Sort does more swaps
- Not used in production-grade sorting libraries; mainly used for teaching algorithmic thinking

---

## 12. Where Bubble Sort Fits — Comparison with Other Sorting Algorithms

| Algorithm | Best | Average | Worst | Space | Stable? |
|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |

This table wasn't explicit in the lecture but is essential context: it shows **why** interviewers ask about Bubble Sort — not because it's used in practice, but because it builds the foundation for understanding comparison-based sorting, swap mechanics, stability, and complexity analysis, all of which transfer directly to Selection Sort and Insertion Sort (commonly taught right after).

---

## 13. Common Interview Questions on Bubble Sort

1. What is the time and space complexity of Bubble Sort (all three cases)?
2. Why is Bubble Sort stable?
3. How would you optimize Bubble Sort? (early-exit flag)
4. Trace through Bubble Sort on a given array, showing each pass.
5. Compare Bubble Sort with Selection Sort and Insertion Sort.
6. Implement Bubble Sort in your language of choice, both with and without optimization.
7. Why does the inner loop range shrink with each outer loop iteration?

---

## 14. Quick Summary (Cheat Sheet)

- **Mechanism:** Repeatedly compare adjacent elements, swap if out of order
- **Passes needed:** up to `n - 1`
- **Best case (optimized):** O(n)
- **Average/Worst case:** O(n²)
- **Space:** O(1) — in-place
- **Stability:** Stable
- **Other names:** Sinking Sort, Exchange Sort
- **Key optimization:** Track if any swap happened in a pass; if not, break early