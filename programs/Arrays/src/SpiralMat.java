import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMat {

    public static ArrayList<Integer> spiraMat(int[][] mat){
        ArrayList<Integer> ans= new ArrayList<>();
        int firstRow=0;int firstCol=0;
        int lastRow= mat.length-1; int lastCol=mat[0].length-1;

            while(firstRow<=lastRow && firstCol<=lastCol){
                // first add the row -->
                // run loop till the fCol- lCol
                int i=firstRow; int j=firstCol;
                while(firstCol<=lastCol && j<=lastCol){
                    ans.add(mat[i][j++]);
                }
                firstRow++;
                // now run loop till frow - lrow
                i=firstRow; j=lastCol;
                while (firstRow<=lastRow && i<=lastRow){
                    ans.add(mat[i++][j]);
                }
                lastCol--;

                // run loop till the lcol- fcol

                i=lastRow; j=lastCol;
                while (lastRow>=firstRow && j>=firstCol){
                    ans.add(mat[i][j--]);
                }
                lastRow--;

                i=lastRow; j=firstCol;
                while( lastCol >=firstCol && i>=firstRow){
                    ans.add(mat[i--][j]);
                }
                firstCol++;
                System.out.println(ans);
            }

        return ans;
    }


    public static void main(String[] args) {
        int [][]mat={{1},{2},{3}};
//        Arrays<> re=spiraMat(mat);
        System.out.println(spiraMat(mat));
    }


}
