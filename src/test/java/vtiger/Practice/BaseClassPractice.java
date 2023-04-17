package vtiger.Practice;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;


public class BaseClassPractice {
	@BeforeSuite
	public void bsconfig()
	{
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("after suite");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("before class");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("after method");
	}
	
}
