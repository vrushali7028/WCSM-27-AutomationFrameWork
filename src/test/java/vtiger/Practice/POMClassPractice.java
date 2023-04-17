package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMClassPractice {
      public static void main(String[] args) {
	     WebDriverManager.firefoxdriver().setup();
	     WebDriver driver = new FirefoxDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     driver.get("http://localhost:8888");
	     
	     LoginPage lp = new LoginPage(driver);
	     lp.getUsernameEdt().sendKeys("admin");
	     lp.getPasswordEdt().sendKeys("admin");
	     lp.getSubmitBtn().click();
    }
}
