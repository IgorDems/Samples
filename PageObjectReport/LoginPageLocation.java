package PageObjectReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLocation {

	WebDriver driver;

	private By userName = By.xpath(".//*[@id='exampleInputEmail1']");
	private By Passwd = By.xpath(".//*[@id='exampleInputPassword1']");
	private By LogButt = By.xpath(".//*[text()='Login']");

	public LoginPageLocation(WebDriver driver) {
		this.driver = driver;
	}

	public void setEmail(String strEmail) {
		WebElement userTbox = driver.findElement(userName);
		userTbox.sendKeys(strEmail);
	}

	public void setPasswd(String strPasswd) {
		WebElement passTbox = driver.findElement(Passwd);
		passTbox.sendKeys(strPasswd);
	}

	public void click() {
		WebElement butt = driver.findElement(LogButt);
		butt.click();
	}

	// public String getUserNameLocation(){
	// return UserNameLocation;
	// }
	//
	// public String getPasswdLocation(){
	// return PasswdLocation;
	// }
	//
	// public String getLogButtLocation(){
	// return LogButtLocation;
	// }
}
