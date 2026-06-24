public class SingleEle {
    public static void main(String[] args) {
        // find the sigble in the sorted array
        int []arr={1,1,2,3,3,4,4,8,8};
        int res=singleNonDuplicate(arr);
        System.out.println(res);
    }
    public  static  int  singleNonDuplicate(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int ans=0;

        while(start<=end){

            int mid=start+(end-start)/2;
            // check for is mid is last index
            if(mid==arr.length-1){
                return arr[mid];
            }
            // check for goodpair
            boolean right=mid%2==0;// check for where to compare
            // compare
            boolean goodPair=(right)?arr[mid]==arr[mid+1]:arr[mid]==arr[mid-1];
            // if its goodPair -> true;
            if(goodPair){
                start=mid+1;
            }else{
                ans=mid;//potaintiall ans
                end=mid-1;
            }
        }
        return arr[ans];
    }
}
