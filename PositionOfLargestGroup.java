import sun.jvm.hotspot.runtime.posix.POSIXSignals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anshul on 13/08/18.
 *
 * https://leetcode.com/problems/positions-of-large-groups/description/
 */
public class PositionOfLargestGroup {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, N = S.length();

        for (int j = 0; j < N; j++) {
            if (j == N - 1 || S.charAt(j) != S.charAt(j + 1)) {
                if (j - i + 1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PositionOfLargestGroup p = new PositionOfLargestGroup();
        System.out.println(p.largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
