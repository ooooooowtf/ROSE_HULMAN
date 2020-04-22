package stage2;

import java.util.ArrayList;

public class Contest {
	public String title;
	public int shots;
	public ArrayList<Player> players;

	public Contest(String titl, int shox) {
		this.setTitle(titl);
		this.setShots(shox);
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player pla) {
		this.players.add(pla);
	}

	public int getPlayersSize() {
		return this.players.size();
	}

	public void runContest() {
		for (int i = 0; i < this.getPlayersSize(); i++) {
			Player cur_pla = this.players.get(i);
			String result = "";
			double accurac = cur_pla.getAccuracy();
			for (int j = 0; j < this.getShots(); j++) {
				double x = BasketballUtility.getRandomDouble();
				if (x < accurac) {
					result = result + "X";
				} else {
					result = result + "_";
				}
			}
			cur_pla.addPerformance(this, result);
		}
	}

	public void setTitle(String titl) {
		this.title = titl;
	}

	public String getTitle() {
		return this.title;
	}

	public void setShots(int shot1) {
		this.shots = shot1;
	}

	public double getShots() {
		return this.shots;
	}
}
