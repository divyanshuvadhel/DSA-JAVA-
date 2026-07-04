public class Main {
    //print  1 to 5 ok!

    // every recursion have to case
    // 1 will be the base case: where recursion stops
    // 2. recursive call: is where recuren sitars with new arguments

    public  static  void print(int start,int end){
        // base case :
        if(start>end) return ;

        //recursive call :
        System.out.println(start);
        print(start+1,end);
        // starts printing from 1;
    }

    public static void main(String[] args) {
        print(1,5);
    }
}