import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // problem stattment
        // write a program that checks whether number is prime or not.
        // prime Number - the number that is num>1  divisible by only and only 1 and it self.
        // 2 is  prime 12 is not prim

        // input a number  and it should be >1

        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number >1 ");
        int number = sc.nextInt();

        // while loop conndition divider*divider <= number number %divider == 0 not prim
        // if not then checks for divider++
        int d=2;

        while(d*d<=number){
            if(number%d==0){
                System.out.println("Not Prime");
                return;
            }else{
                d++;
            }
        }
         System.out.println("Prime");



    }
}