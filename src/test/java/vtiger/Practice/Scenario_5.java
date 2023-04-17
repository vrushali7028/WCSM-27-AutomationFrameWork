package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario_5 {

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
		
		//Step 3 = Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4 = Click on Create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5 = Create contact with mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("VIP");
		
		//Step 6 = Select the Organization from organization look up image
		driver.findElement(By.xpath("//img[@onclick='return window.open(\"index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=3\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0\");']")).click();
		driver.findElement(By.xpath("//a[text()='vrus']")).click();
		
		
		//Step 7 = Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8 = verify
	    String dvHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (dvHeader.contains("VIP")) {
			System.out.println("...Pass...");
		}else {
			System.out.println("...Fail...");
		}
		
		//logout of application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign Out Successfully");

	}

}
