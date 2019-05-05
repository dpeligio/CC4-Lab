/*
 * Devon Blandin
 * Assignment 3 :: CSC383 (SSII)
 * August 4th, 2012
*/

public class TreeNode<T extends Comparable>
{
    public T data;            // data stored at this node
    public TreeNode left;    // reference to left subtree
    public TreeNode right;   // reference to right subtree

    // Constructs a leaf node with the given data.
    public TreeNode(T data)
    {
        this(data, null, null);
    }

    // Constructs a leaf or branch node with the given data and links.
    public TreeNode(T data, TreeNode left, TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
} // end TreeNode
