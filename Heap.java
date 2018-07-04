import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by anshul on 03/07/18.
 */
//Min Heap
public class Heap {
    private int capacity = 100;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyDown() {
        int index = 0;

        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void heapifyUp() {
        int index = size - 1;

        while(hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public int getKthMin(int k) {
        int item;

        for(int i = 0; i < k - 1; i++)
            item = poll();

        item = poll();

        return item;
    }

    public static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    public static void getMedians(int []arr) {
        //max heap for numbers to the left side of median
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        // max heap for numbers to the right side of median
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        double[] medians = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        for (Double elem : medians) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.add(12);
        heap.add(3);
        heap.add(5);
        heap.add(7);
        heap.add(19);

        // System.out.println("2nd smallest element is: " + heap.getKthMin(2));
        // getMedians(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }
}
