package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step 1 = Launch Browser
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\patil\\Desktop\\Java\\selenium_jars\\Edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:8888");
		
		//Step 2 = Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3 = Navigate to Contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4 = Click on Create contact look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 5 = Create Contact with Mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("CVV");
		
		//Step 6 = Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7 = Verify
		String dvHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (dvHeader.contains("CVV")) {
			System.out.println(dvHeader+ "...Pass...");
		}else {
			System.out.println("...Fail...");
		}
		//Step 8 = logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign Out Successfully");
	}

}
