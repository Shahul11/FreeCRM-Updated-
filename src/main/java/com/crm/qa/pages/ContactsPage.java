package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	// Page Factory

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	public WebElement lblContacts;

	@FindBy(xpath = "(//a[text()='test2 test2'])[2]/../..//input[@type='checkbox']")
	public WebElement chkboxContact;
	
	
	@FindBy(id="first_name")
	public WebElement firstName;
	
	@FindBy(id="surname")
	public WebElement lastName;
	
	@FindBy(name="client_lookup")
	public WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	public WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateContactsLabel() {
		return lblContacts.isDisplayed();
	}

	public void selectCheckboxContacts(String contactName) {
		//String path = "(//a[text()='" + contactName + "'])[2]/../..//input[@type='checkbox']";
		//driver.findElement(By.xpath(path)).click();
		
		driver.findElement(By.xpath("//a[text()='" + contactName + "']/../..//input[@type='checkbox']")).click();
		//driver.findElement(By.xpath("//a[text()='Parul Sharma']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();

	}
	
	public void createNewcontact(String titleType, String fname, String lname, String companyname)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(titleType);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(companyname);
		saveBtn.submit();
	}

}
