package bst;

import java.util.ArrayList;

/**
 *
 * Exam 2a. Tree methods.
 * 
 * @author
 */

/*
 * TODO: Directions: Implement the method below. See the paper for details.
 */
public class BinarySearchTree {

	BinaryNode root;

	// The -17 is arbitrary -any int would be fine since we never refer to it.
	final BinaryNode NULL_NODE = new BinaryNode(-17);

	public BinarySearchTree() {
		this.root = this.NULL_NODE;
	}

	public int internalNodeSum() {
		// TODO Write this!
		return this.root.countSum();
	}

	public boolean attachPathMinAndMaxToNode(int value) {
		// TODO: Write this!
		if (this.root == BinarySearchTree.this.NULL_NODE) {
			return false;
		}
		return this.root.attachPath(value, value, value);

	}

	public ArrayList<Integer> listWithinToleranceOfTarget(int target, int tolerance) {
		// TODO: Write this!
		return this.root.listHelp(target, tolerance);
	}

	// The next methods are used by the unit tests
	public void insert(Integer e) {
		this.root = this.root.insert(e);
	}

	/**
	 * Feel free to call from tests to use to verify the shapes of your trees
	 * while debugging. Just remove the calls you are done so the output isn't
	 * cluttered.
	 * 
	 * @return A string showing a traversal of the nodes where children are
	 *         indented so that the structure of the tree can be determined.
	 * 
	 */
	public String toIndentString() {
		return this.root.toIndentString("");
	}

	@Override
	public String toString() {
		return this.root.toString();
	}

	// /////////////// BinaryNode
	public class BinaryNode {

		public int data;
		public BinaryNode left;
		public BinaryNode right;

		// The rest of the methods are used by the unit tests and for debugging
		public BinaryNode(int element) {
			this.data = element;
			this.left = BinarySearchTree.this.NULL_NODE;
			this.right = BinarySearchTree.this.NULL_NODE;
		}

		public ArrayList<Integer> listHelp(int target, int tolerance) {
			// TODO Auto-generated method stub.
			ArrayList<Integer> list = new ArrayList<>();
			this.toArrayList(list);
			ArrayList<Integer> output = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (Math.abs(target - list.get(i)) < (tolerance + 1)) {
					output.add(list.get(i));
				}
			}
			return output;
		}

		public void toArrayList(ArrayList<Integer> list) {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return;
			}
			// recurse Left
			this.left.toArrayList(list);
			// add current data
			list.add(this.data);
			// recurse Right
			this.right.toArrayList(list);
		}

		public boolean attachPath(int value, int max, int min) {
			// TODO Auto-generated method stub.
		
			if (this.data >= max) {
				max = this.data;
			}
			if (this.data <= min) {
				min = this.data;
			}
			if (this.data > value) {

				if (this.left != BinarySearchTree.this.NULL_NODE) {
					return this.left.attachPath(value, max, min);
				}

			} else if (this.data < value) {
				if (this.right != BinarySearchTree.this.NULL_NODE) {
					return this.right.attachPath(value, max, min);
				}
			} else if (this.data == value) {
				this.left = new BinaryNode(min);

				this.right = new BinaryNode(max);

				return true;
			}
			return false;

		}

		public int countSum() {
			// TODO Auto-generated method stub.
			if (this == BinarySearchTree.this.NULL_NODE) {
				return 0;
			} else if (this.left == BinarySearchTree.this.NULL_NODE && this.right == BinarySearchTree.this.NULL_NODE) {
				return this.left.countSum() + this.right.countSum();
			} else {
				return this.data + this.left.countSum() + this.right.countSum();
			}
		}

		public BinaryNode insert(int e) {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return new BinaryNode(e);
			} else if (e < this.data) {
				this.left = this.left.insert(e);
			} else if (e > this.data) {
				this.right = this.right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		@Override
		public String toString() {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return "";
			}
			return this.left.toString() + this.data + this.right.toString();
		}

		public String toIndentString(String indent) {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return indent + "NULL\n";
			}
			String myInfo = indent + String.format("%c\n", this.data);
			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}

}