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
public class VehiclePage {
	
	
	WebDriver driver;

	public VehiclePage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[7]/fieldset//*[@type='text']")
	List<WebElement> textboxs;
	
	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[7]/fieldset/div/div[3]/div[1]//*[text()='Alaska']")
	WebElement dropbox;
	
	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[7]/ul/li[2]/a")
	WebElement next6;

	public void vehicle() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//////////////// ======Distribution============////////
		
		for (int i = 0; i < textboxs.size(); i++)

		{
			try {
				WebElement textarea = textboxs.get(i);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		
		dropbox.click();
		next6.click();
	}
	

}
