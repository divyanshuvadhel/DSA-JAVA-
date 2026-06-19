public class Quetions {
    public static void main(String[] args) {
        //Q.1  Find Numbers with Even Number of Digits
        int []arr={-1,-112,1,0,12,222,24};
//        System.out.println(evenNums(arr));

        //Q.2
//        Richest Customer Wealth

        int[][] accounts={{1,2,3},{3,2,1}};

        System.out.println(richest(accounts));

    }

    public  static int richest(int[][] accounts){
        int richest=0;
        for(int [] ac:accounts){
            int welthofac=countWelth(ac);

            if(welthofac>richest) richest=welthofac;

        }
        return richest;
    }
    public static int countWelth(int[] ac){
        int welth=0;
        for(int balance:ac){
            welth+=balance;
        }
        return welth;
    }


    static int evenNums(int[]arr){
        int ans=0;

        for (int ele : arr) {
            if (ele>=10||ele<=-10) {
                if (countDigits(ele) % 2 == 0){
                    ans++;
                }
            }
        }
        return ans;
    }


    static int countDigits(int number){
        if(number<0) number=-number;
        int count=0;
        while(number>0){
            number= number/10;
            count++;
        }
        return count;
    }

}
