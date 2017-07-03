/**
 * 
 */
package PageObjectReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author igor
 *
 */
public class LoginPage {

	WebDriver driver;
/**
 * 
 * @param ldriver
 */
	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(id = "exampleInputEmail1")
	@CacheLookup
	WebElement username;
	@FindBy(how = How.ID, using = "exampleInputPassword1")
	@CacheLookup
	WebElement passwd;
	@FindBy(tagName = "button")
	@CacheLookup
	WebElement logbutton;
/**
 * 
 * @param uid
 * @param pass
 * @throws InterruptedException
 */
	public void loginToWS(String uid, String pass) throws InterruptedException {
		username.sendKeys(uid);
		passwd.sendKeys(pass);
		Thread.sleep(2000);
		logbutton.click();
	}
}
