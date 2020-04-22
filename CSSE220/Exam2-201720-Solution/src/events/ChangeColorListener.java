package events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeColorListener implements ActionListener {

	private Color color;
	private ColoredSquareComponent component;
	
	public ChangeColorListener(Color color, ColoredSquareComponent component) {
		this.color = color;
		this.component = component;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		component.setColor(color);
		component.repaint();
	}

}
