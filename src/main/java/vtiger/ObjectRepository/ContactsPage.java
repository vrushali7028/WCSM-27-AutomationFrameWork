package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
 
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactLookupImg;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	public WebElement getCreateContactLookupImg() {
		return CreateContactLookupImg;
		
	}
	
	public void clickOnContactPageLookUpImg() {
		CreateContactLookupImg.click();
	}
}
