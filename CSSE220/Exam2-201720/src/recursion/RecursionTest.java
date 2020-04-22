package recursion;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
	public void testIsAlternatingCase(){		
		assertTrue(Recursion.isAlternatingCase(""));
		assertTrue(Recursion.isAlternatingCase("x"));
		assertTrue(Recursion.isAlternatingCase("X"));
		assertTrue(Recursion.isAlternatingCase("Xx"));
		assertFalse(Recursion.isAlternatingCase("xx"));
		assertTrue(Recursion.isAlternatingCase("xX"));
		assertTrue(Recursion.isAlternatingCase("xXyYzZ"));
		assertFalse(Recursion.isAlternatingCase("xXyYzZZ"));
		assertFalse(Recursion.isAlternatingCase("ThIsIsAnNoying"));
		
	}
	
	@Test
	/**
	 * Unit tests for {@link Recursion.reverseString}
	 */
	public void testReverseString(){		
		assertEquals("reduotS", Recursion.reverseString("Stouder"));
		assertEquals("olaffuB", Recursion.reverseString("Buffalo"));
		assertEquals("", Recursion.reverseString(""));
		assertEquals("abccba", Recursion.reverseString("abccba"));
	}
	
	/**
	 * Unit tests for {@link Recursion.average}
	 */
	@Test
	public void testAverage(){
		assertEquals(15.0, Recursion.average(new double[] {0.0, 15.0, 30.0}), 0.000001);
		assertEquals(15.0, Recursion.average(new double[] {0.0, 15.0, 30.0}), 0.000001);
		assertEquals(Double.NaN, Recursion.average(new double[] {}), 0.000001);
	}

	
	
	/**
	 * Unit tests for {@link Recursion.average}
	 */
	@Test
	public void testCanSumToTarget(){
		assertTrue(Recursion.canSumToValue(new int[] {1,2,3,4,5,6,7,8,9,10},10));
		assertFalse(Recursion.canSumToValue(new int[] {1,2,3,4,5,6,7,8,9,10},11));
		assertTrue(Recursion.canSumToValue(new int[] {1}, 1));
		assertFalse(Recursion.canSumToValue(new int[] {},  1));
		assertFalse(Recursion.canSumToValue(new int[] {},  0));
		assertFalse(Recursion.canSumToValue(new int[] {1}, 0));
		assertTrue(Recursion.canSumToValue(new int[] {1,0,-1}, 0));
		assertTrue(Recursion.canSumToValue(new int[] {1,2,3,4,5,6}, 3));
		assertFalse(Recursion.canSumToValue(new int[] {1,2,3,4,5,6}, 13));
	}
}

	
	