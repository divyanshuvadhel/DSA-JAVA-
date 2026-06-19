public class Main {
    public static void main(String[] args) {

        // declartion of array
        // syntax
//        int[] arr=new int[5]; empty array of size five(5)

        int[] arr={1,2,3}; // direct intiazation of array
    // int [] arr ---- it is declartion of array creating a ref variable in stack  poiting to nothing yet
        // new int[6] a acutall object is created in heap memory at runtime not compile time
        // it calls dynamic memory allocation -- assigning memory during runtion not befor execution of program .
        // array in java is not memory continues it totaaly depends jvm

        // indexing of arr

        arr[0]=1;
//        System.out.println(arr[0]);

        // for primitives numeric int 0 double 0.0 float0f long0l char /u0000 null boolean false

        char[] a=new char[2];
//        System.out.println(a[0]); null character not full null
        // null in java it is special type of littral
           // littral is a fix value that writen diirectly in source code
        // can not assign null to primitives
//        a[0]=NUL;
    }
}