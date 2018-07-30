import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anshul on 31/07/18.
 *
 * https://leetcode.com/problems/degree-of-an-array/description/
 */
public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();

        int mx = 0;
        int mn = -1, str_index = -1;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if (count.get(x) == null) {
                count.put(x, 1);
                left.put(x, i);
            } else {
                count.put(x, count.get(x) + 1);
            }

            if (count.get(x) > mx) {
                mx = count.get(x);
                mn = i - left.get(x) + 1;
                str_index = left.get(x);
            } else if ((count.get(x) == mx) && (i - left.get(x) + 1 < mn)) {
                mn = i - left.get(x) + 1;
                str_index = left.get(x);
            }
        }

        for (int i = str_index; i < str_index + mn; i++)
            a.add(nums[i]);

        System.out.println(a);

        return a.size();
    }

    public static void main(String[] args) {
        DegreeOfArray d = new DegreeOfArray();

        System.out.println(d.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(d.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
