import java.util.ArrayList;
import java.util.Arrays;

public class PositionOfElement {
    public static void main(String[] args) {
//        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/


        int []arr={1};
        int targe=1;

    }

    private static int binarySearch(int[] arr, int target, boolean isFirst) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (isFirst) {
                    end = mid - 1;      // Search left for first occurrence
                } else {
                    start = mid + 1;    // Search right for last occurrence
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
