public class BinarySearch {
    public static void main(String[] args) {
        // binary searcch
        int [] example={1,2,3,4,5,6,7,8,9};
        System.out.println(infinitArr(example,9));
    }


    static  void bsIn2d(int[][]mat,int target){
        int raw=0;
        int col=mat[0].length-1;

        while(raw<mat.length && col>=0){
            int ele=mat[raw][col];
            if(ele==target) {
                System.out.println("ele found");
            }
            if(ele<target){
                raw++;
            }else {
                col--;
            }
        }
        System.out.println("not found");
    }

    public  static  int Bs(int []arr,int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>target){
                // left
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public  static  int orderAgnosticBs(int[] arr,int target){

        int start=0;
        int end=arr.length-1;
        boolean isAcending= arr[start]<arr[end];

        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr[mid]==target) return mid;
            if(arr[mid]>target){
                if(isAcending){
                    //left
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(isAcending){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }

        }
        return -1;



    }

    public static int infinitArr(int[] arr,int target){
        // get the bound
        int start=0; int end=1;
        while(arr[end]<target){
            end=end*2;
        }
        return Bs(arr,target);
    }
}