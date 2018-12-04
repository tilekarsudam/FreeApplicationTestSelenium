package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	String sheetName = "contacts";
	String deleteCell = "deleteContacts";

	public ContactsPageTest() {

		super();
	}

	@BeforeClass
	public void setup() throws Throwable {
		initialization();
		Thread.sleep(2000);
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();

	}

	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on page");
	}

//	Select Single Checkboxes
	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContacts("test2 test2");
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

//	Select Multiple Checkboxes

	@Test(priority = 3)
	public void selectMultiplsContactsTest() {
		contactsPage.selectContacts("test2 test2");
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;

	}

//	Working Code
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContacts(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContacts(title, firstName, lastName, company);
		contactsPage.saveNewContacts();

	}

////	Pass Singel Contacts
//	@Test(priority = 4)
//	public void validateCreateNewContacts() {
//		homePage.clickOnNewContactsLink();
//		contactsPage.createNewContacts("Dr.", "Doctor1", "Doctor1", "Health");
//		contactsPage.saveNewContacts();
//
//	}

//See the Created Contacts in Contacts List
	@Test(priority = 5)
	public void clickOnContactsTab() {
		homePage.clickOnContactsLink();
		contactsPage.verifyContactsLabel();
		Assert.assertTrue(true);

	}

//		Update Company for added Contact 
	@Test(priority = 6)
	public void UpdateAddedContactCompany() {
		contactsPage.updateAddedContacts();
		
		
	}
	
	
////	Input Data for Delete Contact
//	@DataProvider
//	public Object[][] getCRMTestDataDelete() {
//		Object[][] data = testUtil.getTestData(deleteCell);
//		return data;
//	}

////	Delete added contacts
//	@Test(priority = 6, dataProvider = "getCRMTestDataDelete")
//	public void deleteCreatedNewContacts(String title, String firstName, String lastName, String company) {
////		contactsPage.selectContacts("Doctor1 Doctor1");
//		String name = firstName + " " + lastName;
//		contactsPage.selectContacts(name);
//		contactsPage.deleteNewContacts();
//		testUtil.alertAccept();
//	}

	@AfterClass
	public void tearDown() {
//		driver.quit();
	}

}
