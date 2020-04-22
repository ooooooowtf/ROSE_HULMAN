package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {
	private Roomba roomba;
	private CatComponent c;
	private String direction;

	public ButtonsListener(Roomba rommba, CatComponent cat, String direct) {
		this.roomba = rommba;
		this.c = cat;
		this.direction = direct;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub.
		if (this.direction.equals("left")) {
			this.roomba.moveBy(-10, 0);
			this.c.repaint();
			this.c.addLine(-10,0);
		}
		if (this.direction.equals("right")) {
			this.roomba.moveBy(10, 0);
			this.c.repaint();
			this.c.addLine(10,0);
		}
		if (this.direction.equals("up")) {
			this.roomba.moveBy(0, -10);
			this.c.repaint();
			this.c.addLine(0,-10);
		}
		
		if (this.direction.equals("down")) {
			this.roomba.moveBy(0, 10);
			this.c.repaint();
			this.c.addLine(0,10);
		}
	}

}