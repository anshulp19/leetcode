import java.util.Arrays;

/**
 * Created by anshul on 26/08/18.
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        int len = 0;
        int start = nums.length, end = 0;

        Arrays.sort(temp);
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0? end - start + 1: 0);
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        System.out.println(s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(s.findUnsortedSubarray(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
