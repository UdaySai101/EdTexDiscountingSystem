package App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EdTexCustomer {

	public String getMembershipType(String name) throws SQLException {

		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		String connectionUrl = "jdbc:sqlserver://192.168.0.99:8022;database=EdTex;user=phhunter;password=udaysai101;encrypt=true;trustServerCertificate=true;";

		Connection conn = DriverManager.getConnection(connectionUrl);

		Statement st = conn.createStatement();

		String query = "select membership from EdTexCustomer where Name like '" + name + "'";

		ResultSet rset = st.executeQuery(query);

		if (rset.next()) {

			String membership = rset.getString(1);

			conn.close();

			return membership;

		}

		System.out.println("You're not a registered customer.. Do you want to register?");

		Scanner scanner = new Scanner(System.in);

		String regornot = scanner.nextLine();

		while (!regornot.toLowerCase().equals("yes") && !regornot.toLowerCase().equals("no")) {

			System.out.println("Invalid entry.. Please enter Yes or No!");

			regornot = scanner.nextLine();

		}

		if (regornot.toLowerCase().equals("yes")) {

			CustomerVisit customerVisit = new CustomerVisit();

			return customerVisit.register(scanner, conn, name);

		}

		scanner.close();

		return "None";

	}

}
