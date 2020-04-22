import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
public class MyComponent extends JComponent{
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub.
		super.paintComponent(g);
		
		System.out.println("painting");
//		g.drawRect(100, 100, 200, 50);
		Graphics2D g2 = (Graphics2D) g;
		
//		Rectangle2D.Double rectangle = new Rectangle2D.Double(100,100,200,50);
//		g2.setColor(Color.BLUE);
//		
//		g2.draw(rectangle);
//		g2.fill(rectangle);
		for(int width =0; width<this.getWidth();width =width+10){
			Rectangle2D.Double rectangle1 = new Rectangle2D.Double(10,10,width,width);
			g2.draw(rectangle1);
		}
		int baseY = this.getWidth();
		Ellipse2D.Double ellipse = new Ellipse2D.Double(10, baseY+20, 50, 100);
		g2.draw(ellipse);
		g2.translate(0,baseY);
		
		
	}
	
	
	
}
