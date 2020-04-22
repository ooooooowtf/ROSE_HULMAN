package polymorphism;

public class Hourly  {

	private String name;
	private double hourlyRate;

	public Hourly(String name, double hourlyRate) {
		this.name = name;
		this.hourlyRate = hourlyRate;
	}
	
	public String getName() {
		return this.name;
	}

	public double getPaycheckAmount(double hoursWorked) {
		return this.hourlyRate * hoursWorked;
	}
	

}
