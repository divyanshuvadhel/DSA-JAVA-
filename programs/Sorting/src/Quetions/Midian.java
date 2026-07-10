package Quetions;

public class Midian {
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m=nums1.length;
//        int n=nums2.length;
//        if(m+n==0)return 0;
//
////        int []merged=new int[m+n];
//        double midian;
//
//        if((((m+n)-1) &1) ==1){
//            int  index1 =((m+n)-1)/2;
//            int index2=(int) Math.ceil(((m+n)-1)/2.0);
//
//        }else{
//        }
//        int i=0;int j=0; int count=0;
//
//        while(i<m && j<n){
//            if(nums1[i]<nums2[j]){
//                count++; i++;
//            }else{
//                count++;
//                j++;
//            }
//        }
//
//        while(i<m){
//            merged[k++]=nums1[i++];
//        }
//
//        while(j<n){
//            merged[k++]=nums2[j++];
//        }
//
//
//        // what is the middian  over hers
//
//
//    }
   /* public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // check if m and n==0
        int m=nums1.length;
        int n=nums2.length;
        if(m+n==0)return 0;

        int []merged=new int[m+n];

        int i=0;int j=0; int k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merged[k++]=nums1[i++];
            }else{
                merged[k++]=nums2[j++];
            }
        }

        while(i<m){
            merged[k++]=nums1[i++];
        }

        while(j<n){
            merged[k++]=nums2[j++];
        }


        // what is the middian  over hers

        double midian;

        if((merged.length-1 &1) ==1){
              int floor =(merged.length-1)/2;
            int ceil=(int) Math.ceil(3/2.0);
            midian=(merged[floor]+merged[ceil])/2.0;
        }else{
            midian=merged[((m+n)-1)/2];
        }
        return midian;
    }
*/


    public static void main(String[] args) {
        int []arr={1,2};
        int []arr1={3};
//        double ans=findMedianSortedArrays(arr,arr1);
//        System.out.println(ans);
    }
}
