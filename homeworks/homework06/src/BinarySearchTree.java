import java.util.ArrayList;

/**
 * Binary Search Tree Class The head class for a binary search tree implementation.
 * 
 * @author jmn4fms
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * A reference pointer to the root of the tree
     */
    private TreeNode<T> root;

    /**
     * Default constructor Creates a binary tree object with null root note (empty tree)
     */
    public BinarySearchTree() {
        this(null);
    }

    /**
     * Constructor Creates a binary tree object with the given node as root
     * 
     * @param newRoot The root of the tree
     */
    public BinarySearchTree(TreeNode<T> newRoot) {
        this.root = newRoot;
    }

    public int size() {
        int count = 0;
        if (this.root != null) {
            count = root.size();
        }
        return count;
    }

    public int height() {
        if (this.root == null) {
            return 0;
        }
        return root.height();
    }

    /**
     * Get the root of the tree
     * 
     * @return The root of the tree
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     * 
     * @param root The new root of this tree
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * Find if an element exists Checks to see if the value val appears in the tree (recursively). Returns true if it
     * appears and false otherwise.
     * 
     * @param val The value to find
     * @return True if the tree contains the value, false otherwise
     */
    public boolean find(T val) {
        if (this.root == null)
            return false;
        return root.find(val);

    }

    /**
     * Insert an element Inserts val into the tree where it should appear, returning true on success and false otherwise
     * 
     * @param val The value to insert
     * @return True on success, false otherwise
     */
    public boolean insert(T val) {
        if (val == null) {
            return false;
        }

        if (this.root == null) {

            TreeNode<T> ins = new TreeNode<T>(val);
            this.root = ins;
            return true;
        }
        return this.root.insert(val);
    }

    public String postOrder() {
        if (this.root == null) {
            return "";
        }
        return root.postOrder();
    }

    public String inOrder() {
        if (this.root == null) {
            return "";
        }
        return root.inOrder();
    }

    /**
     * Delete an element from the tree Deletes val from the tree if it appears, returning true on success and false
     * otherwise
     * 
     * @param val The value to delete
     * @return True on success, false otherwise
     */
    public boolean delete(T val) {
        if (root == null) {
            return false;
        }
        deleteNode(root, val);
        if (find(val) == true) {
            return false;
        }
        return true;
    }

    public TreeNode deleteNode(TreeNode root, T value) {
        if (root == null) {
            return null;
        }
        if (root.getData().compareTo(value) > 0) {
            root.setLeft(deleteNode(root.getLeft(), value));

        } else if (root.getData().compareTo(value) < 0) {
            root.setRight(deleteNode(root.getRight(), value));
        }

        else {
            // if nodeToBeDeleted have both children
            if (root.getLeft() != null && root.getRight() != null) {
                TreeNode temp = root;
                // Finding minimum element from right
                TreeNode minNodeForRight = minimumElement(temp.getRight());
                // Replacing current node with minimum node from right subtree
                root.setData(minNodeForRight.getData());
                // Deleting minimum node from right now
                deleteNode(root.getRight(), (T) minNodeForRight.getData());

            }
            // if nodeToBeDeleted has only left child
            else if (root.getLeft() != null) {
                root = root.getLeft();
            }
            // if nodeToBeDeleted has only right child
            else if (root.getRight() != null) {
                root = root.getRight();
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }

    public static TreeNode minimumElement(TreeNode root) {
        if (root.getLeft() == null)
            return root;
        else {
            return minimumElement(root.getLeft());
        }
    }

    /**
     * Build from a list Build the tree from the given list, overwriting any tree data previously stored in this tree.
     * Should read from beginning to end of the list and repeatedly call insert() to build the tree.
     * 
     * @param list The list from which to build the tree
     * @return True if successfully built, false otherwise
     */
    public boolean buildFromList(ArrayList<T> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            insert(list.get(i));
        }
        System.out.println(list.toString());
        return true;
    }

    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.inOrder();
    }

    /**
     * Main method For testing, etc
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        /*
         * BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(); tree.insert(5); tree.insert(6); tree.insert(2);
         * tree.insert(10); tree.insert(4); System.out.println(tree.inOrder()); System.out.println(tree.postOrder());
         * System.out.println(tree.toString()); System.out.println(tree.size()); System.out.println(tree.find(1));
         * System.out.println(tree.height()); // 3 ArrayList<Integer> list = new ArrayList<>(); list.add(5); list.add(6);
         * list.add(2); list.add(10); list.add(4); // System.out.println(buildFromList(list));
         * //System.out.println(tree.delete(6)); System.out.println(tree.toString());
         */

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        System.out.println(bst.insert(5));
        System.out.println(bst.insert(3));
        System.out.println(bst.insert(1));
        System.out.println(bst.size());
        System.out.println(bst.inOrder());
        System.out.println(bst.find(1));
    }
}
