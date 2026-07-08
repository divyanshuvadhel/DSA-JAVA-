public class RomanToInteger {

    public static  String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        char [] arr={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y','Z'};
       while(columnNumber>0){

           columnNumber--;

           int remender=columnNumber%26;
           ans.append( arr[remender]);

           columnNumber/=26;
       }
       return ans.reverse().toString();
    }
    public static int romanToInt(String s) {
        int number=0;

        char [] string= s.toCharArray();

        for(int i=0;i<string.length;){
            if(string[i]=='I'){
                if(i<string.length-1 && string[i+1]=='V') {
                    number += 4;
                    i+=2;
                }else if(i<string.length-1 && string[i+1]=='X'){
                    number+=9;
                    i+=2;
                }else{
                    number+=1;
                    i++;
                }
            }else if(string[i]=='X'){
                if(i<string.length-1 && string[i+1]=='L'){
                    number+=40;
                    i+=2;
                }else if(i<string.length-1 && string[i+1]=='C'){
                    number+=90;
                    i+=2;
                }else{
                    number+=10;
                    i++;
                }
            }else if(string[i]=='C'){
                if(i<string.length-1 && string[i+1]=='D'){
                    number+=400;
                    i+=2;
                }else  if( i< string.length-1 && string[i+1]=='M'){
                    number+=900;
                    i+=2;
                }else {
                    number+=100;
                    i++;
                }
            }else if(string[i]=='V'){
                number+=5;
                i++;
            }else if(string[i]=='L'){
                number+=50;
                i++;
            }else if(string[i]=='D'){
                number+=500;
                i++;
            } else if (string[i] == 'M') {
                number+=1000;
                i++;
            }
        }

        return number;


    }
    public static void main(String[] args) {
//        int number=romanToInt("MCMXCIV");
////        System.out.println(romanToInt("MCMXCIV"));

        System.out.println(convertToTitle(701));

    }
}
