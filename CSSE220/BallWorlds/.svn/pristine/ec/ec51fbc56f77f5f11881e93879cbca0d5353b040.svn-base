package ballworlds;

import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

public class Pulsar extends Ball {
	private Color color;
	private int diameter;
	private int index=0;

	public Pulsar(BallEnvironment world) {
		super(world);
		// TODO Auto-generated constructor stub.
		this.diameter = 40;
		this.color =new Color(255,255,255);
		double xpos1 = Random.randInterval(0, world.getSize().getWidth());
		double ypos1 = Random.randInterval(0, world.getSize().getHeight());
		this.setCenterPoint(new Point2D.Double(xpos1, ypos1));
	}
	

	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return this.color;
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.
	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.
	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.
		int count = this.color.getBlue();

		if(count <=0){
			index=1;
		}
		else if(count>=255){
			index=-1;
		}
		this.color=new Color(count +index,count +index,count +index);
	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub.
		return this.diameter;
	}

}
