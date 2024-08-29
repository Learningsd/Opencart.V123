package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest  extends Baseclass
{

	@Test(groups = {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("******Starting TC002_LoginTest **********");
		
		//HOMEPAGE
		try {
		HomePage Hp=new HomePage(driver);
		logger.info("********Click on MyAccount**********");
		Hp.clickMyAccount();
		logger.info("********Click on Login**********");
		Hp.clickLogin();
		
		//LOGINPAGE
		logger.info("********Enter valid credentials**********");
		LoginPage Lp=new LoginPage(driver);
		Lp.setEmail(p.getProperty("email"));
		Lp.setPassword(p.getProperty("password"));
		Lp.clickLogin();
		
		//MYACCOUNT
		logger.info("********Login to MyaccounPage**********");
		MyAccountPage MAp=new MyAccountPage(driver);
		
		boolean TargetPAge = MAp.isMyAccountPageExists();
		
		//Assert.assertEquals(TargetPAge, true, "Login Failed");
		
		Assert.assertTrue(TargetPAge, "Login failed");
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******finished TC002_LoginTest **********");
		
		
	}
	
}
