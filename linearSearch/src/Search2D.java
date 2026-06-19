import java.util.Arrays;

public class Search2D {
    public static void main(String[] args) {

        int[][] arr={{12,1},{23,2}};
//        System.out.println(Arrays.toString(search2d(arr,0)));
        System.out.println(max(arr));
    }
    // max in 2d array

    public static int max(int[][] arr){
        int max=arr[0][0];
        for(int[] ar:arr){
            for(int ele:ar){
                if(ele>max) max=ele;
            }
        }
        return max;
    }



    // search in 2d array
     public static int[] search2d(int[][]arr,int target){
        if(arr.length==0) return new int[]{-1,-1};

        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==target) return new int[]{i,j} ;
            }
        }
        return new int[] {-1,-1};
     }
}
