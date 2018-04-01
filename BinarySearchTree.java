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

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inorder();

    }
}