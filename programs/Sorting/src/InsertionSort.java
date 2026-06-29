import java.util.Arrays;

public class InsertionSort {
    public  static void  swap(int a,int b,int[]arr){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public  static void   insertionSort(int []arr){
        for (int i = 1; i <arr.length ; i++) {
            // for the every element sort till the i;
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    swap(j,j-1,arr);
                }else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
            // for evey time loop run it wil sort the array till i
        int [] arr={1,2,3,6,4,3,2,0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }


}
