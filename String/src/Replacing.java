public class Replacing {
    public static String replace(String s){
        // make array out of it
        char[] arr=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<arr.length;i++){

            if(arr[i]=='.'){
                sb.append("[.]");
             }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ip="192.12.12.2";
        System.out.println(replace(ip));

    }
}
