package isleafbalanced;

public class BinarySearchTree {
	BinaryNode root;
	// The -17 is arbitrary, shouldn't refer to it in code.
	final BinaryNode NULL_NODE = new BinaryNode(-17); 

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	public boolean isLeafBalanced() {
		// TODO: write me. See the paper for details
		Helper h = new Helper();
		this.root.isLeafBa(h);
		return h.bo;
	}
	
	public class Helper{
		boolean bo;
		
		public Helper(){
			bo = true;
		}
	}
	///////////////// BinaryNode
	public class BinaryNode {
		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		// The rest of the methods are used by the unit tests and for debugging
		public BinaryNode(Integer element) {
			this.data = element;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public int isLeafBa(Helper h) {
			// TODO Auto-generated method stub.
			int lLeaf = 0;
			int rLeaf = 0;
			if(this==NULL_NODE){
				return 0;
			}
			if(this.left==NULL_NODE&&this.right==NULL_NODE){
				return 1;
			}
			
			if(this.left != NULL_NODE){
				lLeaf += this.left.isLeafBa(h);
			}
			if(this.right != NULL_NODE){
				rLeaf += this.right.isLeafBa(h);
			}
			
			if(Math.abs(lLeaf-rLeaf)>1){
				h.bo = false;
			}
			
			return lLeaf+rLeaf;
		}

		public BinaryNode(Integer element, BinaryNode left, BinaryNode right) {
			this(element);
			this.left = left;
			this.right = right;
		}

		public BinaryNode insert(Integer e) {
			if (this == NULL_NODE) {
				return new BinaryNode(e);
			} else if (e < data) {
				left = left.insert(e);
			} else if (e > data) {
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
			return left.toString() + this.data + right.toString();
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
}