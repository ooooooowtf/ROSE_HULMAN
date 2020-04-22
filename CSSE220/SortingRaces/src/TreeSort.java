import java.util.PriorityQueue;
import java.util.TreeSet;

public class TreeSort {
	private static TreeSet<Integer> tree = new TreeSet<Integer>();
	private static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

	public static void treeSort(Integer[] input) {
		for (int i = 0; i < input.length; i++) {
			Boolean add = tree.add(input[i]);
			if (!add) {
				queue.add(input[i]);
			}
		}
		for (int i = 0; i < input.length; i++) {
			if (queue.peek() != null && queue.peek().equals(tree.first())) {
				input[i] = queue.poll();
			} else {
				input[i] = tree.pollFirst();
			}
		}
	}
}