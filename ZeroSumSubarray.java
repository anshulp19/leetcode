import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anshul on 29/12/18.
 *
 * https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 */
public class ZeroSumSubarray {
    public void subarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0)
                ans.add(Arrays.asList(i));
            else if (sum == 0)
                ans.add(Arrays.asList(0, i));
            else if (map.get(sum) != null)
                ans.add(Arrays.asList(map.get(sum) + 1, i));

            map.put(sum, i);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        ZeroSumSubarray z = new ZeroSumSubarray();
        z.subarrays(new int[]{1, 4, -2, -2, 5, -4, 3});
        z.subarrays(new int[]{1, 2, 3, 4, -9, 6, 7, -8, 1, 9});
    }
}
