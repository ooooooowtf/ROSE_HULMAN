import java.util.ArrayList;

/**
 *  Used to create an invoice with an invoice number and a number of items
 *  
 * @author defoe on March 29, 
 *
 */
public class Invoice {
	private int invoiceNumber;
	
	private ArrayList<Item> items;
	
	public Invoice(int number) {
		this.setInvoiceNumber(number);
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public double getTotal(){
		double total = 0;
		for (Item item : this.items) {
			total += item.getPrice();
		}
		return total;
	}
	
	@Override
	public String toString() {
		return String.format("invoice %d now has %d items", this.invoiceNumber, this.items.size());
	}
}
