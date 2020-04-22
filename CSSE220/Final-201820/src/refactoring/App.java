package refactoring;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

// FIXME: this App uses POOR DESIGN.
// Can you fix it to use GOOD DESIGN?
public class App {
	private static List<GameObjects> gameObject;
	private Diamond[] diamondTiles;
	private Dirt[] dirtTiles;
	private Rock[] rockTiles;

	public static void main(String[] args) {
		gameObject= new ArrayList<>();
		gameObject.add(new Diamond(new Point(1, 0),true));
		// For testing purposes: mutate the above diamond tile.

		
		gameObject.add(new Dirt(new Point(1, 0),true));
		gameObject.add(new Diamond(new Point(0, 1),false));
		// Mutate the first dirt tile, but not the second.

		
		gameObject.add(new Rock(new Point(1, 1),true));
		// Mutate the rock.
		
		App app = new App();
				
		app.handleMutate();
		app.handlePrintPositions();

	}

	public App() {
	}

	public void handleMutate() {
		
		for(GameObjects object :gameObject){
			object.domutate();
		}
		
	}

	public void handlePrintPositions() {
		for(GameObjects object :gameObject){
			System.out.println(object.returnPoint().getX() + " " + object.returnPoint().getY());
		}
	}

}
