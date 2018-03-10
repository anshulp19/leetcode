import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by anshul on 04/12/17.
 */

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node () {
            data = 0;
            next = null;
        }

        Node (int d) {
            this.data = d;
            next = null;
        }

        int getData() {
            return this.data;
        }

        Node getNextNode() {
            return this.next;
        }

        void setData(int d) {
            this.data = d;
        }

        void setNextNode(Node n) {
            this.next = n;
        }
    }

    LinkedList(){}

    LinkedList(Node n){
        this.head = n;
    }

    public void push(int new_data) {
        Node temp_node = new Node(new_data);

        temp_node.setNextNode(head);
        head = temp_node;
    }

    Node getHead(){
        return this.head;
    }

    public void append(int new_data) {
        Node temp_node = new Node(new_data);

        if(head == null){
            head = temp_node;
            return;
        }

        Node temp = head;
        while(temp.getNextNode() != null)
            temp = temp.getNextNode();

        temp.setNextNode(temp_node);
        return;
    }

    public int recur_length(Node node) {
        if(node == null)
            return 0;

        return 1 + recur_length(node.getNextNode());
    }

    public int get_length() {
        return recur_length(head);
    }

    public void print_list() {
        Node temp = head;

        if(temp != null){
            while(temp != null){
                System.out.print(temp.getData() + " ");
                temp = temp.getNextNode();
            }
        }
        else {
            System.out.println("Empty list !!!!");
        }

    }

    public void swapNodes(int x, int y){
        if (x == y)
            return;

        //search for x
        Node prevX = null, currX = head;
        while (currX != null && currX.getData() != x){
            prevX = currX;
            currX = currX.getNextNode();
        }

        //search for y
        Node prevY = null, currY = head;
        while (currY != null && currY.getData() != y){
            prevY = currY;
            currY = currY.getNextNode();
        }

        //if either of x or y not present
        if (currX == null || currY == null)
            return;

        //if x is not the head of the list
        if (prevX != null)
            prevX.setNextNode(currY);
        else //make currY the head
            head = currY;

        //if y is not the head of the list
        if (prevY != null)
            prevY.setNextNode(currX);
        else //make currX the head
            head = currX;

        //swap currX and currY next pointers
        Node temp = currX.getNextNode();
        currX.setNextNode(currY.getNextNode());
        currY.setNextNode(temp);
    }

    public void getMiddleElement(){
        Node slow_ptr = head;
        Node fast_ptr = head;

        if (head != null){
            while (fast_ptr != null && fast_ptr.getNextNode() != null){
                fast_ptr = fast_ptr.getNextNode().getNextNode();
                slow_ptr = slow_ptr.getNextNode();
            }
            System.out.println("Middle element is: " + slow_ptr.getData());
        }
        return;
    }

    public void getNthFromLast(int n){
        Node firstPtr = head;
        Node secondPtr = head;
        int count = 0;

        while(count < n){
            firstPtr = firstPtr.getNextNode();
            count = count + 1;
        }

        while(firstPtr.getNextNode() != null){
            firstPtr = firstPtr.getNextNode();
            secondPtr = secondPtr.getNextNode();
        }

        System.out.println(n + "th element frm last: " + secondPtr.getData());
    }

    private Node addTwoListUtil(Node first, Node second){
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while(first != null || second != null){
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = (sum >= 10 ? 1 : 0);
            sum = sum % 10;
            temp = new Node(sum);

            if(res == null)
                res = temp;
            else
                prev.setNextNode(temp);
            prev = temp;

            if (first != null)
                first = first.getNextNode();
            if (second != null)
                second = second.getNextNode();
        }

        if(carry > 0)
            temp.setNextNode(new Node(carry));
        return res;
    }

    public LinkedList addTwoList(LinkedList l1, LinkedList l2){
        Node temp = addTwoListUtil(l1.getHead(), l2.getHead());
        return new LinkedList(temp);
    }

    public void revereListIter(){
        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while(current != null){
            nextNode = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    private Node reverseListRecurUtil(Node curr, Node prev){
        if(curr.getNextNode() == null){
            head = curr;
            curr.setNextNode(prev);
            return null;
        }
        Node nextNode = curr.getNextNode();
        curr.setNextNode(prev);
        reverseListRecurUtil(nextNode, curr);

        return head;
    }

    public void revereseListRecur(){
        head = reverseListRecurUtil(head, null);
    }

    private Node mergeTwoSortedListIterUtil(Node first, Node second) {
        Node temp = new Node();
        Node p = temp;

        while(first != null && second != null) {
            if(first.getData() <= second.getData()) {
                p.setNextNode(first);
                first = first.getNextNode();
            } else {
                p.setNextNode(second);
                second = second.getNextNode();
            }
            p = p.getNextNode();
        }
        if(first == null)
            p.setNextNode(second);
        if(second == null)
            p.setNextNode(first);

        return temp.getNextNode();
    }

    public LinkedList mergeTwoSortedListIter(LinkedList l1, LinkedList l2){
        Node temp = mergeTwoSortedListIterUtil(l1.getHead(), l2.getHead());
        return new LinkedList(temp);
    }

    private Node mergeTwoSortedListRecurUtil(Node first, Node second) {
        Node result = null;

        if(first == null)
            return second;
        if(second == null)
            return first;

        if(first.getData() <= second.getData()) {
            result = first;
            result.setNextNode(mergeTwoSortedListRecurUtil(first.getNextNode(), second));
        } else {
            result = second;
            result.setNextNode(mergeTwoSortedListRecurUtil(first, second.getNextNode()));
        }

        return result;
    }

    public LinkedList mergeTwoSortedListRecur(LinkedList l1, LinkedList l2){
        Node temp = mergeTwoSortedListRecurUtil(l1.getHead(), l2.getHead());
        return new LinkedList(temp);
    }

    private Node reverseUtil(Node node) {
        Node prev = null;
        Node current = node;
        Node nextNode = null;

        while(current != null){
            nextNode = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    private boolean compareList(Node first, Node second) {
        Node temp1 = first;
        Node temp2 = second;

        while(temp1 != null && temp2 != null){
            if(temp1.getData() == temp2.getData()){
                temp1 = temp1.getNextNode();
                temp2= temp2.getNextNode();
            } else
                return false;
        }
        if(temp1 == null && temp2 == null)
            return true;
        return false;
    }

    private boolean isPalindromeUtil(Node node) {
        Node second_half = null;
        Node slow_ptr = head;
        Node fast_ptr = head;
        Node prev_slow_ptr = head;
        Node midNode = null;
        boolean res = true;

        if(head != null && head.getNextNode() != null){

            //get to the middle of the list
            while(fast_ptr != null && fast_ptr.getNextNode() != null){
                fast_ptr = fast_ptr.getNextNode().getNextNode();
                prev_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.getNextNode();
            }

            if(fast_ptr != null) {
                midNode = slow_ptr;
                slow_ptr = slow_ptr.getNextNode();
            }

            second_half = slow_ptr;
            prev_slow_ptr.setNextNode(null);
            second_half = reverseUtil(second_half);
            res = compareList(head, second_half);

            second_half = reverseUtil(second_half);

            if(midNode != null){
                prev_slow_ptr.setNextNode(midNode);
                midNode.setNextNode(second_half);
            } else
                prev_slow_ptr.setNextNode(second_half);

        }

        return res;
    }

    public boolean isPalindrome(){
        return isPalindromeUtil(this.getHead());
    }

    private boolean isPalindromeRecurUtil(Node right){
        Node left = head;

        if(right == null)
            return true;

        boolean isp = isPalindromeRecurUtil(right.getNextNode());
        if(isp == false)
            return false;

        boolean isp1 = (right.getData() == left.getData());

        left = left.getNextNode();

        return isp1;
    }

    public boolean isPalindromeRecur(){
        return isPalindromeRecurUtil(this.getHead());
    }

    public void removeDuplicatesSorted(){
        Node current = head;

        Node next_next;

        if(head == null)
            return;

        while(current.getNextNode() != null) {
            if(current.getData() == current.getNextNode().getData()){
                next_next = current.getNextNode().getNextNode();
                current.setNextNode(null);
                current.setNextNode(next_next);
            } else
                current = current.getNextNode();
        }
    }

    public void removeDuplicatesUnsorted(){
        HashSet<Integer> hs = new HashSet<>();

        Node current = head;
        Node prev = null;

        while(current != null){
            int currentVal = current.getData();

            if(hs.contains(currentVal)){
                prev.setNextNode(current.getNextNode());
            } else {
                hs.add(currentVal);
                prev = current;
            }
            current = current.getNextNode();
        }
    }

    public void pairwiseSwapData(){
        Node temp = head;

        while(temp != null && temp.getNextNode() != null){
            int k = temp.getData();
            temp.setData(temp.getNextNode().getData());
            temp.getNextNode().setData(k);
            temp = temp.getNextNode().getNextNode();
        }
    }

    private Node sortedIntersectUtil(Node first, Node second){
        if(first == null || second == null)
            return null;

        if(first.getData() < second.getData())
            return sortedIntersectUtil(first.getNextNode(), second);

        if(first.getData() > second.getData())
            return sortedIntersectUtil(first, second.getNextNode());

        Node temp = new Node();
        temp.setData(first.getData());

        temp.setNextNode(sortedIntersectUtil(first.getNextNode(), second.getNextNode()));

        return temp;

    }

    public LinkedList sortedIntersect(LinkedList l1, LinkedList l2){
        Node temp = sortedIntersectUtil(l1.getHead(), l2.getHead());
        return new LinkedList(temp);
    }

    private Node reverseKNodesUtil(Node node, int k){
        Node current = node;
        Node next = null;
        Node prev = null;

        int count = 0;

        while(count < k && current != null){
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
            count++;
        }

        if(next != null)
            node.setNextNode(reverseKNodesUtil(next, k));

        return prev;

    }

    public void reverseKNodes(int k){
        LinkedList temp = new LinkedList(reverseKNodesUtil(this.getHead(), k));
        temp.print_list();
    }

    private LinkedList getUnionUtil(Node h1, Node h2){
        HashMap<Integer, Integer> hMap=  new HashMap<>();
        Node n1 = h1;
        Node n2 = h2;
        LinkedList result = new LinkedList();

        while(n1 != null){
            if(hMap.containsKey(n1.getData())){
                int val = hMap.get(n1.getData());
                hMap.put(n1.getData(), val + 1);
            } else {
                hMap.put(n1.getData(), 1);
            }
            n1 = n1.getNextNode();
        }

        while(n2 != null){
            if(hMap.containsKey(n2.getData())){
                int val = hMap.get(n2.getData());
                hMap.put(n2.getData(), val + 1);
            } else {
                hMap.put(n2.getData(), 1);
            }
            n2 = n2.getNextNode();
        }

        for(int val: hMap.keySet())
            result.append(val);

        return result;
    }

    public void getUnion(LinkedList l1, LinkedList l2){
        getUnionUtil(l1.getHead(), l2.getHead()).print_list();
    }

    private LinkedList getIntersectionUtil(Node h1, Node h2){
        HashSet<Integer> hSet = new HashSet<>();
        Node n1 = h1;
        Node n2 = h2;
        LinkedList result = new LinkedList();

        while(n1 != null){
            hSet.add(n1.getData());
            n1 = n1.getNextNode();
        }

        while(n2 != null){
            if(hSet.contains(n2.getData()))
                result.append(n2.getData());

            n2 = n2.getNextNode();
        }

        return result;
    }

    public void getIntersection(LinkedList l1, LinkedList l2){
        getIntersectionUtil(l1.getHead(), l2.getHead()).print_list();
    }

    public void rotate(int k){
        if(k == 0)
            return;
        Node current = head;

        int count = 1;
        while(count < k && current != null){
            count++;
            current = current.getNextNode();
        }
        if(current == null)
            return;
        Node kthNode = current;

        while(current.getNextNode() != null)
            current = current.getNextNode();

        current.setNextNode(head);
        head = kthNode.getNextNode();

        kthNode.setNextNode(null);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList l3 = new LinkedList();

        for(int i = 8; i > 3; i--)
            list.push(i);

        for(int i = 13; i > 6; i--)
            list1.push(i);
        /*list.push(7);
        list.push(5);
        list.push(9);
        list.push(4);
        list.push(6);

        list1.push(8);
        list1.push(4);*/

        System.out.println("\n");

        //System.out.println("Length of list: "+ list.get_length());

        /*list.swapNodes(2, 8);
        list.print_list();*/

        // list.getMiddleElement();

        // list.getNthFromLast(2);

        // l3.addTwoList(list, list1).print_list();

        /*list.revereListIter();
        list.print_list();*/

        /*list.revereseListRecur();
        list.print_list();*/

        // l3.mergeTwoSortedListIter(list, list1).print_list();

        // l3.mergeTwoSortedListRecur(list, list1).print_list();

        // System.out.println(list.isPalindrome());
        // System.out.println(list.isPalindromeRecur());

        /*list.push(1);
        list.push(1);
        list.removeDuplicatesSorted();
        list.print_list();*/

        /*list.push(1);
        list.push(1);
        list.removeDuplicatesUnsorted();
        list.print_list();*/

        /*list.pairwiseSwapData();
        list.print_list();*/

        // l3.sortedIntersect(list, list1).print_list();

        /*list1.print_list();
        System.out.println();
        list1.reverseKNodes(3);*/

        /*list.print_list();
        System.out.println();
        list1.print_list();
        System.out.println();
        l3.getUnion(list, list1);*/

        /*list.print_list();
        System.out.println();
        list1.print_list();
        System.out.println();
        l3.getIntersection(list, list1);*/

        /*list.print_list();
        list.rotate(4);
        System.out.println();
        list.print_list();*/
    }
}
    
