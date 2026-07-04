import java.lang.reflect.Array;
import java.util.Arrays;

public class BubleRecursion {

   public static void bsort(int base,int start,int []arr,boolean isSorted){
        boolean sorted=isSorted;
       if(start!=base){
           if(arr[start]<arr[start-1]){
               // swap each other
               int temp=arr[start];
               arr[start]=arr[start-1];
               arr[start-1]=temp;
               // set the isSorted to false;
               sorted=false;
                int newSTart=start-1;
               // call the bsort with start-1;
               bsort(base,newSTart,arr,sorted);
           }else{

               // call the bsort(start-1)
               bsort(base,start-1,arr,sorted);
           }
       }
       if(start<=base && sorted==false){
           // which mean still array is not sorted
           // call the bsort with new values
           int newBase=++base;
            sorted=true;
           bsort(newBase,arr.length-1,arr,sorted);
       }
   }

    public static void main(String[] args) {
        int [] arr={5,4,3,2,8,3,2,1};
//        System.out.println(Arrays.toString(arr));
        boolean isSorted=false;
        bsort(0,arr.length-1,arr,isSorted);
        System.out.println(Arrays.toString(arr));
    }

}
