package polymorphism;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeMainTest {
	@Test
	public void test() {
		
		String expected;
		
		expected = "Employee name:    Hourly Jones,	amount: $  250.00";
		assertTrue(EmployeeMain.getWeeklyPayReport().contains(expected));

		expected = "Employee name:    Salary Smith,	amount: $1,346.15";
		assertTrue(EmployeeMain.getWeeklyPayReport().contains(expected));

		expected = "Employee name:      Bob Hourly,	amount: $  225.00";
		assertTrue(EmployeeMain.getWeeklyPayReport().contains(expected));
		
		expected = "Employee name:    Susan Salary,	amount: $1,923.08";
		assertTrue(EmployeeMain.getWeeklyPayReport().contains(expected));
		
	}

}
