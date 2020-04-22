import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class BadFracTest {

	@Test
	public void testIsReduced() {
		ArrayList<BadFrac> fractions = new ArrayList<BadFrac>();
		fractions.add(new BadFrac(1, 2));
		fractions.add(new BadFrac(5, 1));
		fractions.add(new BadFrac(2, 5));
		fractions.add(new BadFrac(0, 1));
		for (BadFrac frac : fractions) {
			boolean actualResult = frac.isReduced();

			assertEquals(true, actualResult);
		}
	}

	@Test
	public void isNotReduced() {
		ArrayList<BadFrac> fractions = new ArrayList<BadFrac>();
		fractions.add(new BadFrac(1, 2));
		fractions.add(new BadFrac(6, 2));
		fractions.add(new BadFrac(0, 2));
		fractions.add(new BadFrac(1, 0));
		for (BadFrac frac : fractions) {
			boolean actualResult = frac.isReduced();

			assertEquals("",false, actualResult);
		}
	}
	

	

}
