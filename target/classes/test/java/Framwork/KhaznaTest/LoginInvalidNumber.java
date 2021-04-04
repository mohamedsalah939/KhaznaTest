package Framwork.KhaznaTest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framwork.KhaznaTest.commonLibrary.*;
import Framwork.KhaznaTest.loginLibrary.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginInvalidNumber extends Capabilities {
	public static Logger log = LogManager.getLogger(Capabilities.class.getName());

	/*
	 * Login with invalid mobile number format
	 */
	@Test(dataProvider = "setData")
	public void LoginInvNum(String MobileNumber) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = CapabilitiesDefine();
		// Click on Login then enter mobile number
		LoginUtils.LoginWithMobile(driver, MobileNumber);
		// Check it is failed to login
		LoginUtils.CheckSuccessORFailureLogin(driver,
				"com.project.imperialcreation.khaznaproject:id/customMessageDialogTitleTv");

	}

	/*
	 * Provide the data to the test case Data coming from Excel
	 */
	@DataProvider
	public Object[][] setData() throws IOException {

		Object[][] ObjArray = dataDriven.FormatData("LoginInvalidNumber");
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
