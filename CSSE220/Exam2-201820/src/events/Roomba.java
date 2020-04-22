package events;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Roomba {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private ArrayList<Line2D> lines;

	public Point position;

	private CurieCat cat;
	private BufferedImage roombaImage;

	public Roomba(Point initialPosition) {
		this.position = initialPosition;
		Point2D p3 = new Point2D.Double(position.x, position.y);
		Point2D p4 = new Point2D.Double(position.x, position.y);
		this.lines=new ArrayList<>();
		this.lines.add(new Line2D.Double(p3, p4));
		this.cat = new CurieCat();
		try {
			this.roombaImage = ImageIO.read(new File("roomba.png"));
		} catch (IOException e) {
			throw new RuntimeException("Error drawing Roomba: " + e);
		}
	}

	public void drawRoombaAndCat(Graphics2D g2) {
		for(int i =0;i<this.lines.size();i++){
			g2.draw(this.lines.get(i));
		}
		g2 = (Graphics2D) g2.create();
		g2.translate(position.x, position.y);
		this.cat.drawCentered(g2);
		
		g2.drawImage(roombaImage, 0, 0, null);

	}

	public void moveBy(int dx, int dy) {
		Point2D p1 = new Point2D.Double(position.x, position.y);
		this.position = new Point(position.x + dx, position.y + dy);
		Point2D p2 = new Point2D.Double(position.x, position.y);
		this.lines.add(new Line2D.Double(p1, p2));

	}

	public Point returnposition() {
		return this.position;
	}
	
}
