import java.util.ArrayList;

public class Kid {
    public static void main(String[] args) {
       int  []candies = {2,3,5,1,3};

       ArrayList<Boolean> result= new ArrayList<>(candies.length);
       int extra=3;
       int maxCandie=0;
       for(int candie:candies){
           if(maxCandie<candie) maxCandie=candie;
       }
       for(int i=0; i<candies.length;i++){
           if(maxCandie>extra+candies[i]){
                result.add(false);
           }else {
               result.add(true);
           }
       }
        System.out.println(result);
    }

}
