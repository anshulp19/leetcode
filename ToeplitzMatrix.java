/**
 * Created by anshul on 13/07/18.
 *
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (r > 0 && c > 0 && matrix[r][c] != matrix[r - 1][c - 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix t = new ToeplitzMatrix();

        System.out.println(t.isToeplitzMatrix(new int[][]{{1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}}));
    }
}
