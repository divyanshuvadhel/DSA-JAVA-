
# Quick sort
Imagine you have a deck of cards numbered **1--10**, all shuffled. You
pick one card at random---let's say **7**---and you say:

> Everything smaller than **7** goes to my left hand. Everything bigger
> goes to my right hand.

Now you have two smaller piles. You do the **exact same thing** to each
pile until every pile has just one card.

**Boom---sorted.**

The card you picked is called the **pivot**.

The magic is that after **one partition**, the pivot is already in its
**final sorted position**.

------------------------------------------------------------------------

## Step 2: Build the Mental Model

``` text
Original:
[3, 6, 2, 8, 1, 9, 5]

Choose Pivot = 5

Partition:

[3, 2, 1]   [5]   [6, 8, 9]
  < 5         ✓      > 5
```

### Invariant

After partition:

-   Everything left of pivot is smaller.
-   Everything right of pivot is larger.
-   The pivot never moves again.

------------------------------------------------------------------------

## Step 3: Java Implementation

``` java
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

## Step 4: Common Interview Twists

Twist                What Changes               Weapon
  -------------------- -------------------------- ----------------------------
Descending Sort      `>=` instead of `<=`       Flip comparison
K-th Smallest        Don't recurse both sides   QuickSelect
Many Duplicates      3-way partition            Dutch National Flag
Linked List          No random access           Merge Sort
Nearly Sorted        Worst-case                 Random Pivot
Memory Constraints   Stack optimization         Tail recursion / iterative

### Three-Way Partition

``` java
private static void quickSort3Way(int[] arr, int low, int high) {
    if (low >= high) return;

    int lt = low, gt = high;
    int pivot = arr[low];
    int i = low;

    while (i <= gt) {
        if (arr[i] < pivot)
            swap(arr, lt++, i++);
        else if (arr[i] > pivot)
            swap(arr, i, gt--);
        else
            i++;
    }

    quickSort3Way(arr, low, lt - 1);
    quickSort3Way(arr, gt + 1, high);
}
```

## Step 5: Hand Trace

``` text
Array:
[4,2,7,3,1,9,8]

Pivot = 8

[4,2,7,3,1] [8] [9]

Pivot = 1

[] [1] [4,2,7,3]

Pivot = 3

[2] [3] [4,7]

Final:

[1,2,3,4,7,8,9]
```

## Step 6:  Self Check

-   Why is Quick Sort average O(n log n)?
-   Why is worst case O(n²)?
-   Why isn't it stable?
-   Why is it in-place?
-   When should you choose Merge Sort instead?
-   How does QuickSelect work?

## QuickSelect

``` java
public static int quickSelect(int[] arr, int k) {

    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {

        int pivotIndex = partition(arr, low, high);

        if (pivotIndex == k)
            return arr[pivotIndex];
        else if (pivotIndex < k)
            low = pivotIndex + 1;
        else
            high = pivotIndex - 1;
    }

    return -1;
}
```

## 5-Day Practice Plan

Day   Task
  ----- --------------------------------------
1     Write Quick Sort from memory 5 times
2     Implement 3-way partition
3     LeetCode 215
4     LeetCode 75
5     LeetCode 347

## Golden Rule

> If you cannot explain **why the pivot ends up in its final position
> after partition**, you do **not** fully understand Quick Sort.
