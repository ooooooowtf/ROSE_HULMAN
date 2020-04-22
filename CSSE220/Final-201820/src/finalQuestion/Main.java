package finalQuestion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * In this project, we start with a box on the screen which does not
 * show up properly unless the screen is resized.
 * 
 * You will need to add or modify classes to:
 * 
 * Stage 1
 * #1 Get the box to appear without resizing the window.
 * #2 Replace the button which advances one tick to use a Timer instead.
 * 
 * Stage 2
 * #3 Make a button to add more boxes to the simulation
 * 
 * Stage 3
 * #4 Make a button to toggle whether the boxes on the screen are moving or not
 * 
 * Stage 4
 * #5 Make a button to freeze all boxes (color and movement) while preserving their state to be unpaused on a subsequent press
 *
 * @author Jason Yoder, Matt Boutell, Mark Hays
 * and their colleagues.
 *Qishun Yu
 */
public class Main {

	public static final int DELAY=50;
	private int count =1;
	private int count2 =1;
	
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		JFrame frame = new JFrame("Colorful Bouncing Boxes");
		frame.setSize(800, 600);
		final DynamicBoxComponent component = new DynamicBoxComponent();
		frame.add(component, BorderLayout.CENTER);
		
		//button panel to add buttons to
		JPanel buttonPanel = new JPanel();
		frame.add(buttonPanel, BorderLayout.SOUTH);
		SimulationTickListener advanceListener = new SimulationTickListener(component);
		
		final Timer timer = new Timer(DELAY, new SimulationTickListener(component));
		
		//TODO Stage 1 :
		//Use a timer to update the game instead of this button
		//Move forward one tick
//		JButton advanceTickButton = new JButton("Advance One Tick");
//		advanceTickButton.addActionListener( advanceListener );
//		buttonPanel.add(advanceTickButton);
		
		
		
		
		//TODO Stage 2,3,4 :
		//Add buttons which perform desired actions
		JButton addButton = new JButton("Add box");
		buttonPanel.add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub.
				component.addBox();
			}

		});
		
		JButton toggleButton = new JButton("Toggle Box Movement");
		buttonPanel.add(toggleButton);
		toggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub.
				count++;
				if(count%2==0){component.stopUpdate();
				}else{
					component.starUpdate();
				}
			}

		});
		
		JButton pauseButton = new JButton("Pause All");
		buttonPanel.add(pauseButton);
		pauseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent f) {
				// TODO Auto-generated method stub.
				count2++;
				if(count2%2==0){timer.stop();
				}else{
					timer.start();
				}
			}

		});
		timer.start();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
