/**
 * Created by anshul on 24/06/18.
 */
public class Arrays {

    private void reverse(int []arr, int start, int end) {
        if (end <= start || arr.length <= 1) {
            for (int elem : arr)
                System.out.print(elem + " ");
        } else {
            while(start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    public void printArray(int []arr) {
        for(int elem: arr) {
            System.out.print(elem + " ");
        }
    }

    public void rotateArray(int []arr, int k) {
        if(arr == null)
            return;
        if(arr.length <= 1 || k == 0) {
            for (int elem : arr)
                System.out.print(elem + " ");
        }
        if(k > arr.length)
            rotateArray(arr, k % arr.length);
        else {
            reverse(arr, 0, k);
            reverse(arr, k+1, arr.length - 1);
            reverse(arr, 0, arr.length - 1);
        }
    }

    public int binarySearch(int arr[], int start, int end, int elem) {
        if(end < start)
            return -1;
        int mid = start + (end - start) / 2;
        if(elem == arr[mid])
            return mid;
        if(elem < arr[mid])
            return binarySearch(arr, 0, mid - 1, elem);
        return binarySearch(arr, mid + 1, end, elem);
    }

    public void searchRotated(int []arr, int k) {
        if(arr.length < 0)
            return;
        if(arr.length == 1 && arr[0] != k)
            System.out.println("Not found");
        else if(arr.length == 1 && arr[0] == k)
            System.out.println("Found at index 0");
        else{
            int i;
            for(i = 1; i < arr.length - 1; i++){
                if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
                    break;
            }
            if(arr[i] == k)
                System.out.println("Found at " + i);
            else if(k <= arr[i - 1] && k >= arr[0]) {
                int result = binarySearch(arr, 0, i - 1, k);
                if (result != -1)
                    System.out.println("Found at " + result);
                else
                    System.out.println("Not found");
            }
            else {
                int result = binarySearch(arr, i + 1, arr.length - 1, k);
                if(result != -1)
                    System.out.println("Found at " + result);
                else
                    System.out.println("Not found");
            }
        }
    }

    public int sortedRotatedMin(int []arr, int low, int high) {
        if(high < low)
            return arr[0];

        if(high == low)
            return arr[low];

        int mid = low + (high - low) / 2;

        if(mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];

        if(mid > low && arr[mid - 1] > arr[mid])
            return arr[mid];

        if(arr[high] > arr[mid])
            return sortedRotatedMin(arr, low, mid - 1);
        return sortedRotatedMin(arr, mid + 1, high);
    }

    // Find the element before which all the elements are smaller than it, and after which all are greater
    public int findTheElement(int []arr) {
        int leftMax[] = new int[arr.length];
        leftMax[0] = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);

        int rightMin = Integer.MAX_VALUE;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(leftMax[i] < arr[i] && rightMin > arr[i])
                return i;
            rightMin = Math.min(rightMin, arr[i]);
        }
        return -1;
    }

    // Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
    public int findMaxSumOnRotattion(int []arr) {
        int arrSum = 0;
        int currSum = 0;

        for(int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            currSum += i * arr[i];
        }

        int maxSum  = currSum;
        for(int i = 1; i < arr.length; i++) {
            currSum = currSum + arrSum - (arr.length) * arr[arr.length - i];
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Arrays a = new Arrays();
        int[] array = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int arr1[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int arr2[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // a.rotateArray(array, 2);
        // a.printArray(array);
        // a.searchRotated(arr, 2);
        // System.out.println(a.sortedRotatedMin(arr, 0, arr.length - 1));
        // System.out.println(a.findTheElement(arr1));
        // System.out.println(a.findMaxSumOnRotattion(arr2));
    }
}
