package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step 1 = Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:8888");
		
		//Step 2 = Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3 = Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4 = Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Step 5 = Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("VVP");
		
		//Step 6 = Select "Energy" in the industry drop down
		WebElement industrydropDown = driver.findElement(By.xpath("//select[@name='industry']"));
		Select industrySelects = new Select(industrydropDown);
		industrySelects.selectByValue("Energy");
		
		//Step 7 = Select "Customer" in the Type Drop down 
		WebElement typeDropDown = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select typeSelect = new Select(typeDropDown);
		typeSelect.selectByValue("Customer");
		
		//Step 8 = Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 9 = Verify
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains("VVP")) {
			System.out.println("...Pass...");
		}else {
			System.out.println("...Fail...");
		}
		
		//Step 10 = logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign Out Successfully");
	}

}
