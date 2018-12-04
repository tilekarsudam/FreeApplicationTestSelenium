package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

//	Page Factory - Object Repository(OR)
	@FindBy(how = How.NAME, using = "username")
	WebElement username;
	@FindBy(how = How.NAME, using = "password")
	WebElement password;
	@FindBy(how = How.XPATH, using = "//input[@class=\"btn btn-small\" and @type=\"submit\"]")
	WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "//font[@color=\"red\" and text()=\"Sign Up\"]")
	WebElement singUpBtn;
	@FindBy(how = How.XPATH, using = "//a[@class=\"navbar-brand\"]//img[@alt=\"free crm logo\"]")
	WebElement crmLogo;

//	Initializing the Page Factory
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

//	Verify the Title of the Page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String userName, String passWord) {
		
		username.clear();
		username.sendKeys(userName);
		password.clear();
		password.sendKeys(passWord);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
//		Commented .click(), due t0 below error
//		org.openqa.selenium.WebDriverException: unknown error: Element <input type="submit" value="Login" class="btn btn-small"> is not clickable
//		loginBtn.click();
		loginBtn.submit();
		return new HomePage();
	}

}
