package polymorphism;

public interface Discount {
	public double calculateDiscountFor(double price);
	public boolean matches(String itemName);
}
