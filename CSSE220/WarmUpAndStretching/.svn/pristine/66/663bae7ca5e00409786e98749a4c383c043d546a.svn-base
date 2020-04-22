package anagram;

/**
 * This utility class can test whether two strings are anagrams.
 *
 * @author Claude Anderson.
 */
public class Anagram {

	/**
	 * We say that two strings are anagrams if one can be transformed into the
	 * other by permuting the characters (and ignoring case).
	 * 
	 * For example, "Data Structure" and "Saturated Curt" are anagrams,
	 * as are "Elvis" and "Lives".
	 * 
	 * @param s1
	 *            first string
	 * @param s2
	 *            second string
	 * @return true iff s1 is an anagram of s2
	 */
	public static boolean isAnagram(String s1, String s2) {
		// TODO: implement this method
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		if(s2.length()!=s1.length()){
			return false;
		}
		for(int i=0; i<s1.length();i++){
			if(s2.contains(s1.subSequence(i, i+1))==false){
				return false;
			}
		}
		return true;
	}
}
