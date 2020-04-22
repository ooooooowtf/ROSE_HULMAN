import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

public class PineTree {
	private int xo;
	private int yo;
	private int Width;
	private int Height;

	private Color bRown = new Color(145, 112, 33);
	private Color gReen = new Color(40, 135, 22);

	public PineTree(int x, int y, int wid, int hei) {
		this.xo = x;
		this.yo = y;
		this.Width = wid;
		this.Height = hei;
	}

	public void drawOn(Graphics2D g2) {
		int xT = this.xo + this.Width / 3;
		int yT = this.yo + this.Height * 2 / 3;
		int h = this.Height * 2 / 3;
		int w = this.Width / 2;
		int[] xpoints = { this.xo, this.xo + this.Width, this.xo + w };
		int[] ypoints = { this.yo + h, this.yo + h, this.yo };
		g2.setColor(this.bRown);
		Rectangle2D.Double trunk = new Rectangle2D.Double(xT, yT, this.Width / 3, this.Height / 3);
		g2.fill(trunk);

		g2.setColor(this.gReen);
		Polygon po1 = new Polygon(xpoints, ypoints, 3);
		g2.fill(po1);

		g2.draw(trunk);
		g2.draw(po1);
	}
}
