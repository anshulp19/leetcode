import java.util.HashSet;

/**
 * Created by anshul on 26/07/18.
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (h.contains(nums[i])) {
                return true;
            } else {
                h.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates c = new ContainsDuplicates();

        System.out.println(c.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(c.containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
