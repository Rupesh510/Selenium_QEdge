package orangehrm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class AdminLoginTestwithValiddata extends AppUtils
{

	public String datafile="C:\\Selenium730PM\\OHRM_DDT\\testdatafiles\\TestData.xlsx";
	public String datasheet = "LoginValidData";
	
	@Test
	public void checkAdminLogin() throws IOException
	{
		String adminuid,adminpwd;
		int rowcount;
		boolean res;
		rowcount = XLUtils.getRowCount(datafile, datasheet);
		
		LoginPage lp = new LoginPage();
		for(int i=1 ; i<=rowcount; i++)
		{
			adminuid = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			adminpwd = XLUtils.getStringCellData(datafile, datasheet, i, 1);
			lp.login(adminuid, adminpwd);
			res = lp.isAdminModuleDisplayed();
			Assert.assertTrue(res);
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
				lp.logout();
			}else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
		}	
		
	}
	
	
	
}
