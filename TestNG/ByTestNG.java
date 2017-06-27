package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

		  System.setProperty("webdriver.chrome.driver","/Users/igor/Downloads/chromedriver");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    wait = new WebDriverWait(driver, 30);
		    driver.get("http://qabidder.net/testwave/#/page/login");
		    System.out.println(driver.getCurrentUrl()+" ==== "+ driver.getTitle() +"page opened");
		}
	//////////======exam==========
	@Test(priority=2,invocationCount=2)
	public void Test1(){
		System.out.println("Test 1");
	}
	
	@Test(priority=1)
	public void Test2(){
		System.out.println("Test 2");
	}

	
	@Test(dataProvider = "giveUnameAndPass()")
//	public void login(String emailID, String passwd){
//		
//		driver.findElements(By.id("exampleInputEmail1")).get(0).sendKeys("emailID");
//		driver.findElements(By.id("exampleInputPassword1")).get(0).sendKeys("passwd");
//		driver.findElements(By.tagName("button")).get(0).click();
//		driver.close();
//	}
	
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
		Assert.assertFalse(false,"Assert OK!");
	}

	@Test(dependsOnMethods = "login", alwaysRun = true)
	public void testBody() {
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
	@DataProvider
	public Object[][] giveUnameAndPass() throws Exception {
		
		Object[][] objArray =  {{"U1","P1"},
							    {"U1","P1"},
								{"U1","P1"},
								{"U1","P1"},
								{"U1","P1"}};
		return objArray;
	}

	@AfterTest
	public void closeApp() {
		driver.close();
		System.out.println("=========================BOWSER WAS CLOSED - OK!=======================");
	}

}
