package linearLightsOut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LinearGameListener implements ActionListener {

	public ArrayList<JButton> buttons;
	public int index;
	public JFrame myFrame;
	public JButton newGame;

	public LinearGameListener(ArrayList<JButton> buttons, int index, JFrame myFrame, JButton newGame) {
		this.index = index;
		this.buttons = buttons;
		this.myFrame = myFrame;
		this.newGame = newGame;
	}

	public void press() {
		JButton button1 = this.buttons.get(this.index);
		if (this.index == 0) {
			JButton buttonPlus = this.buttons.get(this.index + 1);
			actionWhenPress(buttonPlus);
			actionWhenPress(button1);
		}
		if (this.index == (this.buttons.size()-1)) {
			JButton buttonMinus = this.buttons.get(this.index -1);
			actionWhenPress(buttonMinus);
			actionWhenPress(button1);
		}else{
			JButton buttonPlus = this.buttons.get(this.index + 1);
			JButton buttonMinus = this.buttons.get(this.index -1);
			actionWhenPress(buttonPlus);
			actionWhenPress(buttonMinus);
			actionWhenPress(button1);
		}
	}

	public void actionWhenPress(JButton button1) {
		String xo = button1.getText();
		if (xo.equals("X")) {
			button1.setText("O");
		} else {
			button1.setText("X");
		}
	}
	
	public void win(){
		boolean allT =true;
		String first = this.buttons.get(0).getText();
		for(int i=0;i<this.buttons.size();i++){
			JButton currentButton = this.buttons.get(i);
			String check = currentButton.getText();
			if(check.equals(first)==false){
				allT= false;
			}
		}
		if(allT){
			JFrame winFrame = new JFrame();
			JLabel winLabel = new JLabel("You Win!");
			winFrame.add(winLabel);
			winFrame.pack();
			winFrame.setVisible(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub.
		press();
		win();
	}

}
