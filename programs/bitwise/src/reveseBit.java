public class reveseBit {
    public static void main(String[] args) {
        // a^1=a~
        int n=43261596;
        int rev=0;
        for(int i=0;i<32 ;i++){
            rev=(rev<<1)| (n & 1);
            n=n>>1;
        }

        System.out.println(rev);


    }
}
