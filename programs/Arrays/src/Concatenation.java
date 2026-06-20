import java.util.Arrays;

public class Concatenation {
    public static void main(String[] args) {
        int [] example={1,2,1};
        System.out.println(Arrays.toString(con(example)));
    }

    public static int[] con(int[]arr){
        int n=arr.length;
        int [] ans=new int[2*n];
        for(int i=0;i<n; i++){
            ans[i]=arr[i];
            ans[i+n]=arr[i];
        }
        return ans;

    }

}
