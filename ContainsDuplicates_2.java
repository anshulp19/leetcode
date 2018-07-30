import java.util.HashMap;

/**
 * Created by anshul on 30/07/18.
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class ContainsDuplicates_2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else {
                if (i - map.get(nums[i]) <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates_2 c = new ContainsDuplicates_2();

        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
