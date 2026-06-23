import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String[] temp={"Celsius","Fahrenheit","Kelvin"};
        for (int i=0; i<3; i++){
            System.out.println((i+1) + "." + temp[i]);
        }
        System.out.println();
        int selected=sc.nextInt();

        System.out.println("ENTER A TEMPARATURE ");
        double temprature=sc.nextDouble();

         switch (selected){
             case 1:
                 System.out.println(celsiusToFahrenheit(temprature) + " F");
                 System.out.println(celsiusToKelvin(temprature) +" K");
                 break;

             case 2:
                 double cel=fahrenheitToCelsius(temprature);
                 System.out.println(cel + " C");
                 System.out.println(celsiusToKelvin(cel) +" K");
                 break;
             case 3:
                 double celsius= kelvinToCelsius(temprature);
                 System.out.println(celsius + " C");
                 System.out.println(celsiusToFahrenheit(celsius) + " F");
         }

    }


    static double kelvinToCelsius (double kelvin ){
    //        c= k-273.15
        double c=kelvin-273.15;
    //        System.out.println(c + " C");
        return c;
    }
    static  double celsiusToKelvin(double celsius){
        //        K = C + 273.15
        double kelvin=celsius+273.15;
    //        System.out.println(k + " K");
        return kelvin;
    }
    static double fahrenheitToCelsius(double fahrenheit){
    //    formula    C = (F - 32) × 5/9
        double celsius=(fahrenheit -32)*5/9;
    //        System.out.println(fahrenheit + " C");
        return  celsius;
    }
    static  double celsiusToFahrenheit(double celsius){
    //  formula       F = (C × 9/5) + 32
                  double fahrenheit=( celsius * 9/5) +32;
    //        System.out.println(f + " F");
        return  fahrenheit;
    }


}
