package orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage 
{

	
	@FindBy(linkText="Admin")
	WebElement adminlink;
	
	@FindBy(partialLinkText="Welcome")
	WebElement welcomelink;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public boolean isAdminModuleDisplayed()
	{
		if(adminlink.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public void logout()
	{
		welcomelink.click();
		logout.click();
	}
	
	
}
