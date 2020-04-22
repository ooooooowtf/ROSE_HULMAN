/**
 * An item has a number, price, and description.
 * Items will be added to invoices.
 * 
 * @author defoe on March 29, 2016
 *
 */
public class Item {
	private int itemNumber;
	private double price;
	private String description;
	
	public Item(int number, double price, String description) {
		this.setItemNumber(number);
		this.setPrice(price);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int intemNumber) {
		this.itemNumber = intemNumber;
	}
}
