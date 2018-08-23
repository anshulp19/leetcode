/**
 * Created by anshul on 23/08/18.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1, n2 = n - 1, n3 = m + n - 1;

        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] > nums2[n2])
                nums1[n3--] = nums1[n1--];
            else
                nums1[n3--] = nums2[n2--];
        }
        while (n2 >= 0)
            nums1[n3--] = nums2[n2--];

        System.out.println();
        for (int i = 0; i < m + n; i++)
            System.out.print(nums1[i] + " ");
    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();

        m.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}
