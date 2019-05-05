/**
 * NAME: TreeNode.java
 * Description: creates the node with root, left and right children defined
 * 
 */


class TreeNode<E extends Comparable<E>>{
   E element;
   TreeNode left;
   TreeNode right;


   public TreeNode(){
    
   }


public E getElement() { return element; }


public void setElement(E element) {
	this.element = element;
}


public TreeNode getLeft() {
	return left;
}


public void setLeft(TreeNode left) {
	this.left = left;
}


public TreeNode getRight() {
	return right;
}


public void setRight(TreeNode right) {
	this.right = right;
}
   
   
   // end TreeNode

}// end class TreeNode