package orangehrm.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AppUtils;

public class Employee extends AppUtils
{

	
	public boolean addEmployee(String fname,String lname) throws InterruptedException
	{
		
		String expval;
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		expval = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(expval);
		driver.findElement(By.id("searchBtn")).click();
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("resultTable"))));
		
		WebElement resulttable;
		resulttable = driver.findElement(By.id("resultTable"));
		
		List<WebElement> rows = resulttable.findElements(By.tagName("tr"));
		List<WebElement> cols = rows.get(1).findElements(By.tagName("td"));
		String actval = cols.get(1).getText();
		if(expval.equals(actval))
		{
			return true;
		}else
		{
			return false;
		}
		
		
	}
	
	
	
	
}
