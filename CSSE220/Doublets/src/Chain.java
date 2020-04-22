import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Chain {
	private HashSet<String> chainItems;

	public Chain() {
		this.chainItems = new LinkedHashSet<>();

	}

	public Chain addLast(String string) {
		Chain output = new Chain();
		output.chainItems.addAll(this.chainItems);
		output.chainItems.add(string);
		return output;
	}

	public String getLast() {
		return (String) this.chainItems.toArray()[chainItems.size() - 1];
	}

	public int length() {
		return this.chainItems.size();
	}

	public boolean contains(String string) {
		return this.chainItems.contains(string);
	}

	public Iterator<String> iterator() {
		return this.chainItems.iterator();
	}

	public String toString() {
		return this.chainItems.toString();
	}
}
