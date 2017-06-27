package NGGrouping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGGrouping {

	WebDriver driver;
	Navigation navigate;

	@BeforeClass // (groups={"Functional","Smoke"})
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/igor/Downloads/chromedriver");
		driver = new ChromeDriver();
		navigate = driver.navigate();
	}

	@BeforeMethod // (groups={"FF","SS"})
	public void goTo() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://qabidder.net/testwave/#/page/login");
	}

	@Test(groups = { "FF", "SS" })

	public void BlankFields() throws InterruptedException {

		System.out.println("BlankFields 1");
		// Login
		String title = driver.getTitle();
		Assert.assertEquals(title, "FITS - FITS Web Application");
		WebElement userName = driver.findElement(By.id("exampleInputEmail1"));
		userName.sendKeys("qauber.sa1@mailinator.com");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("exampleInputPassword1"));
		password.sendKeys("123456");
		Thread.sleep(3000);
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		// Go to Entities
		Thread.sleep(3000);
		WebElement entities = driver.findElement(By.linkText("Entities"));
		entities.click();

		Thread.sleep(3000);
		// Click Edit Button
		driver.findElement(By.cssSelector("button[title='Edit']")).click();

		// Remove Entity name
		Thread.sleep(3000);
		WebElement entity = driver.findElement(By.xpath("//input[@name='name']"));
		entity.click();
		entity.clear();

		// Remove country name dropdown
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		country.findElement(By.xpath("option[text()='Select a country']")).click();
		// Remove Address 1
		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.click();
		address1.clear();
		// Remove city
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.click();
		city.clear();
		// Remove state
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.click();
		state.clear();
		// Remove state
		WebElement postalCode = driver.findElement(By.xpath("//input[@name='zip']"));
		postalCode.click();
		postalCode.clear();

		// Click Update Button
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("Button[ng-click='$ctrl.updateAction()']")).click();
	}

	@Test(groups = { "FF" })

	public void InvalidEmail() throws InterruptedException {
		// driver.get("http://testwave.qabidder.net/#/page/login");
		// navigate.refresh();
		System.out.println("InvalidEmail 2");
		// login
		String title = driver.getTitle();
		Assert.assertEquals(title, "FITS - FITS Web Application");
		Thread.sleep(3000);
		WebElement userName = driver.findElement(By.id("exampleInputEmail1"));
		userName.sendKeys("qauber.sa1@mailinator.com");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.id("exampleInputPassword1"));
		password.sendKeys("123456");
		Thread.sleep(3000);
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		// Go to Entities
		Thread.sleep(3000);
		WebElement entities = driver.findElement(By.linkText("Entities"));
		entities.click();

		Thread.sleep(3000);
		// Click Edit Button
		driver.findElement(By.cssSelector("button[title='Edit']")).click();

		Thread.sleep(3000);
		WebElement emailTextBox = driver.findElement(By.xpath("// input[@name='email']"));
		emailTextBox.click();
		emailTextBox.clear();
		emailTextBox.sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("Button[ng-click='$ctrl.updateAction()']")).click();

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
