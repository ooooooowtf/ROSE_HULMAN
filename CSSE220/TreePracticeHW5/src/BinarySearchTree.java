/**
 * More Binary Tree practice problems. This problem creates BSTs of type
 * Integer: 1. Neither problem makes use of the BST ordering property; I just
 * found insert() to be a convenient way to build trees for testing. 2. I used
 * Integer instead of T since the makeTree method sets the data value of each
 * node to be a depth, which is an Integer.
 * 
 * @author Matt Boutell and <<<YOUR NAME HERE>>>.
 * @param <T>
 */

/*
 * TODO: 0 You are to implement the methods below. Use recursion!
 */
public class BinarySearchTree {

	private BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * This constructor creates a full tree of Integers, where the value of each
	 * node is just the depth of that node in the tree.
	 * 
	 * @param maxDepth
	 *            The depth of the leaves in the tree.
	 */
	public BinarySearchTree(int maxDepth) {
		// TODO: 1 Write this.
		// Hint: You may find it easier if your recursive helper method is
		// outside of the BinaryNode class.
		if (maxDepth < 0) {
			root = NULL_NODE;
			return;
		}
		root = new BinaryNode(0);
		BinarySearchTreeHelper(maxDepth, root, 1);
	}

	public void BinarySearchTreeHelper(int maxDepth, BinaryNode lastNode, int currDepth) {
		if (maxDepth < currDepth) {
			return;
		}
		BinaryNode left = new BinaryNode(currDepth);
		BinaryNode right = new BinaryNode(currDepth);
		lastNode.left = left;
		lastNode.right = right;
		BinarySearchTreeHelper(maxDepth, left, currDepth + 1);
		BinarySearchTreeHelper(maxDepth, right, currDepth + 1);
	}

	public int getSumOfHeights() {
		// TODO. 2 Write this.
		// Can you do it in O(n) time instead of O(n log n) by avoiding repeated
		// calls to height()?
		return root.getSum().sum;
	}

	// These are here for testing.
	public void insert(Integer e) {
		root = root.insert(e);
	}

	/**
	 * @return A string showing an in-order traversal of nodes with extra
	 *         brackets so that the structure of the tree can be determined.
	 */
	public String toStructuredString() {
		return root.toStructuredString();
	}

	public class Sum {
		public int height;
		public int sum;

		public Sum(int height, int sum) {
			this.height = height;
			this.sum = sum;
		}
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Integer element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		// TODO Auto-generated method stub.
		public Sum getSum() {
			if (this == NULL_NODE) {
				return new Sum(-1, 0);
			}
			Sum leftS = left.getSum();
			Sum rightS = right.getSum();
			int height = Math.max(leftS.height, rightS.height)+1;
			int sum = leftS.sum+rightS.sum+height;
			return new Sum(height,sum);
		}

		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(data) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(data) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		public String toStructuredString() {
			if (this == NULL_NODE) {
				return "";
			}
			return "[" + left.toStructuredString() + this.data + right.toStructuredString() + "]";
		}

	}
}