package polymorphism;

public class Hourly implements Employee {

	private String name;
	private double hourlyRate;

	public Hourly(String name, double hourlyRate) {
		this.name = name;
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getPaycheckAmount(double hoursWorked) {
		return this.hourlyRate * hoursWorked;
	}
	

}
