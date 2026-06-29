public class suffle {
    public  static String suffle(String s, int[]indices){
        char[] ans=new char[indices.length];
        for(int i=0;i<indices.length;i++){
            int index=indices[i];
            ans[index]=s.charAt(i);
        }
        return new String(ans);
    }
}
