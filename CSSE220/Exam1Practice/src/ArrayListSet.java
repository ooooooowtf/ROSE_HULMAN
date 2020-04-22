import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * An implementation of the SimpleSet interface that uses an ArrayList. The
 * items are stored in no particular order.
 * 
 * @author <<<Your name here>>>. Created Sep 28, 2013.
 * @param <E>
 *            Generic type.
 */
public class ArrayListSet<E extends Comparable<E>> implements SimpleSet<E> {
	// You many add no other instance variables.
	private ArrayList<E> items;

	// TODO: Reference SimpleSet documentation for javadoc for these methods.

	/**
	 * Creates an empty array list.
	 */
	public ArrayListSet() {
		// TODO: Implement constructor
		this.items = new ArrayList<E>();
	}

	@Override
	public boolean add(E element) {
		// TODO: implement
		// You may store the elements in whatever order you choose.
		// Efficiency doesn't matter except for addAll().
		if (this.items.contains(element)) {
			return false;
		}
		this.items.add(element);
		return true;
	}

	@Override
	public void addAll(SimpleSet<E> otherSet) {
		// TODO: implement
		
		for (E element : otherSet.toArray()) {
			this.items.add(element); 
		}
		Collections.sort(this.items); // O(n log n)
		ArrayList<E> noDups = new ArrayList<E>();
		noDups.add(this.items.get(0));
		for (int i = 1; i < this.items.size(); i++) {
			// Don't add if it's already been added. Only need to check
			// last once since they are sorted.
			E toAdd = this.items.get(i);
			if (!noDups.get(noDups.size() - 1).equals(toAdd)) {
				noDups.add(toAdd);
			}
		} // loop is O(n), since each just compares to 1
		this.items = noDups;
	}

	

	@Override
	public void clear() {
		// TODO: implement
		this.items.clear();
	}

	@Override
	public boolean contains(E element) {
		// TODO: implement
		return this.items.contains(element);
	}

	@Override
	public boolean containsAll(SimpleSet<E> other) {
		// TODO: implement
		for (E c : other) {
			if (!this.items.contains(c)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object o) {
		// Ensure that you are comparing with another
		if (!(o instanceof ArrayListSet)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		SimpleSet<E> other = (SimpleSet<E>) o;
		// TODO: complete this. Hint: if you rely on another method you wrote,
		// this will only take a single line.

		return this.containsAll(other) && other.containsAll(this);
	}

	@Override
	public boolean isEmpty() {
		// TODO: implement
		return this.items.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: implement
		return this.items.iterator();
	}

	@Override
	public boolean remove(E element) {
		// TODO: implement
		return this.items.remove(element);
	}

	@Override
	public int size() {
		// TODO: implement
		return this.items.size();
	}

	@Override
	public E[] toArray() {
		// I'm giving you part of this,
		// so you won't have to look back at the written assignment
		int size = this.items.size();

		// Uses reflection, as shown in WA2, #3 (generic max/min). Assumes this
		// array isn't empty.
		@SuppressWarnings("unchecked")
		E[] result = (E[]) Array.newInstance(this.items.get(0).getClass(), size);
		// TODO: fill the array.
		for (int i = 0; i < size; i++) {
			result[i] = this.items.get(i);
			}
		return result;
	}

	@Override
	public String toString() {
		// TODO: implement
		String s = this.items.toString();
		s = s.replace('[', '{');
		s = s.replace(']', '}');
		return s;
	}
}
