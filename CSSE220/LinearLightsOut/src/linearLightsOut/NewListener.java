package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NewListener implements ActionListener {
	public ArrayList<JButton> buttons;
	public JFrame myFrame;
	
	public NewListener(ArrayList<JButton> buttons, JFrame myFrame){
		this.buttons= buttons;
		this.myFrame = myFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub.
		for(int i =0;i<this.buttons.size();i++){
			double probability = Math.random();
			if (probability >= 0.5) {
				this.buttons.get(i).setText("X");
			} else {
				this.buttons.get(i).setText("O");
			}
		}
	}

}
