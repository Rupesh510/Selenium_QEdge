package orangehrm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class AdminLoginTestwithInvaliddata extends AppUtils 
{

	public String datafile="C:\\Selenium730PM\\OHRM_DDT\\testdatafiles\\TestData.xlsx";
	public String datasheet = "LoginInvalidData";
	
	@Test
	public void checkAdminLogin() throws IOException
	{
		
		int rowcount = XLUtils.getRowCount(datafile, datasheet);
		String adminuid,adminpwd;
		boolean res;
		
		LoginPage lp = new LoginPage();
		
		
		for(int i=1;i<=rowcount;i++)
		{
			adminuid = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			adminpwd = XLUtils.getStringCellData(datafile, datasheet, i, 1);
			lp.login(adminuid, adminpwd);
			res = lp.isInvalidCredentialsMsgDisplayed();
			Assert.assertTrue(res);
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
			}else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
			
		}
		
		
		
		
	}
	
	
}
