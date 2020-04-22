import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 * This class represents an isosceles triangle.
 * 
 * @author YOUR_NAME_HERE. Created Sep 28, 2009.
 */
public class Triangle {
	private double xo;
	private double yo;
	private double tBase;
	private double tHeight;
	private double rotation;
	// TODO, Prob. C2: decide what field(s) to use in your implementation

	/**
	 * Constructs a new isosceles triangle from the given parameters. See Figure
	 * 1 on the printed test for additional explanation of the parameters.
	 * 
	 * @param x
	 *            the x-coordinate of the triangle's tip
	 * @param y
	 *            the y-coordinate of the triangle's tip
	 * @param base
	 *            the width of the triangle's base, in pixels
	 * @param height
	 *            the height of the triangle, in pixels
	 * @param angle
	 *            the angle formed between the x-axis and a line through this
	 *            triangle's tip that bisects its base, in degrees clockwise
	 */
	public Triangle(int x, int y, int base, int height, double angle) {
		this.xo = x;
		this.yo = y;
		this.tHeight = height;
		this.tBase = base;
		this.rotation = angle;

		// TODO, Prob. C2: implement this constructor

	}

	/**
	 * Scales this triangle by the given factor in each dimension, so a scaling
	 * factor of 2.0 quadruples the triangle's area.
	 * 
	 * @param factor
	 */
	public void scale(double factor) {
		this.tBase = this.tBase * factor;
		this.tHeight = this.tHeight * factor;

		// TODO, Prob. C2: implement this method
	}

	/**
	 * Rotates this triangle through the specified number of degrees.
	 * 
	 * @param degrees
	 *            positive rotates clockwise
	 */
	public void rotate(double degrees) {
		// TODO, Prob. C2: implement this method
	}

	/**
	 * @return the area of this triangle, in pixels^2
	 */
	public double area() {
		// TODO, Prob. C2: implement this method
		return (this.tBase * this.tHeight / 2);
	}

	/**
	 * Draws this triangle on the given graphics object.
	 * 
	 * @param graphics2
	 */
	public void drawOn(Graphics2D graphics2) {
		int[] xpoints = { (int) this.xo, (int) (this.xo - this.tBase / 2), (int) (this.xo + this.tBase / 2) };
		int[] ypoints = { (int) this.yo, (int) (this.yo + this.tHeight), (int) (this.yo + this.tHeight) };
		Polygon po1 = new Polygon(xpoints, ypoints, 3);
		graphics2.draw(po1);
		// TODO, Prob. C2: implement this method
	}
}
