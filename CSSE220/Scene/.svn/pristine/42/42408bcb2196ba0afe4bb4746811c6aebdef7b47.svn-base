import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Sun {
	private static final Color BORDER_COLOR = Color.BLACK;
	private static final int NUMBER_OF_RAYS = 8;
	private static final double RAY_LENGTH_SCALE = 0.5;
	private static final double RAY_WIDTH_SCALE = 0.1;
	private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;
	private static final double DEFAULT_SUN_DIAMETER = 100.0;
	private static final double DEFAULT_SUN_X = 100.0;
	private static final double DEFAULT_SUN_Y = 100.0;
	private static final Color DEFAULT_SUN_COLOR = Color.YELLOW;
	private static final double LITTLE_SUNS_X_OFFSET = 50;

	private double x;
	private double y;
	private double circleDiameter;
	private double rayLength;
	private double rayWidth;
	private double rayDistanceFromSun;
	private Color color;

	public Sun() {
		this.x = DEFAULT_SUN_X;
		this.y = DEFAULT_SUN_Y;
		this.circleDiameter = DEFAULT_SUN_DIAMETER;
		this.color = DEFAULT_SUN_COLOR;
		this.rayLength = DEFAULT_SUN_DIAMETER * RAY_LENGTH_SCALE;
		this.rayWidth = DEFAULT_SUN_DIAMETER * RAY_WIDTH_SCALE;
		this.rayDistanceFromSun = DEFAULT_SUN_DIAMETER * RAY_DISTANCE_FROM_SUN_SCALE;
	}

	public Sun(double x0, double yo, double circleDia, Color colour) {
		this.x = x0;
		this.y = yo;
		this.circleDiameter = circleDia;
		this.color = colour;
		this.rayLength = this.circleDiameter * RAY_LENGTH_SCALE;
		this.rayWidth = this.circleDiameter * RAY_WIDTH_SCALE;
		this.rayDistanceFromSun = this.circleDiameter * RAY_DISTANCE_FROM_SUN_SCALE;

	}

	public void drawRay(Graphics2D g2) {
		g2.translate(this.x + this.circleDiameter / 2, this.y + this.circleDiameter / 2);

		for (int i = 0; i < NUMBER_OF_RAYS; i++) {
			g2.rotate(Math.PI / 4);
			g2.setColor(this.color);
			Rectangle2D.Double nRay = new Rectangle2D.Double(this.rayDistanceFromSun + this.circleDiameter / 2, 0,
					this.rayLength, this.rayWidth);
			g2.fill(nRay);

			g2.setColor(BORDER_COLOR);
			Rectangle2D.Double nRay1 = new Rectangle2D.Double(this.rayDistanceFromSun + this.circleDiameter / 2, 0,
					this.rayLength, this.rayWidth);

			g2.draw(nRay1);
			g2.draw(nRay);
		}

		g2.translate(-this.x - this.circleDiameter / 2, -this.y - this.circleDiameter / 2);
	}

	public void drawOn(Graphics2D g2) {
		g2.setColor(this.color);
		Ellipse2D.Double circle = new Ellipse2D.Double(this.x, this.y, this.circleDiameter, this.circleDiameter);
		g2.fill(circle);

		g2.setColor(BORDER_COLOR);
		Ellipse2D.Double circle1 = new Ellipse2D.Double(this.x, this.y, this.circleDiameter, this.circleDiameter);

		g2.draw(circle);
		g2.draw(circle1);

		drawRay(g2);

	}
}
