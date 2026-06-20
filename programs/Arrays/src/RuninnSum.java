import java.util.Arrays;

public class RuninnSum {
    public static void main(String[] args) {
        int[] example={1,2,3,4};
        System.out.println(Arrays.toString(runnigSum(example)));
    }
    public  static int[] runnigSum(int[]arr){
        int[] ans=new int[arr.length];


        for(int i=0;i<arr.length;i++){
           int sum =0;
            // calculate the sum
            for(int j=0;j<=i;j++){
                sum+=arr[j];
            }
            ans[i]=sum;
        }
        return ans;
    }

    public static int[] prifix(int [] nums){
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i] +nums[i-1];

        }
        return nums;
    }

}
