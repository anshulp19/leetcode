/**
 * Created by anshul on 13/07/18.
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    public int biggestAreaOfIsland(int [][]grid) {
        int ans = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++)
                ans = Math.max(ans, getRegionSize(grid, visited, r, c));
        }

        return ans ;
    }

    private int getRegionSize(int [][]grid, boolean [][]visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0)
            return 0;

        visited[r][c] = true;

        return (1 + getRegionSize(grid, visited, r - 1, c) + getRegionSize(grid, visited, r + 1, c)
        + getRegionSize(grid, visited, r, c - 1) + getRegionSize(grid, visited, r, c + 1));
    }

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        System.out.println(m.biggestAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));

        System.out.println(m.biggestAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
    }
}
