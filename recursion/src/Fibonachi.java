public class Fibonachi {
    // find nth fibonachi number
    public static int fibonachi(int n){

                // base condition
         if(n<2) return n;

        return fibonachi(n-1)+fibonachi(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibonachi(6));
    }
}
