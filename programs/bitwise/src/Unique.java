public class Unique {

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 1, 1};
        System.out.println(uni(arr));
    }

    private static int uni(int[] arr) {
        int unique=0;
        for(int n:arr){
            unique^=n;
        }
        return  unique;
    }

}
