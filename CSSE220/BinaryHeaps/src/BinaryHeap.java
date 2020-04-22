import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class BinaryHeap<T extends Comparable<T>> {
	private int size;
	private T[] data;
	private static final int DEFAULT_CAPACITY = 5;
	private Class<T> type;
	private Comparator<T> comparator;
	private Comparator<T> DEFAULT_COMPARATOR = new Comparator<T>() {

		public int compare(T o1, T o2) {
			return o1.compareTo(o2);
		}
	};
	
	private Comparator<T> REVERSE_COMPARATOR = new Comparator<T>() {

		public int compare(T o1, T o2) {
			return o2.compareTo(o1);
		}
	};

	public BinaryHeap(Class<T> type) {
		this.type = type;
		this.data = (T[]) Array.newInstance(type, DEFAULT_CAPACITY);
		this.comparator= DEFAULT_COMPARATOR;
	}

	public void sort(T[] array) {
		// dont lose the current data
		T[] temp = data;
		data = array;

		// Swap the smallest item in the array to position 0
		// so it is out of the way of the heap operations

		// TODO: change the array into a heap

		// TODO: change comparator to reverse, deletMin is deletMax
		comparator = REVERSE_COMPARATOR;
		

		for (int i = 0; i < data.length; i++) {
			T max = deleteMin();
			data[size] = max;
		}
		// TODO: Change back to a min-heap
		comparator = DEFAULT_COMPARATOR;
		data = temp;
	}

	public boolean insert(T value) {
//		TODO
//		will use things like comparator.compare(pos,pos/2)
		return true;
	}

	public T deleteMin() {
		return null;
	}
	
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOfRange(data,0,size+1));
	}
}
