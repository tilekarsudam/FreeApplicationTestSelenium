package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ScreenShotTest extends TestBase {

	TestUtil testUtil;

	public ScreenShotTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();

		driver.get("https://www.google.com/");

	}

	@Test
	public void takeScreenShot() {
		Assert.assertEquals(false, true);
		System.out.println("ScreenShot Taken");
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ScreenShot Taken Done");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
