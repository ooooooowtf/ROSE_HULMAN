package refactoring;

import java.awt.Point;

public class Rock extends GameObjects{

	int dy;
	public int y;

	public Rock(Point point,Boolean b) {
		super(point,b);
		this.dy = 1;
		this.y =(int) point.getY(); 
	}
	
	
	public void fall() {
		this.y += dy;
		super.setY(this.y);
		System.out.println("Rock is falling " + dy);
	}

	@Override
	public void domutate() {
		this.dy *= -1;
		System.out.println("dy is now " + this.dy);
	}

}
