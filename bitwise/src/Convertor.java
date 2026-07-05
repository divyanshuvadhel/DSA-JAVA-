public class Convertor {
    public  static String  decimalTobinary(int n){
        String binary="";
        if(n==0)return "0";

        while(n>0){
            int curry=n%2;
            binary=curry+binary;
            n=n/2;

        }
        return binary;
    }


    public static double binaryTodecimal(int binary){
        double decimal=0;
        int i=0;
        while(binary>0){
            // get the last digit
            int last=binary%10;
            decimal= decimal+(last*Math.pow(2,i));
            binary/=10;
            i++;
        }
        return decimal;
    }


    public static void main(String[] args) {
        System.out.println(decimalTobinary(22));
        System.out.println(binaryTodecimal(10110));
    }
}
