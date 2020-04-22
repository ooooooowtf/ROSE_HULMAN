package stage1;

import java.util.ArrayList;

public class PlayerStatistics {
	private Contest cont1;
	private Player pla1;
	private double percentage;
	private ArrayList<Boolean> performance;

	public PlayerStatistics(Contest content1, Player player1) {
		this.cont1 = content1;
		this.pla1 = player1;
		double j = 0.0;

		ArrayList<Boolean> performanc = new ArrayList<>();
		for (int i = 0; i < this.cont1.returnShots(); i++) {
			double x = BasketballUtility.getRandomDouble();
			if (x > this.pla1.returnAccuracy()) {
				performanc.add(false);
			} else {
				performanc.add(true);
				j++;
			}
		}
		this.percentage = j / this.cont1.returnShots();
		this.performance = performanc;
	}

	public void percentage() {
		String numberAsString = Double.toString(this.percentage);
		System.out.println("Percentage is " + numberAsString);
	}

	public void shotinRow() {
		int count = 1;
		int maxc = 0;
		for (int i = 0; i < this.performance.size() - 1; i++) {
			if (this.performance.get(i) == this.performance.get(i + 1)) {
				count++;
			} else {
				count = 1;
			}
			if (count > maxc) {
				maxc = count;
			}
		}
		System.out.println("Shot In a Row " + maxc);
	}

	public void hitsnMiss() {
		String hnm = "";
		for (int i = 0; i < this.performance.size(); i++) {
			if (this.performance.get(i) == true) {
				hnm = hnm.concat("X");
			} else {
				hnm = hnm.concat("_");
			}
		}
		System.out.println("Hit and Miss " + hnm);
	}
}
