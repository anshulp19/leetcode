import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by anshul on 23/08/18.
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class AllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (h.contains(nums[i]))
                result.add(nums[i]);
            else
                h.add(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        AllDuplicatesInArray a = new AllDuplicatesInArray();

        System.out.println(a.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
