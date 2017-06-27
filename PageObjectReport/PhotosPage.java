/**
 * 
 */
package PageObjectReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author igor
 *
 */
public class PhotosPage {
	
	WebDriver driver;

	public PhotosPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	

	
	
	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[8]/ul/li[2]/a")
	WebElement next7;
	
	public void photo() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		next7.click();
	}
	
}
