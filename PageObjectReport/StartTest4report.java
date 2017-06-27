/**
 * 
 */
package PageObjectReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * @author igor
 *
 */
public class StartTest4report {

	// launch browser and specific url
	WebDriver driver = BrowserFactory.startBrowser("firefox", "http://qabidder.net/testwave/#/page/login");
	// MainMenu links start
	MainNavigation mn = PageFactory.initElements(driver, MainNavigation.class);

	@Test(priority =1, groups = { "Functional", "Smoke" }, enabled = true, description = "Logining")
	/**
	 * 
	 * @throws InterruptedException
	 */
	public void checkUser() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create Page Object using Page Factory
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		// Call the method
		lp.loginToWS("qauber.sa1@mailinator.com", "123456");
		//go2addReport
		mn.goToAddReport();
		

	}
	@Test(priority =2, groups = { "Functional", "Smoke" }, enabled = true, description = "Logining")
	public void choosDep() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EntytyPage ep = PageFactory.initElements(driver, EntytyPage.class);
		ep.getDep();
		
	}
	
	@Test(priority =3, groups = { "Functional", "Smoke" }, enabled = true, description = "Logining")
	public void suInfo() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SubjInfo sui = PageFactory.initElements(driver, SubjInfo.class);
		sui.subjectInfo("7777777","TEST","30","6.0","100.1","eng","STREET","London","CA","99999","345 322 1111","asdfg@asd.org");
		
	}
	
	@Test(priority =4, groups = { "Functional", "Smoke" }, enabled = true, description = "Field Main datas Interview Card")
	public void fieldCardInterview() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		FieldInterviewCard fci = PageFactory.initElements(driver, FieldInterviewCard.class);
		fci.fieldCard();
		
	}
	
	
	@Test(priority =5, groups = { "Functional", "Smoke" }, enabled = true, description = "Info ID Page")
	public void IInfoID() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		IInfoID iid = PageFactory.initElements(driver, IInfoID.class);
		iid.Info();
		
	}

	@Test(priority =6, groups = { "Functional", "Smoke" }, enabled = true, description = "Gang History Page")
	public void GangPage() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		GangPage gm = PageFactory.initElements(driver, GangPage.class);
		gm.gangMemb();
		
	}
	
	@Test(priority =7, groups = { "Functional", "Smoke" }, enabled = true, description = "Vehicle Page")
	public void VehiclePage() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		VehiclePage car = PageFactory.initElements(driver, VehiclePage.class);
		car.vehicle();
		
	}
	
	@Test(priority =8, groups = { "Functional", "Smoke" }, enabled = true, description = "Photos add Page")
	public void PhotosPage() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PhotosPage pho = PageFactory.initElements(driver, PhotosPage.class);
		pho.photo();
		
	}
	@Test(priority =9, groups = { "Functional", "Smoke" }, enabled = true, description = "FinalReportPage")
	public void FinRepPage() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FinRepPage f = PageFactory.initElements(driver, FinRepPage.class);
		f.finaly();
		
	}
	
	
	
	
	@Test(priority =10, groups = { "Functional", "Smoke" }, enabled = true, description = "REPORT Check")
	public void Fintest() throws InterruptedException{
		WebElement finalcheck = driver.findElement(By.xpath("html/body/div[2]/section/div/div[3]/div[2]/table/tbody/tr[1]/td/div/div/div[1]/div/h4"));
		String text = finalcheck.getText();
		System.out.println(text);
		Thread.sleep(3000);
		
	if (text.contains("TEST TEST") == true) {
		System.out.println("Test Case Passed - REPORT was created");
	} else {
		System.out.println("Test Case NOTPASSED");
	}
	}
	
	
	@AfterTest
	public void closeApp() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
		System.out.println("=========================BOWSER WAS CLOSED - OK!=======================");
	}
}
