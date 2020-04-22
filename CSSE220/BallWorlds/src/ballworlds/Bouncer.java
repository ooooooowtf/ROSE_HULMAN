package ballworlds;

import java.awt.Color;

import util.Random;

public class Bouncer extends AbstractBouncer {
	private Color color;
	private int diameter;

	public Bouncer(BallEnvironment world) {
		super(world);
		// TODO Auto-generated constructor stub.
		this.diameter = 40;
		int color1 = Random.randRange(0, 255);
		int color2 = Random.randRange(0, 255);
		int color3 = Random.randRange(0, 255);
		this.color = new Color(color1, color2, color3);

	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.
		super.setVelocity();
	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub.
		return this.diameter;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return this.color;
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

}
