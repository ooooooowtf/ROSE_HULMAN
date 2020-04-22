package polymorphism;

public class FixedDiscount implements Discount {

	private String partialName;
	private double savings;

	/**
	 * Create a new fixed discount for a given name
	 * 
	 * @param name
	 * @param savings
	 */
	public FixedDiscount(String partialName, double savings) {
		this.partialName = partialName;
		this.savings = savings;
	}
	
	public double calculateDiscountFor(double price) {
		return this.savings;
	}

	public boolean matches(String itemName) {
		return itemName.contains(this.partialName);
	}

}
