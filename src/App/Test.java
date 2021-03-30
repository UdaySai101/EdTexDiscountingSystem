package App;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	
	static int z = 0;

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your name!");

		String name = scanner.nextLine();

		System.out.println("Enter x (price of a product)");

		int x = scanner.nextInt();

		System.out.println("Enter y (price of second product)");

		int y = scanner.nextInt();

		System.out.println("Your total price is: Rs. " + calcTotalPrice(name, x, y));

		scanner.close();
	}
	

	public static float calcTotalPrice(String name, int x, int y) throws SQLException {

		EdTexCustomer edt = new EdTexCustomer();

		String membership = edt.getMembershipType(name);

		int totalPrice = x + y;

		Discount discount = new Discount();

		float totalDiscount = totalPrice * 0.01f * discount.calcDiscount(membership);
		
		return totalPrice + z - totalDiscount;

	}

	public void addMembershipCosts(int z) {

		Test.z = z;

	}

}
