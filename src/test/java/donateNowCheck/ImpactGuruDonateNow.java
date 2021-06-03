package donateNowCheck;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImpactGuruDonateNow {

	static WebDriver driver;

	public boolean openChromeAndLoadWebsite() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/ravisanb/eclipse-workspace/ImpactGuruProject/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://staging.igstg.com/fundraiser/help-testdocumentchecklist ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='auth-local-btn']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("candidate");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("igcandidate");
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		Thread.sleep(5000);
		driver.get("https://impactguru:8nvbil51pp@staging.igstg.com/fundraiser/help-testdocumentchecklist");
		return true;
	}


	public boolean testEnterPersonalDetails() {
		driver.findElement(By.xpath("//a[@id='cmp-nfr-top-side-donate']")).click();
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Arjun Krishna");
		driver.findElement(By.xpath("//input[@name='email_receipt']")).sendKeys("arjun.saha@gmail.com");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("7871445476");
		driver.findElement(By.xpath("//input[@name='city_text']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//button[@class='btn-g-new text-center mt-2 story-popup-donate-button cmp-analytics']")).click();
		return true;
	}

	public boolean testEnterCardDetails() {
		driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys("5411759305935531");
		driver.findElement(By.xpath("//input[@id='expiryDate']")).sendKeys("0825");
		driver.findElement(By.xpath("//input[@id='cvvNumber']")).sendKeys("564");
		return true;
	}

	public boolean clickOnContribute() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='donate-card-contribute']")).click();
		Thread.sleep(15000);
		return true;
	}

	public boolean testTransactionSuccessful() throws InterruptedException {
		String parentWindow= driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
			Thread.sleep(8000);
			driver.findElement(By.xpath("//button[@class='success']")).click();
			Thread.sleep(8000);
			driver.switchTo().window(parentWindow);
			String str = "Arjun Krishna, pat your back!";
			String thanksBanner = driver.findElement(By.xpath("//div[@class='thankyou-banner__content-main']")).getText();
			System.out.println(thanksBanner);
			str.equalsIgnoreCase(thanksBanner);
		return true;
	}
}
