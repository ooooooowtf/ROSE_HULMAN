import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Pyramid {
	private Color color;
	private double x;
	private double y;
	private double xo;
	private double yo;

	// TODO: Add fields and constructors.
	// public Pyramid(){
	// Rectangle2D.Double rectan = new Rectangle2D.Double(0, 0, 30, 15);
	// }

	public Pyramid() {

	}

	public Pyramid(double x1, double y1) {
		this.xo = x1;
		this.yo = y1;
	}

	public static void drawOneBlock(Graphics2D g2) {
		
		g2.setColor(Color.green);
		Rectangle2D.Double rectan = new Rectangle2D.Double(0, 0, 30, 15);	
		g2.fill(rectan);
		g2.setColor(Color.black);
		g2.draw(rectan);
	}

	public static void drawOn(Graphics2D g2) {
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < (5 - i); j++) {
				Pyramid.drawOneBlock(g2);
				g2.translate(30, 0);
//				g2.setColor(Color.green);
//				Rectangle2D.Double rectan = new Rectangle2D.Double(this.x + 30 * j, this.y + 15 * i, 30, 15);
//				g2.fill(rectan);
//				g2.setColor(Color.BLACK);
//				Rectangle2D.Double rectan1 = new Rectangle2D.Double(this.x + 30 * j, this.y + 15 * i, 30, 15);
//				g2.draw(rectan);
//				g2.draw(rectan1);
			}
			g2.translate(15-(5-i)*30, 15);
//			this.x = this.x + 15;
		}
		g2.translate(-75, -75);
	}

	public void drawRotated(Graphics2D g2, double degrees) {
		// TODO: UNCOMMENT the code below PyramidComponent's TODO 3
		g2.translate(this.xo, this.yo);
		for (int i = 0; i < 4; i++) {
			Pyramid.drawOn(g2);
			g2.rotate(degrees / 180 * Math.PI);
		}
		g2.translate(-this.xo, -this.yo);
		// TODO: Complete Phase 3
	}
}