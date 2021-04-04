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

public class RegisterWOCompanyWBank extends Capabilities {
	public static Logger log = LogManager.getLogger(Capabilities.class.getName());

	/*
	 * Register individually with valid bank account and make sure that it is
	 * accepting it
	 */
	@Test(dataProvider = "setData")
	public void RegisterWOCmpnyWBnk(String FullName, String IDNumber, String AccountNumber, String MobileNumber)
			throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		// Click on Create new account
		RegisterUtils.CreateAccount(driver);
		// Register Without Company
		RegisterUtils.IndividualRegisterClick(driver);
		// Enter fullname and ID number
		RegisterUtils.AddNameID(driver, FullName, IDNumber);
		// Add front and back images for ID from gallery
		RegisterUtils.AddExistingImage(driver);
		// Click on confirm to navigate to next page
		RegisterUtils.ConfirmFirstPage(driver);
		// Choose the bank and write the valid bank account
		RegisterUtils.ChooseBankAccount(driver, AccountNumber, 3);
		// Enter your mobile number
		RegisterUtils.AddMobileNum(driver, MobileNumber);
		// Check verification code is sent
		RegisterUtils.GetVeriCode(driver);
	}

	/*
	 * Provide the data to the test case Data coming from Excel
	 */
	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("RegisterWOCompanyWBank");
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
