/**
 * Created by anshul on 13/07/18.
 *
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class TotalNumberOfIslands {

    public int numIslands (char [][]grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    region(grid, i, j);
                }
            }
        }

        return count;
    }

    private void region(char [][]grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;

        grid[i][j] = '0';

        region(grid, i - 1, j);
        region(grid, i + 1, j);
        region(grid, i, j - 1);
        region(grid, i, j + 1);
    }

    public static void main(String[] args) {
        TotalNumberOfIslands t = new TotalNumberOfIslands();

        System.out.println(t.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));

        System.out.println(t.numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
    }
}
