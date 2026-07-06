public class Sqrt {
    public static void printSqrt(int n){
        // find the range
        int s=1; int e=n/2;

        while (s<e){

            int mid=s+(e-s)/2;

            if(mid==n/mid) {
                System.out.println(mid);
                return;
            }
            if(mid>n/mid){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
            System.out.println(s);

    }

    public static void main(String[] args) {
        printSqrt(40);
    }
}
