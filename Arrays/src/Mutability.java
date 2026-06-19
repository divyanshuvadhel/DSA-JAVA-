import java.util.Arrays;

public class Mutability {
    public static void main(String[] args) {
        // mutability of arrays in java
        //in java pass by value for object refference adress is passd
        int[] arr={1,2,3,4,5};
        // firest print before changing the arr
        System.out.println(Arrays.toString(arr));
        change(arr);
        // after the chnge function
        System.out.println(Arrays.toString(arr));
        // so the arr of chang function and the arr of main function are point toward the same object to whatever the c
        // change is made by change function it reflact on the main arr
        // arrays in java is mutable but string is not

    }
    static void change(int[] arr){
        arr[0]=10;
    }

}
