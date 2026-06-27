# Selection Sort Algorithm 

---

## 1. What is Selection Sort?

Selection Sort is a **comparison-based, in-place sorting algorithm**. It divides the array into two parts:

- **Sorted part** — at the beginning of the array (initially empty)
- **Unsorted part** — the rest of the array (initially the whole array)

In every pass, it **selects the smallest (or largest) element** from the unsorted part and **swaps** it with the first element of the unsorted part, effectively growing the sorted part by one element each time.

> **Core idea:** "Find the minimum, put it in its correct position, repeat."

---

## 2. Algorithm Steps

1. Start with the first element as the current position `i = 0`.
2. Assume the element at index `i` is the minimum. Call its index `minIndex`.
3. Scan the rest of the array (`j = i+1` to `n-1`) to find the actual smallest element.
4. If a smaller element is found, update `minIndex`.
5. After scanning, swap `arr[i]` with `arr[minIndex]` (only if `minIndex != i`).
6. Move to the next index (`i++`) and repeat until `i = n-1`.

---

## 3. Visual Walkthrough

Array: `[29, 10, 14, 37, 13]`

| Pass | Unsorted Portion Scanned | Minimum Found | Action | Array After Pass |
|------|---------------------------|----------------|--------|-------------------|
| 1 | [29,10,14,37,13] | 10 (idx 1) | swap(0,1) | **10**,29,14,37,13 |
| 2 | [29,14,37,13] | 13 (idx 4) | swap(1,4) | 10,**13**,14,37,29 |
| 3 | [14,37,29] | 14 (idx 2) | no swap needed | 10,13,**14**,37,29 |
| 4 | [37,29] | 29 (idx 4) | swap(3,4) | 10,13,14,**29**,37 |

Final sorted array: `[10, 13, 14, 29, 37]`

Notice: with `n` elements, only **n−1 passes** are needed (the last element is automatically in place).

---

## 4. Pseudocode

```
SelectionSort(arr, n):
    for i = 0 to n-2:
        minIndex = i
        for j = i+1 to n-1:
            if arr[j] < arr[minIndex]:
                minIndex = j
        if minIndex != i:
            swap(arr[i], arr[minIndex])
```

---

## 5. Java Implementation

### 5.1 Basic Ascending Order Implementation

```java
public class SelectionSort {

    // Sorts the array in ascending order
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in arr[i+1...n-1]
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap only if a smaller element was found
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};

        System.out.print("Original array: ");
        printArray(arr);

        selectionSort(arr);

        System.out.print("Sorted array:   ");
        printArray(arr);
    }
}
```

**Output:**
```
Original array: 29 10 14 37 13 
Sorted array:   10 13 14 29 37 
```

### 5.2 Generic Version (Works for any `Comparable` type)

```java
public class GenericSelectionSort {

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 7};
        selectionSort(nums);
        System.out.println(java.util.Arrays.toString(nums)); // [1, 2, 5, 7, 9]

        String[] words = {"banana", "apple", "cherry"};
        selectionSort(words);
        System.out.println(java.util.Arrays.toString(words)); // [apple, banana, cherry]
    }
}
```

### 5.3 Descending Order Variant

```java
// Just flip the comparison
for (int j = i + 1; j < n; j++) {
    if (arr[j] > arr[maxIndex]) {   // looking for MAX instead of MIN
        maxIndex = j;
    }
}
```

---

## 6. Dry Run (Step-by-Step with Variable Tracing)

Array: `[5, 3, 8, 1]`, n = 4

**i = 0:** minIndex starts at 0 (value 5)
- j=1: arr[1]=3 < 5 → minIndex=1
- j=2: arr[2]=8, not < 3 → no change
- j=3: arr[3]=1 < 3 → minIndex=3
- Swap arr[0] and arr[3] → `[1, 3, 8, 5]`

