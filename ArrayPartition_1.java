import java.util.Arrays;

/**
 * Created by anshul on 11/07/18.
 *
 * https://leetcode.com/problems/array-partition-i/description/
 */
public class ArrayPartition_1 {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition_1 a = new ArrayPartition_1();
        System.out.println(a.arrayPairSum(new int[]{1,4,3,2}));
    }
}
