import java.util.ArrayList;
import java.util.Arrays;

public class arrayList {
    public static void main(String[] args) {
        // Array List
        // so array  have fixed size once we declare the size cant grow or shrink the size of it .
        // but Array List can be grow and shrink as our need
        // java handles the resizing autometically by it self it is part of collection framwork java.util package

        // syntax

        ArrayList <Integer> arr=new ArrayList<>(10);

        // should use wraper class to difine the datatype will be stored int array not primitives resone for these is generics  coverd in opps
        // capacity of the array is optional to pass

        //When you create an ArrayList without passing a size, Java initializes it with a default initial capacity of 10 elements.
        // size and capacity two diiffrent things


        // array list operation common
        arr.add(0,1); // add the element
//        arr.get(0); // get the value
//        arr.set(0,2); // update the element
        arr.add(0,10);
        System.out.println(arr);




    }
}
