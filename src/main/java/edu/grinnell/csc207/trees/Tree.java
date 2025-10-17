package edu.grinnell.csc207.trees;

import java.util.ArrayList;
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
        
        if (root != null) {
            Tree<T> leftBranch = new Tree<T>(root.left);
            Tree<T> rightBranch = new Tree<T>(root.right);
            buf.append(root.value);
            buf.append(leftBranch.toStringHelper());
            buf.append(rightBranch.toStringHelper());
        }
        buf.append ("]");
        return buf.toString();
    }

    public String toStringHelper() {
        if (root == null) {
            return "";
        } else {
            StringBuffer buf = new StringBuffer("");
            buf.append(", ");
            buf.append(root.value);
            Tree<T> leftBranch = new Tree<T>(root.left);
            Tree<T> rightBranch = new Tree<T>(root.right);
            buf.append(leftBranch.toStringHelper());
            buf.append(rightBranch.toStringHelper());
            return buf.toString();
        }
    }

    ///// Part 3: Traversals

    /**
     * @return the elements of this tree collected via an in-order traversal
     */
    public List<T> toListInorder() {
        List<T> treeElements = new ArrayList<T>(size());
        inOrderHelper(treeElements, root);
        return treeElements;
    }

    public void inOrderHelper(List<T> lst, Node<T> treeRoot){
        if(treeRoot == null){
            return;
        } else if(treeRoot.left == null && treeRoot.right != null){
            lst.add(treeRoot.value);
            inOrderHelper(lst, treeRoot.right);
        }else if(treeRoot.right ==null && treeRoot.left != null){
            inOrderHelper(lst, treeRoot.left);
            lst.add(treeRoot.value); 
        }else{
            inOrderHelper(lst, treeRoot.left);
            lst.add(treeRoot.value);
            inOrderHelper(lst, treeRoot.right);
        }
    }

    /**
     * @return the elements of this tree collected via a pre-order traversal
     */
    public List<T> toListPreorder() {
        List<T> treeElements = new ArrayList<T>(size());
        preOrderHelper(treeElements, root);
        return treeElements;
    }

    public void preOrderHelper(List<T> lst, Node<T> treeRoot){
        if(treeRoot == null){
            return;
        } else if(treeRoot.left == null && treeRoot.right != null){
            lst.add(treeRoot.value);
            preOrderHelper(lst, treeRoot.right);
        }else if(treeRoot.right ==null && treeRoot.left != null){
            lst.add(treeRoot.value);
            preOrderHelper(lst, treeRoot.left); 
        }else{
            lst.add(treeRoot.value);
            preOrderHelper(lst, treeRoot.left);
            preOrderHelper(lst, treeRoot.right);
        }
    }


    /**
     * @return the elements of this tree collected via a post-order traversal
     */
    public List<T> toListPostorder() {
        List<T> treeElements = new ArrayList<T>(size());
        postOrderHelper(treeElements, root);
        return treeElements;
    }

    public void postOrderHelper(List<T> lst, Node<T> treeRoot){
        if(treeRoot == null){
            return;
        } else if(treeRoot.left == null && treeRoot.right != null){
            postOrderHelper(lst, treeRoot.right);
            lst.add(treeRoot.value);
        }else if(treeRoot.right ==null && treeRoot.left != null){
            postOrderHelper(lst, treeRoot.left); 
            lst.add(treeRoot.value);
        }else{
            postOrderHelper(lst, treeRoot.left);
            postOrderHelper(lst, treeRoot.right);
            lst.add(treeRoot.value);
        }
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
