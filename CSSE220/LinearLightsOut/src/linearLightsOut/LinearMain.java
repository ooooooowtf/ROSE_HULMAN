package linearLightsOut;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author <TODO: Qishun Yu work with Qinghong Wu>. Created Jan 18, 2010.
 */
public class LinearMain {

	/**
	 * Starts here.
	 * 
	 * @param args
	 */

	public static ArrayList<JButton> creatButtons(JPanel panel, int nButtons) {
		ArrayList<JButton> buttons = new ArrayList<>();
		for (int i = 0; i < nButtons; i++) {
			double probability = Math.random();
			JButton button = new JButton();
			if (probability >= 0.5) {
				button.setText("X");
			} else {
				button.setText("O");
			}
			panel.add(button);
			buttons.add(i, button);

		}
		return buttons;
	}

	public static void creatListener(ArrayList<JButton> buttons, JFrame myFrame, JButton newGame) {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(new LinearGameListener(buttons, i, myFrame, newGame));
		}
	}

	public static void main(String[] args) {
		String nButtonsString = JOptionPane.showInputDialog("How many buttons would you like?");
		int nButtons = Integer.parseInt(nButtonsString);

		JFrame myFrame = new JFrame();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		ArrayList<JButton> buttons = creatButtons(panel1, nButtons);
		JButton newGame = new JButton("New Game");
		JButton quit = new JButton("Quit");
		creatListener(buttons, myFrame, newGame);
		newGame.addActionListener(new NewListener(buttons, myFrame));
		quit.addActionListener(new QuitListener());
		panel2.add(newGame);
		panel2.add(quit);
		myFrame.add(panel1,BorderLayout.CENTER);
		myFrame.add(panel2,BorderLayout.SOUTH);
		// you'll want to think about how you want to manage the state of the
		// game
		// also you want to add some buttons and stuff
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
