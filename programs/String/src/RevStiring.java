import java.util.ArrayList;
import java.util.Arrays;

public class RevStiring {

//    Reverse String

    public  static String reverse(String s){
        StringBuilder sb= new StringBuilder();
               for(int i=s.length()-1;i>=0; i-- ){
                   sb.append(s.charAt(i));
               }

            return sb.toString();
    }
    public static void main(String[] args) {
        String h="hello";
        System.out.println(reverse(h));
    }
}
