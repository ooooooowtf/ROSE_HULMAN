import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 
 * Implementation of most of the Set interface operations using a Binary Search Tree
 *
 * @author Matt Boutell and <<< YOUR NAME HERE >>>.
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	private BinaryNode root;
	int time = 0;
	final BinaryNode NULL_NODE = new BinaryNode();

	// Most of you will prefer to use NULL NODES once you see how to use them.
	// private final BinaryNode NULL_NODE = new BinaryNode();

	public BinarySearchTree() {
		this.root = this.NULL_NODE; // NULL_NODE;
	}

	// For manual tests only
	void setRoot(BinaryNode n) {
		this.root = n;
	}
	
	public boolean containsNonBST(T val) {
		// TODO Auto-generated method stub.
		return this.root.containsNonBSTHelper(val);
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub.
		return this.root==this.NULL_NODE;
	}
	
	public int size(){
		// if doesnt have a root return 0
		if(this.root==null){
			return 0;
		}
		return this.root.sizeHelper();
	}
	
	public int height() {
		// TODO Auto-generated method stub.
		return this.root.heightHelper();
	}

	// Not private, since we need access for manual testing.
	class BinaryNode {
		T data;
		BinaryNode left;
		private BinaryNode right;
		
		
		public boolean containsNonBSTHelper(T val) {
			// TODO Auto-generated method stub.
			if(this==BinarySearchTree.this.NULL_NODE){
				return false;
			}
			if(this.data.equals(val)){
				return true;
			}
			return this.left.containsNonBSTHelper(val)||this.right.containsNonBSTHelper(val);
		}

		public BinaryNode() {
			this.data = null;
			this.left = null;
			this.right = null;
		}

		public BinaryNode(T element) {
			this.data = element;
			this.left = BinarySearchTree.this.NULL_NODE;
			this.right = BinarySearchTree.this.NULL_NODE;
		}

		public T getData() {
			return this.data;
		}

		public BinaryNode getLeft() {
			return this.left;
		}

		public BinaryNode getRight() {
			return this.right;
		}

		// For manual testing
		public void setLeft(BinaryNode left) {
			this.left = left;
		}
		
		public void setRight(BinaryNode right) {
			this.right = right;
		}
		
		public int sizeHelper(){
			if(this==BinarySearchTree.this.NULL_NODE){
				return 0;
			}
			//do recursion
			return 1+ this.left.sizeHelper()+this.right.sizeHelper();
		}
		
		public int heightHelper(){
			if(this==BinarySearchTree.this.NULL_NODE){
				return -1;
			}
			// return the max height of left/ right
			return 1+Math.max(this.left.heightHelper(), this.right.heightHelper());
		}
		
		public void toArrayList(ArrayList<T> list) {
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
		
		public BinaryNode insert(T item){
			if (this == BinarySearchTree.this.NULL_NODE) {
				return new BinaryNode(item);
			}
			if (this == null) {
				// throw exception
				throw new IllegalArgumentException();
			}
			//find the position to insert
			if (this.data.compareTo(item) > 0) {
				this.left = this.left.insert(item);
			} else if (this.data.compareTo(item) < 0) {
				this.right = this.right.insert(item);
			} 
			return this;
		}
		
		public boolean contains(T item) {
			if (this == BinarySearchTree.this.NULL_NODE) {
				return false;
			}
			if (this.data.equals(item)) {
				return true;
			} else if (this.data.compareTo(item) > 0) {
				return this.left.contains(item);
			} else if (this.data.compareTo(item) < 0) {
				return this.right.contains(item);
			}
			return false;
		}
		
		public BinaryNode remove(T item) {

			if (item == null) {
				throw new IllegalArgumentException();
			}
			if (this.data.equals(item)) {
				if (this.left == BinarySearchTree.this.NULL_NODE) {
					return this.right;
				}
				if (this.right == BinarySearchTree.this.NULL_NODE) {
					return this.left;
				}
				if (this.left.right == BinarySearchTree.this.NULL_NODE) {
					this.left.right = this.right;
					return this.left;
				}

				BinaryNode temp = this;
				BinaryNode tempLeft = this.left;
				while (tempLeft.right != BinarySearchTree.this.NULL_NODE) {
					temp = tempLeft;
					tempLeft = tempLeft.right;
				}
				temp.right = tempLeft.left;
				tempLeft.right = this.right;
				tempLeft.left = this.left;
				return tempLeft;
			}
			if (item.compareTo(this.data) < 0) {
				this.left = this.left.remove(item);
			} else if (item.compareTo(this.data) > 0) {
				this.right = this.right.remove(item);
			}
			return this;
		}
	}

	// TODO: Implement your 3 iterator classes here, plus any other inner helper classes you'd like. 
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub.
		return new iterator(this.root);
	}
	public Iterator<T> inefficientIterator() {
		// TODO Auto-generated method stub.
		return new ArrayListIterator();
	}
	public Iterator<T> preOrderIterator() {
		// TODO Auto-generated method stub.
		return new PreOrderIterator();
	}
	public class ArrayListIterator implements Iterator<T>{
		private ArrayList<T> list;
		private int index;
		int change = BinarySearchTree.this.time;
		
		public ArrayListIterator(){
			this.index = 0;
			this.list = toArrayList();
		
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub.
			return (this.index < this.list.size());
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub.
			if (!hasNext()) {
				throw new NoSuchElementException("Reached end of interation");
			}
			if (this.change != BinarySearchTree.this.time) {
				throw new ConcurrentModificationException();
			}
			return (this.list.get(this.index++));
		}
		
	}
	public class PreOrderIterator implements Iterator<T> {
		private Stack<BinaryNode> st;
		int change = BinarySearchTree.this.time;
		int count = 0;
		boolean next = false;
		T t;

		PreOrderIterator() {
			this.st = new Stack<>();
			if (BinarySearchTree.this.root != BinarySearchTree.this.NULL_NODE) {
				this.st.push(BinarySearchTree.this.root);
			}
		}

		@Override
		public boolean hasNext() {
			return !this.st.isEmpty();
		}

		@Override
		public T next() {
			this.count = 0;
			this.next = true;
			if (!hasNext()) {
				throw new NoSuchElementException("Reached end of interation");
			}
			if (this.change != BinarySearchTree.this.time) {
				throw new ConcurrentModificationException();
			}
			BinaryNode currentNode = this.st.pop();
			T result = currentNode.data;
			if (currentNode.right != BinarySearchTree.this.NULL_NODE) {
				this.st.push(currentNode.right);
			}
			if (currentNode.left != BinarySearchTree.this.NULL_NODE) {
				this.st.push(currentNode.left);
			}
			this.t = currentNode.data;
			return result;
		}

		@Override
		public void remove() {
			this.count++;
			if (this.count > 1) {
				throw new IllegalStateException();
			}
			if (this.next == false) {
				throw new IllegalStateException();
			}
			BinarySearchTree.this.remove(this.t);
		}

	}
	public class iterator implements Iterator<T> {


		private Stack<BinaryNode> st;
		int change = BinarySearchTree.this.time;
		boolean next = false;
		int count = 0;
		T t;

		public iterator(BinaryNode root) {
			this.st = new Stack<>();
			while (root != BinarySearchTree.this.NULL_NODE) {
				this.st.push(root);
				root = root.left;
			}
		}

		@Override
		public boolean hasNext() {
			return !this.st.isEmpty();
		}

		@Override
		public T next() {
			this.next = true;
			this.count = 0;
			if (this.change != BinarySearchTree.this.time) {
				throw new ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			BinaryNode temp = this.st.pop();
			T result = temp.data;
			if (temp.right != BinarySearchTree.this.NULL_NODE) {
				temp = temp.right;
				while (temp != BinarySearchTree.this.NULL_NODE) {
					this.st.push(temp);
					temp = temp.left;
				}
			}
			this.t = result;
			return result;
		}

		@Override
		public void remove() {
			this.count++;
			if (this.count > 1) {
				throw new IllegalStateException();
			}
			if (this.next == false) {
				throw new IllegalStateException();
			}
			BinarySearchTree.this.remove(this.t);
		}
	}

	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<>();
		
		this.root.toArrayList(list);
		return list;
	}
	
	@Override
	public String toString() {
		ArrayList<T> output = this.toArrayList();
		return output.toString();
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub.

		Object[] result = new Object[this.toArrayList().size()];
		for (int i = 0; i < this.toArrayList().size(); i++) {
			result[i] = this.toArrayList().get(i);
		}
		return result;
	}

	
	public boolean insert(T item) {
		// TODO Auto-generated method stub.
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (this.contains(item)) {
			return false;
		}
		this.time++;
		this.root = this.root.insert(item);
		return true;
	}

	public boolean contains(T item) {
		// TODO Auto-generated method stub.
		return this.root.contains(item);
	}
	public boolean remove(T item) {
		// TODO Auto-generated method stub.
		if (item == null) {
			throw new IllegalArgumentException();
		}
		if (!this.contains(item)) {
			return false;
		}
		this.root = this.root.remove(item);
		this.time++;
		return true;
	}

}
