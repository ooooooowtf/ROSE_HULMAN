import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Viewer {
	public Viewer(){
		JFrame frame = new JFrame();
		frame.setTitle("File button counting program");
		
		JButton button = new JButton("0");
		frame.add(button);
		
		ActionListener counter = new Counter(button,0);
		button.addActionListener(counter);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Viewer();
	}
}
