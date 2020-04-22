import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * A hash set implementation for Strings. Cannot insert null into the set. Other
 * requirements are given with each method.
 *
 * @author Matt Boutell and <<TODO: your name here >>>. Created Oct 6, 2014.
 */
public class StringHashSet {

	// The initial size of the internal array.
	private static final int DEFAULT_CAPACITY = 5;
	final Node NULL_NODE = new Node();
	private Node[] array;
	private int size;
	// You'll want fields for the size (number of elements) and the internal
	// array of Nodes. I also added one for the capacity (the length
	// of the internal array).

	private class Node {
		// TODO: Implement this class . These are just linked-list style
		// nodes, so you will need at least fields for the data and a reference
		// to the next node, plus a constructor. You can choose to use a
		// NULL_NODE at the end, or not. I chose not to do so this time.
		Node nextNode;
		Node previousNode;
		String data;

		public Node(Node previous, String element) {
			this.data = element;
			this.nextNode = NULL_NODE;
			this.previousNode = previous;
		}

		public Node(Node previous, String thing, Node next) {
			this.data = thing;
			this.nextNode = next;
			this.previousNode = previous;
		}

		public Node() {
			this.data = null;
			this.nextNode = NULL_NODE;
			this.previousNode = NULL_NODE;
		}

		public String toRawString() {
			if (this == NULL_NODE) {
				return "null";
			}
			return this.data + " " + this.nextNode.toRawString();
		}
		
		public boolean contains(String item){
			if(this == NULL_NODE){
				return false;
			}
			if(this.data != item){
				return nextNode.contains(item);
			}
			return true;
		}

		public void toString(ArrayList<String> list) {
			if (this == NULL_NODE) {
				return;
			}
			list.add(this.data);
			this.nextNode.toString(list);
		}
		
		public boolean remove(String item){
			if(item == null){
				throw new IllegalArgumentException();
			}
			if(this == NULL_NODE){
				return false;
			}
			if(this.data.equals(item)){
				this.previousNode.nextNode = this.nextNode;
				StringHashSet.this.size--;
				return true;
			}
			return this.nextNode.remove(item);
		}
	}

