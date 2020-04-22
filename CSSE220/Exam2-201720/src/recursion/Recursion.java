package recursion;

/**
 * 
 * These problems should ALL be solved recursively - not with the use of rarely
 * used library functions, for loops, or while loops.
 * 
 * You can use recursive helper functions if you choose.
 * 
 * YOU ONLY NEED TO SOLVE 3 OF THESE 4 RECURSION PROBLEMS.
 * 
 * Leave the problem you've decided not to solve blank, and leave a comment
 * saying you've decided to skip it.
 * 
 * @author Mike Hewner and Amanda Stouder, Created on 1/2017
 */

public class Recursion {
	/**
	 * Checks to see if the given string is written in alternating case. So, if
	 * the first character is lower case, the second character is upper case,
	 * the third is lower case, etc.
	 * 
	 * For example: "aBcD" returns true "AbCdE" returns true "abcd" returns
	 * false "aBCd" returns false "a" returns true "" returns true
	 *
	 * To check if a character is uppercase, do this:
	 *
	 * char c = 'q'; if (Character.isLowerCase(c)) { }
	 *
	 * @param input
	 *            Some string.
	 * 
	 * @return true if the has alternating case, false otherwise.
	 */
	public static boolean isAlternatingCase(String input) {
		if (input.length() < 2) {
			return true;
		}
		char first = input.charAt(0);
		char second = input.charAt(1);

		if (Character.isLowerCase(first) && Character.isUpperCase(second)) {
			return isAlternatingCase(input.substring(1));
		}
		if (Character.isLowerCase(second) && Character.isUpperCase(first)) {
			return isAlternatingCase(input.substring(1));
		}
		return false;
	}

	/**
	 * Given a string, reverses the characters in the string.
	 * 
	 * For example, reverseString("Stouder") returns "redoutS".
	 * 
	 * @param toReverse.
	 *            The string to reverse.
	 * @return The sum of the given number's digits.
	 */
	public static String reverseString(String toReverse) {
		return null;
	}

	/**
	 * Gets the average of the values in the given array.
	 * 
	 * For example, average([0.0, 15.0, 30.0]) returns 15.0.
	 * 
	 * For the case in which the given array has a length of zero, return
	 * Double.NaN (which stands for Not a Number. This will be returned
	 * automatically if you divide a double by a zero.
	 * 
	 * Note: You may prefer to add a helper method to this.
	 * 
	 * @param values
	 *            - The values to average
	 * @return The average of the given values.
	 */
	public static double average(double[] values) {
		return averageHelper(values,0)/values.length;
	}
	
	public static double averageHelper(double[] values, int index){
		if(index>=values.length){
			return 0;
		}
		
		return values[index]+averageHelper(values,index+1);
	}

	/**
	 * Returns true if a subset of the given array, always starting the subset
	 * from index 0, can total to the given target.
	 * 
	 * For example, canSumToValue([1,2,3,4,5,6], 3) returns true, because 1 + 2
	 * = 3
	 * 
	 * canSumToValue([1,2,3,4,5,6], 13) return false, because there is no way to
	 * find a subset from index 0 to n in which the sum of the items matches the
	 * given target value.
	 * 
	 * Note: You may prefer to add a helper method to this.
	 * 
	 * @param array
	 *            An array
	 * @param target
	 *            The target value for the sum of the subset
	 * @return true if a subset can be found that sums to the target, false
	 *         otherwise.
	 */
	public static boolean canSumToValue(int[] array, int target) {
		if (array.length == 0) {
			return false;
		}
		return sumHelper(array, target, 1, array[0]);
	}
	
	public static boolean sumHelper(int[] array, int target, int index, int curTotal){
		if (index == array.length) {
			return false;
		}
		if (curTotal == target) {
			return true;
		}
		return sumHelper(array, target, index+1, curTotal+array[index]);
	}
}
