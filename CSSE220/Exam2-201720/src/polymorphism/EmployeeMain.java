package polymorphism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeMain {

	/**
	 * A company needs to track payments for two types of Employees:
	 * Salaried and Hourly. Salaried employees have a specific annual salary
	 * that they are paid, regardless of the number of hours they work each 
	 * week. Hourly employees are paid by an hourly rate, and their pay depends
	 * on the hours worked.
	 * 
	 * Here's a solution which given a list of employees creates a report
	 * showing the pay for all current employees. The order of the employees
	 * in the report is not important.
	 * 
	 * Use interfaces to remove the code duplication and create one method that
	 * can be used for both kinds of employees.
	 * 
	 * It currently passes unit tests and should still pass them after you make
	 * your changes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getWeeklyPayReport());
	}

	public static String getWeeklyPayReport() {
		String result = getHourlyEmployeeReport();
		result += getSalariedEmployeeReport();
		return result;
	}
	public static String getHourlyEmployeeReport() {
		ArrayList<Hourly> hourly = new ArrayList<Hourly>();
		hourly.add(new Hourly("Hourly Jones", 10.0));
		hourly.add(new Hourly("Bob Hourly", 15.0));
		
		HashMap<Hourly, Double> hoursWorkedByEmployee = new HashMap<Hourly, Double>();
		hoursWorkedByEmployee.put(hourly.get(0), 25.0);
		hoursWorkedByEmployee.put(hourly.get(1), 15.0);
		
		String result = "";
		for (Hourly e : hourly) {
			result += String.format("Employee name: %15s,\t", e.getName());
			result += "amount: " + String.format("$%,8.2f\n", e.getPaycheckAmount(hoursWorkedByEmployee.get(e)));
		}
		return result;
	}
	public static String getSalariedEmployeeReport() {
		ArrayList<Salaried> salaried = new ArrayList<Salaried>();
		salaried.add(new Salaried("Salary Smith", 70000.0));
		salaried.add(new Salaried("Susan Salary", 100000.0));
		
		HashMap<Salaried, Double> hoursWorkedByEmployee = new HashMap<Salaried, Double>();
		
		hoursWorkedByEmployee.put(salaried.get(0), 42.0);
		hoursWorkedByEmployee.put(salaried.get(1), 38.0);
			
		String result = "";
		for (Salaried e : salaried) {
			result += String.format("Employee name: %15s,\t", e.getName());
			result += "amount: " + String.format("$%,8.2f\n", e.getPaycheckAmount(hoursWorkedByEmployee.get(e)));
		}
		return result;
	}


}
