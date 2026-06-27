# Insertion Sort 

# Big Idea

Insertion Sort builds the sorted portion of the array **one element at a
time**.

Imagine sorting playing cards in your hand: - The left side is already
sorted. - Pick the next card. - Shift larger cards to the right. -
Insert the picked card into its correct position.

------------------------------------------------------------------------

# Core Principle

At every iteration:

-   `arr[0..i-1]` is already sorted.
-   Insert `arr[i]` into its correct place.

------------------------------------------------------------------------

# Visualization

Initial

``` text
5 3 4 1 2
^
Sorted
```

Take `3`

``` text
5 > 3
```

Shift `5`

``` text
5 5 4 1 2
```

Insert `3`

``` text
3 5 4 1 2
```

Repeat until the entire array is sorted.

------------------------------------------------------------------------

# Algorithm

1.  Start from index `1`.
2.  Store current value in `key`.
3.  Compare with previous elements.
4.  Shift every larger element one position right.
5.  Insert `key` into the empty position.

------------------------------------------------------------------------

# Why Shifting Instead of Swapping?

Swapping moves two values repeatedly.

Shifting only moves larger elements and inserts the key once.

This reduces unnecessary writes.

------------------------------------------------------------------------

# Java Implementation

``` java
static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}
```

------------------------------------------------------------------------

# Loop Invariant

Before every iteration:

`arr[0...i-1]` is sorted.

After insertion:

`arr[0...i]` becomes sorted.

------------------------------------------------------------------------

# Time Complexity

Case                     Complexity
  ------------------------ ------------
Best (Already Sorted)    O(n)
Average                  O(n²)
Worst (Reverse Sorted)   O(n²)

------------------------------------------------------------------------

# Space Complexity

`O(1)`

In-place algorithm.

------------------------------------------------------------------------

# Stability

Stable.

Equal elements keep their original order because we shift only when:

``` java
arr[j] > key
```

Not when equal.

------------------------------------------------------------------------

# Adaptive

Yes.

Nearly sorted arrays require very few shifts.

------------------------------------------------------------------------

# Common Mistakes

-   Starting loop from index `0`.
-   Forgetting to save `key`.
-   Swapping instead of shifting.
-   Using `>=` instead of `>` (breaks stability).
-   Forgetting `arr[j+1] = key`.

------------------------------------------------------------------------

# Pattern Recognition

Use Insertion Sort when:

-   Array is small.
-   Array is nearly sorted.
-   Stable sorting is required.
-   Building sorted data incrementally.

------------------------------------------------------------------------

# Mental Model

> The left side is your sorted notebook.
>
> Every new element must be inserted into the correct place by shifting
> larger elements.

------------------------------------------------------------------------

# Interview Checklist

-   Start from index `1`.
-   Save the key.
-   Shift larger elements.
-   Insert key once.
-   Maintain sorted prefix.
