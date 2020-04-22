package ballworlds;

import java.awt.geom.Point2D;

import util.Random;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class AbstractBouncer extends Ball {
	// nothing here... yet
	private double velocityx;
	private double velocityy;
	private double boundx;
	private double boundy;

	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */
	public AbstractBouncer(BallEnvironment world) {
		super(world);
		this.setVandbound(world);
		this.setCenterPoint(world.getCenterPoint());

	}

	public AbstractBouncer(BallEnvironment world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setVandbound(world);
		this.setCenterPoint(world.getCenterPoint());
	}

	public void setVelocity() {
		double xpos = this.getCenterPoint().getX();
		double ypos = this.getCenterPoint().getY();
		if (xpos <= 0) {
			this.velocityx = -this.velocityx;
		} else if (xpos >= this.boundx) {
			this.velocityx = -this.velocityx;
		}
		if (ypos <= 0) {
			this.velocityy = -this.velocityy;
		} else if (ypos >= this.boundy) {
			this.velocityy = -this.velocityy;
		}
		xpos = xpos + this.velocityx;
		ypos = ypos + this.velocityy;
		this.setCenterPoint(new Point2D.Double(xpos, ypos));

	}

	public void setVandbound(BallEnvironment world) {
		this.velocityx = Random.randInterval(-2.0, 2.0);
		this.velocityy = Random.randInterval(-2.0, 2.0);
		this.boundx = world.getSize().getWidth();
		this.boundy = world.getSize().getHeight();
	}
}