**i = 1:** minIndex starts at 1 (value 3)
- j=2: arr[2]=8, not < 3 → no change
- j=3: arr[3]=5, not < 3 → no change
- minIndex == i, no swap → `[1, 3, 8, 5]`

**i = 2:** minIndex starts at 2 (value 8)
- j=3: arr[3]=5 < 8 → minIndex=3
- Swap arr[2] and arr[3] → `[1, 3, 5, 8]`

Loop ends (i goes only up to n-2 = 2). Final: `[1, 3, 5, 8]` ✅

---

## 7. Time Complexity Analysis

The outer loop runs `n-1` times. For each `i`, the inner loop runs `n - i - 1` times **regardless of the input's order** (it always scans the whole remaining unsorted part to find the minimum).

Total comparisons:
```
(n-1) + (n-2) + (n-3) + ... + 1  =  n(n-1)/2
```

| Case | Time Complexity | Reason |
|------|------------------|--------|
| Best Case | **O(n²)** | Even if array is already sorted, it still scans for the minimum every time |
| Average Case | **O(n²)** | Same number of comparisons regardless of initial arrangement |
| Worst Case | **O(n²)** | Same reasoning — comparisons don't depend on data order |

> **Key Insight:** Unlike Insertion Sort or Bubble Sort, Selection Sort's comparison count is **always exactly n(n-1)/2**, no matter how the input is arranged. It cannot "finish early" on a sorted array because it always has to search for the minimum across the whole unsorted region.

### Number of Swaps
This is where Selection Sort shines:
- **Maximum swaps = n−1** (at most one swap per outer loop iteration)
- Compare this to Bubble Sort, which can perform O(n²) swaps in the worst case.
- This makes Selection Sort attractive when **swap/write operations are expensive** (e.g., writing to flash memory, or sorting objects with costly copy operations) — even though comparisons are still O(n²).

---

## 8. Space Complexity

**O(1)** — Selection Sort is an **in-place** algorithm. It only uses a few extra variables (`i`, `j`, `minIndex`, `temp`) regardless of input size. No auxiliary array is needed.

---

## 9. Stability

**Selection Sort is NOT stable** by default.

> A sorting algorithm is *stable* if two elements with equal keys retain their original relative order after sorting.

### Why it's unstable — Example:
Consider sorting by the first element of pairs: `[(4,'a'), (3,'b'), (4,'c')]`

- i=0: minIndex search finds value 3 at index 1 → swap(0,1)
  → `[(3,'b'), (4,'a'), (4,'c')]`
- The relative order of the two `4`s — originally `'a'` before `'c'` — is preserved here, but in general, **the long-distance swap mechanism of selection sort can jump an equal element past another equal element**, breaking original order. This long-range swapping (as opposed to adjacent swapping like Insertion/Bubble sort) is what causes instability in many cases.

### Making it stable
Instead of swapping, you can **shift** elements (like insertion sort does) — but this defeats the O(n) swap advantage and turns it into something closer to insertion sort. Typically, if stability is required, Selection Sort is not the right choice — prefer Insertion Sort or Merge Sort.

---

## 10. In-Place Property

✅ Yes — sorts within the original array using a constant amount of extra space (O(1)), no extra array required.

---

## 11. Advantages

1. **Simple to understand and implement.**
2. **Minimal number of swaps** — exactly O(n) swaps in the worst case, useful when write/swap operations are costly.
3. **In-place** — O(1) auxiliary space.
4. Performs well on **small datasets**.
5. Doesn't depend on initial order of input for its time complexity — predictable performance.

## 12. Disadvantages

1. **O(n²) time complexity** for ALL cases (best, average, worst) — inefficient for large datasets.
2. **Not stable** by default.
3. **Not adaptive** — does not take advantage of existing order in the input (unlike Insertion Sort, which runs in O(n) on a nearly-sorted array).
4. Outperformed by O(n log n) algorithms (Merge Sort, Quick Sort, Heap Sort) for large `n`.

---

## 13. Comparison with Other Simple Sorting Algorithms

