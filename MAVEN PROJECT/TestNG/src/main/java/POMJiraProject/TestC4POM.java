package POMJiraProject;

import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestC4POM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		String newdep = "NEW39";

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/igor/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();

//		Navigation navigate = driver.navigate();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/*
		 * Go to Login Page of TestWave
		 */
		driver.get("http://testwave.qabidder.net/#/page/login");

		/*
		 * Login into TestWave
		 */

		WebElement usernameTextBox = driver.findElement(By.id("exampleInputEmail1"));
		usernameTextBox.sendKeys("dems_i@mail.ru");
		WebElement passwordTextBox = driver.findElement(By.id("exampleInputPassword1"));
		passwordTextBox.sendKeys("11111111");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement loginButton = driver.findElement(By.tagName("button"));
		Thread.sleep(6000);

		loginButton.click();

		// WebElement entity = driver.findElement(By.partialLinkText("Users"));
		// entity.click();

		WebElement userpf = driver.findElement(By.xpath("//span[text() = 'Vasyl']"));
		userpf.click();

		WebElement editpf = driver.findElement(By.xpath("//button[text() = 'Edit Profile']"));
		Thread.sleep(3000);
		editpf.click();

		// WebElement passwd =
		// driver.findElement(By.xpath("html/body/div[2]/section/div/div/div[2]/form[2]/div/div[2]//input"));
		// passwd.click();

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
			System.out.println(textfield.isDisplayed());
			System.out.println(textfield.isEnabled());
			System.out.println(textfield.getTagName());
			System.out.println(textfield.getSize());

		}
		
		WebElement chpwd = driver.findElement(By.xpath("//html/body/div[2]/section/div/div/div[2]/form[2]/div/div[3]/button"));
		Thread.sleep(3000);
		chpwd.click();

		Thread.sleep(6000);
		driver.close();
	}

}
