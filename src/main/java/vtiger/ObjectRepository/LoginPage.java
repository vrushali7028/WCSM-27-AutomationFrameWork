package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1: create separate POM class for every web page
	
	//Rule 2: Identify all the webElements using annotation
	@FindBy(name="user_name")
	private WebElement UsernameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	 
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@input='submit']")})
	private WebElement SubmitBtn;
    
	//Rule 3: Initialize these web elements with a constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to access these elements
	public WebElement getUsernameEdt() {
		return UsernameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Library-Generic Method-Project Specific
	/**
	 * This method will login to Application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD) {
		UsernameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
		
	}
	
}
