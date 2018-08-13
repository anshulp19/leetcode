/**
 * Created by anshul on 13/08/18.
 */
public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int max, max1, index = 0;
        max = max1 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max1 = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > max1) {
                max1 = nums[i];
            }
        }

        if (max >= 2 * max1)
            return index;

        return -1;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers l = new LargestNumberAtLeastTwiceofOthers();
        System.out.println(l.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(l.dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
