import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Monster extends GameObject{

	public Point2D position;
	protected boolean isPaused = false;
	protected BufferedImage image;
	private String name;
	private World world;
	
	public Monster(Point2D centerPoint, World world) {
		super(centerPoint, world);
		this.position = centerPoint;
		this.name="pookie";
		this.world = world;
		this.setName("fygar");
	}
	

	public Point2D returnPosition(){
		return this.position;
	}
	
	
	
	
	@Override
	public void timePassed() {
		updatePosition();

	}
	

	@Override
	public void die() {
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	@Override
	public boolean getIsPaused() {
		return this.isPaused;
	}
	
	public void updatePosition() {
		Point2D newPosition = new Point2D.Double(300,400);
		this.setCenterPoint(newPosition);
	}

}
