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

public class RegisterWithExistingImage extends Capabilities {
	public static Logger log = LogManager.getLogger(Capabilities.class.getName());

	/*
	 * Full register cycle using existing image in the gallery
	 */
	@Test(dataProvider = "setData")
	public void RegisterWExistImg(String Company, String FullName, String IDNumber, String MobileNumber)
			throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		// Click on Create new account
		RegisterUtils.CreateAccount(driver);
		// Choose company related to you
		RegisterUtils.ChooseCompany(driver, Company);
		// Enter fullname and ID number
		RegisterUtils.AddNameID(driver, FullName, IDNumber);
		// Choose front and back images from the gallery
		RegisterUtils.AddExistingImage(driver);
		// Click on confirm to go to next page
		RegisterUtils.ConfirmFirstPage(driver);
		// Enter mobile number
		RegisterUtils.AddMobileNum(driver, MobileNumber);
		// Check that verification code is sent
		RegisterUtils.GetVeriCode(driver);

	}

	/*
	 * Provide the data to the test case Data coming from Excel
	 */
	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("RegisterWithExistingImage");
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
