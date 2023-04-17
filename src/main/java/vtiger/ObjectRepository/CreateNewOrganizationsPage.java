package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtilities.WebDriverUtility;



public class CreateNewOrganizationsPage extends WebDriverUtility {

	//Declaration
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDwn;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn ;

	 public CreateNewOrganizationsPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }


	
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropdwn() {
		return industryDropDwn;
    }
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	// Business Library
	 
	/**
	 * This method will create a new organization
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) {
		 OrgNameEdt.sendKeys(ORGNAME);
		 SaveBtn.click();

	}
	/**
	 * This method will create a new organization with industry type
	 * @param orgName
	 * @param INDUSTRY
	 */
	 public void createNewOrganization(String ORGNAME,String INDUSTRY) {
		 OrgNameEdt.sendKeys(ORGNAME);
		 handleDropdown(industryDropDwn, INDUSTRY);
		 SaveBtn.click();
	 }



}
