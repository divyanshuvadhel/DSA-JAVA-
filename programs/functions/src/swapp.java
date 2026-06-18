public class swapp {
    public static void main(String[] args) {
        int num1 =2,num2=4;
        System.out.println( num1 + " " + num2);
        swap(num1,num2); // in function it will be swapped
        System.out.println( num1 + " " + num2); // but not here resoan for these is pass by vlue concept

        // in java primitives always pass by value
        //   it does not send the acctuall value to the function instead it sends copy of the num1 and num2,

        // in main memory num1=2 and num2=4;
        // function swapp get coppies of these a=2 b=4 after the swapp in func a=4 ,b=2
        // only in function it never touched actuall value num1, num2
        // java passes value not variable it self

    }
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println( a + " " + b);
    }
}
