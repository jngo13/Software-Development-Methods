
/**
 * Binary Tree Node Tree node that has two children: left and right
 * 
 * @author jmn4fms
 * @param <Comparable> The type of data this tree node stores
 */

public class TreeNode<T extends Comparable<T>> {

    /**
     * Reference pointer to the left subtree
     */
    private TreeNode<T> left;

    /**
     * Reference pointer to the right subtree
     */
    private TreeNode<T> right;

    /**
     * Data stored at this node
     */
    private T data;

    /**
     * Default Constructor Creates a binary tree node with null data and null children
     */
    public TreeNode() {
        this(null, null, null);
    }

    /**
     * Data-only Constructor Creates a binary tree node with the given data and null children
     * 
     * @param theData The data to store at this node
     */
    public TreeNode(T theData) {
        this(theData, null, null);
    }

    /**
     * Full Constructor Creates a binary tree node with the given data and child reference pointers
     * 
     * @param theData    The data to store at this node
     * @param leftChild  A reference pointer to the left subtree
     * @param rightChild A reference pointer to the right subtree
     */
    public TreeNode(T theData, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        data = theData;
        left = leftChild;
        right = rightChild;
    }

    /**
     * Left Child/Subtree getter
     * 
     * @return A reference pointer to the root of the left subtree
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Left Child/Subtree Setter
     * 
     * @param left A reference pointer to the new left subtree's root node
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Get the data at this node
     * 
     * @return The data stored at this node
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data at this node
     * 
     * @param data The data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * toString method
     */
    @Override
    public String toString() {
        // Not right
        String retVal = "";
        if (this.left != null)
            retVal += this.left.toString(); // recursive call on left
        if (this.right != null)
            retVal += this.right.toString(); // recursive call on right
        retVal += "(" + this.data + ")"; // add this node's data
        return retVal;
    }

    /**
     * size method (node-level) size returns the number of nodes in the (sub)tree; if called from root, size of entire tree
     * 
     * @return - returns an integer representing the number of nodes in the tree
     */
    public int size() {
        int size = 0;

        if (this.left != null) {
            size = size + this.left.size(); // call size on my left child
        }
        if (this.right != null) {
            size = size + this.right.size(); // call size on my right child
        }

        return size + 1; // one for "myself"
    }

    public int height() {
        if (this.getData() == null) {
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (this.left != null) {
            leftHeight = this.left.height();
        }
        if (this.right != null) {
            rightHeight = this.right.height();
        }

        int max = Math.max(leftHeight, rightHeight);

        return max + 1;
    }

    public boolean find(T val) {
        TreeNode<T> next = null;

        if (this.data == val) {
            return true;
        }

        else if (val.compareTo(this.data) < 0) {
            next = this.getLeft();
        }

        else
            next = this.getRight();

        if (next == null)
            return false;

        return next.find(val);
    }

    public boolean insert(T val) {
        if (this.getData() == null) {
            return false;
        }
        if (find(val) == true) {
            return false;
        }
        if (val.compareTo(this.data) < 0) {
            if (this.left == null) {
                TreeNode<T> ins = new TreeNode<T>(val);
                this.setLeft(ins);
            }

            else
                this.left.insert(val);

        } else if (val.compareTo(this.data) > 0) {
            if (this.right == null) {
                TreeNode<T> ins = new TreeNode<T>(val);
                this.setRight(ins);
            }

            else
                this.right.insert(val);
        }
        return true;
    }

    public String inOrder() {
        String retVal = "";
        if (this.left != null)
            retVal += this.left.inOrder(); // recursive call on left

        retVal += "(" + this.data + ")"; // add this node's data

        if (this.right != null)
            retVal += this.right.inOrder(); // recursive call on right

        return retVal;
    }

    public String postOrder() {
        String retVal = "";
        if (this.left != null)
            retVal += this.left.postOrder(); // recursive call on left

        if (this.right != null)
            retVal += this.right.postOrder(); // recursive call on right

        retVal += "(" + this.data + ")"; // add this node's data

        return retVal;
    }

    /**
     * Main method For main method testing, etc
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

    }

}
