package JUnit;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import App.CustomerVisit;

public class TestCustomerVisit {

	static Scanner scanner;
	static Connection conn;
	static String name;
	static CustomerVisit cv;

	@Before
	public void setUp() throws Exception {

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		String connectionUrl = "jdbc:sqlserver://192.168.0.99:8022;database=EdTex;user=phhunter;password=udaysai101;encrypt=true;trustServerCertificate=true;";

		conn = DriverManager.getConnection(connectionUrl);
		System.setIn(new ByteArrayInputStream("platinum".getBytes()));
		scanner = new Scanner(System.in);

		 byte[] array = new byte[7]; // length is bounded by 7
		    new Random().nextBytes(array);
		    name = new String(array, Charset.forName("UTF-8"));


		cv = new CustomerVisit();
	}

	@After
	public void tearDown() throws Exception {
		scanner.close();
	}

	@Test
	public void test() throws SQLException {

		

		Assert.assertEquals("platinum", cv.register(scanner, conn, name).toLowerCase());
	}

}
