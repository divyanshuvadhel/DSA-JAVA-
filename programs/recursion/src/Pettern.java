public class Pettern {
    public static void revTriangel(int n){
        for(int i=1; i<=n; i++){
            System.out.print(" * ");
        }
        if(n!=0){
            System.out.println();
            revTriangel(n-1);
        }else{
            return;
        }
    }
    public static void triangle(int n){
        if(n!=0){
            triangle(n-1);
            System.out.println();
        }
        for(int i=1; i<=n; i++){
            System.out.print(" * ");
        }

    }

    public static void main(String[] args) {
        triangle(7);
    }
}
