import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Tests the Triangle class.
 *
 * @author Curt Clifton.
 *         Created Sep 29, 2009.
 */
public class TriangleTest {
	private static final double DELTA = 0.00001;
	private Triangle little;
	private Triangle medium;
	private Triangle large;
	private Triangle huge;
	
	/**
	 * Sets up some triangles for testing.
	 */
	@Before
	public void setup() {
		this.little = new Triangle(0,0,10,10,0.0);
		this.medium = new Triangle(7,8,10,100,35.0);
		this.large = new Triangle(0,0,100,100,35.0);
		this.huge = new Triangle(7,8,32768,32767,0.0);
	}

	/**
	 * Test method for {@link Triangle#scale(double)}.
	 */
	@Test
	public void testScale() {
		this.little.scale(1000);
		assertEquals(50000000.0, this.little.area(), DELTA);

		this.medium.scale(0.25);
		assertEquals(31.25, this.medium.area(), DELTA);

		this.large.scale(2.0);
		assertEquals(20000.0, this.large.area(), DELTA);

		this.huge.scale(1.0);
		assertEquals(536854528.0, this.huge.area(), DELTA);
		
		this.huge.scale(0.0);
		assertEquals(0.0, this.huge.area(), DELTA);
	}

	/**
	 * Test method for {@link Triangle#rotate(double)}.
	 */
	@Test
	public void testRotate() {
		this.little.rotate(125);
		this.medium.rotate(225);
		this.large.rotate(325);
		this.huge.rotate(0);
		testArea();
	}

	/**
	 * Test method for {@link Triangle#area()}.
	 */
	@Test
	public void testArea() {
		assertEquals(50.0, this.little.area(), DELTA);
		assertEquals(500.0, this.medium.area(), DELTA);
		assertEquals(5000.0, this.large.area(), DELTA);
		assertEquals(536854528.0, this.huge.area(), DELTA);
	}

}
