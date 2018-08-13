/**
 * Created by anshul on 14/08/18.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1])
                nums[j++] = nums[i];
        }
        nums[j++] = nums[nums.length - 1];

        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        System.out.println(r.removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5}));
        System.out.println(r.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
