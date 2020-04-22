import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class House {
	private static final int HEIGHT = 50;
	private static final int WIDTH = 100;
	private static final int ROOF_HEIGHT = 20;
	private int xo;
	private int yo;

	private Color color;

	public House(int x, int y, Color color) {
		this.xo = x;
		this.yo = y;
		this.color = color;
		// TODO: save off the parameters into instance variables
	}

	public void drawOn(Graphics2D g2) {
		g2.setColor(this.color);
		Rectangle2D.Double rectangle = new Rectangle2D.Double(this.xo, this.yo, WIDTH, HEIGHT);
		g2.fill(rectangle);

		Point2D.Double point1 = new Point2D.Double(this.xo, this.yo);
		Point2D.Double point2 = new Point2D.Double(this.xo + WIDTH, this.yo);
		Point2D.Double point3 = new Point2D.Double(this.xo + WIDTH / 2, this.yo - ROOF_HEIGHT);
		Line2D.Double line1 = new Line2D.Double(point1, point3);
		Line2D.Double line2 = new Line2D.Double(point2, point3);
		g2.draw(line1);
		g2.draw(line2);
		g2.draw(rectangle);

		// TODO: Draw the house body (a rectangle) and the roof (3 lines or a
		// Polygon)
	}

}
