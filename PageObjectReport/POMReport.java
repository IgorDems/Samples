package PageObjectReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMReport {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/igor/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/*
		 * Go to Login Page of TestWave
		 */
		driver.get("http://qabidder.net/testwave/#/page/login");

		LoginPageLocation logpage = new LoginPageLocation(driver);

		logpage.setEmail("qauber.sa1@mailinator.com");
		logpage.setPasswd("123456");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(6000);
		logpage.click();

		driver.quit();
	}

}
