public class ZigZag {
    public static String convert(String s, int numRows) {
        if(numRows>=s.length()) return s;

        StringBuilder str=new StringBuilder();

        int totalSteps= numRows+(numRows -2 );

        for(int row=0; row<numRows; row++){
            // total steps form the o th element
            int start=row;

            // loop to add more charter form these row

            if(row==numRows-1){
                // it is last row so just print in intervals
                while(true){

                    if(start<s.length()){
                        str.append(s.charAt(start));
                    }
                    start+=totalSteps;
                    if(start>=s.length()){
                        break;
                    }

                }
            }


            while(row<numRows-1){
                if(start<s.length()){
                    str.append(s.charAt(start));
                }
                    start+=totalSteps - (row + row);
                if(start>=s.length()){
                    break;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALIS" , 4));
    }
}
