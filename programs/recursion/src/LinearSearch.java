public class LinearSearch {

    public  static int  search(int index,int[] arr, int target){
        if(index==arr.length-1){
            return (arr[index]==target)?index:-1;
        }

        if(arr[index]==target) return index;

        return search(index+1,arr,target);
    }
    public static void main(String[] args) {
            int []arr={1,2,3,4,5,6,7,8};
        System.out.println(search(0,arr,9));
    }
}
