package addlettersProblem;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddLettersViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JLabel textOutput = new JLabel("> ");
		JButton a = new JButton("Add A");
		JButton b = new JButton("Add B");
		JButton c = new JButton("Add C");
		
		a.addActionListener(new AddListener(textOutput, "A"));
		b.addActionListener(new AddListener(textOutput, "B"));
		c.addActionListener(new AddListener(textOutput, "C"));
		
		JPanel panel = new JPanel();
		panel.add(a);
		panel.add(b);
		panel.add(c);
		
		frame.add(textOutput, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
