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
 * @author Mike Hewner and Matt Boutell, Created on 10/2016
 */

public class Recursion {
	/**
	 * Checks to see if the given string is in the format of a bunch of x's,
	 * followed by twice that many y's. For example, xxxyyyyyy would return
	 * true, while xaxyyyy would return false.
	 * 
	 * @param input
	 *            Some string.
	 * 
	 * @return true if the string is n 'x' characters, followed by 2*n y
	 *         characters
	 */
	public static boolean isXDoubleY(String input) {
		if (input.isEmpty()) {
			return true;
		}
		if (!(input.substring(0, 1).equals("x"))) {
			return false;
		}
		if (!(input.substring(input.length() - 2).equals("yy"))) {
			return false;
		}
		return isXDoubleY(input.substring(1, input.length() - 2));
	}

	/**
	 * Given a number, return the sum of its digits
	 * 
	 * @param number.
	 *            An arbitrary positive integer.
	 * @return The sum of the given number's digits.
	 */
	public static int digitSum(int number) {
		if (number == 0) {
			return 0;
		}
		return number % 10 + digitSum(number / 10);
	}

	/**
	 * Forms a new string by inserting letters of the first string after letters
	 * of the second string, one character at a time. If the first string is shorter than the second string, 
	 * it will restart at the beginning of the first string. 
	 * 
	 * For example, for strings "ab" and "xxxxxx", it returns "xaxbxaxbxaxb" 
	 * 
	 * Note: You may prefer to add a helper method to this.
	 * @param first A string to intersperse, assumed to be of equal or shorter length than the second string.
	 * @param second The original string.
	 * @return The interspersed string, as described above.
	 */
	public static String intersperse(String first, String second) {
		return intersperseHelper(first, second, 0);
	}

	private static String intersperseHelper(String first, String second, int pos) {
		if (pos >= second.length()) {
			return "";
		}

		return "" + second.charAt(pos) + first.charAt(pos % first.length()) + intersperseHelper(first, second, pos + 1);
	}

	/**
	 * Returns a new array in which each element is found by subtracting the
	 * corresponding elements of the given two arrays.
	 * 
	 * For example, subtract([7,6,5], [2,3,4]) would return the array, [5,3,1].
	 * 
	 * You may assume that the two given arrays have the same length.
	 * 
	 * Note: You may prefer to add a helper method to this.
	 * 
	 * @param first
	 *            An array
	 * @param second
	 *            An array to subtract from the first array.
	 * @return An array formed by subtracting first - second.
	 */
	public static int[] subtract(int[] first, int[] second) {
		int[] difference = new int[first.length];
		subtractHelper(difference, first, second, 0);
		return difference;
	}

	private static void subtractHelper(int[] difference, int[] first, int[] second, int pos) {
		if (pos < first.length) {
			difference[pos] = first[pos] - second[pos];
			subtractHelper(difference, first, second, pos + 1);
		}
	}
}
