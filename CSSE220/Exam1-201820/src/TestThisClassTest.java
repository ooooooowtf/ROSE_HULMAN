import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TestThisClassTest {

	@Test
	public void test() {
		assertTrue(TestThisClass.isGoingCrazy(4, 2));
		assertTrue(TestThisClass.isGoingCrazy(10, 2));
		assertFalse(TestThisClass.isGoingCrazy(2, 2));
		assertFalse(TestThisClass.isGoingCrazy(4, 0));
		assertTrue(TestThisClass.isGoingCrazy(10, 2));
		assertFalse(TestThisClass.isGoingCrazy(3, 1));
		assertTrue(TestThisClass.isGoingCrazy(4, 1));
		/* when the day till break is the same as the homework is due, thus the result
		 can not pass the test
		 */
	}

}
