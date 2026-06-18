public class changObj {
    public static void main(String[] args) {
        String name="akash";
        System.out.println(name);
        name =S(name);// reassign now name pointing to new object
        System.out.println(name);

        // for array

        int[] abc={1,2,3,4};
        System.out.println(abc[0]);
        A(abc);
        System.out.println(abc[0]);


    }

    // for String is immutable once it created it cant be change u can only reassign it
    // for array pass by value meants object pass reffrence and in reffrence their is

    public  static String S(String s){
        s="hellow";
        return  s;
    }

    public static void  A(int[]a){
        a[0]=10;
    }
}
