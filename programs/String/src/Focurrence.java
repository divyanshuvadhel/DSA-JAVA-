public class Focurrence {
    public static  int strStr(String haystack, String needle) {
        int i=0; int j=i+3;
        while(j<haystack.length()){
            if(needle.equals(haystack.substring(i,j))){
                return i;
            }
            i++; j++;
        }
        return -1;
    }

    public static int strStr2(String heystack, String needle) {
        int i=0;
        while(i<heystack.length()-(needle.length()-1)){
            int j=0;
            while(j<needle.length()){
                if(needle.charAt(j)!= heystack.charAt(i+j)){
                    break;
                }
                j++;
            }
            if(j==needle.length()-1){
                return j;
            } else{
                i++;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        String s="sadbutsad";
        System.out.println(s.substring(0,2));
        System.out.println(strStr2("sadbutsad","sad"));
    }
}
