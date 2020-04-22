import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;


public class Counter implements ActionListener {

	JButton button;
	int count;
	File countFile;
	
	
	
	public Counter(JButton button, int i) {
		// TODO Auto-generated constructor stub.
		this.button = button;
		this.count =i;
		this.countFile = new File("count.text");
		try{
			Scanner in = new Scanner(this.countFile);
			count = in.nextInt();
			in.close();
		}catch(FileNotFoundException e){
			this.count=0;
			
		}finally{
			this.button.setText(count+"");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub.
		count++;
		button.setText(count+"");
	}

}
