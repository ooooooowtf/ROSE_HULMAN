package stage1;

/**
 * A basketball simulator. See the specification.
 *
 * @author Qishun Yu
 */
public class BasketballMain {

	/**
	 * This method sets up an instance of the BasketballMain class
	 * 
	 * @param args
	 *            - not used
	 */
	public static void main(String[] args) {
		// TODO: Solve the problem in the specification.
		// You may add any other classes you need.

		// You can use code from the BasketballUtility class if it helps.

		// Add some code, here in main() is fine,
		// to check that it works correctly.
		Contest con1 = new Contest("test1", 10);
		Player Kobe = new Player("Kobe", 0.9);
		PlayerStatistics kobeSta = new PlayerStatistics(con1, Kobe);
		kobeSta.percentage();
		kobeSta.shotinRow();
		kobeSta.hitsnMiss();
	}

}