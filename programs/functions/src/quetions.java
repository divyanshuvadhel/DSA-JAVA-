public class quetions {
    public static void main(String[] args) {
    //     Q,1 prime number
//        System.out.println(Prime(64));

    // Q.2 Armstrong number

//        System.out.println(Armstrong(153));

    // Q.3 all three digit armstrong number

        PrintArmstrong();
    }

    public  static boolean Prime(int number){

        if(number<=1) return false;

        int c=2;

        while(c*c<=number){
            if(number%c==0){
                return false;
            }else{
                c++;
            }
        }
        return true;



    }

    public static boolean Armstrong(int number ){
        // get the indiavidual num
        // make cub of it store it.
        // now add it and copare to number
        int original=number;
        int sum=0;
        while(number>0){

            int singleNum=number%10;
            int cube= singleNum * singleNum * singleNum;
            sum +=cube;
            number/=10;
        }

        return sum==original;
    }


   public  static  void PrintArmstrong(){
        for(int i=100; i<=1000; i++){
           if(Armstrong(i)){
               System.out.println(i);
           }
        }
   }


}
