package edu.grinnell.csc207.trees;

import java.util.List;

/**
 * A generic binary tree implementation.
 */
public class Tree<T extends Comparable<? super T>> {

    ///// From the reading
    
    // N.B., the Node<T> class is made public for this lab, so that you can
    // construct trees without an insert-style method!

    private Node<T> root;

    /**
     * Constructs a new, empty binary tree.
     */
    public Tree() {
        root = null;
    }

    /**
     * Constructs a new binary tree with the given root node.
     * @param root the root node of the tree
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    /**
     * @param node the root of the tree 
     * @return the number elements found in this tree rooted at node
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /** @return the number of elements in the tree */
    public int size() {
        return sizeH(root);
    }

    ///// Part 1: Contains

    /**
     * @param value the value to search for
     * @return true iff the tree contains <code>value</code>
     */
    public boolean contains(T value) {
        if(root == null){
            return false;
        } else{
            Tree<T> leftBranch = new Tree<T>(root.left);
            Tree<T> rightBranch = new Tree<T>(root.right);
            if(value.compareTo(root.value)==0){
                return true;
            } else if(root.left == null && root.right == null){
                return false;
            } else if(rightBranch.contains(value)){
                return true;
            } else if(leftBranch.contains(value)){
                return true;
            } else{
                return false;
            }
        }
    }

    ///// Part 2: toString
   
    /**
     * @return a string represent of this tree in the form, "[x1, ..., xk]."
     * The order of the elements is left unspecified.
     */
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer("[");
        if (root == null) {
            buf.append ("]");
        } else {
            buf.append(root.value);
            buf.append(", ");
            Tree<T> leftBranch = new Tree<T>(root.left);
            Tree<T> rightBranch = new Tree<T>(root.right);
            buf.append(leftBranch.toString());
            buf.append(rightBranch.toString());
        }
        return buf.toString();
    }

    // public String toStringHelper() {

    // }

    ///// Part 3: Traversals

    /**
     * @return the elements of this tree collected via an in-order traversal
     */
    public List<T> toListInorder() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return the elements of this tree collected via a pre-order traversal
     */
    public List<T> toListPreorder() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return the elements of this tree collected via a post-order traversal
     */
    public List<T> toListPostorder() {
        throw new UnsupportedOperationException();
    }

    ///// Extra: Pretty Printing
    
    /**
     * @return a string represent of this tree in bulleted list form.
     */
    public String toPrettyString() {
        throw new UnsupportedOperationException();
    }

    /**
     * The main driver for this program
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Nothing to do. 'Run' via the JUnit tests instead!");
    }
}
