import java.util.Scanner;

public class returntype {
    public static void main(String[] args) {

//        int addition =sum();
//        System.out.println(addition);

        System.out.println(greet("divyesh"));

    }

    public  static int sum (){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a num 1:");
        int num1=sc.nextInt();
        System.out.println("Enter num 2 :");
        int num2=sc.nextInt();
     return num2+num1; // sending back the value to whoever calls these function
    }

    // returnring a string

    public  static String greet(String name ){
        String msg= "hellow " + name + ", goodmoringin";
        return  msg;
    }
}
