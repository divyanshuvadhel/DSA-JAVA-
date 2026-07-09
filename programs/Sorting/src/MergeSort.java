import java.util.Arrays;

public class MergeSort {

    static int[] mergerSort(int []arr){

        // base condition will be
        if(arr.length==1) return arr;

        // divide int to two parts
        int []part1= mergerSort(Arrays.copyOfRange(arr,0,arr.length/2));
        int []part2= mergerSort(Arrays.copyOfRange(arr,arr.length/2, arr.length));

        // return the merged array
        return mergeArr(part1,part2);


    }
    static  int[] mergeArr(int[]arr1,int[]arr2){
        int [] merged= new int[arr2.length+arr1.length];
        int i=0;int j=0; int k=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                merged[k]=arr1[i];
                i++;
            }else{
                merged[k]=arr2[j];
                j++;
            }
            k++;
        }

        // the arr1 or arr2 hase left over ;

            // arr2 have the left over
            while (j<arr2.length){
                merged[k]=arr2[j];
                j++;
                k++;
            }
            while (i<arr1.length){
                merged[k]=arr1[i];
                i++;
                k++;
            }


        return merged;
    }

    static void inplceMergesort(int []arr,int start,int end ){
        // we have the base condition over heare
        if(end-start==1) return;

        int mid=start+(end-start)/2;


        inplceMergesort(arr,start,mid);
        inplceMergesort(arr,mid,end);

        int [] temp=new int[end-start];

        int i=start; int j=mid; int k=0;

        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }


        while(i<mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            temp[k]=arr[j];
            j++;
            k++;
        }

        for(int l=0; l<temp.length; l++){
            arr[start+l]=temp[l];
        }
    }
    public static void main(String[] args) {
        int []arr={1,3,2,1,45,6,0,8};
//        arr=mergerSort(arr);
        inplceMergesort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
