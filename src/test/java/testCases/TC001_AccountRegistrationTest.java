package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest  extends Baseclass
{
	
	
	@Test(groups = {"Regression","Master"})
	public void verify_Account_Registration()
	{
		logger.info("*********** starting TC001_AccountRegistrationTest *************");
		
		try {
		HomePage Hp=new HomePage(driver);
		Hp.clickMyAccount();
		
		logger.info("**********Click on MyAccountLink************");
		Hp.clickRegister();
		logger.info("**********Click on RegisterLink************");
		
		AccountRegistrationPage Ap=new AccountRegistrationPage(driver);
		
		logger.info("**********Providing Customer Details************");
		
		Ap.setFirstName(RandomString().toUpperCase());
		
		Ap.setLastName(RandomString().toUpperCase());
		
		Ap.setEmail(RandomString()+"@gmail.com");
		
		Ap.setTelephone(Randomnumber());
		
		String password=RandomAlphanumeric();
		
		Ap.setPassword(password);
		Ap.setConfirmPassword(password);
		
		Ap.setPrivacyPolicy();
		Ap.clickContinue();
		
		logger.info("**********Validating expected  message************");
		
		String confirmessage=Ap.getConfirmationMsg();
		Assert.assertEquals(confirmessage,"Your Account Has Been Created!");
		}catch(Exception e)
		{
			logger.error("test is failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		
	}
	
	
	
}
