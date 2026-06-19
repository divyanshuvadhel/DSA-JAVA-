public class Main {
    public static void main(String[] args) {

        // what is searching -- find the target element in data stucture
        // linear search is the algorith that simply search one by one element untill found target ele or arr all elem fini

//        int[] nums={1,2,3,4,5,6,7};
//        System.out.println(linear(nums,8));


        String str="hello madarbhat";
        searchInStr(str,'b');
    }



    public static int inRange(int[]arr,int target,int start,int end ){
        if(arr.length==0) return -1;

        for(int i=start; i<=end; i++){
            if(arr[i]==target) return i;
        }
        return -1;

    }
    public static void searchInStr(String str,char target){
        if(str.length()==0){
            System.out.println(false);
        }
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)==target){
                System.out.println("found" + i);
                return ;
            }
        }
        System.out.println("not found");
    }
    public static int linear(int[]arr,int target){
       // if arr.leangth ==0 return -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}