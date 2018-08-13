/**
 * Created by anshul on 14/08/18.
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int sum = nums[0];

        for (int i = 1 ; i < k; i++)
            sum += nums[i];

        int max_sum = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > max_sum)
                max_sum = sum;
        }
        return (double)max_sum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray m = new MaximumAverageSubarray();
        System.out.println(m.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
