import java.util.Scanner;
public class input {
    public static void main(String[] args) {
        // take  two numbers and print the sum of it .

        Scanner sc=new Scanner(System.in);

        System.out.println("enter a number 1:");
        int num1 = sc.nextInt();

        System.out.println("enter a number 2:");
        int num2 =sc.nextInt();

        System.out.println(num1 +num2);
    }
}
