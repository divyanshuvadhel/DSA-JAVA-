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
    public boolean searchMatrix(int[][] matrix, int target) {
            // check whether element in mat
            if(matrix[0][0]>=target && matrix[matrix.length-1][matrix[0].length-1]>=target){
                int col=matrix[0].length-1;
                int row=0;
                while(row<matrix.length && col>=0){

                    if(matrix[row][col]== target) return true;

                    if(matrix[row][col]>target){
                        col--;
                    }else{
                        row++;
                    }
                }
            }
            return false;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(bs(arr,0,arr.length-1,-1));
    }
}
