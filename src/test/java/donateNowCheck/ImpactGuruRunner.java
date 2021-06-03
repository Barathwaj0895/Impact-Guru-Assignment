package donateNowCheck;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImpactGuruRunner extends ImpactGuruDonateNow {

	WebDriver driver;

	// 	public static WebDriver changeLocation() {
	//		driver = new ChromeDriver();
	//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//		return driver;	
	//			}

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("Setting up the enviornment for Automation Test");
		System.setProperty("webdriver.chrome.driver", "C:/Users/ravisanb/eclipse-workspace/ImpactGuruProject/driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		System.out.println("Test Method has been completed");
		System.out.println("Clearing the defaults for next method execution");
		driver.quit();
	}

	@Test
	public void impactGuruLogin() throws InterruptedException {
		Assert.assertTrue(openChromeAndLoadWebsite(), "Login Successful");
		Assert.assertTrue(testEnterPersonalDetails(), "Personal Details Entry Successful");
		Assert.assertTrue(testEnterCardDetails(), "Card Details Entry Successful");
		Assert.assertTrue(clickOnContribute() && testTransactionSuccessful(), "Donation Successful");
	}
	
}
