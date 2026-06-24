

public class CeillingInArray {
    public static void main(String[] args) {
//        // 1. Target exists in array
//        int[] arr = {2, 3, 5, 9, 14, 16, 18};
//        int target = 14;
//// Expected: 14
//
//// 2. Target between two elements
//        int[] arr = {2, 3, 5, 9, 14, 16, 18};
//        int target = 15;
//// Expected: 16
//
//// 3. Target smaller than smallest element
//        int[] arr = {2, 3, 5, 9, 14, 16, 18};
//        int target = 1;
//// Expected: 2
//
//// 4. Target greater than largest element
//        int[] arr = {2, 3, 5, 9, 14, 16, 18};
//        int target = 20;
//// Expected: -1 (or whatever your program returns)
//
//// 5. Target equals first element
//        int[] arr = {2, 3, 5, 9, 14, 16, 18};
//        int target = 2;
//// Expected: 2
//
//// 6. Target equals last element
//        int[] arr = {2, 3, 5, 9, 14, 16, 18};
//        int target = 18;
//// Expected: 18
//
//// 7. Single element array - target exists
//        int[] arr = {5};
//        int target = 5;
//// Expected: 5
//
//// 8. Single element array - target smaller
//        int[] arr = {5};
//        int target = 3;
//// Expected: 5
//
//// 9. Single element array - target larger
        int[] arr = {5};
        int target = 7;
//// Expected: -1
//
//// 10. Two element array
//        int[] arr = {5, 10};
//        int target = 6;
//// Expected: 10
//
//// 11. All duplicate elements
//        int[] arr = {5, 5, 5, 5, 5};
//        int target = 4;
//// Expected: 5
//
//// 12. All duplicate elements - target exists
//        int[] arr = {5, 5, 5, 5, 5};
//        int target = 5;
//// Expected: 5
//
//// 13. All duplicate elements - target larger
//        int[] arr = {5, 5, 5, 5, 5};
//        int target = 6;
//// Expected: -1
//
//// 14. Negative numbers
//        int[] arr = {-20, -10, -5, 0, 5, 10};
//        int target = -7;
//// Expected: -5
//
//// 15. Negative target smaller than all
//        int[] arr = {-20, -10, -5, 0, 5, 10};
//        int target = -30;
//// Expected: -20
//
//// 16. Empty array
//        int[] arr = {};
//        int target = 10;
//// Expected: -1
        // find the ceiling of target in sorted array
//        int [] arr={0,1,2,3,4,6,7,8,10};
//        int target=-1;

        // bs for the target >=

        int start=0;
        int end=arr.length-1;

        while (start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                end=mid;
                break;
            }
            if(arr[mid]>target){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        if(arr[end]<target){
            System.out.println("no celling");
        }else{
            System.out.println(arr[end]);

        }



    }
}
