package editortrees;

import editortrees.Node.Code;

// A height-balanced binary tree with rank that could be the basis for a text editor.

public class EditTree {

	private Node root;

	private Integer[] rotationalCount = { 0 };

	private int size = 0;

	private DisplayableBinaryTree display;

	private boolean needChange = false;

	/**
	 * MILESTONE 1 Construct an empty tree
	 */
	public EditTree() {
		this.root = Node.NULL_NODE;
	}

	/**
	 * MILESTONE 1 Construct a single-node tree whose element is ch
	 * 
	 * @param ch
	 */
	public EditTree(char ch) {
		this.root = new Node(ch);

	}

	/**
	 * MILESTONE 2 Make this tree be a copy of e, with all new nodes, but the
	 * same shape and contents.
	 * 
	 * @param e
	 */
	public EditTree(EditTree e) {
		if (e.root == Node.NULL_NODE || e.height() == 0) {
			this.root = e.root;
		} else {
			this.root = new Node();
			this.root = this.root.constructHelper(e.root);
		}

	}
	
	/**
	 * Constructor for the split method
	 * 
	 * @param n
	 *            the new root node
	 */
	public EditTree(Node n) {
		this.root = n;
		this.size = this.root.size();
	}

	/**
	 * MILESTONE 3 Create an EditTree whose toString is s. This can be done in
	 * O(N) time, where N is the size of the tree (note that repeatedly calling
	 * insert() would be O(N log N), so you need to find a more efficient way to
	 * do this.
	 * 
	 * @param s
	 */
	public EditTree(String s) {
		this.root = createTree(s, 0, s.length() - 1);
	}

	public Node createTree(String s, int start, int end) {
		if (start >= s.length() || end < 0) {
			return Node.NULL_NODE;
		}
		if (start == end) {
			Node node = new Node(s.charAt(start));
			return node;
		} else if (start < end) {
			int val = (start + end) / 2;
			int leftval = val - start;
			int rightval = end - val;
			int leftH = (int) (Math.log(leftval) / Math.log(2));
			int rightH = (int) (Math.log(rightval) / Math.log(2));

			Node newNode = new Node(s.charAt(val));
			newNode.rank = leftval;
			newNode.left = this.createTree(s, start, val - 1);
			newNode.right = this.createTree(s, val + 1, end);

			if (leftH < rightH) {
				newNode.balance = Code.RIGHT;
			}
			return newNode;
		}
		return Node.NULL_NODE;
	}

	/**
	 * MILESTONE 1 returns the total number of rotations done in this tree since
	 * it was created. A double rotation counts as two.
	 *
	 * @return number of rotations since this tree was created.
	 */
	public int totalRotationCount() {
		return this.rotationalCount[0];
	}

