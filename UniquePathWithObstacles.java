/**
 * Created by anshul on 22/08/18.
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] path = new int[row][column];

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < row) {
                    path[i][0] = 0;
                    i++;
                }
            } else {
                path[i][0] = 1;
            }
        }

        for (int i = 0; i < column; i++) {
            if (obstacleGrid[0][i] == 1) {
                while (i < column) {
                    path[0][i] = 0;
                    i++;
                }
            } else {
                path[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 0)
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                else
                    path[i][j] = 0;
            }
        }

        return path[row - 1][column - 1];
    }

    public static void main(String[] args) {
        UniquePathWithObstacles u = new UniquePathWithObstacles();
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0, 0, 0},
                                                                  {0, 1, 0},
                                                                  {0, 0, 0}}));
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0, 0, 0, 1},
                                                                  {0, 1, 0, 0},
                                                                  {0, 0, 1, 0},
                                                                  {0, 1, 0, 0}}));
    }
}
