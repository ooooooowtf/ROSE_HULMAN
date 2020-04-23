import java.awt.Point;

/*
 * fruit can be acquired after hero drops two rocks
 * 
 */

public class Fruit extends GameObject {

	public Fruit(Point center, World world, String name) {
		super(center, world, name);
	}

	@Override
	public void timePassed() {
		this.collideWithHero(this.world.hero);
	}
	
	@Override
	public void collideWithHero(Hero hero) {
		double x1 = this.getCenterPoint().getX();
		double y1 = this.getCenterPoint().getY();
		double x2 = this.world.hero.getCenterPoint().getX();
		double y2 = this.world.hero.getCenterPoint().getY();
		if (Math.abs(x2 - x1) < 40 && Math.abs(y2 - y1) < 40) {
			this.world.fruits.remove(this);
			this.world.addToScore(100);
		}
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public boolean getIsPaused() {
		// TODO Auto-generated method stub.
		return false;
	}
}