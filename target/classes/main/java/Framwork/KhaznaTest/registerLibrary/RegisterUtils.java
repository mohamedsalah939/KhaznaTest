package Framwork.KhaznaTest.registerLibrary;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RegisterUtils {
	/*
	 * Click on create new account button
	 */
	public static void CreateAccount(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		Thread.sleep(10000);
		// Click on Create new account
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/optionsRegisterBtn")).click();
		Thread.sleep(10000);
	}

	/*
	 * Search for specific company that I am working it to create the account
	 */
	public static void ChooseCompany(AndroidDriver<AndroidElement> driver, String Search)
			throws MalformedURLException, InterruptedException {

		// Search in Companies
		Thread.sleep(10000);
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/companySearchInputField"))
				.sendKeys(Search);

		// Select Company after search
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + Search + "']")).click();
		Thread.sleep(10000);
	}

	/*
	 * Add my full name and ID number
	 */
	public static void AddNameID(AndroidDriver<AndroidElement> driver, String Fullname, String IDNum)
			throws MalformedURLException, InterruptedException {

		// Enter full name
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoNameEd")).sendKeys(Fullname);
		// Enter valid national ID
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoNationalIdEd")).sendKeys(IDNum);

	}

	/*
	 * Add front and back images for the ID using an existing images in the gallery
	 */
	public static void AddExistingImage(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {

		/*
		 * Click to add front image of national ID, I was using the element coordinates
		 * as below but it is not same between test case and another (between
		 * registering with company or individual TouchAction touchAction = new
		 * TouchAction(driver); touchAction.tap(PointOption.point(730, 1553)).perform();
		 */
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoFrontImageTV")).click();
		// Click to select new front ID images
		driver.findElementByXPath("(//android.widget.ImageView)[2]").click();
		Thread.sleep(5000);
		// Give permission to the app to access the gallery
		driver.findElementByXPath("(//android.widget.Button)").click();
		Thread.sleep(5000);
		// select first image in the gallery
		driver.findElements(
				By.xpath("//android.widget.ImageView[contains(@resource-id,'com.sec.android.gallery3d:id/thumbnail')]"))
				.get(0).click();

		Thread.sleep(10000);
		// Click to add back image of national ID
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoBackImageTV")).click();
		Thread.sleep(5000);
		// Click to add new image
		driver.findElementByXPath("(//android.widget.ImageView)[2]").click();

		Thread.sleep(5000);
		// select second image in the gallery
		driver.findElements(
				By.xpath("//android.widget.ImageView[contains(@resource-id,'com.sec.android.gallery3d:id/thumbnail')]"))
				.get(1).click();

		Thread.sleep(5000);

	}

	/*
	 * Add front and back images for my ID using the camera
	 */
	public static void AddNewImage(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {

		/*
		 * Click to add front image of national ID, I was using the element coordinates
		 * as below but it is not same between test case and another (between
		 * registering with company or individual TouchAction touchAction = new
		 * TouchAction(driver); touchAction.tap(PointOption.point(730, 1553)).perform();
		 */
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoFrontImageTV")).click();
		// Click to add new image
		driver.findElementByXPath("(//android.widget.ImageView)").click();
		// Give permissions for the camera
		driver.findElementByXPath("(//android.widget.Button)").click();
		driver.findElementByXPath("(//android.widget.Button)").click();
		Thread.sleep(5000);
		// Take the Photo and click ok
		driver.findElementByXPath("(//android.widget.ImageButton)").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//android.widget.Button[@text='OK'])").click();

		Thread.sleep(10000);
		// Click to add back image of national ID
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoBackImageTV")).click();
		// touchAction.tap(PointOption.point(730, 1800)).perform();
		Thread.sleep(5000);
		// Click to add new image
		driver.findElementByXPath("(//android.widget.ImageView)").click();
		// Take the Photo and click ok
		driver.findElementByXPath("(//android.widget.ImageButton)").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//android.widget.Button[@text='OK'])").click();

		Thread.sleep(5000);

	}

	/*
	 * After adding full name, ID number, front image and back image for ID click on
	 * confirm to go to next step
	 */
	public static void ConfirmFirstPage(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {
		// Click on Confirm
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/infoSubmitBtn")).click();
	}

	/*
	 * Add my mobile number
	 */
	public static void AddMobileNum(AndroidDriver<AndroidElement> driver, String Mobile)
			throws MalformedURLException, InterruptedException {

		// Add mobile number
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/phonePhoneField")).sendKeys(Mobile);
		// Check agree
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/phoneRulesCb")).click();
		// Click Confirm
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/phoneSubmitBtn")).click();

	}

	/*
	 * check if error message appeared in the application if my data is wrong
	 */
	public static void CheckErrorMsg(AndroidDriver<AndroidElement> driver) {

		if (driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/otpHeaderTv")).isDisplayed()) {
			driver.executeScript("client:client.setTestStatus(true,'msg : test pass')");
		}
		driver.executeScript("client:client.setTestStatus(false,'msg : test fail')");
	}

	/*
	 * make sure that verification code is sent after all registration steps
	 */
	public static void GetVeriCode(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {

		Thread.sleep(10000);
		// Take the verification code

		String VerificationCode = driver
				.findElement(By.id("com.project.imperialcreation.khaznaproject:id/otpCodeField")).getText().toString();
		// Make sure it is not Empty
		if (!VerificationCode.isEmpty()) {
			driver.executeScript("client:client.setTestStatus(true,'msg : test pass')");
		}

		driver.executeScript("client:client.setTestStatus(false,'msg : test fail')");

	}

	/*
	 * Click on register button without choosing a company (individual registration)
	 */
	public static void IndividualRegisterClick(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {

		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/companyIndividualRegister")).click();
	}

	/*
	 * Choose a bank that I have account in it Write the bank account number
	 */
	public static void ChooseBankAccount(AndroidDriver<AndroidElement> driver, String AccountNumber, int bankID)
			throws MalformedURLException, InterruptedException {

		Thread.sleep(10000);
		// Choose bank Account Option
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoBankAccountRB")).click();

		// Choose Bank
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoBankNameTv")).click();
		driver.findElements(By.id("com.project.imperialcreation.khaznaproject:id/companyArrowIv")).get(bankID).click();

		// Add bank account number
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoBankAccountNumberInputField"))
				.setValue(AccountNumber);
		Thread.sleep(10000);
		// Click on confirm
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoSubmitBtn")).click();
	}

	/*
	 * Enter my mobile number which I have wallet linked to it
	 */
	public static void ChooseMobileWallet(AndroidDriver<AndroidElement> driver, String MobileWallet)
			throws MalformedURLException, InterruptedException {

		// Choose Mobile Wallet
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoWalletRB")).click();
		// Enter mobile number
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoWalletMobileNumberInputField"))
				.sendKeys(MobileWallet);
		Thread.sleep(10000);
		// Click on confirm
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoSubmitBtn")).click();
	}

	/*
	 * Choose a bank that I have Visa in it Write the Visa number
	 */
	public static void ChooseVisa(AndroidDriver<AndroidElement> driver, String VisaNumber, int bankID)
			throws MalformedURLException, InterruptedException {

		// Choose Visa Option
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoCardRB")).click();
		// Choose Bank
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoBankNameTv")).click();
		driver.findElements(By.id("com.project.imperialcreation.khaznaproject:id/companyArrowIv")).get(bankID).click();
		// Enter Visa number
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoCardNumberInputField"))
				.sendKeys(VisaNumber);

		Thread.sleep(10000);
		// Click on confirm
		driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/bankInfoSubmitBtn")).click();

	}

	/*
	 * Check that the application not navigated to next page when I enter wrong data
	 */
	public static void CheckNotNavigated(AndroidDriver<AndroidElement> driver)
			throws MalformedURLException, InterruptedException {

		// Check it is not navigated to next page
		if (!driver.findElement(By.id("com.project.imperialcreation.khaznaproject:id/phonePhoneField")).isDisplayed()) {
			driver.executeScript("client:client.setTestStatus(true,'msg : test pass')");
		}

		driver.executeScript("client:client.setTestStatus(false,'msg : test fail')");
	}
}
