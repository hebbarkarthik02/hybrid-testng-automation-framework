package testng.framework.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void titlewait(String title) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleIs(title));
			Reporter.log("title of the page is matching");
		} catch (Exception e) {
			Reporter.log("title of the page is not matching");
			Assert.fail();
		}
	}
	
	public void elementVisibility(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Webelement is visible");
		} catch (Exception e) {
			Reporter.log("Webelement is not visible");
			Assert.fail();
		}
	}
}
