package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

public class Mover extends Ball {
	private Color color;
	private int diameter;
	private double velocityx;
	private double velocityy;

	public Mover(BallEnvironment world) {
		super(world);
		// TODO Auto-generated constructor stub.
		this.diameter = 40;
		this.velocityx = Random.randInterval(-1.0, 1.0);
		this.velocityy = Random.randInterval(-1.0, 1.0);
		int color1 = Random.randRange(0, 255);
		int color2 = Random.randRange(0, 255);
		int color3 = Random.randRange(0, 255);
		this.color = new Color(color1, color2, color3);
		this.setCenterPoint(world.getCenterPoint());

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return this.color;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.
		double x = this.getCenterPoint().getX();
		double y = this.getCenterPoint().getY();
		x=x + this.velocityx;
		y=y + this.velocityy;
		super.setCenterPoint(new Point2D.Double(x,y));
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub.
		return this.diameter;
	}
}
