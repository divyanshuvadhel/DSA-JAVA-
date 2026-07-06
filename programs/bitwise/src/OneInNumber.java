public class OneInNumber {
    public static void main(String[] args) {
        int n=4;
        int count=0;
        while (n>0){
            if((n&1)==1) count++;
            n=n>>1;
        }
        System.out.println(count);
    }
}
