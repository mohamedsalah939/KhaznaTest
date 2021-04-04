package Framwork.KhaznaTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import Framwork.KhaznaTest.commonLibrary.*;
import Framwork.KhaznaTest.registerLibrary.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchForNonExistingCompany extends Capabilities {
	public static Logger log = LogManager.getLogger(Capabilities.class.getName());

	/*
	 * Try to search with non existing company and make sure registration is not
	 * completed
	 */
	@Test(dataProvider = "setData")
	public void SearchForNonExistingCmpny(String Company) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		// Click on create new account
		RegisterUtils.CreateAccount(driver);
		// choose non existing company
		RegisterUtils.ChooseCompany(driver, Company);
		// Make sure that it is not appeared
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='xyz']")).isDisplayed()) {
			driver.executeScript("client:client.setTestStatus(false,'msg : test fail')");
		}
		driver.executeScript("client:client.setTestStatus(true,'msg : test pass')");
	}

	/*
	 * Provide the data to the test case Data coming from Excel
	 */
	@DataProvider
	public Object[] setData() throws IOException {
		ArrayList data = dataDriven.getData("SearchForNonExistingCompany");
		Object[] objArray = data.toArray();

		return objArray;

	}

	/*
	 * Close the application after test case running
	 */
	@AfterTest
	public void closeKhaznaApp() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		CloseApp.CloseRunningApp(driver);

	}

}
