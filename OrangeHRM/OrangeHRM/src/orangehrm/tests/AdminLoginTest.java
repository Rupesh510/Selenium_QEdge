package orangehrm.tests;

import orangehrm.library.LoginPage;
import utils.AppUtils;

public class AdminLoginTest 
{

	public static void main(String[] args) 
	{
		
		AppUtils.launchApp("http://orangehrm.qedgetech.com");
		
		LoginPage lp = new LoginPage();
		boolean res = lp.adminLogin("Admin", "Qedge123!@#");
		if(res)
		{
			System.out.println("Admin Login Test Pass");
			lp.logout();
		}else
		{
			System.out.println("Admin Login Test Fail");
		}
		AppUtils.closeApp();		

	}

}
