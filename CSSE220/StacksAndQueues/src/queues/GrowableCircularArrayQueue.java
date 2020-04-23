package queues;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * A circular queue that grows as needed.
 * 
 * @author Matt Boutell and <<<your name here>>>
 * @param <T>
 */
public class GrowableCircularArrayQueue<T> implements SimpleQueue<T>{
	// TODO: Declare this class to implement SimpleQueue<T>, then add the
	// missing methods (Eclipse will help).
	// TODO: The javadoc for overridden methods is in the SimpleQueue interface.
	// Read it!
	
	public static void main(String[] args){
		GrowableCircularArrayQueue<Integer> myArr = new GrowableCircularArrayQueue<Integer>(Integer.class);
		
		
	}

	private static final int INITIAL_CAPACITY = 5;

	private T[] array;
	private Class<T> type;
	private int front;
	private int rear;
	private int numItems;

	/**
	 * Creates an empty queue with an initial capacity of 5
	 * 
	 * @param type
	 *            So that an array of this type can be constructed.
	 */
	@SuppressWarnings("unchecked")
	public GrowableCircularArrayQueue(Class<T> type) {
		this.type = type;
		// This is a workaround due to a limitation Java has with
		// constructing generic arrays.
		this.array = (T[]) Array.newInstance(this.type, INITIAL_CAPACITY);
		this.front = 0;
		this.rear = 0;
		this.numItems = 0;
	}

	/**
	 * Displays the contents of the queue in insertion order, with the
	 * most-recently inserted one last, in other words, not wrapped around. Each
	 * adjacent pair will be separated by a comma and a space, and the whole
	 * contents will be bounded by square brackets. See the unit tests for
	 * examples.
	 */
	@Override
	public String toString() {
		// TODO: implement this method
		if(this.numItems == 0){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		for(int i = 0; i < this.numItems -1; i++){
			sb.append(this.array[(i+ this.front) % this.array.length] + ", ");
		}
		System.out.println("Rear: " + Integer.toString(this.rear -1));
		int index;
		if(this.rear -1 < 0){
			index = this.array.length -1;
		} else {
			index = this.rear -1;
		}
		sb.append(this.array[index]);
		sb.append("]");
		return sb.toString();
	}
	
	public void resize(){
		
		T[] original = this.array;
		
		this.array = (T[]) Array.newInstance(this.type, original.length * 2);
		
		for(int i = 0; i < this.numItems; i++){
			this.array[i] = original[(i + this.front) % original.length];
		}
		this.front = 0;
		this.rear = this.numItems;
		
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub.
		
		this.array[0] = null;
		this.front = 0;
		this.rear = 0;
		this.numItems = 0;
	}

	@Override
	public void enqueue(T item) {
		
		if(this.numItems >= this.array.length){
			this.resize();
			//Now front =0
		}
		
		this.array[rear] = item;
		this.rear = (this.rear+1) % this.array.length;
		this.numItems++;
		// TODO Auto-generated method stub.
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub.
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		
		T val = this.array[this.front];
		this.array[this.front] = null;
		this.front = (this.front + 1) % this.array.length;
		this.numItems--;
		return val;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if(this.isEmpty()){
			throw new NoSuchElementException();
		}
		// TODO Auto-generated method stub.
		return this.array[this.front];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub.
		return this.numItems == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub.
		return this.numItems;
	}

	@Override
	public boolean contains(T item) {
		int current = this.front;
		while(current != this.rear){
			if(this.array[current].equals(item))
				return true;
			
			current = (current + 1) % this.array.length;
		}
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public String debugString() {
		// TODO Auto-generated method stub.
		return null;
	}

}