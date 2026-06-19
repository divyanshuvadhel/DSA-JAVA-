import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Scanner;

public class multiarray {
    public static void main(String[] args) {
        // 2d array  - is like array of arrays
        // think like matrix
     // declaariton of 2d array

        int[][] matrix= {
                {1,2,3},
                {2,4}
        };

         int[][] arr=new int[2][3];

         input2d(arr);


//        Arrays.toString(matrix)
        // accessign elemtnts arr[0][1];

        // using for-loops( nested loop) print the aray
            print2d(matrix);

        print2d(arr);
    }

    static void print2d(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);

                // Only print the comma if it's NOT the last element
                if (j < arr[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    static  void  input2d(int[][] arr){
        Scanner sc =new Scanner(System.in);

        for(int i=0; i<arr.length; i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
    }

}
