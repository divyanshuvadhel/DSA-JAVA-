public class IsSorted {
    public  static boolean isSorted(int i,int[]arr){
        if(i>=arr.length-1){
            return true;
        }
        return arr[i]<arr[i+1] && isSorted(i+1,arr);
    }

    public static void main(String[] args) {
        int []arr={};
        System.out.println(isSorted(0,arr));
    }
}
