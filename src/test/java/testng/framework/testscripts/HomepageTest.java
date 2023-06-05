package testng.framework.testscripts;

import org.testng.annotations.Test;

import testng.framework.generic.BaseTest;
import testng.framework.generic.Utility;
import testng.framework.pom.HomePage;

public class HomepageTest extends BaseTest{
	
	@Test
	public void googleFlightTest() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.enterFrom();
		hp.enterTo();
		hp.enterFromDate();
		hp.enterToDate();
		hp.exploreFlights();
		hp.getcustomList();
	}

}
