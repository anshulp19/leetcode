import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anshul on 07/09/18.
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array. What is the most number of chunks
 * we could have made?
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 */
public class MaxChunksToMakeArraySorted {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int[] expect = arr.clone();
        int nonZero = 0, ans = 0;

        Arrays.sort(expect);

        for(int i = 0; i < arr.length; i++) {
            int x = arr[i], y = expect[i];

            count.put(x, count.getOrDefault(x, 0) + 1);
            if(count.get(x) == 0) nonZero--;
            if(count.get(x) == 1) nonZero++;

            count.put(y, count.getOrDefault(y, 0) - 1);
            if(count.get(y) == -1) nonZero++;
            if(count.get(x) == 0) nonZero--;

            if(nonZero == 0)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeArraySorted m = new MaxChunksToMakeArraySorted();
        System.out.println(m.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(m.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    }
}
