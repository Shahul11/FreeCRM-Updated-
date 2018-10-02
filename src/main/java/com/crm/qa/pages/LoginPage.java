package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase {

	// Page Factory

	@FindBy(name = "username")
	public WebElement txtusername;

	@FindBy(name = "password")
	public WebElement txtpassword;

	//@FindBy(xpath = "//input[@type='submit')]")
	
	@FindBy(xpath="//input[@type='submit']")	
	public WebElement btnLogin;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")	
	public WebElement btnLogin1;
	

	@FindBy(xpath = "//a[text()='Sign Up']")
	public WebElement linkSignUp;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')][1]")
	public WebElement crmLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public HomePage validateLogin(String name, String pwd) {
		txtusername.sendKeys(name);
		txtpassword.sendKeys(pwd);
		btnLogin1.submit();
//		JavascriptExecutor js= ((JavascriptExecutor)driver);
//		js.executeScript("arguments[0].click", "btnLogin");
//		
		
		//btnLogin.click();
		return new HomePage();
	}

	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

}
