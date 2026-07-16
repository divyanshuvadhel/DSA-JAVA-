package Quetions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Thirdmax {

    public  static int third(int[]arr){

        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for(int i: arr){
            if(i > first){
                third = second;
                second = first;
                first = i;
            }
            else if(i > second && i != first){
                third = second;
                second = i;
            }
            else if(i >= third && i != first && i != second){
                third = i;
            }
        }

        return third == Long.MIN_VALUE ? (int) first : (int) third;


    }




    public static void mergeSort(int[] arr, int start, int end) {
        if (end - start <= 1) return;

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        int[] temp = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            // Sort in descending order
            if (arr[i] >= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (j < end) {
            temp[k++] = arr[j++];
        }
        while (i < mid) {
            temp[k++] = arr[i++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[l + start] = temp[l];
        }
    }

    public static int thirdMax(int[] nums) {
        // Step 1: Sort the array in descending order
        mergeSort(nums, 0, nums.length);

        // track distnct elements
        int distinctCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                distinctCount++;
            }

            if (distinctCount == 3) {
                return nums[i];
            }
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[]arr={3,4,3,2,1};
        int ans= thirdMax(arr);
        System.out.println(ans);
    }
}
