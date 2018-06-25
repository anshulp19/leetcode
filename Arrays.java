import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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

    public static void main(String[] args) {
        Arrays a = new Arrays();
        int[] array = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};

        // a.rotateArray(array, 2);
        // a.printArray(array);
        // a.searchRotated(arr, 2);
    }
}
