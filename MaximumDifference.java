/**
 * Created by anshul on 26/07/18.
 *
 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 */
public class MaximumDifference {

    public int MaximumDiff (int []arr) {
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];

        for (int i = 1; i < arr.length; i ++) {
            if (arr[i] - minElement > maxDiff)
                maxDiff = arr[i] - minElement;
            if (arr[i] < minElement)
                minElement = arr[i];
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        MaximumDifference m = new MaximumDifference();
        System.out.println(m.MaximumDiff(new int[]{1, 2, 90, 10, 110}));
    }
}
