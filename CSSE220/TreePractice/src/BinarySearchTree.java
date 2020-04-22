/**
 * Binary Tree practice problems
 * 
 * @author Matt Boutell and <<<YOUR NAME HERE>>>. 2014.
 * @param <T>
 */

/*
 * TODO: 0 You are to implement the four methods below. I took most of them from
 * a CSSE230 exam given in a prior term. These can all be solved by recursion -
 * I encourage you to do so too, since most students find practicing recursion
 * to be more useful.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		this.root = this.NULL_NODE;
	}

	/**
	 * This method counts the number of occurrences of positive Integers in the
	 * tree that is of type Integer. Hint: You may assume this tree contains
	 * integers, so may use a cast.
	 * 
	 * @return The number of positive integers in the tree.
	 */

	public int countPositives() {
		// TODO: 1 Write this.
		
		return this.root.countPossitive();
	}

	/**
	 * Recall that the depth of a node is number of edges in a path from this
	 * node to the root. Returns the depth of the given item in the tree. If the
	 * item isn't in the tree, then it returns -1.
	 * 
	 * @param item
	 * @return The depth, or -1 if it isn't in the tree.
	 */
	public int getDepth(T item) {
		// TODO: 2 Write this.
		if(this.root.contains(item)){
			return this.root.countDepth(item);
		}
		return -1;
	}

	/**
	 * This method visits each node of the BST in pre-order and determines the
	 * number of children of each node. It produces a string of those numbers.
	 * If the tree is empty, an empty string is to be returned. For the
	 * following tree, the method returns the string: "2200110"
	 * 
	 * 10 5 15 2 7 18 10
	 * 
	 * @return A string representing the number of children of each node when
	 *         the nodes are visited in pre-order.
	 */

	public String numChildrenOfEachNode() {
		// TODO: 3 Write this.
		return root.numChildrenOfEachNod();
	}

	/**
	 * This method determines if a BST forms a zig-zag pattern. By this we mean
	 * that each node has exactly one child, except for the leaf. In addition,
	 * the nodes alternate between being a left and a right child. An empty tree
	 * or a tree consisting of just the root are both said to form a zigzag
	 * pattern. For example, if you insert the elements 10, 5, 9, 6, 7 into a
	 * BST in that order. , you will get a zig-zag.
	 * 
	 * @return True if the tree forms a zigzag and false otherwise.
	 */
	public boolean isZigZag() {
		// TODO: 4 Write this.
		return root.isZigZag(-1);
	}

	public void insert(T e) {
		this.root = this.root.insert(e);
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public T element;
		public BinaryNode left;
		public BinaryNode right;
		public int count;

		public BinaryNode(T element) {
			this.element = element;
			this.left = BinarySearchTree.this.NULL_NODE;
			this.right = BinarySearchTree.this.NULL_NODE;
		}

		public BinaryNode insert(T e) {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(this.element) < 0) {
				this.left = this.left.insert(e);
			} else if (e.compareTo(this.element) > 0) {
				this.right = this.right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}
		
		public int countDepth(T item){
			if(this.element==item){
				return 0;
			}
			if(this.element.compareTo(item)>0){
				return 1+this.left.countDepth(item);
			}
			return 1+this.right.countDepth(item);
		}
		public int countPossitive(){
			if(this.element==null){
				return 0;
			}else if ((int)this.element>0){
				return 1+ this.left.countPossitive()+this.right.countPossitive();
			}else{
				return this.left.countPossitive()+this.right.countPossitive();
			}
		}
		
		public boolean contains(T item) {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return false;
			}
			return this.element.equals(item) || this.left.contains(item) || this.right.contains(item);
		}
		
		public String numChildrenOfEachNod(){
			int counter = 0;
			if (this.left != BinarySearchTree.this.NULL_NODE) {
				counter++;
			}
			if (this.right != BinarySearchTree.this.NULL_NODE) {
				counter++;
			}
			if (this == BinarySearchTree.this.NULL_NODE) {
				return "";
			}
			return Integer.toString(counter) + this.left.numChildrenOfEachNod() + this.right.numChildrenOfEachNod();
		}
		
		public boolean isZigZag(int a){
			int indicator = -1;
			if (this.left == NULL_NODE && this.right == NULL_NODE) {
				return true;
			} else if (this.left == NULL_NODE) {
				indicator = 0;
			} else if (this.right == NULL_NODE) {
				indicator = 1;
			} else if(this==NULL_NODE){
				return true;
			}
			else {
				return false;
			}
			if (indicator == a) {
				return false;
			} else
				return true && left.isZigZag(indicator) && right.isZigZag(indicator);
		}
		
	}
}