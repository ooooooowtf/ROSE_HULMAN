import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class SceneComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics graphics) {
		// TODO Auto-generated method stub.
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;
		graphics2.setColor(Color.blue);
		Rectangle2D.Double sky = new Rectangle2D.Double(0, 0, 750, 375);
		graphics2.fill(sky);
		graphics2.draw(sky);
		graphics2.setColor(Color.green);
		Rectangle2D.Double grass = new Rectangle2D.Double(0, 375, 750, 600);
		graphics2.fill(grass);
		graphics2.draw(grass);

		Sun sun = new Sun();
		sun.drawOn(graphics2);
		for (int i = 75; i < 600; i += 120) {
			House house = new House(i, 475, Color.RED);
			house.drawOn(graphics2);
		}
		for (int i = 200; i < 700; i += 20) {
			PineTree tree = new PineTree(i, 345, 10, 40);
			tree.drawOn(graphics2);
		}
		for (int i = 200; i < 635; i += 30) {
			PineTree tree1 = new PineTree(i, 365, 20, 80);
			tree1.drawOn(graphics2);
		}
	}

}
