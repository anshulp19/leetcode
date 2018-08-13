import javax.sql.rowset.serial.SerialArray;

/**
 * Created by anshul on 13/08/18.
 *
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0])
            return 0;
        for (int i = 0; i < nums.length; i ++) {
            if (target == nums[i] || target < nums[i])
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
