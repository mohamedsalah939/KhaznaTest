package Framwork.KhaznaTest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framwork.KhaznaTest.commonLibrary.*;
import Framwork.KhaznaTest.registerLibrary.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EnterInvalidMobile extends Capabilities {
	public static Logger log = LogManager.getLogger(Capabilities.class.getName());

	/*
	 * Try to register with invalid mobile number format
	 */
	@Test(dataProvider = "setData")
	public void EnterInvMob(String Company, String FullName, String IDNumber, String MobileNum)
			throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		// Click on Create new account
		RegisterUtils.CreateAccount(driver);
		// Search For A Company by name
		RegisterUtils.ChooseCompany(driver, Company);
		// Enter full name and ID number
		RegisterUtils.AddNameID(driver, FullName, IDNumber);
		// Add image from library
		RegisterUtils.AddExistingImage(driver);
		// Click Submit
		RegisterUtils.ConfirmFirstPage(driver);
		// Enter invalid mobile number
		RegisterUtils.AddMobileNum(driver, MobileNum);
		// Check if invalid banner appeared
		RegisterUtils.CheckErrorMsg(driver);
	}

	/*
	 * Provide the data to the test case Data coming from Excel
	 */
	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("EnterInvalidMobile");
		return ObjArray;
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
