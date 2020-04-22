package finalQuestion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class represents a box with a changing color and position which bounces
 * around the screen.
 * 
 * Some variables or methods for this class may need to be added or modified.
 * 
 * 
 * @author Jason Yoder, Matt Boutell, Mark Hays and their colleagues.
 */
public class DynamicBoxComponent extends JComponent {

	// This variable should NOT need to be changed
	private int numTicks;
	// TODO: This may need to be changed
	private ArrayList<DynamicBox> boxs;

	// This constructor initializes a single box
	public DynamicBoxComponent() {
		this.boxs = new ArrayList<>();
		this.boxs.add(new DynamicBox(this));

	}

	// This method updates the screen to view the current state of the Component
	public void drawScreen() {
		this.repaint();
		System.out.println("Tick " + this.numTicks);
	}

	// This method should draw anything considered to be part of the Component
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (DynamicBox box : this.boxs) {
			box.drawOn(g2);
		}
	}

	// This method updates the state of anything belonging to the Component,
	// currently the single box and ticks passed
	public void updateState() {
		for (DynamicBox box : this.boxs) {
			box.updateState();
		}
		this.numTicks++;
	}

	public void addBox() {
		DynamicBox nbox = new DynamicBox(this);
		boxs.add(nbox);
	}

	public void stopUpdate() {
		for (DynamicBox box : this.boxs) {
			box.setIsPaused(true);
		}
	}

	public void starUpdate() {
		for (DynamicBox box : this.boxs) {
			box.setIsPaused(false);
		}
	}
	

}
