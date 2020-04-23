import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * DigDugComponent  
 * 
 * 
 * @author penryoa
 *
 */
public class DigDugComponent extends JComponent {
	
	// ======= Important Objects ======= \\
	private World world;

	// ======= DigDugComponent Constructor ======= \\
	public DigDugComponent(JLabel scoreLabel) {
		this.world = new World(this, scoreLabel);
	}

	// ======= Important Methods ======= \\

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// makes things look slightly prettier
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		this.world.drawDirtImage(g2);
		this.drawObjects(g2);
	}

	private void drawObjects(Graphics2D g2) {
		HashMap<Point, BlackSpace> blackSpacesToDraw = new HashMap<>();
		blackSpacesToDraw.putAll(this.world.blackSpaces);
		for(BlackSpace b: blackSpacesToDraw.values()) {
			b.drawCentered(g2);
		}
		for(GameObject o : this.world.getObjects()) {
				o.drawCentered(g2);
		}
		if(this.world.theSword!=null) {
			this.world.theSword.drawCentered(g2);
		}
	}

	public World getWorld() {
		return this.world;
	}
}