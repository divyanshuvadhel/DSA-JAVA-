public class AndInRange {
    public static void main(String[] args) {
//        int start = 5;
//        int end = 7;
//        int  ans =start;
//
//        while(start+1<=end){
//            ans= ans & (start+1);
//            if(ans==0) break;
//            start++;
//        }
//        System.out.println(ans);

        int star= 3455; int end= 234567;
        int shiftbits=0;
        while(star<end){
            star>>=1;
            end>>=1;
            shiftbits++;
        }
        System.out.println(star<<shiftbits);


    }
}
