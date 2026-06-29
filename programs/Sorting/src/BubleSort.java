import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int []arr={12,2,3,0,1,10};
        System.out.println(Arrays.toString(bbleSort(arr)));
    }
    static int[] bbleSort(int[] arr){
        boolean swapp=false;
        for(int i=0; i<arr.length; i++){
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    //swap these ttwo
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapp=true;
                }
            }
            if(!swapp){
                // it is sorted
                break;
            }
        }
        return arr;

    }
}
