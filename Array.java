/**
 * Created by anshul on 24/06/18.
 */
import java.util.*;

public class Array {

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

    public int getMin(int arr[]) {
        int min = arr[0];
        for(int i = 1;  i< arr.length; i++) {
            min = Math.min(arr[i], min);
        }

        return min;
    }

    public int getMax(int arr[]) {
        int max = arr[0];
        for(int i = 1;  i< arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    public boolean IsArrayConsecutive(int []arr) {
        if(arr.length < 1)
            return false;
        int min = getMin(arr);
        int max = getMax(arr);

        if(max - min + 1 == arr.length) {
            boolean visited[] = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++) {
                if(visited[arr[i] - min] != false)
                    return false;
                visited[arr[i] - min] = true;
            }
            return true;
        }
        return false;
    }

    // arrange the array such that elements at even positions are greater than all elements before it
    // and elements at odd positions are less than all elements before it.
    public void RearrangeArray(int arr[]) {
        int even = arr.length / 2;
        int odd = arr.length - even;

        int temp[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        Arrays.sort(temp);

        int j = odd - 1;
        for(int i = 0; i < arr.length; i += 2) {
            arr[i] = temp[j];
            j--;
        }

        j = odd;
        for(int i = 1; i < arr.length; i += 2) {
            arr[i] = temp[j];
            j++;
        }

        printArray(arr);
    }

    // Rearrange the array elements so that positive and negative numbers are placed alternatively
    public void RearrangePositiveNegative(int arr[]) {
        int i = -1, temp = 0;
        for(int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pos = i + 1, neg = 0;
        while(neg < pos && pos < arr.length && arr[neg] < 0){
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
        printArray(arr);
    }

    public void PlaceNegativeBeforePositive(int arr[]) {
        int i = -1, temp = 0;
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        printArray(arr);
    }

    public void MoveZeroesToEnd(int arr[]) {
        int count = 0;
        int temp;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }

        printArray(arr);
    }

    public void SmallestLargest(int []arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int ArrIndex = 0;
        int []tempArr = new int[n];

        for(int i = 0, j = n - 1; i <= n/2 || j > n/2; i++, j--) {
            if(ArrIndex < n) {
                tempArr[ArrIndex] = arr[i];
                ArrIndex++;
            }
            if(ArrIndex < n) {
                tempArr[ArrIndex] = arr[j];
                ArrIndex++;
            }
        }
        for(int i = 0; i < n; i++)
            arr[i] = tempArr[i];

        printArray(arr);
    }

    public void DoubleFirstRepeatingNumber(int []arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
            }
        }

        System.out.println();
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }

        printArray(arr);
    }

    public static void main(String[] args) {
        Array a = new Array();
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};

        // a.rotateArray(new int[]{ 1,2,3,4,5,6,7,8,9,10 }, 2);
        // a.printArray(new int[]{ 1,2,3,4,5,6,7,8,9,10 });
        // a.searchRotated(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 2);
        // System.out.println(a.sortedRotatedMin(arr, 0, arr.length - 1));
        // System.out.println(a.findTheElement(new int[]{5, 1, 4, 3, 6, 8, 10, 7, 9}));
        // System.out.println(a.findMaxSumOnRotattion(new int[]{5, 1, 4, 3, 6, 8, 10, 7, 9}));
        /* System.out.println(a.IsArrayConsecutive(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}));
           System.out.println(a.IsArrayConsecutive(new int[]{5, 1, 4, 3, 6, 8, 10, 7, 9})); */
        // a.RearrangeArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        // a.RearrangePositiveNegative(new int[]{1, 2, 3, -4, -1, 4});
        // a.PlaceNegativeBeforePositive(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9});
        // a.MoveZeroesToEnd(new int[]{0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9});
        // a.SmallestLargest(new int[]{5, 1, 4, 3, 6, 8, 10, 7, 9});
        // a.DoubleFirstRepeatingNumber(new int[]{ 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 });
    }
}
