package testng.framework.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility implements AutoConstants {

	public static void getScreenshot(WebDriver driver, String name) throws Throwable {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshot_path + name + screenshot_file_extension);
		FileUtils.copyFile(src, dest);
	}

	public static String getData(String sheetName, int row, int column) throws Throwable {
		FileInputStream fis = new FileInputStream(excel_path);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return value;
	}
	
	public static void waittoLoadElemet(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void escapeKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
}
