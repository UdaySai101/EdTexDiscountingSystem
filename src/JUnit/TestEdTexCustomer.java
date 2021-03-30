package JUnit;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import App.EdTexCustomer;

public class TestEdTexCustomer {

	 EdTexCustomer edc;
	String name1;
	String name2;

	@Before
	public void setUp() throws Exception {

		edc = new EdTexCustomer();
		name1 = "fhfeghre";
		name2 = "Hemanth";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() throws SQLException {

		System.setIn(new ByteArrayInputStream("no".getBytes()));

		Assert.assertEquals("None", edc.getMembershipType(name1));
		
		Assert.assertEquals("Platinum", edc.getMembershipType(name2));
	}

}
