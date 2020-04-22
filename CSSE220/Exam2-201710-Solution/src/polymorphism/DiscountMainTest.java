package polymorphism;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountMainTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expected;
		
		expected = "Total discounts: 1.0\nFinal price: 4.0";
		assertEquals(expected, DiscountMain.getTotalDiscountString("Milk", 5));

		expected = "Total discounts: 0.25\nFinal price: 1.75";
		assertEquals(expected, DiscountMain.getTotalDiscountString("Eggs", 2));

		expected = "Total discounts: 0.0\nFinal price: 3.0";
		assertEquals(expected, DiscountMain.getTotalDiscountString("Bread", 3));

		expected = "Total discounts: 1.0\nFinal price: 9.0";
		assertEquals(expected, DiscountMain.getTotalDiscountString("Apples Bulk", 10));

		expected = "Total discounts: 1.5\nFinal price: 3.5";
		assertEquals(expected, DiscountMain.getTotalDiscountString("Milk Bulk", 5));

		expected = "Total discounts: 6.25\nFinal price: 3.75";
		assertEquals(expected, DiscountMain.getTotalDiscountString("Bulk Expired Eggs", 10));
		
		
	}

}
