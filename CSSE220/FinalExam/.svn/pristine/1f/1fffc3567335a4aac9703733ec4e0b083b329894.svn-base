package tree;

/**
 * An implementation of a binary search tree, containing Integer data.
 * 
 * @author <<TODO: your name here >>>.
 *
 */

public class BinarySearchTree {

	BinaryNode root;

	public final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}
	
	public int countExactlyBalancedNodes() {
		// TODO: Write this method!
		return this.root.countE().sum;
	}
	
	public class Sum{
		int sum;
		int height;
		
		public Sum(int sum, int height){
			this.sum = sum;
			this.height=height;
		}
	}
	
	// The next methods are used by the unit tests
	public void insert(Integer e) {
		root = root.insert(e);
	}

	@Override
	public String toString() {
		return root.toString();
	}

	// /////////////// BinaryNode
	class BinaryNode {
		
		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Integer data) {
			this.data = data;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}


		public Sum countE() {
			// TODO Auto-generated method stub.
			if (this.left == NULL_NODE&& this.right==NULL_NODE) {
				return new Sum(1, 0);
			}
			if (this == NULL_NODE) {
				return new Sum(0, -1);
			}
			Sum leftS = left.countE();
			Sum rightS = right.countE();
			int sum;
			if(leftS.height==rightS.height){
				sum = leftS.sum+rightS.sum+1;
			}else{
				sum = leftS.sum+rightS.sum;
			}
			int height = Math.max(leftS.height, rightS.height)+1;
			
			return new Sum(sum,height);
		}


		// The next 2 methods are used by the unit tests
		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e.compareTo(this.data) < 0) {
				left = left.insert(e);
			} else if (e.compareTo(this.data) > 0) {
				right = right.insert(e);
			} else {
				// do nothing
			}
			return this;
		}

		@Override
		public String toString() {
			if (this == NULL_NODE) {
				return "";
			}
			return left.toString() + this.data.toString() + right.toString();
		}
	}

}