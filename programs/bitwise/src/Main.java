public class Main {


    public static void isEven(int n){

        System.out.println((n & 1)!=1);
    }

    public static void main(String[] args) {

        isEven(0);
        System.out.println("Hello world!");
    }
}