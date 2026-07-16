public class SkipA {
    public static String skip(String str,int start,StringBuilder ans){

        if(start>str.length()-1){
            return ans.toString();
        }


        if(str.charAt(start)!='a'){
            ans.append(str.charAt(start));
        }
        skip(str,start+1,ans);
        return ans.toString();
    }

    public static void main(String[] args) {
        String str="aabcda";
        StringBuilder ans=new StringBuilder();
        System.out.println(skip(str,0,ans));
    }
}
