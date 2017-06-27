package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ByTestNG2 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {

		  System.setProperty("webdriver.chrome.driver","/Users/igor/Downloads/chromedriver");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    wait = new WebDriverWait(driver, 30);
		    driver.get("http://testwave.qabidder.net/#/page/login");
		    System.out.println(driver.getCurrentUrl()+" page opened");
		}
	
	
	@Test
	public void login() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleInputEmail1"))).clear();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleInputEmail1"))).sendKeys("dems_i@mail.ru");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("exampleInputPassword1"))).sendKeys("11111111");

		// wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")))
		// .click();

		WebElement loginButton = driver.findElement(By.tagName("button"));
		Thread.sleep(6000);
		loginButton.click();
		System.out.println("Login OK!");
	}
	
	@Test(dependsOnMethods = "login", alwaysRun = true)
	public void testBody() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Vasyl']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Edit Profile']"))).click();

		List<WebElement> passwds = driver.findElements(By.xpath(""

				+ "html/body/div[2]/section/div/div/div[2]/form[2]/div/div[2]//input"));

		System.out.println(passwds.size());
		for (int i = 0; i < passwds.size(); i++)

		{

			WebElement textfield = passwds.get(i);
			String text = textfield.getText();
			System.out.println(text);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Thread.sleep(3000);

			textfield.sendKeys("11111111");
			if (i == 1) {
				textfield.sendKeys("11111112");
			} else {
				textfield.sendKeys("11111111");
			}

		}
//		Assert.assertFalse(false,"Assert OK!");
//		WebElement chpwd = driver
//				.findElement(By.xpath("//html/body/div[2]/section/div/div/div[2]/form[2]/div/div[3]/button"));
//		Thread.sleep(6000);
//		chpwd.click();
		Thread.sleep(6000);
		//////////////---------------result-----------------//////////////
		WebElement err = driver
				.findElement(By.xpath("//fieldset[3]/div/div/span[2][text()='Password does Not match']"));
		Thread.sleep(6000);
		
		String text = err.getText();
		System.out.println(text + " Text ");
//		Assert.assertEquals(text, "Password does Not match");//ssertTrue(text.contains("Password does Not match"));

		if (text.contains("Password does Not match") == true) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case NOTPASSED");
		}

		System.out.println(text + " Text ");
	}

	@AfterTest
	public void closeApp() {
		driver.close();

	}

}
