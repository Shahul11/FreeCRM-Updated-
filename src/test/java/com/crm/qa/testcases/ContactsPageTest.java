package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	public LoginPage loginpage;
	public TestUtil testUtil;
	public HomePage homepage;
	public ContactsPage contactspage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		initization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swithToFrame();
		contactspage = homepage.verifyContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactspage.validateContactsLabel(), "Contacts Label is missing");
	}

	//@Test(priority = 2)
	public void verifySelectContactsTest() {

		contactspage.selectCheckboxContacts("Parul Sharma");
		contactspage.selectCheckboxContacts("test2 test2");
	}

	// @Test(priority = 3)
	public void selectMutlipleContactsTest() {
		contactspage.selectCheckboxContacts("Parul Sharma");
		contactspage.selectCheckboxContacts("test2 test2");
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void verifyCreateContactTest(String title, String firstname, String lastname, String companyname) {
		homepage.clickonNewContactLink();
		contactspage.createNewcontact(title, firstname, lastname, companyname);

	}

	@DataProvider()
	public  Object[][] getCRMTestData() {
		Object[][] data = testUtil.getTestData();
		return data;
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();

	}

}
