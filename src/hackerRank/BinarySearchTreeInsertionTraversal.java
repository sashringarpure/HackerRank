package hackerRank;

// Similar to Linked List.
// Class TreeNode stores the value at that node and a pointer to left and right node.
// Class Tree creates the root node.
// Include : InOrder Traversal, Return Min and Max value, Insert a Node, Search for a Value(GET)

public class BinarySearchTreeInsertionTraversal {

	public static void main(String[] args) {
		Tree intTree = new Tree();
		intTree.insert(25);
		intTree.insert(20);
		intTree.insert(15);
		intTree.insert(27);
		intTree.insert(30);
		intTree.insert(29);
		intTree.insert(26);
		intTree.insert(22);
		intTree.insert(32);
		intTree.traverseInOrder();
		System.out.println();
		System.out.println(intTree.get(27));
		System.out.println(intTree.get(888));
		System.out.println("Min : " + intTree.min());
		System.out.println("Max : " + intTree.max());
		System.out.println("Deleting node 15 ...");
		intTree.delete(15);
		intTree.traverseInOrder();
		System.out.println();
		System.out.println("Deleting node 27 ...");
		intTree.delete(27);
		intTree.traverseInOrder();
		System.out.println();
		System.out.println("Deleting node 25 ...");
		intTree.delete(25);
		intTree.traverseInOrder();		
	}
	

}

class Tree {
	
//	This class starts the creation of a binary search tree.
	private TreeNode root;
	
	public void delete(int value) {
		root = delete(root, value);
	}
	
	private TreeNode delete(TreeNode subtreeRoot, int value) {
		if ( subtreeRoot == null )  return subtreeRoot;
		
		
		if ( value < subtreeRoot.getData() ) {
			subtreeRoot.setleftChild(delete(subtreeRoot.getLeftChild(), value));
		} else if ( value > subtreeRoot.getData() ) {
			subtreeRoot.setrightChild(delete(subtreeRoot.getRightChild(), value));
		} else {
//			To be used when node to be deleted has 0 or 1 child(ren)
			if ( subtreeRoot.getLeftChild() == null ) {
				return subtreeRoot.getRightChild();
			} else if ( subtreeRoot.getRightChild() == null ) {
					return subtreeRoot.getLeftChild();
				}
			
//			Node to be deleted has 2 or more children.
//			Replace the value in the subtreeroot node with the smallest value from the right subtree.
			subtreeRoot.setData(subtreeRoot.getRightChild().min());
//			Delete the node that has the smallest value in the right subtree.
			subtreeRoot.setrightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
			}
		return subtreeRoot;
		}
		
	
	public TreeNode get(int value) {
		if ( root != null ) 
			return root.get(value);
		
		return null;
	}
	
	public void insert(int value) {
		if ( root == null ) {
			root = new TreeNode(value) ;
		} else {
//			this calls the insert method from the TreeNode class, since root is an instance of TreeNode.
			root.insert(value);
		}
	}
	
	public void traverseInOrder() {
		if ( root != null ) {
			root.traverseInOrder();
		}
	}
	
	public int min() {
		if ( root == null ) return Integer.MIN_VALUE ; 
		else return root.min();
	}
	
	public int max() {
		if ( root == null ) return Integer.MAX_VALUE ; 
		else return root.max();
	}
	
}


class TreeNode {
	
	public TreeNode(int d) {
		this.data = d;
	}
	
	private int data;
//	Each node can have a left child and a right child.
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public int min() {
		if ( leftChild == null) return data;
		else {
			return leftChild.min();
		}
	}
	
	public int max() {
		if ( rightChild == null) return data;
		else {
			return rightChild.max();
		}
	}
	
	public TreeNode get(int value) {
	
		if ( value == this.data)
			return this;
		
		if ( value < this.data) {
			if ( leftChild != null)
				return leftChild.get(value);
		} else {
			if ( rightChild != null )
				return rightChild.get(value);
		}
		
		return null;
	}
	
	public void traverseInOrder() {
		
//		In Order Prints the left node first
		if ( leftChild != null ) {
			leftChild.traverseInOrder();
		}
		
		System.out.print("Data = " + data + " , ");
		
		if ( rightChild != null ) {
			rightChild.traverseInOrder();
		}
		
	}
	
	public void insert(int val ) {

//		If the value is less than the "data", explore the left sub-tree
//		Do nothing if the value == "data", ignore dupes.
		if ( val < this.data) {
			if ( leftChild == null ) {
				leftChild = new TreeNode(val);
			} else {
				leftChild.insert(val);
			}
		}
		
//		If the value is greater than the "data", explore the right sub-tree
		if ( val > this.data) {
			if ( rightChild == null ) {
				rightChild = new TreeNode(val);
			} else {
				rightChild.insert(val);
			}
		}
	}
	
	public void setData(int d) {
		this.data = d;
	}
	
	public void setleftChild(TreeNode lc) {
		this.leftChild = lc;
	}
	
	public void setrightChild(TreeNode rc) {
		this.rightChild = rc;
	}
	
	public int getData() {
		return this.data;
	}
	
	public TreeNode getLeftChild() {
		return this.leftChild;
	}
	
	public TreeNode getRightChild() {
		return this.rightChild;
	}
}
