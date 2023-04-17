package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String data = pUtil.readDataFromPropertyFile("browser");
		System.out.println(data);

		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Organization", 1, 2);
		System.out.println(value);

		eUtil.writeIntoExcel("Organization", 10, 7, value);
		System.out.println("data added");

		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateInFormat());
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.maximizeWindow(driver);;
		Thread.sleep(2000);
		wUtil.minimizeWindow(driver);
	}

}
