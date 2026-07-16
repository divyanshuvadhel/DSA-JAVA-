import java.util.Arrays;

public class SpiralII {
        public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

            int[][] ans = new int[rows * cols][2];

            int index = 0;

            int r = rStart;
            int c = cStart;

            ans[index++] = new int[]{r, c};

            int step = 1;

            while (index < rows * cols) {

                // go to  right
                for (int i = 0; i < step; i++) {
                    c++;
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        ans[index++] = new int[]{r, c};
                        if (index == rows * cols) return ans;
                    }
                }

                // move down side
                for (int i = 0; i < step; i++) {
                    r++;
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        ans[index++] = new int[]{r, c};
                        if (index == rows * cols) return ans;
                    }
                }

                step++;

                // go left
                for (int i = 0; i < step; i++) {
                    c--;
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        ans[index++] = new int[]{r, c};
                        if (index == rows * cols) return ans;
                    }
                }

                //  above
                for (int i = 0; i < step; i++) {
                    r--;
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        ans[index++] = new int[]{r, c};
                        if (index == rows * cols) return ans;
                    }
                }

                step++;
            }

            return ans;
        }


    public static void main(String[] args) {
        int [][] ans=spiralMatrixIII(1,4,0,0);
        System.out.println(Arrays.toString(ans));
    }
}