| Feature | Selection Sort | Bubble Sort | Insertion Sort |
|---|---|---|---|
| Best Case Time | O(n²) | O(n) (optimized) | O(n) |
| Average Time | O(n²) | O(n²) | O(n²) |
| Worst Time | O(n²) | O(n²) | O(n²) |
| Space | O(1) | O(1) | O(1) |
| Stable? | ❌ No | ✅ Yes | ✅ Yes |
| In-place? | ✅ Yes | ✅ Yes | ✅ Yes |
| Adaptive? | ❌ No | ✅ Yes | ✅ Yes |
| Number of Swaps | O(n) | O(n²) | O(n²) (shifts) |
| Best Use Case | Swap-cost-sensitive sorting | Educational / tiny datasets | Nearly-sorted or small datasets |

---

## 14. Variation: Double-Ended (Bidirectional) Selection Sort

An optimization that finds **both the minimum and maximum** in each pass, placing them at both ends simultaneously. This roughly **halves the number of outer-loop passes**.

```java
public class DoubleSelectionSort {

    public static void selectionSortBidirectional(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[minIndex]) minIndex = i;
                if (arr[i] > arr[maxIndex]) maxIndex = i;
            }

            // Swap min to the left boundary
            int temp = arr[left];
            arr[left] = arr[minIndex];
            arr[minIndex] = temp;

            // IMPORTANT: if max was at 'left' before the above swap,
            // its index needs to be corrected after the first swap
            if (maxIndex == left) {
                maxIndex = minIndex;
            }

            // Swap max to the right boundary
            temp = arr[right];
            arr[right] = arr[maxIndex];
            arr[maxIndex] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 1, 8, 3};
        selectionSortBidirectional(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // [1, 2, 3, 4, 7, 8, 9]
    }
}
```

> Still **O(n²)** time complexity overall, but constant-factor improvement (~half the passes). Conceptually a stepping stone toward understanding more advanced selection-based algorithms.

---

## 15. When Should You Actually Use Selection Sort?

✅ Good fit when:
- Dataset is **very small** (n < ~20–50).
- **Memory writes/swaps are expensive** (e.g., EEPROM, flash storage) and you want to minimize them.
- You need a **simple, easy-to-verify** algorithm for teaching/learning purposes or quick prototyping.

❌ Avoid when:
- Dataset is large → use Merge Sort, Quick Sort, or Heap Sort (O(n log n)).
- Stability matters → use Insertion Sort, Merge Sort, or Tim Sort.
- Input is nearly sorted → use Insertion Sort (adaptive, runs near O(n)).

---

## 16. Quick Recap Table

| Property | Value |
|---|---|
| Time Complexity (Best/Avg/Worst) | O(n²) / O(n²) / O(n²) |
| Space Complexity | O(1) |
| Stable | No |
| In-place | Yes |
| Adaptive | No |
| Number of comparisons | n(n-1)/2 |
| Number of swaps (max) | n - 1 |

---

## 17. Common Interview / Viva Questions

1. **Q:** Why is Selection Sort's time complexity O(n²) even in the best case (already sorted array)?
   **A:** Because the algorithm always scans the entire unsorted portion to find the minimum, regardless of whether the array is already sorted — there's no early-exit mechanism based on order.

2. **Q:** Is Selection Sort better than Bubble Sort?
   **A:** Both are O(n²), but Selection Sort does far fewer swaps (O(n) vs O(n²)), making it better when swap cost is high. Bubble Sort can be optimized to O(n) best case for nearly sorted arrays (with an early-stop flag); Selection Sort cannot.

3. **Q:** Can Selection Sort be made stable?
   **A:** Yes, by replacing the "swap" with a "shift/insert" operation — but this changes its performance profile and makes the number of writes O(n²), similar to insertion sort.

4. **Q:** What's the minimum number of swaps Selection Sort performs?
   **A:** Zero, if the array is already sorted (since `minIndex == i` every time and we skip swapping).

---

*End of notes.*