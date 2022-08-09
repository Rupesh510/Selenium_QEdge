package orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import orangehrm.library.Employee;
import orangehrm.library.LoginPage;
import orangehrm.library.User;
import utils.AppUtils;
import utils.XLUtils;

public class OrangeHRMTestSuite extends AppUtils
{

	
	String keywordfile ="C:\\Selenium730PM\\OHRM_Hybrid\\keywordfiles\\OrangeHRMKeywords.xlsx";
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	
	@Test
	public void orangeHRM_Test() throws IOException, InterruptedException
	{
		
		LoginPage lp = new LoginPage();
		Employee emp = new Employee();
		User us = new User();
		
		
		
		String adminuid,adminpwd;
		String fname,lname;
		String role,empname,uname,pword;
		String empuid,emppwd;
		
		boolean res=false;
		
		int tccount,tscount;		
		tccount = XLUtils.getRowCount(keywordfile, tcsheet);
		tscount = XLUtils.getRowCount(keywordfile, tssheet);
		
		String tcid,tcexeflag,tstcid,keyword;
		String tsres,tcres;
		
		for(int i=1;i<=tccount;i++)
		{
			
			tcexeflag = XLUtils.getStringCellData(keywordfile, tcsheet, i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				tcid = XLUtils.getStringCellData(keywordfile, tcsheet, i, 0);
				for(int j=1;j<=tscount;j++)
				{
					tstcid = XLUtils.getStringCellData(keywordfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword = XLUtils.getStringCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
							adminuid = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							adminpwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							lp.login(adminuid, adminpwd);
							res = lp.isAdminModuleDisplayed();
							break;
						case "adminlogout":
							res = lp.logout();
							break;
						case "newempreg":
							fname = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							lname = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							res = emp.addEmployee(fname, lname);
							break;
						case "newuserreg":
							role = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							empname = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							uname = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
							pword = XLUtils.getStringCellData(keywordfile, tssheet, j, 8);
							res = us.addUser(role, empname, uname, pword);
							break;
						case "emplogin":
							empuid = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							emppwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							lp.login(empuid, emppwd);
							res = lp.isEmployeeModuleDisplayed();
							break;
						case "emplogout":
							res = lp.logout();
							break;
						}
						if(res)
						{
							tsres = "Pass";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, tsres);
							XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						}else
						{
							tsres = "Fail";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, tsres);
							XLUtils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						
						// Code toupdate TestCase Result
						tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(!tcres.equalsIgnoreCase("fail"))
						{
							XLUtils.setCellData(keywordfile, tcsheet, i, 3, tsres);
						}
						tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(tcres.equalsIgnoreCase("pass"))
						{
							XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
						}else
						{
							XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
						
						
					}
				}
			}else
			{
				XLUtils.setCellData(keywordfile, tcsheet, i, 3, "Blocked");
				XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
			}
		}
		
		
	}
	
	
	
	
}
