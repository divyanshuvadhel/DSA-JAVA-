import java.util.Arrays;

public class Pangram {
    public static boolean checkIfPangram(String sentence) {
        // if size of the string is lesser then the 26 return false;
        if(sentence.length()<26) return false;
        // if is is not then
        // count the frequency of the each letter
        int[] alphabetCount=new int[26];
        int sum=0;
        for(int i=0;i<sentence.length();i++){
//        // charat give me the char at the index
            char letter=sentence.charAt(i);
//            alphabetCount[122-(int)letter]++
            // is letter is encounterd before ?
            if(alphabetCount[122-(int)letter]>0){
                continue;
            }else{
                alphabetCount[122-(int)letter]++;
                sum++;
            }
        }
        return sum>=26;
    }

    public static void main(String[] args) {
        String xyz="jwtucoucmdfwxxqnxzkaxoglszmfrcvjoiunqqausaxxaaijyqdqgvdnqcaihwilqkpivenpnekioyqujrdrovqrlxovcucjqzjsxmllfgndfprctxvxwlzjtciqxgsxfwhmuzqvlksyuztoetyjugmswfjtawwaqmwyxmvo";
        System.out.println(checkIfPangram(xyz));
    }
}
