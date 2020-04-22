package stage1;

import java.util.HashMap;

public class Players {

	HashMap<String, Player> plays = new HashMap<>();

	public Players() {

	}

	public void addPlayers(Player pla) {
		this.plays.put(pla.returnName(), pla);
	}
}
