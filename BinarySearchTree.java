import java.util.*;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 * Created by anshul on 01/04/18.
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        left = null;
        right = null;
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return this.data;
    }

    public TreeNode getLeftChild() {
        return this.left;
    }

    public TreeNode getRightChild() {
        return this.right;
    }

    public void setData(int d) {
        this.data = d;
    }

    public void setLeftChild(TreeNode n) {
        this.left = n;
    }

    public void setRightChild(TreeNode n) {
        this.right = n;
    }
}

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    private TreeNode getRoot() {
        return this.root;
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(val <= root.getData())
            root.setLeftChild(insertRec(root.getLeftChild(), val));
        else if(val > root.getData())
            root.setRightChild(insertRec(root.getRightChild(), val));

        return root;
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private void preorderUtil(TreeNode root) {
        if(root != null) {
            System.out.print(root.getData() + " ");
            preorderUtil(root.getLeftChild());
            preorderUtil(root.getRightChild());
        }
    }

    public void preorder() {
        preorderUtil(root);
        System.out.println();
    }

    private void inorderUtil(TreeNode root) {
        if(root != null) {
            inorderUtil(root.getLeftChild());
            System.out.print(root.getData() + " ");
            inorderUtil(root.getRightChild());
        }
    }

    public void inorder() {
        inorderUtil(root);
        System.out.println();
    }

    private void postorderUtil(TreeNode root) {
        if(root != null) {
            postorderUtil(root.getLeftChild());
            postorderUtil(root.getRightChild());
            System.out.print(root.getData() + " ");
        }
    }

    public void postorder() {
        postorderUtil(root);
        System.out.println();
    }

    public void levelorder() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.getData() + " ");

            if(tempNode.getLeftChild() != null)
                queue.add(tempNode.getLeftChild());
            if(tempNode.getRightChild() != null)
                queue.add(tempNode.getRightChild());
        }
        System.out.println();
    }

    public void inorderWithoutRecur() {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null) {
            stack.push(node);
            node = node.getLeftChild();
        }

        while(stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.getData() + " ");

            if(node.getRightChild() != null) {
                node = node.getRightChild();

                while(node != null) {
                    stack.push(node);
                    node = node.getLeftChild();
                }
            }
        }
        System.out.println();
    }

    private void MorrisTraversal_InorderUtil(TreeNode node) {
        TreeNode current, prev;

        if(node == null)
            return;

        current = node;
        while(current != null) {
            if(current.getLeftChild() == null) {
                System.out.print(current.getData() + " ");
                current = current.getRightChild();
            } else {
                prev = current.getLeftChild();

                while(prev.getRightChild() != null && prev.getRightChild() != current)
                    prev = prev.getRightChild();

                if(prev.getRightChild() == null) {
                    prev.setRightChild(current);
                    current = current.getLeftChild();
                } else {
                    prev.setRightChild(null);
                    System.out.print(current.getData() + " ");
                    current = current.getRightChild();
                }
            }
        }
    }

    public void MorrisTraversal_Inorder() {
        MorrisTraversal_InorderUtil(root);
        System.out.println();
    }

    private int height_util(TreeNode node) {
        if(node == null)
            return 0;
        else {
            int lHeight = height_util(node.getLeftChild());
            int rHeight = height_util(node.getRightChild());

            return (lHeight > rHeight) ? lHeight + 1 : rHeight + 1;
        }
    }

    public int height() {
        return height_util(root);
    }

    private void printGivenLevelNode(TreeNode node, int level) {
        if(node == null)
            return;
        if(level == 1)
            System.out.print(node.getData() + " ");
        else if(level > 1) {
            printGivenLevelNode(node.getLeftChild(), level - 1);
            printGivenLevelNode(node.getRightChild(), level - 1);
        }
    }

    public void reverseLevelOrder() {
        int h = height();
        for(int i = h; i > 0; i--) {
            printGivenLevelNode(root, i);
        }
    }

    private void diagonalPrintUtil( TreeNode node, int d, HashMap<Integer, Vector<Integer>> dPrint) {
        if(node == null)
            return;

        Vector<Integer> k = dPrint.get(d);

        if(k == null) {
            k = new Vector<>();
            k.add(node.getData());
        } else
            k.add(node.getData());

        dPrint.put(d, k);
        diagonalPrintUtil(node.getLeftChild(), d + 1, dPrint);
        diagonalPrintUtil(node.getRightChild(), d, dPrint);
    }

    public void diagonalPrint() {
        HashMap<Integer, Vector<Integer>> dPrint = new HashMap<>();
        diagonalPrintUtil(root, 0, dPrint);

        for(Entry<Integer, Vector<Integer>> entry: dPrint.entrySet())
            System.out.print(entry.getValue());
    }

    private void getVerticalOrder(TreeNode node, int hd, TreeMap<Integer, Vector<Integer>> m) {
        if(node == null)
            return;

        Vector<Integer> temp = m.get(hd);
        if(temp == null) {
            temp = new Vector<>();
            temp.add(node.getData());
        } else
            temp.add(node.getData());

        m.put(hd, temp);

        getVerticalOrder(node.getLeftChild(), hd - 1, m);

        getVerticalOrder(node.getRightChild(), hd + 1, m);
    }

    public void verticalOrder() {
        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, m);

        for(Entry<Integer, Vector<Integer>> entry: m.entrySet())
            System.out.println(entry.getValue());
    }

    private void printLeftBoundary(TreeNode node) {
        if (node != null) {
            if (node.getLeftChild() != null) {

                System.out.print(node.getData() + " ");
                printLeftBoundary(node.getLeftChild());

            } else if(node.getRightChild() != null) {

                System.out.print(node.getData() + " ");
                printLeftBoundary(node.getRightChild());
            }
        }
    }

    private void printLeaves(TreeNode node) {
        if(node != null) {
            printLeaves(node.getLeftChild());

            if(node.getLeftChild() == null && node.getRightChild() == null)
                System.out.print(node.getData() + " ");

            printLeaves(node.getRightChild());
        }
    }

    private void printRightBoundary(TreeNode node) {
        if (node != null) {
            if (node.getRightChild() != null) {

                printRightBoundary(node.getRightChild());
                System.out.print(node.getData() + " ");

            } else if(node.getLeftChild() != null) {

                printRightBoundary(node.getLeftChild());
                System.out.print(node.getData() + " ");
            }
        }
    }

    public void printBoundary() {
        if (root != null) {
            System.out.print("Boundary nodes: " + root.getData() + " ");

            printLeftBoundary(root.getLeftChild());

            printLeaves(root.getLeftChild());
            printLeaves(root.getRightChild());

            printRightBoundary(root.getRightChild());
        }
        System.out.println();
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);
        bst.insert(22);
        bst.insert(25);

       /* System.out.print("Inorder: ");
        bst.inorder();
        System.out.print("Inorder without recursion: ");
        bst.inorderWithoutRecur();

        System.out.print("Preorder: ");
        bst.preorder();

        System.out.print("Postorder: ");
        bst.preorder();

        System.out.print("Levelorder: ");
        bst.levelorder();

       System.out.print("Morris traversal inorder: ");
       bst.MorrisTraversal_Inorder();

       System.out.println("Height: " + bst.height());

       System.out.print("Reverse level order: ");
       bst.reverseLevelOrder();

       System.out.print("Diagonal print: ");
       bst.diagonalPrint();

       System.out.println("Vertical Order:");
       bst.verticalOrder();

       bst.printBoundary();
       System.out.print("Left boundary: ");
       bst.printLeftBoundary(bst.getRoot());
       System.out.println();
       System.out.print("Right boundary: ");
       bst.printRightBoundary(bst.getRoot());
       System.out.println();
       System.out.print("Leaf bodes: ");
       bst.printLeaves(bst.getRoot());
       System.out.println(); */
    }
}
