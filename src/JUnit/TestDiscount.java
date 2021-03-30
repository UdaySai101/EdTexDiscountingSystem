package JUnit;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import App.Discount;

public class TestDiscount {

	String membership1;
	String membership2;
	Discount disc;

	@Before
	public void setUp() throws Exception {

		membership1 = "Platinum";
		membership2 = "Diamond";
		disc = new Discount();

	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void testcalcDiscount() throws SQLException {

		Assert.assertEquals(28, disc.calcDiscount(membership1));

		Assert.assertEquals(21, disc.calcDiscount(membership2));

	}

}
