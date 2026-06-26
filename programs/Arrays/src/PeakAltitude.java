public class PeakAltitude {
    public int largestAltitude(int[] gain) {
        int highest=0;
        int cur=0;
        for(int i=0; i<gain.length;i++){
            // what is gaine from the start
            int gainAltitude=cur+gain[i];
            if(gainAltitude>highest){
                highest=gainAltitude;
            }
            cur=gainAltitude;

        }
        return highest;
    }

    public static void main(String[] args) {

    }
}
