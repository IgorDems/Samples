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
public class EntytyPage {

	WebDriver driver;

	/**
	 * 
	 * @param ldriver
	 */
	public EntytyPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = ".//label[contains(.,'Dep 1')]")
//	@CacheLookup
	WebElement dep;

	@FindBy(xpath = "//html/body/div[2]/section/div/div/form/div[1]/div[2]/div[2]/ul/li/a")
//	@CacheLookup
	WebElement next1;

	public void getDep() throws InterruptedException {

		dep.click();
		next1.click();
	}

}
