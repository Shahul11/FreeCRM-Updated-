package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		
	}

	@BeforeMethod()
	public void setUp() {
		initization();
		loginpage = new LoginPage();

	}

	//@Test(priority=1,enabled=true)
	public void verifyLoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	//@Test(priority=2, enabled=true)
	public void verifyCRMLogoTest() {
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyLoginTest()
	{
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
	}
}
