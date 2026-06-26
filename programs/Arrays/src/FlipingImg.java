public class FlipingImg {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int []raw : image){
            reversArrayAndInvert(arr);
        }
        return image;
    }
    public void reversArrayAndInvert(int[]arr){
        int start=0;
        int end=arr.length-1;

        while(start<=end){

            //invert lement
            if(start!=end){
                arr[start]=arr[start]==0?1:0;
                arr[end]=arr[end]==0?1:0;
            }else{
                arr[end]=arr[end]==0?1:0;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;


            start++;
            end--;
        }
    }
    public int[][] flipAndInvertImage(int[][] image) {

    }
}
