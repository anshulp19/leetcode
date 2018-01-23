/**
 * Created by anshul on 23/01/18.
 */
import java.util.*;

public class TwoSums {
    public int[] twoSums(int[] nums, int target){
        /*int firstPos = 0;
        int secondPos = 0;

        for(int i = 0; i < nums.length; i++){
            // firstPos = i;
            for(int j = i + 1; j < nums.length; j++){
                if(target - nums[i] == nums[j]) {
                    //System.out.println("val1: " + nums[i] + " " + "val2: " + nums[j]);
                    //System.out.println("i: " + i + " " + "j: " + j);
                    firstPos = i;
                    secondPos = j;
                }
            }
        }
        return new int[]{firstPos, secondPos};*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        TwoSums ts = new TwoSums();
        int[] result = ts.twoSums(new int[]{3, 2, 4}, 6);

        for(int elem: result)
            System.out.println(elem);
    }

}
