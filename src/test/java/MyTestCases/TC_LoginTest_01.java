package MyTestCases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import MyPageObjects.LoginPage;

//Run all
public class TC_LoginTest_01 extends BaseClass{
	@Test // Test case should contains only test methods and nothing else
	public void loginTest() throws InterruptedException{
		Logger logger;
		logger = LogManager.getLogger(TC_LoginTest_01.class);

		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name entered successfully");
		lp.setPassword(password);
		logger.info("Password is entered successfully");
		lp.clickSubmit();
		lp.AddtocartSubmit();
		lp.ShoppingSubmit();
		lp.CheckoutSubmit();
		lp.setFirstName(firstname);
		logger.info("First name entered successfully");
		lp.setLastName(lastname);
		logger.info("Last name entered successfully");
		lp.setPostalCode(postalcode);
		logger.info("Postal Code entered successfully");
		lp.ContinueSubmit();
		lp.FinishSubmit();
		logger.info("Shopping Done");
		//lp.clickSubmit(mobileno);
		//logger.info("Mobile No is entered successfully");
		if(driver.getTitle().toString().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Log in was successful");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Log in was not successfull");
		}
	}

}