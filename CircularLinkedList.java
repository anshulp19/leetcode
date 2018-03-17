/**
 * Created by anshul on 13/03/18.
 */
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

public class CircularLinkedList {
    Node head;

    CircularLinkedList() { head = null; }

    public void sorted_insert(int num) {
        Node temp = new Node(num);
        Node current = head;

        //if head is null
        if (current == null) {
            temp.setNextNode(temp);
            head = temp;
        }

        //Node to be inserted just before the head
        else if (current.getData() >= num) {
            while(current.getNextNode() != head)
                current = current.getNextNode();
            current.setNextNode(temp);
            temp.setNextNode(head);

            head = temp;
        }

        //node is to be inserted somewhere after head
        else {
            while(current.getNextNode() != head && current.getData() < num)
                current = current.getNextNode();
            temp.setNextNode(current.getNextNode());
            current.setNextNode(temp);
        }
    }

    public void print_circularList() {
        if(head != null){
            Node temp = head;

            do {
                System.out.print(temp.getData() + " ");
                temp = temp.getNextNode();
            } while(temp != head);
        } else {
            System.out.println("Empty List!!");
        }
        System.out.println("\n");
    }

    public int getJosephusPosition(int m) {
        Node ptr1 = head;
        Node ptr2 = head;

        while(ptr1.getNextNode() != ptr1) {
            int count = 1;

            while(count != m) {
                ptr2 = ptr1;
                ptr1 = ptr1.getNextNode();
                count++;
            }
            ptr2.setNextNode(ptr1.getNextNode());
            ptr1 = ptr2.getNextNode();
        }

        return ptr1.getData();
    }

    public static void main(String args[]) {
        CircularLinkedList cl = new CircularLinkedList();

        //cl.print_circularList();
        for(int i = 1; i < 11; i++)
            cl.sorted_insert(i);
        
        System.out.println(cl.getJosephusPosition(3));
    }
}
