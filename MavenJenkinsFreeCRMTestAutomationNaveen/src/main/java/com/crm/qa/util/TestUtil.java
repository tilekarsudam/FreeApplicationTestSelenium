package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEET_PATH = "G:\\Automation\\WorkSpace-Eclipse-FW\\MavenJenkinsFreeCRMTestAutomationNaveen\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}
//		Temporary Not using added code in ContactPage.java
//	public static void windowsHandler() {
//		Set<String> handler = driver.getWindowHandles();
//		Iterator<String> iterator = handler.iterator();
//		String ParentWindow = iterator.next();
//		System.out.println("Parent Window ID is: " +ParentWindow);
//		String ChildWindow = iterator.next();
//		System.out.println("Child Window ID is: "+ChildWindow);
//		ContactsPage.changeCompany();
//		
//		
//	}

	public static void changeCompany() {

	}

	public void takeScreenshotAtEndOfTest() throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/ScreenShotsTemp" + System.currentTimeMillis() + ".png"));
				
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		FileUtils.copyFile(srcFile, new File(currentDir + "/ScreenShots" + System.currentTimeMillis() + ".png"));

	}

}
