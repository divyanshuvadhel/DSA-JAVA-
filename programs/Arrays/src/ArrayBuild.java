import java.util.ArrayList;
import java.util.Arrays;

public class ArrayBuild {

    public static int[] creatTargetArray(int[]nums,int[]index){
        // creat the list
        ArrayList<Integer> temp=new ArrayList<>(101);
        // add aording to two arras
        for(int i=0;i<index.length;i++){
            temp.add(index[i],nums[i]);
        }
        // create the ans array
        int []ans=new int[nums.length];
        for(int i=0;i<temp.size();i++){
            ans[i]=temp.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {

    int [] nums={1,2,3,4,0};
    int [] index={0,0,2,3,0};

        System.out.println(Arrays.toString(creatTargetArray(nums,index)));


    }
}
