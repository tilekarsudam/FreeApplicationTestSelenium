package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(name = "title")
	WebElement TitleDropdown;
	@FindBy(name = "first_name")
	WebElement firstName;
	@FindBy(id = "surname")
	WebElement lastName;
	@FindBy(name = "client_lookup")
	WebElement company;
	@FindBy(xpath = "//form//input[@type='submit' and @class='button' and @value='Save']")
	WebElement saveNewContacts;
	@FindBy(xpath = "//a[contains(@href,'Doctor1 Doctor1')]/i[@title='Edit']")
	WebElement UpdateNewContacts;
	@FindBy(xpath = "//input[@name='client_lookup']/following-sibling::input[@type='button']")
	WebElement updateCompanyLookupValue;
	@FindBy(xpath = "//a[contains(@href,'Doctor1 Doctor1')]/i[@title='Delete']")
	WebElement deleteNewContacts;
	@FindBy(id = "search")
	static WebElement searchCompany;
	@FindBy(xpath = "//input[@type='submit' and @class='button']")
	static WebElement searchCompanyButton;
	@FindBy(xpath = "//a[text()='HealthCricket']")
	static WebElement selectCompany;
	@FindBy(xpath = "//a[@_name='HealthCricket']")
	WebElement updatedCompanyName;

	public ContactsPage() {

		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactsLabel() {

		return contactsLabel.isDisplayed();

	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='" + name
				+ "']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"))
				.click();
	}

	public void createNewContacts(String Title, String FirstName, String LastName, String Company) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Select select = new Select(TitleDropdown);
		select.selectByVisibleText(Title);

		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		company.sendKeys(Company);

	}

	public void saveNewContacts() {
		saveNewContacts.click();

	}

	public void updateAddedContacts() {
		UpdateNewContacts.click();
		Assert.assertEquals(
				driver.findElement(By.xpath("//legend[@class='fieldset' and text()='Contact Information']")),
				"Contact Information");
		updateCompanyLookupValue.click();

		Set<String> handler = driver.getWindowHandles();
		Iterator<String> iterator = handler.iterator();
		String ParentWindow = iterator.next();
		System.out.println("Parent Window ID is: " + ParentWindow);
		String ChildWindow = iterator.next();
		System.out.println("Child Window ID is: " + ChildWindow);

		driver.switchTo().window(ChildWindow);
		searchCompany.sendKeys("HelthCricket");
		searchCompanyButton.click();
		selectCompany.click();
		driver.switchTo().window(ParentWindow);

		saveNewContacts.click();
		
		Assert.assertEquals("	HealthCricket  ", updatedCompanyName);

	}

	public void deleteNewContacts() {
		deleteNewContacts.click();
	}
}
