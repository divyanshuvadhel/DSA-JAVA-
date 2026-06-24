public class PeakEle {
    public static void main(String[] args) {
        //find the pick in the array
        int []arr={1,2};

        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] arr) {
        // single element is always a peak
        if (arr.length == 1) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is a pik element
            boolean isGreaterThanLeft = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean isGreaterThanRight = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            if (isGreaterThanLeft && isGreaterThanRight) {
                return mid;  // Peak found
            }

            // If right element is greater, peakk must be on the right side
            if (mid != arr.length - 1 && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                // we are in decreasing order, peak must be on the left side
                end = mid - 1;
            }
        }

        return -1;
    }
}


