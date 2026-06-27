    import java.util.Scanner;

    public class AdvanceCalc {
       static Scanner sc=new Scanner(System.in);
        public static void main(String[] args) {

            System.out.println("--------------- Advance Calculator ---------------");
            boolean running =true;

            while (running){
                // find the input type
                System.out.println("Type of the input:");
                System.out.print("1.Integer   " );
                System.out.println("2.Decimal");
                int type=sc.nextInt();

                // now show the  functions
                String [] operations={"Add","Subtract","Multiply","Divide","Modulo","Power","Squar Root"};

                for(int i=0; i<operations.length;i++){
                    System.out.print ((i+1) + "." + operations[i] + "   ");
                    if(i== operations.length/2) {
                        System.out.println();
                        System.out.println();
                    }
                }
                System.out.println("8. Exit");

                // get the type of function want user
                int input=sc.nextInt();


                if(input==8) {
                    System.out.println("-------- thnak u for using this calc----------------");
                    running=false;
                    break;
                }

                // check which type of input

                if(type==1){
                    runForIntegers(input);// pass the option
                } else if (type==2){
                    runForDecimal(input);
                }else{
                    System.out.println("Enter valid option");
                }

                System.out.println("------------------------------------------------------------------");

            }
            sc.close();
        }
        public  static void runForDecimal(int option) {

            // cases for option
            switch (option) {
                case 1://addition
                    System.out.print("Enter num1:");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter num2:");
                    double num2 = sc.nextDouble();

                    System.out.println(add(num1,num2));

                    break;
                case 2: // substraction
                    System.out.print("Enter num1:");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2:");
                    num2 = sc.nextDouble();

                    System.out.println(sub(num1,num2));
                    break;
                case 3://Multiplie
                    System.out.print("Enter num1:");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2:");
                    num2 = sc.nextDouble();

                    System.out.println(multy(num1,num2));
                    break;
                case 4://Devision
                    System.out.print("Enter num1:");
                    num1 = sc.nextDouble();
                    System.out.print("Enter num2:");
                    num2 = sc.nextDouble();

                    System.out.println(divi(num1, num2));
                    break;
                case 5://modulo
                    System.out.print("Enter num1:");
                    int a = sc.nextInt();
                    System.out.print("Enter num2:");
                    int b = sc.nextInt();

                    System.out.println(modulo(a,b));
                    break;
                case 6://power
                    System.out.print("Enter base:");
                    num1 = sc.nextDouble();
                    System.out.print("Enter expo:");
                    int expo= sc.nextInt();
                    System.out.println(power(num1,expo));
                    break;
                case 7://Squar Root
                    System.out.println("Enter number:");
                    double num = sc.nextInt();

                    System.out.println(squarRoot(num));
                    break;

            }
        }


        public  static void runForIntegers(int option){

            // cases for option
            switch (option){
                case 1://addition
                    System.out.print("Enter num1:");
                    int num1=sc.nextInt();
                    System.out.print("Enter num2:");
                    int num2=sc.nextInt();

                    System.out.println(add(num1,num2));
                    break;
                case 2: // substraction
                    System.out.print("Enter num1:");
                     num1=sc.nextInt();
                    System.out.print("Enter num2:");
                     num2=sc.nextInt();

                    System.out.println(sub(num1,num2));
                    break;
                case 3://Multiplie
                    System.out.print("Enter num1:");
                    num1=sc.nextInt();
                    System.out.print("Enter num2:");
                    num2=sc.nextInt();

                    System.out.println(multy(num1,num2));

                    break;
                case 4://Devision
                    System.out.print("Enter num1:");
                    num1=sc.nextInt();
                    System.out.print("Enter num2:");
                    num2=sc.nextInt();

                    System.out.println(divi(num1,num2));
                    break;
                case 5://modulo
                    System.out.print("Enter num1:");
                    num1=sc.nextInt();
                    System.out.print("Enter num2:");
                    num2=sc.nextInt();

                    System.out.println(modulo(num1,num2));
                    break;
                case 6://power
                    System.out.print("Enter base:");
                    num1=sc.nextInt();
                    System.out.print("Enter expo:");
                    num2=sc.nextInt();

                    System.out.println(power(num1,num2));
                    break;
                case 7://Squar Root
                    System.out.println("Enter number:");
                    double num=sc.nextInt();

                    System.out.println(squarRoot(num));
                    break;
            }
        }


        static  double squarRoot(double a){
            return  Math.sqrt(a);
        }
        static  double power(double base,int exp){
            if(exp==0) return 1;
            double power=1;
            for(int i=1; i<=exp;i++){
                power*=base;
            }
            return  power;
        }
        static  int modulo (int a, int b){
            return a%b;
        }
        static  int add(int a, int b){
            return a+b;
        }
        static double add(double a, double b){
            return a+b;
        }
        static  int sub(int a, int b){
            return a-b;
        }
        static double sub(double a, double b){
            return a-b;
        }
         static  int multy(int a, int b){
            return a*b;
        }
        static double multy(double a, double b){
            return a*b;
        }
         static  int divi(int a, int b){
    //        if(b==0) return 0;
            return a/b;
        }
        static double divi(double a, double b){
            return a/b;
        }






    }
