import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {

        int[] example={0,2,1,5,3,4};
        System.out.println(Arrays.toString(permutate(example)));

    }

    public  static int[] permutate(int[]arr){

        int [] ans =new int[arr.length];

        for(int i=0; i<arr.length;i++){
            ans[i]=arr[arr[i]];
        }
        return ans;

    }
}
