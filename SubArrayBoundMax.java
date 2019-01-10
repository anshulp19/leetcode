/**
 * Created by anshul on 10/01/19.
 *
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 *
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element
 * in that subarray is at least L and at most R.
 *
 */
public class SubArrayBoundMax {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j = 0, count = 0, res = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                res += i - j + 1;
                count = i - j + 1;
            } else if (A[i] < L) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubArrayBoundMax s = new SubArrayBoundMax();
        System.out.println(s.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println(s.numSubarrayBoundedMax(new int[]{2, 1, 4, 3, 2}, 2, 3));
    }
}
