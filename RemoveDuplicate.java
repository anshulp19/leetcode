/**
 * Created by anshul on 22/08/18.
 *
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveDuplicate {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicate r = new RemoveDuplicate();
        System.out.println(r.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(r.removeElement(new int[]{3, 2, 2, 3}, 2));
        System.out.println(r.removeElement(new int[]{3, 2, 2, 3}, 1));
        System.out.println(r.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
