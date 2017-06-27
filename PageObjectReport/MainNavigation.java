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
public class MainNavigation {

	WebDriver driver;

	/**
	 * 
	 * @param ldriver
	 */
	public MainNavigation(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(how = How.LINK_TEXT, using = "Entities")
	@CacheLookup
	WebElement entities;
	@FindBy(how = How.LINK_TEXT, using = "Users")
	@CacheLookup
	WebElement users;
	@FindBy(how = How.LINK_TEXT, using = "Add Report")
	@CacheLookup
	WebElement addrep;
	@FindBy(how = How.LINK_TEXT, using = "Reports")
	@CacheLookup
	WebElement reports;

	public void goToEntities() {
		entities.click();
	}

	public void goToUsers() {
		users.click();
	}

	public void goToAddReport() {
		addrep.click();
	}

	public void goToReports() {
		reports.click();
	}

}
