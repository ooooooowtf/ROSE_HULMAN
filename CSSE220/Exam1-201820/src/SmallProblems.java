import java.util.ArrayList;

public class SmallProblems {

	/**
	 * Rotates the values in a character array left by the given number of
	 * positions, n, and saves it in a string. The first n characters are moved
	 * to the end of the string. Therefore, when done, the string has the same
	 * length as the given array.
	 * 
	 * For example, rotate(['a', 'b', 'c', 'd'], 1) gives "bcda" rotate(['a',
	 * 'b', 'c', 'd'], 3) gives "dabc" rotate(['h', 'e', 'l', 'l', 'o'], 2)
	 * gives "llohe"
	 * 
	 * 
	 * You can assume that n is non-negative and less than the size of the
	 * array.
	 */
	public static String rotateIntoString(char[] array, int n) {
		String output = "";
		for (int i = 0; i < array.length; i++) {
			output = output + array[(i + n) % array.length];
		}
		return output;
	}

	/**
	 * Given a value n, generates an array list containing a sequence of numbers
	 * that follow these rules: If a value v is even, the next value will be
	 * half as big. If a value v is odd, the next value will be one bigger. If
	 * the value v is 1, then stop.
	 * 
	 * Examples: generate(5) --> [5,6,3,4,2,1] generate(8) --> [8,4,2,1]
	 * generate(50) --> [50, 25, 26, 13, 14, 7, 8, 4, 2, 1]
	 * 
	 * @param n
	 * @return The specified list of numbers
	 */

	public static ArrayList<Integer> generate(int n) {
		ArrayList<Integer> output = new ArrayList<>();
		int addn = n;
		output.add(addn);
		while (true) {
			if (addn % 2 == 1 && addn != 1) {
				addn = addn + 1;
				output.add(addn);
			}
			if (addn == 1) {
				return output;
			}
			if (addn % 2 == 0) {
				addn = addn / 2;
				output.add(addn);
			}
		}

	}
}
