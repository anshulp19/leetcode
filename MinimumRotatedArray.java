import java.nio.charset.MalformedInputException;

/**
 * Created by anshul on 09/01/19.
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Find Minimum in Rotated Sorted Array
 *
 */
public class MinimumRotatedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right])
            return nums[left];

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumRotatedArray m = new MinimumRotatedArray();
        System.out.println(m.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(m.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
