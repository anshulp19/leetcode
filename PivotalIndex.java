/**
 * Created by anshul on 13/08/18.
 */
public class PivotalIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];

            if (leftSum == sum)
                return i;

            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotalIndex p = new PivotalIndex();
        System.out.println(p.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(p.pivotIndex(new int[]{1, 2, 3}));
    }
}
