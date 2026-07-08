import java.util.Arrays;

public class SelectionSort {

    public static void sort(int s,int e,int maxIndex,int[]arr){
        if(e<=0){
            return;
        }
        if(arr[maxIndex]<arr[s]){
            maxIndex=s;
        }
        if(s==e){
            int temp=arr[e];
            arr[e]=arr[maxIndex];
            arr[maxIndex]=temp;
            sort(0,e-1,0,arr);
            return;
        }
        // call for next element
        sort(s+1,e,maxIndex,arr);
    }

    public static void main(String[] args) {
        int []arr={3,2,1,10,2,3,4,12};
        sort(0,arr.length-1,0,arr);
        System.out.println(Arrays.toString(arr));
    }
}
