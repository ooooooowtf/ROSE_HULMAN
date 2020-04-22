package stage1;

import java.util.HashMap;

public class Contests {
	HashMap<String, Contest> conts = new HashMap<>();

	public Contests() {

	}

	public void addContest(Contest con) {
		this.conts.put(con.returnTitle(), con);
	}

}
