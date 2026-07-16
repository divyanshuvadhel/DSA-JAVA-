import java.util.ArrayList;
import java.util.Arrays;

public class SubSeq {
    public  static ArrayList<String> sub(String str){
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0 ; i<str.length(); i++){
            for(int j=str.length()-1; j>=i; j--){
                String sub="";
                if(j==i){
                    sub+=str.charAt(j);
                    ans.add(sub);
                    sub="";
                    break;
                }
                sub+=str.charAt(i);
                sub+=str.charAt(j);
                ans.add(sub);
                sub="";
            }
            if((str.length()-i)>2){
                ans.add(str.substring(i));
            }
        }
        return ans;
    }

    public static void subRecursion(String sub,String str,ArrayList<String> ans){
        if(str.isEmpty()){
            if(sub.isEmpty()) return;
            ans.add(sub);
            return;
        }

         subRecursion(sub + str.charAt(0),str.substring(1),ans);
         subRecursion(sub ,str.substring(1),ans);
    }

    public static void permutation(String sub, String str, ArrayList<String> ans) {
        if (str.isEmpty()) {
            ans.add(sub);
            return;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= sub.length(); i++) {
            String first = sub.substring(0, i);
            String second = sub.substring(i);

            permutation(first + ch + second, str.substring(1), ans);
        }
    }


    public static void main(String[] args) {
        String s="abc";
        String a="";
        ArrayList<String > ans=new ArrayList<>();
//        subRecursion(a,s,ans);
        permutation(a,s,ans);
        System.out.println(ans);



    }
}
