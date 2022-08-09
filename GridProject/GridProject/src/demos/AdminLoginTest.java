package demos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminLoginTest 
{

	@Parameters({"browser"})
	@Test
	public void checkAdminLogin(String br) throws MalformedURLException
	{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		switch (br.toLowerCase()) 
		{
		case "firefox":
			cap.setBrowserName("firefox");
			break;
		case "chrome":
			cap.setBrowserName("chrome");
			break;
		case "safari":
			cap.setBrowserName("safari");
			break;
		default:
			System.out.println("Browser not found!");	
			break;
		}
		
		
		URL huburl = new URL("http://192.168.1.160:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(huburl, cap); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys("Samyuktha");
		driver.findElement(By.id("lastName")).sendKeys("demo");
		driver.findElement(By.id("btnSave")).click();
	}
	
	
	
	
	
	
}
