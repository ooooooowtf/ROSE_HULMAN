package recursion;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Use the test functions in this file to test the methods of the Recursion class.
 * You should not modify the tests in this file. This means that only one
 * set of test function is expected to fail, i.e., the set of tests for the 
 * method you did not implement.
 * 
 * @author Matt Boutell and Mike Hewner, Created on 10/2016
 */
public class RecursionTest {
	
	@Test
	/**
	 * Unit tests for {@link Recursion.isXDoubleY}
	 */
	public void testIsXDoubleY(){		
		assertTrue(Recursion.isXDoubleY(""));
		assertTrue(Recursion.isXDoubleY("xyy"));
		assertTrue(Recursion.isXDoubleY("xxyyyy"));
		assertTrue(Recursion.isXDoubleY("xxxxxyyyyyyyyyy"));
		assertFalse(Recursion.isXDoubleY("xy"));
		assertFalse(Recursion.isXDoubleY("xyyy"));
		assertFalse(Recursion.isXDoubleY("xxy"));
		assertFalse(Recursion.isXDoubleY("xaxyyyy"));
		assertFalse(Recursion.isXDoubleY("xx yyyy"));
		assertFalse(Recursion.isXDoubleY("yyx"));
	}
	
	@Test
	/**
	 * Unit tests for {@link Recursion.digitSum}
	 */
	public void testDigitSum(){		
		assertEquals(7, Recursion.digitSum(34));
		assertEquals(5, Recursion.digitSum(5));
		assertEquals(26, Recursion.digitSum(5849));
		assertEquals(22, Recursion.digitSum(16384));
		assertEquals(26, Recursion.digitSum(32768));
		assertEquals(25, Recursion.digitSum(65536));
		assertEquals(0, Recursion.digitSum(0));
	}
	
	/**
	 * Unit tests for {@link Recursion.intersperse}
	 */
	@Test
	public void testIntersperseSameLength(){
		assertEquals("xfxixrxe", Recursion.intersperse("fire", "xxxx"));
		assertEquals("htehlelroe", Recursion.intersperse("there", "hello"));
	}

	/**
	 * Unit tests for {@link Recursion.intersperse}
	 */
	@Test
	public void testIntersperseRepeating(){
		assertEquals("xaxbxaxbxaxb", Recursion.intersperse("ab", "xxxxxx"));
		assertEquals("zazbzczazbtc", Recursion.intersperse("abc", "zzzzzt"));
	}
	
	/**
	 * Unit tests for {@link Recursion.intersperse}
	 */
	@Test
	public void testIntersperseRepeatingUsePartialTheLastTime(){
		assertEquals("wawbwa", Recursion.intersperse("ab", "www"));
		assertEquals("xaxbxcxaxbxcxaxb", Recursion.intersperse("abc", "xxxxxxxx"));
	}
	
	/**
	 * Unit tests for {@link Recursion.intersperse}
	 */
	@Test
	public void testIntersperseEmpty(){
		assertEquals("", Recursion.intersperse("xyz", ""));
	}
	
	/**
	 * Unit tests for {@link Recursion.subtract}
	 */
	@Test
	public void testSubtract1() {
		int[] testArray1 = {1, 9, 5, 7};
		int[] testArray2 = {18, 2, 5, 4};
		int[] expectedDifference = {-17, 7, 0, 3};
		assertArrayEquals(expectedDifference, Recursion.subtract(testArray1, testArray2));
	}
	
	/**
	 * Unit tests for {@link Recursion.subtract}
	 */
	@Test
	public void testSubtract2() {
		int[] testArray1 = {4, 17, -3};
		int[] testArray2 = {1, 50, 2};
		int[] expectedDifference = {3, -33, -5};
		assertArrayEquals(expectedDifference, Recursion.subtract(testArray1, testArray2));
	}
	
	/**
	 * Unit tests for {@link Recursion.subtract}
	 */
	@Test
	public void testSubtractEmpty() {
		int[] testArrayEmpty = {};
		int[] expectedDifferenceEmpty = {};
		assertArrayEquals(expectedDifferenceEmpty, Recursion.subtract(testArrayEmpty, testArrayEmpty));
	}
}
