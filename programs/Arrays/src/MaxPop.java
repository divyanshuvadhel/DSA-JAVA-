public class MaxPop {
    public static void main(String[] args) {

    }
    public int maximumPopulation(int[][] logs) {

        int start=1950;
        int end=2050;
        int[]ans=new int[101];

        for(int []year:logs){
            int s=year[0]-start;
            int e=year[1]-start;

            ans[s]++;
            ans[e]--;



            // for(int i=s;i<e;i++){
            //     ans[i]++;
            // }
        }

        // find max in ans
        int max=ans[0];
        int year=start;
        for(int i=1;i<101;i++){
            ans[i]+= ans[i-1];
            if(max<ans[i]){
                max=ans[i];
                year=i+start;
            }
        }

        return year;
    }
}
