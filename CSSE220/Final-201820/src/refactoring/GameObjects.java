package refactoring;

import java.awt.Point;

public abstract class GameObjects {
	boolean mutate;
	public Point position;
	public GameObjects(Point position, boolean mutate){
		this.position = position;
		this.mutate=mutate;
	}
	
	public void domutate(){
		
	}
	
	public Point returnPoint(){
		return this.position;
	}
	
	public void setY(int p){
		this.position.y =p;
	}
	
	public boolean mutateOrnot(){
		return this.mutate;
	}
}
