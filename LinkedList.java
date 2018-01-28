import sun.awt.image.ImageWatched;

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

        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNextNode();
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList l3 = new LinkedList();

        /*for(int i = 0; i < 9; i++)
            list.push(i);*/
        list.push(7);
        list.push(5);
        list.push(9);
        list.push(4);
        list.push(6);

        list1.push(8);
        list1.push(4);

        System.out.println("\n");

        //System.out.println("Length of list: "+ list.get_length());

        /*list.swapNodes(2, 8);
        list.print_list();*/

        // list.getMiddleElement();

        // list.getNthFromLast(2);

        l3.addTwoList(list, list1).print_list();

    }
}
    
