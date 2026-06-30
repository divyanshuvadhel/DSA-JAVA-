import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser{

    public static String stringParser(String s) {
        if (s == null) {
            return "";
        }

        int start = 0;
        int end = s.length();
        StringBuilder sb = new StringBuilder();

        while (start < end) {
            // Case 1: Match "G"
            if (s.charAt(start) == 'G') {
                sb.append('G');
                start++;
            }
            // Case 2: Match opening parenthesis "("
            else if (s.charAt(start) == '(') {

                // Check for "()" safely -> Requires 1 more character ahead
                if (start + 1 < end && s.charAt(start + 1) == ')') {
                    sb.append('o');
                    start += 2;
                }
                // Check for "(al)" safely -> Requires 3 more characters ahead
                else if (start + 3 < end
                        && s.charAt(start + 1) == 'a'
                        && s.charAt(start + 2) == 'l'
                        && s.charAt(start + 3) == ')') {
                    sb.append("al");
                    start += 4;
                }
                // Skip invalid or unmatched single '(' to prevent infinite loop
                else {
                    start++;
                }
            }
            // Case 3: Skip any other character
            else {
                start++;
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        String s="G()(al)a";
        System.out.println(stringParser(s));
//        Pattern p1= Pattern.compile("\\\\(\\\\)");
//        Matcher a= p1.matcher(s);
//        boolean hase=s.matches("()");
//        System.out.println(hase);

//
//        if(a.find()){
//            System.out.println(a.group());
//        }

//        System.out.println(s.charAt(1));
    }



}
