package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Chain<T> {
	LinkedHashSet<T> chainItems;
	T last;

	public Chain() {
		this.chainItems = new LinkedHashSet<>();
	}

	public Chain(LinkedHashSet<T> newchain, T last) {
		this.chainItems = newchain;
		this.last = last;
	}
	
	public Chain<T> addLast(T item) {
		if (this.chainItems.contains(item)) {
			return this;
		}
		LinkedHashSet<T> newChain = (LinkedHashSet<T>) this.chainItems.clone();
		newChain.add(item);
		return new Chain<>(newChain,item);
	}

	public T getLast() {
		return last;
	}
	
	public boolean contains(T string) {
		return this.chainItems.contains(string);
	}
	
	public Iterator<T> iterator() {
		return this.chainItems.iterator();
	}
	
	public List<T> toList(){
		ArrayList<T> toReturn = new ArrayList<>();
		Iterator<T> iter = this.iterator();
		while (iter.hasNext()) {
			toReturn.add(iter.next());
		}
		return toReturn;
	}

}
