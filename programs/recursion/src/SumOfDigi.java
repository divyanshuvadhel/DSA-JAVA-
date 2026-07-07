public class SumOfDigi {
    static int rev=0;

    private  static void revn(int n){
        if(n==0) return;
        int last=n%10;
        rev=rev*10 + last;
        revn(n/10);
    }


    public static void main(String[] args) {
//        System.out.println(sumOfDigit(512));
//        System.out.println(revn(512));
        revn(123);
        System.out.println(rev);
    }

    private static int sumOfDigit(int n) {
        if(n<=1) return n;
        return n%10 + sumOfDigit(n/10);

    }
}
