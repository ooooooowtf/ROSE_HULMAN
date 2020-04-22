package events;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {

	// making an instance of the class to make it easier
	// to use inner classes if you wish 
	public static void main(String[] args) {
		Main instance = new Main();
		instance.createWindow();
	}
	
	public void createWindow() {
		JFrame frame = new JFrame();
		frame.setTitle("Final Question");
		
		ColoredSquareComponent c = new ColoredSquareComponent();
		c.setPreferredSize(new Dimension(200,200));
		frame.add(c);
		
		JPanel panel = new JPanel();
		frame.add(panel, BorderLayout.SOUTH);
		
		JButton b1 = new JButton("Red");
		panel.add(b1);
		
		JButton b2 = new JButton("Blue");
		panel.add(b2);
		
		JButton b3 = new JButton("Green");
		panel.add(b3);
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
