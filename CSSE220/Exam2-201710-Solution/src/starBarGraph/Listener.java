package starBarGraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Listener implements ActionListener {

	int[] data;
	JTextArea label;
	int num;
	
	public Listener(int[] data, JTextArea label, int num) {
		this.data = data;
		this.label = label;
		this.num = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.data[num]++;
		String output = "";
		for(int i = 0; i < this.data.length; i++) {
			output += (i+1) + "|";
			for(int j = 0; j < this.data[i]; j++) {
				output += "*";
			}
			output += "\n";
		}
		this.label.setText(output);
	}

}
