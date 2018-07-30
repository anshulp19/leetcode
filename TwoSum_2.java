/**
 * Created by anshul on 30/07/18.
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSum_2 {

    private int search(int[] num, int start, int end, int n) {
        if (start == num.length)
            return -1;

        int low = start, high = end;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (num[mid] == n)
                return mid;
            if (num[mid] < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int secondIndex = search(numbers, i + 1, numbers.length - 1, target - numbers[i]);

            if (secondIndex != -1) {
                result[0] = i + 1;
                result[1] = secondIndex + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum_2 t = new TwoSum_2();

        int[] temp = t.twoSum(new int[]{0, 0, 3, 4}, 0);
        System.out.println(temp[0] + "\t" + temp[1]);
    }
}
