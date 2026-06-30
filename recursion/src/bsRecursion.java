public class bsRecursion {
    public static int bs(int [] arr,int start,int end,int target){
           // base condition
          if(start>end) return -1;

            int mid=start+(end-start)/2;

            if(arr[mid]==target) return mid;

            if(arr[mid]>target){
                // appy call bs
               return bs(arr,start,mid-1,target);
            }else{
               return bs(arr,mid+1,end,target);
            }

    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(bs(arr,0,arr.length-1,-1));
    }
}
