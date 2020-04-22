package search;

public class EfficientSearch {
	public static int search(int[] sortedArray, int searchTerm) {
		// TODO You recognize this starting code as a SEQUENTIAL (one at a time, in-order) search. 
		// It runs in O(n) worst-case time.
		// So if there are 1,000,000 items in the array, it will have to make that many comparisons in the worst case.
		// 
		// Since the array is sorted, 
		// replace it with the much-more efficient BINARY search, which runs in O(log n) worst case time. 
		// If there are 1,000,000 items in the array, it will only have to make ~20 comparisons.
		//
		// You can look up binary search algorithm from the CSSE220 materials
		// or here: https://en.wikipedia.org/wiki/Binary_search_algorithm#Procedure
		final int n = sortedArray.length;
		return searchHelper(sortedArray, searchTerm, 0, n);
	}
	
	public static int searchHelper(int[] sortedArray, int searchTerm, int low, int high){
		
		if (low >= high) {
			return -1;
		}
		int halfSize = (high - low) / 2;
		int middle = sortedArray[low + halfSize];
		
		if (searchTerm == middle) {
			return low + halfSize;
		} else if (searchTerm < middle) {
			// search lower half
			return searchHelper(sortedArray, searchTerm, low, low + halfSize);
		} else {
			// search upper half
			return searchHelper(sortedArray, searchTerm, low + halfSize + 1, high);
		}
	}
}
