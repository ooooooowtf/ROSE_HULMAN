
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This program runs various sorts and gathers timing information on them.
 *
 * @author <<YOUR NAMES HERE>> Created May 7, 2013.
 */
public class SortRunner {
	private static Random rand = new Random(17); // uses a fixed seed for
													// debugging. Remove the
													// parameter later.

	/**
	 * Starts here.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// array size must be an int. You will need to use something much larger
		int size = 1000000;

		// Each integer will have the range from [0, maxValue). If this is
		// significantly higher than size, you
		// will have small likelihood of getting duplicates.
		int maxValue = Integer.MAX_VALUE;

		// Test 1: Array of random values.
		System.out.println("Random");
		int[] randomIntArray = getRandomIntArray(size, maxValue);
		runAllSortsForOneArray(randomIntArray);

		// TODO: Tests 2-4
		// Generate the three other types of arrays (shuffled, almost sorted,
		// almost reverse sorted)
		// and run the sorts on those as well.
		System.out.println("shuffled");
		int[] shuffledArray = getUniqueElementArray(size);
		runAllSortsForOneArray(shuffledArray);
		System.out.println("almostSorted");
		int[] almostSortedIntArray = getAlmostSortedArray(size, maxValue);
		runAllSortsForOneArray(almostSortedIntArray);
		System.out.println("almostReversedSorted");
		int[] almostReverseSortedArray = getAlmostReverseSortedArray(size, maxValue);
		runAllSortsForOneArray(almostReverseSortedArray);
	}

	

	/**
	 * 
	 * Runs all the specified sorts on the given array and outputs timing
	 * results on each.
	 *
	 * @param array
	 */
	private static void runAllSortsForOneArray(int[] array) {
		long startTime, elapsedTime;
		boolean isSorted = false;

		// TODO: Read this.
		// We prepare the arrays. This can take as long as needed to shuffle
		// items, convert
		// back and forth from ints to Integers and vice-versa, since you aren't
		// timing this
		// part. You are just timing the sort itself.

		int[] sortedIntsUsingDefaultSort = array.clone();
		Integer[] sortedIntegersUsingDefaultSort = copyToIntegerArray(array);
		Integer[] sortedIntegersUsingHeapSort = sortedIntegersUsingDefaultSort.clone();
		Integer[] sortedIntegersUsingTreeSort = sortedIntegersUsingDefaultSort.clone();
		// No skiplist this term. Integer[] sortedIntegersUsingSkipListSort =
		// sortedIntegersUsingDefaultSort.clone();
		int[] sortedIntsUsingQuickSort = array.clone();

		int size = array.length;

		// What is the default sort for ints? Read the javadoc.
		startTime = System.currentTimeMillis();
		Arrays.sort(sortedIntsUsingDefaultSort);
		elapsedTime = (System.currentTimeMillis() - startTime);
		isSorted = verifySort(sortedIntsUsingDefaultSort);
		displayResults("int", "the default sort", elapsedTime, size, isSorted);

		// What is the default sort for Integers (which are objects that wrap
		// ints)?
		startTime = System.currentTimeMillis();
		Arrays.sort(sortedIntegersUsingDefaultSort);
		elapsedTime = (System.currentTimeMillis() - startTime);
		isSorted = verifySort(sortedIntegersUsingDefaultSort);
		displayResults("Integer", "the default sort", elapsedTime, size, isSorted);

		// Sort using the following methods, and time and verify each like done
		// above.
		// TODO: a simple sort that uses a TreeSet but handles a few duplicates
		// gracefully.
//		startTime = System.currentTimeMillis();
//		QuickSort.quickSort(sortedIntsUsingQuickSort, 0, sortedIntsUsingQuickSort.length - 1);
//		elapsedTime = (System.currentTimeMillis() - startTime);
//		isSorted = verifySort(sortedIntsUsingQuickSort);
//		displayResults("int", "the quick sort", elapsedTime, size, isSorted);
		// TODO: your implementation of quick sort. I suggest putting this in a
		// static method in a Quicksort class.
		startTime = System.currentTimeMillis();
		QuickSort.quickSort(sortedIntsUsingQuickSort, 0, sortedIntsUsingQuickSort.length - 1);
		elapsedTime = (System.currentTimeMillis() - startTime);
		isSorted = verifySort(sortedIntsUsingQuickSort);
		displayResults("int", "the quick sort", elapsedTime, size, isSorted);
		
		// TODO: your BinaryHeap sort. You can put this sort in a static method
		// in another class.

		startTime = System.currentTimeMillis();
		HeapSort.sort(sortedIntegersUsingHeapSort);
		elapsedTime = (System.currentTimeMillis() - startTime);
		isSorted = verifySort(sortedIntegersUsingHeapSort);
		displayResults("int", "the heapsort", elapsedTime, size, isSorted);

	}

	private static void displayResults(String typeName, String sortName, long elapsedTime, int size, boolean isSorted) {
		if (isSorted) {
			System.out.printf("Sorted %.1e %ss using %s in %d milliseconds\n", (double) size, typeName, sortName,
					elapsedTime);
		} else {
			System.out.println("ARRAY NOT SORTED");
		}
	}

	/**
	 * Checks in O(n) time if this array is sorted.
	 *
	 * @param a
	 *            An array to check to see if it is sorted.
	 */
	private static boolean verifySort(int[] a) {
		// TODO: implement this.
		int last = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < last) {
				return false;
			}
			last = a[i];
		}
		return true;
	}

	/**
	 * Checks in O(n) time if this array is sorted.
	 *
	 * @param a
	 *            An array to check to see if it is sorted.
	 */
	private static boolean verifySort(Integer[] a) {
		// TODO: implement this.
		Integer last = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < last) {
				return false;
			}
			last = a[i];
		}
		return true;
	}

	/**
	 * Copies from an int array to an Integer array.
	 *
	 * @param randomIntArray
	 * @return A clone of the primitive int array, but with Integer objects.
	 */
	private static Integer[] copyToIntegerArray(int[] ints) {
		Integer[] integers = new Integer[ints.length];
		for (int i = 0; i < ints.length; i++) {
			integers[i] = ints[i];
		}
		return integers;
	}

	/**
	 * Creates and returns an array of random ints of the given size.
	 *
	 * @return An array of random ints.
	 */
	private static int[] getRandomIntArray(int size, int maxValue) {
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = rand.nextInt(maxValue);
		}
		return a;
	}

	/**
	 * Creates a shuffled random array.
	 *
	 * @param size
	 * @return An array of the ints from 0 to size-1, all shuffled
	 */
	private static int[] getUniqueElementArray(int size) {
		// TODO: implement and call this method.
		List<Integer> unShuffled = new ArrayList<Integer>();
		int[] shuFfled = new int[size];
		for (int i = 0; i < size; i++) {
			unShuffled.add(i);
		}
		Collections.shuffle(unShuffled);
		for (int k = 0; k < size; k++) {
			shuFfled[k] = unShuffled.get(k);
		}
		return shuFfled;
	}
	
	private static int[] getAlmostSortedArray(int size, int maxValue) {

		// TODO Auto-generated method stub.
		int[] result = getRandomIntArray(size, maxValue);
		Arrays.sort(result);
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			int a = r.nextInt(size);
			int b = r.nextInt(size);
			int temp = result[a];
			result[a] = result[b];
			result[b] = temp;
		}
		return result;
	}

	private static int[] getAlmostReverseSortedArray(int size, int maxValue) {
		// TODO Auto-generated method stub.
		int[] input = getAlmostSortedArray(size,maxValue);
		int[] output = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			output[(size - i - 1)] = input[i];
		}
		return output;
	}

}