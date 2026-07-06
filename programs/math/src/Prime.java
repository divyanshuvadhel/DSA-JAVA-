public class Prime {
    public  static  boolean isPrime(int n){
       /*1.>  if(n<=1) return false;
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;

        */

//       2
        if(n<=1) return  false;

        for(int i=2; (i*i)<n; i++){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }

    public static void  printNprimes(int n){
        boolean [] primes=new boolean[n+1];

        // initalty all the false;

        for(int i=2; i*i<=n ; i++){
            if(!primes[i]){
                for(int j=i*i; j<=n; j+=i){
                    primes[j]=true;
                }
            }
        }
        for (int k=2; k<=n ; k++){
            if(!primes[k]){
                System.out.print(k+" ");
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println(isPrime(10));
        printNprimes(1000);
    }

}
