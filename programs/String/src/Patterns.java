public class Patterns {
    public static void sqaure(int raw , int col){
            // passign row and col
//                    xxxx
//                    xxxx
//                    xxxx
      for(int i=1; i<=raw;i++) {
          for (int j = 1; j <= col; j++) {
              System.out.print(" x ");
          }
          System.out.println();
      }
    }

    public static void leftTriangle(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print(" A ");
            }
            System.out.println();
        }
    } public static void rightTriangle(int row) {
        for (int i = 1; i <= row; i++) {
            // Print 3 spaces for every missing character to maintain alignment
            for (int s = 1; s <= row - i; s++) {
                System.out.print("   ");
            }
            // Print the character with matching padding
            for (int j = 1; j <= i; j++) {
                System.out.print(" A ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        sqaure(3,4);
        leftTriangle(5);
        rightTriangle
                (5);
    }
}
