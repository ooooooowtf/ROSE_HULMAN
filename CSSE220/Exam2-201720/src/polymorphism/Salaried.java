package polymorphism;

public class Salaried {

	private static final int NUM_WEEKS_IN_YEAR = 52;
	
	private String name;
	private double salary;

	public Salaried(String name, double salary) {
		this.name = name;
		this.salary = salary;
		
	}

	public String getName() {
		return this.name;
		
	}

	public double getPaycheckAmount(double hoursWorked) {
		return this.salary / NUM_WEEKS_IN_YEAR;
	}
	
	
}
