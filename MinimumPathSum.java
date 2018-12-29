import com.sun.xml.internal.bind.v2.model.core.MaybeElement;

/**
 * Created by anshul on 29/12/18.
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int coloumn = grid[0].length;

        int[][] ans = new int[row][coloumn];
        ans[0][0] = grid[0][0];

        for (int i = 1; i < row; i++)
            ans[i][0] = ans[i - 1][0] + grid[i][0];

        for (int i = 1; i < coloumn; i++)
            ans[0][i] = ans[0][i - 1] + grid[0][i];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < coloumn; j++) {
                ans[i][j] = Math.min(ans[i - 1][j], ans[i][j - 1]) + grid[i][j];
            }
        }

        return ans[row - 1][coloumn - 1];
    }


    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        System.out.println(minPathSum(cost));
    }

}
