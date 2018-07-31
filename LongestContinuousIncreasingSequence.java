/**
 * Created by anshul on 31/07/18.
 *
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class LongestContinuousIncreasingSequence {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1, len = 1;

        if (nums.length == 0)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                len++;
            else {
                if (max < len)
                    max = len;
                len = 1;
            }
        }
        if (max < len)
            max = len;

        return max;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSequence l = new LongestContinuousIncreasingSequence();

        System.out.println(l.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(l.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }
}
