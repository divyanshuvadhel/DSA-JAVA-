import java.util.Arrays;

public class CycleSort {
    public static void swap(int[]arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void cycleSort(int[]arr) {
        //take the element put it at it correct index then move forward

        int i=0;
        while(i<arr.length){
            int corectIndex=arr[i]-1;
            if(i!=corectIndex){
                swap(arr,i,corectIndex);
            }else {
                i++;
            }

        }
    }
    public static void main(String[] args) {
        int []arr={4,5,3,1,2};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
