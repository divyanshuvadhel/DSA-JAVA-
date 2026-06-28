package Quetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicate {
    public static List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;

        // Step 1: Sort everything into its correct
        while (i < arr.length) {
            int index = arr[i] - 1;
            if (arr[i] != arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans.add(arr[j]);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int []arr={3,1,3,4,2};
        System.out.println(findDuplicates(arr));
    }
}
