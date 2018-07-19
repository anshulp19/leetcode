import java.util.HashMap;

/**
 * Created by anshul on 20/07/18.
 *
 * https://leetcode.com/problems/majority-element/description/
 * Assume: majority element always exist in the array
 */
public class MajorityElement {

    private boolean isMajorityElement(int num, int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i])
                count++;
        }

        if (count > nums.length / 2 )
            return  true;
        return false;
    }

    private int majorityElementUtil(int[] nums) {
        int maj_index = 0, count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maj_index] == nums[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }

        return nums[maj_index];
    }

    public int majorityElement(int[] nums) {
        int elem = majorityElementUtil(nums);
        if(isMajorityElement(elem, nums))
            return elem;
        return -1;
    }

    public int majorityElement_1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                if (count > nums.length / 2) {
                    return nums[i];
                } else {
                    map.put(nums[i], count);
                }

            } else {
                map.put(nums[i], 1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(new int[]{3, 2, 3}));
        System.out.println(m.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

        System.out.println(m.majorityElement_1(new int[]{3, 2, 3}));
        System.out.println(m.majorityElement_1(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
