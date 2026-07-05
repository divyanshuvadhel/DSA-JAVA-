import java.lang.reflect.Array;
import java.util.Arrays;

public class Count {

    public static int onces(int n){
        // how many 1/s in the number
        int count=0;
        while (n>0){
            if((n&1)==1) count++;
            n>>=1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n=5;
        int [] ans=new int[n+1];
        for(int i=0; i<=n; i++){
            ans[i]=onces(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
