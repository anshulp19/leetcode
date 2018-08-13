/**
 * Created by anshul on 13/08/18.
 */
public class MaxProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1, max2, max3, min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        System.out.println("Largest three numbers: " + max1 + " " + max2 + " " + max3);
        System.out.println("Smallest two numbers: " + min1 + " " + min2);
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        MaxProductOfThreeNumbers m = new MaxProductOfThreeNumbers();
        System.out.println(m.maximumProduct(new int[]{12, 13, 1, 10, 34, 1}));
        System.out.println(m.maximumProduct(new int[]{-10, -3, -5, -6, -20}));
        System.out.println(m.maximumProduct(new int[]{1, -4, 3, -6, 7, 0}));
        System.out.println(m.maximumProduct(new int[]{-4, -3, -2, -1, 60}));
        System.out.println(m.maximumProduct(new int[]{652, -516, -492, 108, 492, -20, -104, 904, -681,
                -505, -616, -732, 25, 132, -657, 40, 566, -779, -676, 566, 52, -799, 783,
                -639, -188, 707, 187,-879, 901, 803, 719, 577, 771, -642, 911, 597, -670, 710, 30, -422,
                310, 619, 874, 632, 126, -657, -694, 800, 81, 290, 163, -835, -810, -839, -151, 829, 942,
                -343, -984, 726, 764, -751, -189, -169, 386, -371, -105, -823, -594, -42, -627, 369, -198,
                -72, -889, -572, -904, 354, -546, -46, -422, 855, 980, 815, 494, 169, 700, -440, -322, 820,
                999, 904, 887, -295, -633,-252, -979, -375, -837, 590}));
    }
}
