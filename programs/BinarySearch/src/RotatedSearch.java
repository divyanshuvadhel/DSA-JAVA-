public class RotatedSearch {
    public static int binary(int[]arr,int target,int start,int end){
        boolean isAcending= (arr[start]<arr[end]);
        while(start<=end){
            int mid=start+(end-start)/2;
            // if found
            if(arr[mid]==target) return mid;
            // not found
            if(arr[mid]>target){
                if(isAcending){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else{
                if (isAcending){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static int search(int[] arr, int target) {
      if(arr.length==1) return arr[0]==target?0:-1;
      // array is not roted
      if(arr[0]<arr[arr.length-1]){
          // sorted but target > last ele = -1
          if(target>arr[arr.length-1])return -1;
          // do normal binary search
          return binary(arr,target,0,arr.length-1);
      }

      // if it rotetad then find peak
      int peakIndex=peak(arr);
        System.out.println(peakIndex);
      // compare with peak ;
      // peak=target -> return pick
        if(arr[peakIndex]==target) return peakIndex;

      //2. peak< target = return -1;
        if(arr[peakIndex]<target) return -1;

      //3.target<pick and first element=<target -- range is 0-peak
        if(target>=arr[0]){
           return binary(arr,target,0, peakIndex);
        }else{
            // 4. target <pick and greatier then fist ele -- range is 0-pick
            return  binary(arr,target,peakIndex+1,arr.length-1);
        }
    }
    public  static int  peak(int[]arr){
        // all the array value are uniq;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            // if it peak -> mid>mid+1 is peak only one condintion in array it hit..
            if(arr[mid]>arr[mid+1]){
                return mid;
            }
            // if not found where to go left or right
            // mid>last ---> peak is lie in these range
            // mid<last ele --> it is sorted so peak lei in left side of mid;
            if(arr[mid]>arr[arr.length-1]){
                // right side of mid;
                start=mid+1;
            } else if (arr[mid]<arr[arr.length-1]) {
                // go to left side
                end=mid-1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        //search in rotated array
//        int []arr={0,2,3,4,5,6,7};
//        int []arr={1,2,3,4,0};
//        int []arr={2,3,4,0,1};
//        int []arr={4,0,1,2,3};
//        int []arr={3,4,0,1,2};
        int []arr={5,1,3};

       System.out.println(search(arr,3));


    }
}
