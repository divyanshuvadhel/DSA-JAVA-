import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        // tacking input in array
        // manual way  a[0] = 1; somting bad and repitive
//        int [] arr=new int[10];
        int[] arr={1,2,3,4,5,6,7,8};
        // useing for loop
        Scanner sc=new Scanner(System.in);
//        System.out.println(arr.length);
//        for(int i=0;i<arr.length; i++){
//            arr[i]=sc.nextInt();
//        }

        // printing the array

//        for(int i=0; i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

     // for each loop to printing and reading array

//        for(int num: arr){
//            System.out.println(num);
//        }


     /// using Arrays.toSring method
     String ar= Arrays.toString(arr);
        System.out.println(ar);
    }


}
