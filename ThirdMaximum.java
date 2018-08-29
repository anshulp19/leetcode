/**
 * Created by anshul on 29/08/18.
 *
 * https://leetcode.com/problems/third-maximum-number/description/
 */
public class ThirdMaximum {
    public int thirdMax(int[] nums) {
        Integer max = null, second_max = null, third_max = null;

        for (Integer n: nums) {
            if (n.equals(max) || n.equals(second_max) || n.equals(third_max))
                continue;
            if (max == null || n > max) {
                third_max = second_max;
                second_max = max;
                max = n;
            } else if (second_max == null || n > second_max) {
                third_max = second_max;
                second_max = n;
            } else if (third_max == null || n > third_max)
                third_max = n;
        }

        return third_max == null ? max : third_max;
    }

    public static void main(String[] args) {
        ThirdMaximum t = new ThirdMaximum();
        System.out.println(t.thirdMax(new int[]{3, 2, 1}));
        System.out.println(t.thirdMax(new int[]{1, 2}));
        System.out.println(t.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(t.thirdMax(new int[]{5, 2, 2}));
    }
}
