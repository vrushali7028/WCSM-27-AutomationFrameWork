package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Read all the necessary Data\
		/*Rear the data from property file*/
	    FileInputStream fis = new FileInputStream("\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("brower");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		Random r = new Random();
		int value = r.nextInt(1000);
		
		/*Read the data from excel sheet*/
		FileInputStream fise = new FileInputStream("\\src\\test\\resources\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+value;
		
		WebDriver driver = null;
		
		//Step 1 = Launch Browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser Name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		
		//Step 2 = Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3 = Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4 = Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 5 = Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		
		//Step 6 = Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 7 = Verify
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader+ "...Pass...");
		}else {
			System.out.println(orgHeader+ "...Fail...");
		}
			
		//Step 8 = logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign Out Successfully");
	}

}
