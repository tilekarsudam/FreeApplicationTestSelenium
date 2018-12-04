package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LogoutPage extends TestBase {

	@FindBy(xpath = "//i[@class='fa fa-sign-out icon-2x']")
	WebElement logoutfromApplication;

//	Initializing the Page Factory

	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

	public void logoutFromApplication() {
		logoutfromApplication.click();
	}

}
