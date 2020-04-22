package averagenodevalue;

/**
 * @author You!
 * @param <T>
 */
public class BinarySearchTree {

	BinaryNode root;

	private final BinaryNode NULL_NODE = new BinaryNode(null);

	public BinarySearchTree() {
		root = NULL_NODE;
	}

	/**
	 * Finds the average numeric value of every node in this tree.
	 * For example, a tree with root = 10 and children = 5 and 20 would return 
	 * (10+5+20)/3 = 11.666666. 
	 * 
	 * See spec for hints and efficiency requirements.
	 * 
	 * @return The average value of the nodes in this tree.
	 */
	public double averageValue() {
		// TODO: Write me
		if(this.root==NULL_NODE){
			return 0;
		}
		return (double) this.root.getAvg().total/this.root.getAvg().sum;
	}
	
	public class Avg {
		public int total;
		public int sum;

		public Avg(int total, int sum) {
			this.total = total;
			this.sum = sum;
		}
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
		return root.toIndentString("");
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
	public class BinaryNode {

		public Integer data;
		public BinaryNode left;
		public BinaryNode right;

		public BinaryNode(Integer data) {
			this.data = data;
			this.left = NULL_NODE;
			this.right = NULL_NODE;
		}

		public Avg getAvg() {
			// TODO Auto-generated method stub.
			if (this == NULL_NODE) {
				return new Avg(0, 0);
			}
			Avg leftS = left.getAvg();
			Avg rightS = right.getAvg();
			int total = leftS.total+rightS.total+this.data;
			int sum = leftS.sum+rightS.sum+1;
			return new Avg(total,sum);
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
			return left.toString() + this.data.toString() + right.toString();
		}

		public String toIndentString(String indent) {
			if (this == NULL_NODE) {
				return indent + "NULL\n";
			}

			String myInfo = indent + String.format("%c\n", this.data);

			return myInfo + this.left.toIndentString(indent + "  ") + this.right.toIndentString(indent + "  ");
		}
	}
}