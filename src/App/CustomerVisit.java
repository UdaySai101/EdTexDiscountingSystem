package App;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerVisit {

	static int membershipFee = 0;

	public String register(Scanner scanner, Connection conn, String name) throws SQLException {

		System.out.println("Select Membership Plan: \nPlatinum - Rs. 500 or Diamond - Rs. 350?");

		String selected = scanner.nextLine();

		while (!selected.toLowerCase().equals("platinum") && !selected.toLowerCase().equals("diamond")) {

			System.out.println("Invalid Entry! Please choose between Platinum or Diamond.");

			selected = scanner.nextLine();
		}

		addMembership(name, selected, conn);

		if (selected.toLowerCase().equals("platinum")) {

			membershipFee = 500;

		}

		else if (selected.toLowerCase().equals("diamond")) {

			membershipFee = 350;

		}

		passmembershipCosts();

		return selected;

	}

	public static void addMembership(String name, String selected, Connection conn) throws SQLException {

		Statement st = null;

		try {
			st = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String query = "insert into EdTexCustomer values ('" + name + "','" + selected + "');";

		try {
			st.executeQuery(query);
		} catch (Exception e) {
		}

	}

	public static void passmembershipCosts() {

		Test test = new Test();

		test.addMembershipCosts(membershipFee);

	}

}
