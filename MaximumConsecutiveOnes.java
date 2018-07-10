/**
 * Created by anshul on 10/07/18.
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 */
public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count  = 0, maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                count++;
            maxCount = Math.max(count, maxCount);
            if(nums[i] == 0)
                count = 0;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes m = new MaximumConsecutiveOnes();
        System.out.println(m.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1}));
    }
}
