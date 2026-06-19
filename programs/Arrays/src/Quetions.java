import java.util.Arrays;

public class Quetions {
    public static void main(String[] args) {
        // Q.1 Swap two elements in an array
        int[] nums={1,2,3,4};
        swap(nums,0,1);

        // Q.2  Find Maximum element in an array

        int[] max={2,3,4,5,1,10};
         max(max);

        // Q.3 Reverse an Array (Two-Pointer Technique)
         rev(max);
    }
    static void  swap(int[] arr,int index,int index2){
        int temp=arr[index];
        arr[index]=arr[index2];
        arr[index2]=temp;
    }

    static void max(int[] arr){
        int max=arr[0];
        for (int num:arr){
            if(num>max) max=num;
        }
        System.out.println(max);
    }
    static void rev(int[] arr){
        // reve arr 1,2,3,4 ---> 4,3,2,1
         int s=0; int e=arr.length-1;
         while(s<e){
             swap(arr,s,e);
             s++;
             e--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
