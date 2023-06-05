package testng.framework.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstants{
	public WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void getDriver(String browser) throws Throwable {
		{
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty(chrome_key, chome_value);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				System.out.println(Utility.getData("Sheet1", 1, 2));
				driver.get(Utility.getData("Sheet1", 1, 2));
			}
			else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty(edge_key, edge_value);
				EdgeOptions options=new EdgeOptions();
				options.addArguments("headless");
				driver=new EdgeDriver(options);
				driver.manage().window().maximize();
				System.out.println(Utility.getData("Sheet1", 1, 2));
				driver.get(Utility.getData("Sheet1", 1, 2));}
		}
	}
	
	@AfterMethod
	public void endTest(ITestResult test) throws Throwable {
		String name = test.getMethod().getMethodName();
		int test_status = test.getStatus();
		if(test_status==2) {
			Utility.getScreenshot(driver, name);
		}
		driver.quit();
	}

}
