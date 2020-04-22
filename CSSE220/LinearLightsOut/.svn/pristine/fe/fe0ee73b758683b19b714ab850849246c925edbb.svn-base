package ballStrikeCounter;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tracker {
	private JLabel label = new JLabel();
	public int numBalls = 0;
	public int numStrikes = 0;

	// Call this to update the text on the label.
	public void updateLabel() {
		this.label.setText("<html>Balls: " + numBalls + "<br />Strikes: " + numStrikes + "</HTML>");
	}
	
	public void setBalls(int i){
		this.numBalls =i;
	}
	
	public void setStrikes(int i){
		this.numStrikes =i;
	}
	
	public int returnBalls(){
		return this.numBalls;
	}
	
	public int returnStrikes(){
		return this.numStrikes;
	}

	public static void main(String[] args) {
		new Tracker();
	}

	public Tracker() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		
		frame.add(this.label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		// DONE: Add buttons and listeners to make things work.
		JButton ball = new JButton("Add Ball");
		JButton strikes = new JButton("Add Strike");
		
		ball.addActionListener(new TrackerListener(this,'b',4));
		strikes.addActionListener(new TrackerListener(this,'s',3));
		panel.add(ball);
		panel.add(strikes);

		// The following line is given to show you how to use the given method:
		updateLabel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
