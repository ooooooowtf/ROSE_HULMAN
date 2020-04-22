import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Student> studs;
	private ArrayList<Double> teamAv;

	public Team(String teamName) {
		this.name = teamName;
		this.studs = new ArrayList<>();
		this.teamAv = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void addStudents(ArrayList<Student> stu) {
		this.studs = stu;
	}

	public void addScore(double scorein) {
		for (int i = 0; i < this.studs.size(); i++) {
			this.studs.get(i).addScore(scorein);
		}
		this.teamAv.add(scorein);
	}

	public double avScore() {
		double total = 0;
		for (int i = 0; i < this.teamAv.size(); i++) {
			total += this.teamAv.get(i);
		}
		return total / this.teamAv.size();
	}

	// You'll need to add methods, constructors and fields here

}
