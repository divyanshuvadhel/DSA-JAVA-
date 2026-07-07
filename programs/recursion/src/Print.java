public class Print {
    public  static void printN(int n){
        if(n==1) {
            System.out.println(n);
            return;
        }
        printN(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printN(5);
    }
}


