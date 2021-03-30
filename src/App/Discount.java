package App;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Discount {

	static int flatDisc = 14;

	public int calcDiscount(String membership) throws SQLException {
		
		
		if(membership.equals("None")) {
			
			return flatDisc;
		}
		
try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		String connectionUrl = "jdbc:sqlserver://192.168.0.99:8022;database=EdTex;user=phhunter;password=udaysai101;encrypt=true;trustServerCertificate=true;";

		Connection conn = DriverManager.getConnection(connectionUrl);

		Statement st = conn.createStatement();
		
		String query = "select Discount from EdTexDiscount where Membership like '"+membership+"'";

		ResultSet rset = st.executeQuery(query);
		
		rset.next();
		
		return flatDisc + rset.getInt(1);
	}

	// incase the flat discount needs changing
	public void setFlatDisc(int flatDisc) {
		Discount.flatDisc = flatDisc;
	}

}
