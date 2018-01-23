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

    public void push(int new_data) {
        Node temp_node = new Node(new_data);

        temp_node.setNextNode(head);
        head = temp_node;
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

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for(int i = 0; i < 9; i++)
            list.append(i);

        list.print_list();
        System.out.println("\n");

        //System.out.println("Length of list: "+ list.get_length());

        /*list.swapNodes(2, 8);
        list.print_list();*/

        list.getMiddleElement();
    }
}
    
