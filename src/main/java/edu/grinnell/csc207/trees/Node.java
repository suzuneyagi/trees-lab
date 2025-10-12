package edu.grinnell.csc207.trees;

/**
 * A node of the binary tree.
 * 
 * N.B., this class is public so that you can manually create a Tree from Nodes.
 * Normally, we would want to make this class internal to the Tree class!
 */
public class Node<T> {
    public T value;
    public Node<T> left;
    public Node<T> right;

    /**
      * @param value the value of the node
      * @param left the left child of the node
      * @param right the right child of the node
      */
    Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
      * @param value the value of the node
      */
    Node(T value) {
        this(value, null, null);
    }
}
