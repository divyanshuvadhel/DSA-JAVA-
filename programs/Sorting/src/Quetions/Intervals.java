package Quetions;

import java.util.ArrayList;
import java.util.Arrays;

public class Intervals {
    private static boolean isOverLaping(int[] one, int[] two){
        return one[0] <= two[1] && one[1] >= two[0];
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        ArrayList<int[]> temp = new ArrayList<>();
        ArrayList<int[]> ans = new ArrayList<>();

        for(int[] arr : intervals){
            temp.add(arr);
        }

        for(int i = 0; i < temp.size(); ) {
            int[] base = temp.get(i);
            boolean foundOverlap = false;

            for(int j = i + 1; j < temp.size(); j++){
                if(isOverLaping(base, temp.get(j))){
                    int min = Math.min(base[0], temp.get(j)[0]);
                    int max = Math.max(base[1], temp.get(j)[1]);

                    // Create the newly merged interval
                    int[] merged = new int[]{min, max};

                    // Remove both original pieces from our working pool
                    temp.remove(j); // Remove 'j' first so it doesn't mess up index 'i'
                    temp.remove(i);

                    // Put the newly merged one right back at the front to check it again
                    temp.add(0, merged);

                    foundOverlap = true;
                    break; // EXIT INNER LOOP IMMEDIATELY because temp has changed!
                }
            }

            if (foundOverlap) {
                i = 0; // Restart scanning from the beginning with our new merged item
            } else {
                ans.add(base);    // No overlaps found for this item anywhere; it is safe
                temp.remove(i);   // Remove it from temp so we don't process it again
                i = 0;            // Reset to 0 to process the next remaining item
            }
        }

        int [][] ret = new int[ans.size()][2];
        for(int k = 0; k < ans.size(); k++){
            ret[k] = ans.get(k);
        }
        return ret;
    }

    public static void main(String[] args) {
        int [][] a = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        System.out.println(Arrays.deepToString(merge(a)));
    }
}
