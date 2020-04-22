package events;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ColoredSquareComponent extends JComponent{

	private static final int BORDER_WIDTH = 60; 
	
	@Override
	protected void paintComponent(Graphics arg0) {
		Graphics2D g = (Graphics2D) arg0;
		int side = Math.min(getWidth(), getHeight()) - 2*BORDER_WIDTH;
		g.setColor(Color.PINK);
		g.fillRect(BORDER_WIDTH, 
				   BORDER_WIDTH,
				   side,
				   side);
	}
	
}