	/**
	 * MILESTONE 1 return the string produced by an inorder traversal of this
	 * tree
	 */
	@Override
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		this.root.stringHelper(toReturn);
		return toReturn.toString();

	}

	/**
	 * MILESTONE 1 This one asks for more info from each node. You can write it
	 * like the arraylist-based toString() method from the BinarySearchTree
	 * assignment. However, the output isn't just the elements, but the
	 * elements, ranks, and balance codes. Former CSSE230 students recommended
	 * that this method, while making it harder to pass tests initially, saves
	 * them time later since it catches weird errors that occur when you don't
	 * update ranks and balance codes correctly. For the tree with root b and
	 * children a and c, it should return the string: [b1=, a0=, c0=] There are
	 * many more examples in the unit tests.
	 * 
	 * @return The string of elements, ranks, and balance codes, given in a
	 *         pre-order traversal of the tree.
	 */
	public String toDebugString() {
		StringBuilder toReturn = new StringBuilder();
		toReturn.append("[");
		this.root.DebugstringHelper(toReturn);

		// trim out the final ", "
		if (toReturn.length() > 1) {
			toReturn.delete(toReturn.length() - 2, toReturn.length());
		}

		toReturn.append("]");
		return toReturn.toString();
	}

	/**
	 * MILESTONE 1
	 * 
	 * @param ch
	 *            character to add to the end of this tree.
	 */
	public void add(char ch) {
		// Notes:
		// 1. Please document chunks of code as you go. Why are you doing what
		// you are doing? Comments written after the code is finalized tend to
		// be useless, since they just say WHAT the code does, line by line,
		// rather than WHY the code was written like that. Six months from now,
		// it's the reasoning behind doing what you did that will be valuable to
		// you!
		// 2. Unit tests are cumulative, and many things are based on add(), so
		// make sure that you get this one correct.

		this.add(ch, Node.END);

	}

	/**
	 * MILESTONE 1
	 * 
	 * @param ch
	 *            character to add
	 * @param pos
	 *            character added in this inorder position
	 * @throws IndexOutOfBoundsException
	 *             if pos is negative or too large for this tree
	 */
	public void add(char ch, int pos) throws IndexOutOfBoundsException {

		Boolean[] isbalance = { false };
		this.root = this.root.add(ch, pos, isbalance, rotationalCount);

	}

	/**
	 * MILESTONE 1
	 * 
	 * @param pos
	 *            position in the tree
	 * @return the character at that position
	 * @throws IndexOutOfBoundsException
	 */
	public char get(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		return this.root.get(pos);
	}

	/**
	 * MILESTONE 1
	 * 
	 * @return the height of this tree
	 */
	public int height() {
		return this.root.height();
	}

	public int slowSize() {
		if (this.root == Node.NULL_NODE) {
			return 0;
		}
		return this.size();
	}

	public int slowHeight() {
		return this.root.height();
	}

	public void show() {
		if (this.display == null) {
			this.display = new DisplayableBinaryTree(this, 960, 1080, true);
		} else {
			this.display.show(true);
		}
	}

	/**
	 * closes the tree window still keeps all the data and you can still reshow
	 * the tree with the show method
	 */
	public void close() {
		if (this.display != null) {
			this.display.close();
		}
	}

	/**
	 * MILESTONE 2
	 * 
	 * @return the number of nodes in this tree, not counting the NULL_NODE if
	 *         you have one.
	 */
	public int size() {
		return this.root.size(); // replace by a real calculation.
	}

	/**
	 * MILESTONE 2
	 * 
	 * @param pos
	 *            position of character to delete from this tree
	 * @return the character that is deleted
	 * @throws IndexOutOfBoundsException
	 */
	public char delete(int pos) throws IndexOutOfBoundsException {
		// Implementation requirement:
		// When deleting a node with two children, you normally replace the
		// node to be deleted with either its in-order successor or predecessor.
		// The tests assume assume that you will replace it with the
		// *successor*.
		Boolean[] isHeightdecrease = { false };
		Node[] endNode = { null };
		this.root = this.root.delete(pos, isHeightdecrease, endNode, this.rotationalCount);
		return endNode[0].element;
	}

	/**
	 * MILESTONE 3, EASY This method operates in O(length*log N), where N is the
	 * size of this tree.
	 * 
	 * @param pos
	 *            location of the beginning of the string to retrieve
	 * @param length
	 *            length of the string to retrieve
	 * @return string of length that starts in position pos
	 * @throws IndexOutOfBoundsException
	 *             unless both pos and pos+length-1 are legitimate indexes
	 *             within this tree.
	 */
	public String get(int pos, int length) throws IndexOutOfBoundsException {
		if (pos < 0 || pos + length - 1 >= this.size()) {
			throw new IndexOutOfBoundsException();
		}
		String output = this.toString().substring(pos, pos + length);
		return output;
	}

	/**
	 * MILESTONE 3, MEDIUM - SEE THE PAPER REFERENCED IN THE SPEC FOR ALGORITHM!
	 * Append (in time proportional to the log of the size of the larger tree)
	 * the contents of the other tree to this one. Other should be made empty
	 * after this operation.
	 * 
	 * @param other
	 * @throws IllegalArgumentException
	 *             if this == other
	 */

	public void concatenate(EditTree other) throws IllegalArgumentException {
		this.concatenate(other, Node.NULL_NODE);

	}
	
	
	
	public void concatenate(EditTree other, Node q) throws IndexOutOfBoundsException {
		if (this == other) {
			throw new IllegalArgumentException();
		}
		//get the height for the tree
		int thisHeight = this.height();
		int otherHeight = other.height();
		//find T and U
		Node T = null;
		Node U = null;
		int HightofT = 0;
		int HightofU = 0;
		Boolean[] heightChange = { false };

		boolean top = thisHeight >= otherHeight;
		if (top) {
			T = this.root;
			U = other.root;
			HightofT = thisHeight;
			HightofU = otherHeight;
		} else {
			T = other.root;
			U = this.root;
			HightofT = otherHeight;
			HightofU = thisHeight;
		}
		//clean other
		other.root = Node.NULL_NODE;
		other.size = 0;
		//find q
		if (q == Node.NULL_NODE) {
			if (U == Node.NULL_NODE) {
				this.root = T;
				return;
			}
			Node[] temp = { null };
			U = U.delete((top ? 0 : Node.END), heightChange, temp, this.rotationalCount);
			HightofU -= heightChange[0] ? 1 : 0;
			q = temp[0];
		}

		// if s contain nothing
		if (U == Node.NULL_NODE) {
			this.root = T;
			this.add(q.element, top ? Node.END : 0);
			return;
		}
		heightChange[0] = false;
		// doing real paste
		T = T.pasteHB(U, HightofU, new Node(q.element), HightofT, top, this.rotationalCount, heightChange);
		this.root = T;


	}


	/**
	 * MILESTONE 3: DIFFICULT This operation must be done in time proportional
	 * to the height of this tree.
	 * 
	 * @param pos
	 *            where to split this tree
	 * @return a new tree containing all of the elements of this tree whose
	 *         positions are >= position. Their nodes are removed from this
	 *         tree.
	 * @throws IndexOutOfBoundsException
	 */
	public EditTree split(int pos) throws IndexOutOfBoundsException {

		EditTree t = new EditTree();
		this.root =this.root.split(t, pos).root;
		return t;
		
	}

	/**
	 * MILESTONE 3: JUST READ IT FOR USE OF SPLIT/CONCATENATE This method is
	 * provided for you, and should not need to be changed. If split() and
	 * concatenate() are O(log N) operations as required, delete should also be
	 * O(log N)
	 * 
	 * @param start
	 *            position of beginning of string to delete
	 * 
	 * @param length
	 *            length of string to delete
	 * @return an EditTree containing the deleted string
	 * @throws IndexOutOfBoundsException
	 *             unless both start and start+length-1 are in range for this
	 *             tree.
	 */
	public EditTree delete(int start, int length) throws IndexOutOfBoundsException {
		if (start < 0 || start + length >= this.size())
			throw new IndexOutOfBoundsException(
					(start < 0) ? "negative first argument to delete" : "delete range extends past end of string");
		EditTree t2 = this.split(start);
		EditTree t3 = t2.split(length);
		this.concatenate(t3);
		return t2;
	}

	/**
	 * MILESTONE 3 Don't worry if you can't do this one efficiently.
	 * 
	 * @param s
	 *            the string to look for
	 * @return the position in this tree of the first occurrence of s; -1 if s
	 *         does not occur
	 */
	public int find(String s) {
		String ToFind = this.toString();

		System.out.println(ToFind);
		for (int i = 0; i < ToFind.length() - s.length() + 1; i++) {
			int a = 0;
			for (int j = 0; j < s.length(); j++) {
				if (ToFind.charAt(i + j) == s.charAt(j)) {
					a++;

				}

			}
			if (a == s.length()) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * MILESTONE 3
	 * 
	 * @param s
	 *            the string to search for
	 * @param pos
	 *            the position in the tree to begin the search
	 * @return the position in this tree of the first occurrence of s that does
	 *         not occur before position pos; -1 if s does not occur
	 */
	public int find(String s, int pos) {
		String ToFind = this.toString();

		System.out.println(ToFind);
		for (int i = pos; i < ToFind.length() - s.length() + 1; i++) {
			int a = 0;
			for (int j = 0; j < s.length(); j++) {
				if (ToFind.charAt(i + j) == s.charAt(j)) {
					a++;

				}

			}
			if (a == s.length()) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * @return The root of this tree.
	 */
	public Node getRoot() {
		return this.root;
	}

}