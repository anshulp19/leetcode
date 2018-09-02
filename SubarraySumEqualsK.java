import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anshul on 31/08/18.
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {
    public int subarraySum_II(int[] nums, int k) {
        List<List<Integer>> pos = new ArrayList<>();
        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                    pos.add(Arrays.asList(new Integer[]{start, end}));
                }
            }
        }

        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum_II(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum_II(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
        System.out.println();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(s.subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }
}
