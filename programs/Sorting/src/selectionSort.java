import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int []arr={12,4,52,323,434,5,52};
//         for every index get right value for this index
        int n=arr.length;
        for(int i=0;i<n-1;i++){
             // find the min element
            int indexOfMin=min(arr,i);

            // swap the index 0 value with its acull value min value

            if(i!=indexOfMin){
                int temp=arr[i];
                arr[i]=arr[indexOfMin];
                arr[indexOfMin]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public  static  int min(int[]arr,int start){
        int indexOfMin=start;
        for(int i=start+1;i<arr.length;i++){
            if(arr[i]<arr[indexOfMin]) indexOfMin=i;
        }
        return indexOfMin;
    }
}
