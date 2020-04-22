package ballStrikeCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackerListener implements ActionListener {

	public char a;
	public Tracker tracker;
	public int max;

	public TrackerListener(Tracker trackerin, char ainput, int maxcount) {
		this.a = ainput;
		this.tracker = trackerin;
		this.max = maxcount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int count = 0;
		if (this.a == 'b') {
			count = this.tracker.returnBalls();
		}
		if (this.a == 's') {
			count = this.tracker.returnStrikes();
		}
		if(count == this.max){
			this.tracker.setBalls(0);
			this.tracker.setStrikes(0);
		}
		else{
			if(this.a =='b'){
				this.tracker.setBalls(count+1);
			}
			if(this.a=='s'){
				this.tracker.setStrikes(count+1);
				
			}
		}
		this.tracker.updateLabel();

	}

}
