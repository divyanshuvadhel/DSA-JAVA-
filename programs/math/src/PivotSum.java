public class PivotSum {
    public static void main(String[] args) {
        int n=49;
        System.out.println(pivotInteger(49));
    }
    public static int pivotInteger(int n) {
        int s=1; int e=n;
        while( s<=e){
            int m= s+(e-s)/2;

            int sumA= (m * (m+1))/2;
            int sumB= (((e-m)+1) * (m+e))/2;

            if(sumA==sumB) return m;

            if(sumA<sumB){
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return -1;
    }
}
