> # Linear Search 
---

# What is Searching?

Searching means finding a specific element inside a collection of data.

### Example

```java
int[] arr = {12, 45, 78, 23, 9};
```

Find whether `23` exists in the array.

---

# Linear Search

Linear Search is the simplest searching algorithm.

It checks each element one by one until:

* The target element is found.
* The array ends.

---

## Visualization

Array:

```text
Index : 0   1   2   3   4
Value : 12  45  78  23  9
```

Target:

```text
23
```

Steps:

```text
12 == 23 ? No
45 == 23 ? No
78 == 23 ? No
23 == 23 ? Yes
```

Found at index `3`.

---

# Algorithm

1. Start from index `0`.
2. Compare current element with target.
3. If equal, return index.
4. Otherwise move to next element.
5. If end of array is reached, return `-1`.

---

# Linear Search Code

```java
public class LinearSearch {

    static int linearSearch(int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {12, 45, 78, 23, 9};

        System.out.println(linearSearch(arr, 23));
    }
}
```

Output:

```text
3
```

---

# Return Element Instead of Index

```java
static int searchElement(int[] arr, int target) {

    for (int num : arr) {

        if (num == target) {
            return num;
        }
    }

    return -1;
}
```

---

# Best Case Time Complexity

Target is found at first position.

Example:

```text
[10, 20, 30, 40]

Target = 10
```

Only one comparison is required.

### Complexity

```text
O(1)
```

---

# Worst Case Time Complexity

Target is:

* At the last position
* Not present in array

Example:

```text
[10,20,30,40]

Target = 40
```

or

```text
Target = 99
```

Need to check every element.

### Complexity

```text
O(n)
```

---

# Space Complexity

Linear search uses only one extra variable.

```text
O(1)
```

---

# Search in String

Search whether a character exists in a string.

---

## Code

```java
static boolean search(String str, char target) {

    if (str.length() == 0) {
        return false;
    }

    for (int i = 0; i < str.length(); i++) {

        if (str.charAt(i) == target) {
            return true;
        }
    }

    return false;
}
```

Example:

```java
search("Kunal", 'u');
```

Output:

```text
true
```

---

# Search in Range

Search only between specific indexes.

---

## Code

```java
static int searchRange(
        int[] arr,
        int target,
        int start,
        int end) {

    for (int i = start; i <= end; i++) {

        if (arr[i] == target) {
            return i;
        }
    }

    return -1;
}
```

---

# Find Minimum Number

---

## Code

```java
static int min(int[] arr) {

    int min = arr[0];

    for (int i = 1; i < arr.length; i++) {

        if (arr[i] < min) {
            min = arr[i];
        }
    }

    return min;
}
```

Example:

```java
int[] arr = {18, 12, -7, 3, 14, 28};

System.out.println(min(arr));
```

Output:

```text
-7
```

---

# Search in 2D Array

---

## Code

```java
static int[] search(
        int[][] arr,
        int target) {

    for (int row = 0; row < arr.length; row++) {

        for (int col = 0; col < arr[row].length; col++) {

            if (arr[row][col] == target) {

                return new int[]{row, col};
            }
        }
    }

    return new int[]{-1, -1};
}
```

---

# Find Maximum in 2D Array

```java
static int max(int[][] arr) {

    int max = Integer.MIN_VALUE;

    for (int[] row : arr) {

        for (int element : row) {

            if (element > max) {
                max = element;
            }
        }
    }

    return max;
}
```

---

# Find Minimum in 2D Array

```java
static int min(int[][] arr) {

    int min = Integer.MAX_VALUE;

    for (int[] row : arr) {

        for (int element : row) {

            if (element < min) {
                min = element;
            }
        }
    }

    return min;
}
```

---



---

# Interview Questions

### Q1. What is Linear Search?

A searching algorithm that checks elements one by one until the target is found.

---

### Q2. Best Case Complexity?

```text
O(1)
```

---

### Q3. Worst Case Complexity?

```text
O(n)
```

---

### Q4. Space Complexity?

```text
O(1)
```

---

### Q5. When should we use Linear Search?

* Small arrays
* Unsorted data
* Simplicity is preferred

---

# Summary

* Searching = Finding data.
* Linear Search checks elements one by one.
* Best Case = O(1)
* Worst Case = O(n)
* Space Complexity = O(1)
* Can be used with arrays, strings, ranges, and 2D arrays.
* Useful for finding min, max, wealth, and digit-related problems.

---
