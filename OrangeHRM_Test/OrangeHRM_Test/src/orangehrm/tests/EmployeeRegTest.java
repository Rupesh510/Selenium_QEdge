package orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.Employee;
import orangehrm.library.LoginPage;
import utils.AppUtils;

public class EmployeeRegTest extends AppUtils 
{

	@Parameters({"fname","lname"})
	@Test
	public void checkEmpReg(String fname,String lname) throws InterruptedException
	{
		
		LoginPage lp = new LoginPage();
		Employee emp = new Employee();
		lp.adminLogin("Admin", "Qedge123!@#");
		boolean res = emp.addEmployee(fname, lname);
		Assert.assertTrue(res);		
		lp.logout();
			
	}
	
	
}
