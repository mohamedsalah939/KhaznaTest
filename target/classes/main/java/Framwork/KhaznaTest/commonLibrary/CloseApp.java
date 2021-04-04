package Framwork.KhaznaTest.commonLibrary;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CloseApp {

	public static void CloseRunningApp(AndroidDriver<AndroidElement> driver) {
		driver.closeApp();
	}

}
