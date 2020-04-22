import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/**
 * Draws some triangles.
 * 
 * @author Curt Clifton. Created Sep 30, 2008.
 */
public class TriangleComponent extends JComponent {
	private static final int INSET = 30;

	@Override
	protected void paintComponent(Graphics g) {
		final int base = 30;
		final int height = 60;
		double circRadius = 61.84658438426;
		final int count = 8;
		final double angle = 35.0;
		final double scaleFactor = 1.3;
		final double rotateStep = 40.0;
		
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double circ;
		double x = TriangleViewer.WIDTH / 2;
		double y = TriangleViewer.HEIGHT / 2;
		g2.setColor(Color.GRAY);
		for (int i = 0; i < count; i++) {
			circ = new Ellipse2D.Double(x - circRadius, y - circRadius,
					2 * circRadius, 2 * circRadius);
			g2.draw(circ);
			circRadius *= scaleFactor;
		}
				
		g2.setColor(Color.RED);
		Triangle t1 = new Triangle(INSET, TriangleViewer.HEIGHT - 2*INSET, INSET,
				TriangleViewer.WIDTH - 2 * INSET, 0.0);
		t1.drawOn(g2);

		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2.0f));
		Triangle t2 = new Triangle(TriangleViewer.WIDTH / 2,
				TriangleViewer.HEIGHT / 2, base, height, angle);
		for (int i = 0; i < count; i++) {
			t2.drawOn(g2);
			t2.scale(scaleFactor);
			t2.rotate(rotateStep);
		}

	}

}
