import java.util.*;
import java.util.LinkedList;

/**
 * Created by anshul on 17/07/18.
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 */
public class MissingNumbersInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int []arr = new int[nums.length + 1];

        for(int i: nums)
            arr[i] = 1;

        for(int i = 1; i <= nums.length; i++) {
            if(arr[i] == 0)
               l.add(i);
        }

        return l;
    }

    public List<Integer> findDisappearedNumbers_1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        long mask = 0;

        for(int i: nums)
            mask |= (1 << i);

        for(int i = 1; i <= nums.length; i++){
            if (((mask >> i) & 1) != 1)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        MissingNumbersInArray m = new MissingNumbersInArray();
        System.out.println(m.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(m.findDisappearedNumbers_1(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,32   }));
    }
}
