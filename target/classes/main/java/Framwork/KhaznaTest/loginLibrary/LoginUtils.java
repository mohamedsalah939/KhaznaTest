package Framwork.KhaznaTest.loginLibrary;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginUtils {
	/*
	 * Click on login Put your mobile number
	 */
	public static void LoginWithMobile(AndroidDriver<AndroidElement> driver, String MobileNum)
			throws MalformedURLException, InterruptedException {
		Thread.sleep(10000);

		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/optionsLoginBtn")).click();
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/phonePhoneField")).sendKeys(MobileNum);
	}

	/*
	 * Check if it is valid mobile number or not
	 */
	public static void CheckSuccessORFailureLogin(AndroidDriver<AndroidElement> driver, String ElementID)
			throws MalformedURLException, InterruptedException {
		// Check it is not navigated to next page
		if (driver.findElement(By.id(ElementID)).isDisplayed()) {
			driver.executeScript("client:client.setTestStatus(true,'msg : test pass')");
		}

		driver.executeScript("client:client.setTestStatus(false,'msg : test fail')");
	}
}
