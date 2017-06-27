/**
 * 
 */
package PageObjectReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author igor
 *
 */
public class FinRepPage {
	WebDriver driver;

	public FinRepPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[2]/button[1]//em")
	WebElement repbutton;

	@FindBy(xpath = ".//*[@id='ngdialog1']/div[2]/div/div/button[1][text()='YES']")
	WebElement okbutton;
	
	public void finaly() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		repbutton.click();
		okbutton.click();
	}
}
