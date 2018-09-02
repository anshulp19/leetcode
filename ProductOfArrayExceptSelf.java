import javax.sound.midi.Soundbank;

/**
 * Created by anshul on 29/08/18.
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        for (int i = 1; i < nums.length; i++)
            res[i] = res[i - 1] * nums[i - 1];

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
        return res;
    }

    public int[] productExceptSelf_UsingLog(int[] nums) {
        int[] ans = new int[nums.length];
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++)
            sum += Math.log10(nums[i]);

        for (int i = 0; i < nums.length; i++)
            ans[i] = (int)(1e-9 + Math.pow(10.00, sum - Math.log10(nums[i])));

        /*for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + " ");*/
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        p.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println();
        p.productExceptSelf(new int[]{10, 3, 5, 6, 2});
        System.out.println();
        p.productExceptSelf(new int[]{1, 0});
    }
}
