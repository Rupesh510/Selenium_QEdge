package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMFunctions 
{

	public static WebDriver driver;
	public String expempno;
	
	@Given("^i open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url)  
	{
	    
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);	
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page() 
	{
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		  {
			  System.out.println("Application Launched Successfully");
		  }else
		  {
			  System.out.println("Application Launch Failed");
		  }
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pword) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}

	@When("^i click login$")
	public void i_click_login() 
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^i should see admin module$")
	public void i_should_see_admin_module() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
	    {
	    	System.out.println("Admin Login Successful");
	    }else
	    {
	    	System.out.println("Admin Login failed for valid data");
	    }
	}
	
	
	@When("^i click logout$")
	public void i_click_logout()  
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@When("^i close browser$")
	public void i_close_browser() 
	{
	    driver.close();
	}

	@Then("^i should see error message$")
	public void i_should_see_error_message() 
	{
		String errmsg;
		errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		if(errmsg.contains("invalid"))
		{
			System.out.println("System displayed Error message for invalid inputs, test pass");
		}
	}
	
	@When("^i click PIM$")
	public void i_click_PIM() 
	{
	    driver.findElement(By.linkText("PIM")).click();
	}

	@When("^i click Add Employee$")
	public void i_click_Add_Employee() 
	{
		driver.findElement(By.linkText("Add Employee")).click();
	}

	@Then("^i should see New Employee Registration Page$")
	public void i_should_see_New_Employee_Registration_Page()  
	{
	    String pgurl;
	    pgurl = driver.getCurrentUrl().toLowerCase();
	    if(pgurl.contains("addemployee"))
	    {
	    	System.out.println("System displayed New Employee Registration Page");
	    }
	}

	@When("^i enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);
		
	}

	@When("^i enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) 
	{
	    driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("^i click Save$")
	public void i_click_Save() 
	{
	    expempno = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	    
	}

	@Then("^i should see Employee Registered Successfully$")
	public void i_should_see_Employee_Registered_Successfully()
	{
		String actempno;
		actempno = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		if(expempno.equalsIgnoreCase(actempno))
		{
			System.out.println("New Employee Registered Successfully");
		}		
	}
	
}
