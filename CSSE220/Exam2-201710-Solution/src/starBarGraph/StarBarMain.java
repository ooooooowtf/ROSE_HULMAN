package starBarGraph;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StarBarMain {

	// making an instance of the class to make it easier
	// to use inner classes if you wish 
	public static void main(String[] args) {
		StarBarMain instance = new StarBarMain();
		instance.createWindow();
	}
	
	public void createWindow() {
		JFrame frame = new JFrame();
		frame.setTitle("Star Bar Graph!");
		final JTextArea label = new JTextArea();
		label.setEditable(false);
		frame.add(label, BorderLayout.CENTER);
		
		label.setText("1|**\n2|****\n3|\n4|***");
		
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.SOUTH);
		int[] data = new int[4];
		for(int i = 0; i < 4; i++) {
			JButton numButton = new JButton("[" + (i + 1) + "]");
			panel.add(numButton);
			Listener l = new Listener(data, label, i);
			numButton.addActionListener(l);
		}
			
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
