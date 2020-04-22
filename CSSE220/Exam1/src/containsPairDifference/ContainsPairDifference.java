package containsPairDifference;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsPairDifference<T extends Comparable<T>> {

	public static boolean containsPairDifferenceLinearTime(int[] array, int diff) {
		// TODO: write this
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<array.length;i++){
			int current = array[i];
			if(set.contains(current+diff)||set.contains(current-diff)){
				return true;
			}
			set.add(current);
		}
		return false;
	}

	public static boolean containsPairDifferenceArrayOnly(int[] array, int diff) {
		// TODO: write this
		
		//array has been sorted
		Arrays.sort(array);
		for(int i=0;i<array.length;i++){
			int target=array[i]+diff;
			int targetIndex=Arrays.binarySearch(array, target);
			if(targetIndex>=0 && targetIndex!=i){
				return true;
			}
		}
		return false;
//		mergeSort(array);
//		
//		for (int i = 0; i < array.length-1; i++) {
//			for (int j = i+1; j < array.length; j++) {
//				if (array[j] - array[i] == diff) {
//					return true;
//				}
//			}
//		}
//
//		return false;

	}

	public static void mergeSort(int[] array) {
		final int n = array.length;
		if (n <= 1)
			return;

	
		int[] lower = new int[n / 2];
		int[] upper = new int[n - (n / 2)];
		int arrayIndex = 0;
		for (int i = 0; i < lower.length; i++) {
			lower[i] = array[arrayIndex];
			arrayIndex++;
		}
		for (int i = 0; i < upper.length; i++) {
			upper[i] = array[arrayIndex];
			arrayIndex++;
		}

		
		mergeSort(lower);
		mergeSort(upper);

	
		int lowerIndex = 0;
		int upperIndex = 0;
		arrayIndex = 0;
		while (lowerIndex < lower.length && upperIndex < upper.length) {
			if (lower[lowerIndex] <= (upper[upperIndex])) {
				array[arrayIndex] = lower[lowerIndex];
				arrayIndex++;
				lowerIndex++;
			} else {
				array[arrayIndex] = upper[upperIndex];
				arrayIndex++;
				upperIndex++;
			}
		}
		
		for (int i = lowerIndex; i < lower.length; i++) {
			array[arrayIndex] = lower[i];
			arrayIndex++;
		}
		for (int i = upperIndex; i < upper.length; i++) {
			array[arrayIndex] = upper[i];
			arrayIndex++;
		}
	}
}
