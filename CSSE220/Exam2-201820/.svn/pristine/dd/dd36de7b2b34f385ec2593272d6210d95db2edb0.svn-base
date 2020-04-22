package events;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CatViewer {

	/**
	 * The width of the frame.
	 */
	public static final int WIDTH = 400;
	/**
	 * The height of the frame.
	 */
	public static final int HEIGHT = 300;

	public void makeWindow() {
		JFrame frame = new JFrame();
		
		frame.setTitle("Curie Cat");
		
		CatComponent c = new CatComponent();
		
		c.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.add(c);
		
		
		JPanel panel = new JPanel();
		
		
		// TODO: add your buttons here.
		
		JButton b1 = new JButton("Left");
		b1.addActionListener(new ButtonsListener(c.roomba,c,"left"));
		panel.add(b1);
		
		JButton b2 = new JButton("Right");
		b2.addActionListener(new ButtonsListener(c.roomba,c,"right"));
		panel.add(b2);
		
		JButton b3 = new JButton("Up");
		b3.addActionListener(new ButtonsListener(c.roomba,c,"up"));
		panel.add(b3);
		
		JButton b4 = new JButton("Down");
		b4.addActionListener(new ButtonsListener(c.roomba,c,"down"));
		panel.add(b4);
		
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		CatViewer viewer = new CatViewer();
		viewer.makeWindow();
	}
	
	

}
