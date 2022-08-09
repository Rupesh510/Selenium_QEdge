package orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{

	//Define Elements
	
	@FindBy(id="txtUsername")
	WebElement uid;
	
	@FindBy(name="txtPassword")
	WebElement pwd;
	
	@FindBy(xpath="//*[@value='LOGIN']")
	WebElement login;
	
	
	//Define Methods
	
	public void login(String uname,String pword)
	{
		uid.sendKeys(uname);
		pwd.sendKeys(pword);
		login.click();		
	}
	
	
	
	
}
