package refactoring;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Dirt extends GameObjects{
	
	public Color color = Color.black;

	public Dirt(Point position, Boolean b) {
		super(position,b);
	}
	
	public void setColor(Color color){
		this.color  =color;
	}
	
	@Override
	public void domutate() {
		Random random = new Random();
		this.color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		System.out.println("Color is now " + this.color);
	}

}
