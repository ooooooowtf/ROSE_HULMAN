package polymorphism;

import java.util.Scanner;

public class DiscountMain {

	/**
	 * At a certain grocery store, products are given discounts. There are two
	 * kinds of discounts: FixedDiscounts which apply a fixed savings (e.g.
	 * $0.50 off) or PercentageDiscounts which save a percentage of the total
	 * price (e.g. 10% off). In some circumstances, many discounts can apply to
	 * the same product.
	 * 
	 * Here's a solution which given a product's name, calculates the
	 * appropriate discount. It uses classes to represent the various discounts.
	 * This code operates correctly; unfortunately, there is code duplication
	 * between the calculatePercentageDiscounts method and the
	 * calculateFixedDiscounts method, both called from getTotalDiscountString()
	 * below.
	 * 
	 * Use interfaces to remove the code duplication and create one method that
	 * can be used for both kinds of discounts.
	 * 
	 * It currently passes unit tests and should still pass them after you make
	 * your changes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// to see a situation where multiple discounts apply
		// enter a product like "Bulk Expired Eggs"
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the product name?");
		String name = scanner.nextLine();
		System.out.println("What is the normal price?");
		double price = scanner.nextDouble();

		String result = getTotalDiscountString(name, price);
		System.out.println(result);
	}

	public static String getTotalDiscountString(String name, double price) {
		Discount[] discounts = new Discount[5];

		discounts[0] = new FixedDiscount("Milk", 1);
		discounts[1] = new FixedDiscount("Eggs", 0.25);
		discounts[2] = new FixedDiscount("Engine Oil", 1.50);

		discounts[3] = new PercentageDiscount("Expired", .5);
		discounts[4] = new PercentageDiscount("Bulk", .1);

		double totalDiscount = calculateDiscounts(name, price, discounts);
		String result = "Total discounts: " + totalDiscount + "\n";
		double finalPrice = Math.max(0, price - totalDiscount);
		result += "Final price: " + finalPrice;
		return result;
	}

	private static double calculateDiscounts(String name, double price, Discount[] discounts) {
		double total = 0;
		for (Discount discount : discounts) {
			if (discount.matches(name)) {
				total += discount.calculateDiscountFor(price);
			}
		}
		return total;
	}

}
