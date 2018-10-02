package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	/*
	 * @FindBy(xpath = "//td[contains(text(),'immor')]") public WebElement
	 * lableUserName;
	 */

	@FindBy(xpath = "//td[contains(text(),'User: immortal gf ')]")
	public WebElement lableUserName;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	public WebElement linkContacts;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	public WebElement linkDeals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	public WebElement linktasks;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	public WebElement newContact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCorrectUserName() {
		return lableUserName.isDisplayed();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage verifyContactsLink() {
		linkContacts.click();
		return new ContactsPage();
	}

	public DealsPage verifyDealsLink() {
		linkDeals.click();
		return new DealsPage();
	}

	public TasksPage verifyTasksLink() {
		linktasks.click();
		return new TasksPage();
	}
	
	
	
	public void clickonNewContactLink()
	{
		Actions act= new Actions(driver);
		act.moveToElement(linkContacts).build().perform();
		newContact.click();
	}

	
}
