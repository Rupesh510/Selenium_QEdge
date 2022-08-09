package orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;

public class AdminLoginTest extends AppUtils 
{

	@Parameters({"uname","pword"})
	@Test
	public void checkAdminLogin(String uid,String pwd)
	{
		
		LoginPage lp = new LoginPage();
		boolean res = lp.adminLogin(uid, pwd);
		Assert.assertTrue(res);
		lp.logout();	 
	}
		
	
}
