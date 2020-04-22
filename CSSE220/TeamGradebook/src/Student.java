import java.util.ArrayList;

public class Student {
	private String name;
	private int absence;
	private ArrayList<Double> scores;

	/**
	 * makes a new student object
	 * 
	 * @param newName
	 *            the name of the student
	 */

	public Student(String newName) {
		// TODO: initialize fields here
		this.name = newName;
		this.scores = new ArrayList<>();
		this.absence = 0;
	}

	/**
	 * gets the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {

		return this.name;
	}

	public void addAbsence() {
		this.absence += 1;
	}

	public int getAbsence() {
		return this.absence;
	}

	public void addScore(double score) {
		this.scores.add(score);
	}

	public ArrayList<Double> getScore() {
		return this.scores;
	}

	public String avScore() {
		double total = 0.0;
		int count = this.scores.size();
		for (double value : this.scores) {
			total += value;
		}
		return Long.toString(Math.round(total) / count);
	}

	// TODO: You'll need to add some new methods here
}
