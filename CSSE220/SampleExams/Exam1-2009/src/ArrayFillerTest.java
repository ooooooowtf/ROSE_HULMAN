import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Tests ArrayFiller
 * 
 * @author Curt Clifton. Created Sep 28, 2009
 */
public class ArrayFillerTest {

	/**
	 * Test method for {@link ArrayFiller#fillErUp1()}.
	 */
	@Test
	public void testFillErUp1() {
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(expected, ArrayFiller.fillErUp1());
	}

	/**
	 * Test method for {@link ArrayFiller#fillErUp2()}.
	 */
	@Test
	public void testFillErUp2() {
		int[] expected = { 2, 4, 6, 8, 10, 12, 14 };
		assertArrayEquals(expected, ArrayFiller.fillErUp2());
	}

	/**
	 * Test method for {@link ArrayFiller#fillErUp3()}.
	 */
	@Test
	public void testFillErUp3() {
		List<Integer> expected = Arrays.asList(0, 3, 6, 9, 12, 15, 18);
		assertEquals(expected, ArrayFiller.fillErUp3());
	}

	/**
	 * Test method for {@link ArrayFiller#fillErUp4()}.
	 */
	@Test
	public void testFillErUp4() {
		List<Integer> expected = Arrays
				.asList(1, 4, 7, 10, 13, 13, 10, 7, 4, 1);
		assertEquals(expected, ArrayFiller.fillErUp4());
	}

}