	/**
	 * Creates a Hash Set with the default capacity.
	 */
	public StringHashSet() {
		// Recall that using this as a method calls another constructor
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates a Hash Set with the given capacity.
	 */
	public StringHashSet(int initialCapacity) {
		initialize(initialCapacity);
	}

	private void initialize(int initialCapacity) {
		// TODO: Set the capacity to the given capacity, and initialize the
		// other fields.
		// Why did we pull this out into a separate method? Perhaps another
		// method needs to initialize the hash set as well? (Hint)
		this.array = new Node[initialCapacity];
		for (int i = 0; i < this.array.length; i++) {
			this.array[i] = NULL_NODE;
		}
		this.size = 0;
	}

	/**
	 * Calculates the hash code for Strings, using the x=31*x + y pattern.
	 * Follow the specification in the String.hashCode() method in the Java API.
	 * Note that the hashcode can overflow the max integer, so it can be
	 * negative. Later, in another method, you'll need to account for a negative
	 * hashcode by adding Integer.MAX_VALUE before you mod by the capacity
	 * (table size) to get the index.
	 *
	 * This method is NOT the place to calculate the index though.
	 *
	 * @param item
	 * @return The hash code for this String
	 */
	public static int stringHashCode(String item) {
		// TODO: Write this.
		return item.hashCode();
	}

	/**
	 * Adds a new node if it is not there already. If there is a collision, then
	 * add a new node to the -front- of the linked list.
	 * 
	 * Must operate in amortized O(1) time, assuming a good hashcode function.
	 *
	 * If the number of nodes in the hash table would be over double the
	 * capacity (that is, lambda > 2) as a result of adding this item, then
	 * first double the capacity and then rehash all the current items into the
	 * double-size table.
	 *
	 * @param item
	 * @return true if the item was successfully added (that is, if that hash
	 *         table was modified as a result of this call), false otherwise.
	 */
	public boolean add(String item) {
		// TODO: Write this
		if (this.contains(item)) {
			return false;
		}
		if (this.size >= 2 * this.array.length) {
			Node[] oldArray = this.array;
			int oldSize = this.size();
			this.initialize(2 * this.array.length);
			this.size = oldSize;
			for (int i = 0; i < oldArray.length; i++) {
				this.add(oldArray[i].data);
			}

		}
		int num = this.stringHashCode(item);
		if (num < 0) {
			num += Integer.MAX_VALUE;
		}
		int insertPlace = num % this.array.length;
		if (this.array[insertPlace] != NULL_NODE) {
			Node next = this.array[insertPlace];
			this.array[insertPlace] = new Node(NULL_NODE, item, next);
			next.previousNode = this.array[insertPlace];
		} else {
			this.array[insertPlace] = new Node(NULL_NODE, item);
		}
		this.size++;
		return true;
	}

	/**
	 * Prints an array value on each line. Each line will be an array index
	 * followed by a colon and a list of Node data values, ending in null. For
	 * example, inserting the strings in the testAddSmallCollisions example
	 * gives "0: shalom hola null 1 bonjour null 2 caio hello null 3 null 4 hi
	 * null". Use a StringBuilder, so you can build the string in O(n) time.
	 * (Repeatedly concatenating n strings onto a growing string gives O(n^2)
	 * time)
	 * 
	 * @return A slightly-formatted string, mostly used for debugging
	 */
	public String toRawString() {
		// TODO: Write this
		StringBuilder toReturn = new StringBuilder();
		for (int i = 0; i < this.array.length; i++) {
			toReturn.append(i);
			String eachLine = ": " + this.array[i].toRawString() + "\n";
			toReturn.append(eachLine);
		}
		return toReturn.toString();
	}

	/**
	 * 
	 * Checks if the given item is in the hash table.
	 * 
	 * Must operate in O(1) time, assuming a good hashcode function.
	 *
	 * @param item
	 * @return True if and only if the item is in the hash table.
	 */
	public boolean contains(String item) {
		// TODO: Write this
		int num = this.stringHashCode(item);
		if(num<0){
			num += Integer.MAX_VALUE;
		}
		return this.array[num % this.array.length].contains(item);
	}

	/**
	 * Returns the number of items added to the hash table. Must operate in O(1)
	 * time.
	 *
	 * @return The number of items in the hash table.
	 */
	public int size() {
		// TODO: Write this
		return this.size;
	}

	/**
	 * @return True iff the hash table contains no items.
	 */
	public boolean isEmpty() {
		// TODO: Write this
		for(Node node : this.array){
			if(node!=NULL_NODE){
				return false;
			}
		}
		return true;
	}

	/**
	 * Removes all the items from the hash table. Resets the capacity to the
	 * DEFAULT_CAPACITY
	 */
	public void clear() {
		// TODO: Write this. Should take 1 line if you read carefully above.
		this.initialize(DEFAULT_CAPACITY);
	}

	/**
	 * Removes the given item from the hash table if it is there. You do NOT
	 * need to resize down if the load factor decreases below the threshold.
	 * 
	 * @param item
	 * @return True If the item was in the hash table (or equivalently, if the
	 *         table changed as a result).
	 */
	public boolean remove(String item) {
		// TODO: Write this.
		if(this.contains(item)){
			int hash = this.stringHashCode(item);
			if(hash<0){
				hash += Integer.MAX_VALUE;
			}
			return this.array[hash%this.array.length].remove(item);
		}
		return false;
	}

	/**
	 * Adds all the items from the given collection to the hash table.
	 *
	 * @param collection
	 * @return True if the hash table is modified in any way.
	 */
	public boolean addAll(Collection<String> collection) {
		// TODO: Write this.
		for(String item : collection){
			if(this.contains(item)){
				return false;
			}
			this.add(item);
		}
		return true;
	}

	/**
	 * 
	 * Challenge Feature: Returns an iterator over the set. Return the items in
	 * any order that you can do efficiently. Should throw a
	 * NoSuchElementException if there are no more items and next() is called.
	 * Should throw a ConcurrentModificationException if next() is called and
	 * the set has been mutated since the iterator was created.
	 *
	 * @return an iterator.
	 */
	public Iterator<String> iterator() {
		return null;
	}

	// Challenge Feature: If you have an iterator, this is easy. Use a
	// StringBuilder, so you can build the string in O(n) time. (Repeatedly
	// concatenating n strings onto a string gives O(n^2) time)
	// Format it like any other Collection's toString (like [a, b, c])
	@Override
	public String toString() {
		return null;
	}
}
