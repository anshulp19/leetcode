/**
 * Created by anshul on 29/12/18.
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 */
public class MaxLengthRepeatedSubarray {

    public static int findLength(int[] A, int[] B) {
        int[][] memo = new int[A.length + 1][B.length + 1];
        int ans = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j])
                        ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};

        System.out.println(findLength(A, B));
    }
}
