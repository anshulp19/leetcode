import java.util.*;
import java.util.LinkedList;

/**
 * Created by anshul on 14/07/18.
 */
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r * c)
            return nums;

        int [][]ans = new int[r][c];
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[0].length; j++)
                q.add(nums[i][j]);
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                ans[i][j] = q.remove();

        return ans;
    }
}
