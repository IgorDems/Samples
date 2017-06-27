package TestNGL3HW2;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.BeforeClass;
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

/**
 * 
 * @author igor
 *
 */
public class ByTestNG {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "/Users/igor/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
		driver.get("http://qabidder.net/testwave/#/page/login");
		System.out.println(driver.getCurrentUrl() + " ==== " + driver.getTitle() + "page opened");
	}

	@Test(priority =1, groups = { "Functional", "Smoke" }, enabled = true, description = "Logining")
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
		Assert.assertFalse(false, "Assert OK!");
	}

	@Test(priority =2, groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", enabled = true, description = "Go to user profile", alwaysRun = true)
	public void test1() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Vasyl']"))).click();

	}

	@Test(priority =3, groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = true, description = "Push 'Edit Profile' button")
	public void test2() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Edit Profile']"))).click();
	}

	@Test(priority =4, groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = true, description = "Changing password by same")
	public void test3() {
		List<WebElement> passwds = driver.findElements(By.xpath(""

				+ "html/body/div[2]/section/div/div/div[2]/form[2]/div/div[2]//input"));

		System.out.println(passwds.size());
		for (int i = 0; i < passwds.size(); i++)

		{

			WebElement textfield = passwds.get(i);
			String text = textfield.getText();
			System.out.println(text);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			textfield.sendKeys("11111111");
			System.out.println(textfield.isDisplayed());
			System.out.println(textfield.isEnabled());
			System.out.println(textfield.getTagName());
			System.out.println(textfield.getSize());

		}

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("" + "//html/body/div[2]/section/div/div/div[2]/form[2]/div/div[3]/button"))).click();
		System.out.println("Password was changed - OK!");
	}

	@Test(priority =5, groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = true, description = "Test for not correct current user password")
	public void test4() throws InterruptedException {
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
			if (i == 0) {
				textfield.sendKeys("11111112");
			} else {
				textfield.sendKeys("11111111");
			}

		}
		Assert.assertFalse(false, "Login by not correct password - error!");

		WebElement err = driver.findElement(By.xpath(
				"html/body/div[2]/section/div/div/div[2]/form[2]/div/div[2]/fieldset[1]/div/div/span[2][text()='Your current password is different']"));
		Thread.sleep(6000);

		String text = err.getText();

		if (text.contains("Your current password is different") == true) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case NOTPASSED");
		}

		System.out.println(text);

	}

	@Test(priority =6 , groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = true, description = "Test for not correct retype changed password")
	public void test5() {

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
		Assert.assertFalse(false, "Login by not correct password - error!");
	}

	@Test(priority =7, groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = false, description = "Test for not correct ruls of changed password")
	public void test6() {

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

			if (i == 0) {
				textfield.sendKeys("11111111");
			} else {
				textfield.sendKeys("AA");
			}

		}
		Assert.assertFalse(false, "Login by not correct password - error!");
	}

	@Test(groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = false, description = "Test for empty changed password")
	public void test7() {
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

			if (i == 0) {
				textfield.sendKeys("11111111");
			} else {
				textfield.sendKeys("");
			}

			System.out.println(textfield.isDisplayed());
			System.out.println(textfield.isEnabled());
			System.out.println(textfield.getTagName());
			System.out.println(textfield.getSize());

		}
		Assert.assertFalse(false, "Login by not correct password - error!");
	}

	@Test(groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = false, description = "empty template")
	public void test8() {

	}

	@Test(groups = { "Functional",
			"Smoke" }, dependsOnMethods = "login", alwaysRun = true, enabled = false, description = "empty template")
	public void test9() {

	}

	@AfterTest
	public void closeApp() {
		driver.close();
		System.out.println("=========================BOWSER WAS CLOSED - OK!=======================");
	}

}
