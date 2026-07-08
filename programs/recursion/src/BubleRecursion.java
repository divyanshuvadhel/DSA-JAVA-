import java.lang.reflect.Array;
import java.util.Arrays;

public class BubleRecursion {

   public static void bsort(int start,int []arr,int end){

        if(end==0){
            return;
        }
       if(start>=end) {
           bsort(0,arr,end-1);
           return;
       }
       if(arr[start]>arr[start+1]){
           //swap it
           int temp=arr[start];
           arr[start]=arr[start+1];
           arr[start+1]=temp;
       }
       bsort(start+1,arr,end);
   }

    public static void main(String[] args) {
        int [] arr={5,4,3,2,8,3,2,1};
        System.out.println(Arrays.toString(arr));
        bsort(0,arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
