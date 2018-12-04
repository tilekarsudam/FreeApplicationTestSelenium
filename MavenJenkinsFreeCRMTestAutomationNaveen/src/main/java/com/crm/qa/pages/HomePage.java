package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Sudam Tilekar')]")
//	@CacheLookup
	WebElement userNameLabel;
	@FindBy(xpath = "//td[contains(text(),'CRMPRO') and @class='logo_text']")
	WebElement HomePageLogo;
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsLink;
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement taskLink;
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContactsLink;
	
	

//Initialization
	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

//	Navigate to Contacts Page
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();

	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();

	}

	public TasksPage clickOnTasksLink() {
		contactsLink.click();
		return new TasksPage();

	}

	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();

	}

}
