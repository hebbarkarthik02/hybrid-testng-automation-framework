package testng.framework.pom;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testng.framework.generic.BasePage;
import testng.framework.generic.Utility;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@class='II2One j0Ppje zmMKJ LbIaRd'])[1]")
	private WebElement fromTextbox;
	
	@FindBy(xpath = "(//input[@class='II2One j0Ppje zmMKJ LbIaRd'])[3]")
	private WebElement toTextbox;
	
	@FindBy(xpath = "(//input[@type='text'])[5]")
	private WebElement fromDate;
	
	@FindBy(xpath = "(//input[@type='text'])[6]")
	private WebElement toDate;
	
	@FindBy(xpath = "(//span[text()='Done'])[2]")
	private WebElement doneButtonDate;
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement exploreButton;
	
	@FindBy(xpath = "(//li[contains(@aria-label, 'Mumbai')])[1]")
	private WebElement exactTo;
	
	@FindBy(xpath = "(//li[contains(@aria-label, 'Bengaluru')])[1]")
	private WebElement exactFrom;
	
	public void enterFrom() throws Throwable {
		fromTextbox.clear();
		fromTextbox.sendKeys(Utility.getData("Sheet1", 1, 3));
		Utility.waittoLoadElemet(driver, exactFrom);
		exactFrom.click();
	}
	
	public void enterTo() throws Throwable {
		toTextbox.clear();
		toTextbox.sendKeys(Utility.getData("Sheet1", 1, 4));
		Utility.waittoLoadElemet(driver, exactTo);
		exactTo.click();
	}
	
	public void enterFromDate() throws Throwable {
		fromDate.clear();
		fromDate.sendKeys(Utility.getData("Sheet1", 1, 5));
//		doneButtonDate.click();
	}
	
	public void enterToDate() throws Throwable {
		toDate.clear();
		toDate.sendKeys(Utility.getData("Sheet1", 1, 6));
//		doneButtonDate.click();
	}
	
	public void exploreFlights() {
		exploreButton.click();
	}
	
	@FindBy(xpath = "(//div[@class='BVAVmf I11szd POX3ye'])//span[contains(text(),'₹')]")
	private List<WebElement> priceListofFlights;
	
	public void getcustomList() {
		int count = 0;
		for (WebElement webElement : priceListofFlights) {
			String text = webElement.getText();
			System.out.println(text);
			String rupees = text.substring(1);
			String price = rupees.replace(",", "");
			int intprice = Integer.parseInt(price);
			if(intprice<=5000) {
				count=count+1;
				}
			}
		System.out.println(count);
		}
	}


