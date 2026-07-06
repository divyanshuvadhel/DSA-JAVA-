public class Factors {
    public static void main(String[] args) {
        int n=20;
        // print all factor of 20;

        for(int i=1; i<n/i; i++){
            if(n%i==0){
                if(n/i==i){
                    System.out.print(i +" ");
                }
                else{
                    System.out.print( i + " "+ n/i +" ");
                }
            }
        }
    }
}
