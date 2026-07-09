package Quetions;

import java.util.Arrays;

public class MajorityElement {

    public static   void inplceMergesort(int []arr,int start,int end ){
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

    public  static int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        // sort the array
        inplceMergesort(nums,0,nums.length);

        System.out.println(Arrays.toString(nums));
        int i=0;
        int count=0;
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]){
                count++;
                if(count+1>nums.length/2) return nums[i];
            }else{
                count=0;

            }
            i++;
        }
        System.out.println(count);
        return -1;

    }


    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,2,2};
        int ele=majorityElement(arr);
        System.out.println(ele);
    }

}
