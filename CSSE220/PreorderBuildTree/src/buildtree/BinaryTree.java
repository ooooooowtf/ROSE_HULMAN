package buildtree;

//import BinarySearchTree.BinaryNode;

/**
 * 
 * @author Matt Boutell and <<<Qishun Yu>>>.
 * @param <T>
 */

public class BinaryTree {

	private BinaryNode root;

	final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinaryTree() {
		this.root = this.NULL_NODE;
	}

	/**
	 * Constructs a tree (any tree of characters, not just a BST) with the given
	 * values and number of children, given in a pre-order traversal order. See
	 * the HW spec for more details.
	 * 
	 * @param chars
	 *            One char per node.
	 * @param children
	 *            L,R, 2, or 0.
	 */
	public BinaryTree(String chars, String children) {
		// TODO: Implement this constructor. You may not add any other fields to
		// the BinaryTree class, but you may add local variables and helper
		// methods if you like.
		if (chars.length()>0) {
			StringBuilder charS = new StringBuilder(chars);
			StringBuilder chilD = new StringBuilder(children);
			this.root = new BinaryNode(charS, chilD);
		} else {
			root = NULL_NODE;
		}

	}

	/**
	 * In-order traversal of the characters
	 */
	@Override
	public String toString() {
		return this.root.toString();
	}

	/**
	 * @return A string showing an in-order traversal of nodes with extra
	 *         brackets so that the structure of the tree can be determined.
	 */
	public String toStructuredString() {
		return this.root.toStructuredString();
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public Character data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Character element) {
			this.data = element;
			this.left = BinaryTree.this.NULL_NODE;
			this.right = BinaryTree.this.NULL_NODE;
		}

		public BinaryNode(StringBuilder charS, StringBuilder chilD) {
			// TODO Auto-generated method stub.

			this.data = charS.charAt(0);

			if (chilD.charAt(0) == '0') {
				this.data = charS.charAt(0);
				this.left = NULL_NODE;
				this.right = NULL_NODE;
				return;
			}

			if (chilD.charAt(0) == 'L') {
				this.right = NULL_NODE;
				this.left = new BinaryNode(charS.deleteCharAt(0), chilD.deleteCharAt(0));
			} else if (chilD.charAt(0) == 'R') {
				this.left = NULL_NODE;
				this.right = new BinaryNode(charS.deleteCharAt(0), chilD.deleteCharAt(0));
			} else {
				this.left = new BinaryNode(charS.deleteCharAt(0), chilD.deleteCharAt(0));
				this.right = new BinaryNode(charS.deleteCharAt(0), chilD.deleteCharAt(0));
			}
		}

//		public BinaryNode insert(Character e) {
//			if (this == BinaryTree.this.NULL_NODE) {
//				return new BinaryNode(e);
//			} else {
//				// do nothing
//			}
//			return this;
//		}

		@Override
		public String toString() {
			if (this == BinaryTree.this.NULL_NODE) {
				return "";
			}
			return this.left.toString() + this.data + this.right.toString();
		}

		public String toStructuredString() {
			if (this == BinaryTree.this.NULL_NODE) {
				return "";
			}
			return "(" + this.left.toStructuredString() + this.data + this.right.toStructuredString() + ")";
		}

	}
}