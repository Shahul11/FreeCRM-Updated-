package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() throws InterruptedException {
		initization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(6000);

	}

	@Test(priority = 1, enabled = true)
	public void verifyHomePageTitleTest() throws InterruptedException {

		String homepageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "Home page title is not displayed");
	}

	@Test(priority = 2, enabled = true)
	public void verifyUserNameTest() {
		testUtil.swithToFrame();
		boolean flag = homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.swithToFrame();
		contactspage = homepage.verifyContactsLink();
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();
	}

}
