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
public class GangPage {
	WebDriver driver;

	public GangPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[1]//span")
	List<WebElement> chboxs;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[2]//input")
	List<WebElement> textboxs;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[3]//span")
	List<WebElement> chboxs1;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[3]/div[1]//input")
	List<WebElement> textboxs1;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[4]//span")
	List<WebElement> chboxs2;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[5]//input")
	List<WebElement> textboxs2;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[4]/*//input[@type='text']")
	List<WebElement> textboxs3;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[5]//textarea")
	WebElement text;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/ul/li[2]/a")
	WebElement next5;

	public void gangMemb() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//////////////// ======Distribution============////////
		for (int i = 0; i < chboxs.size() - 1; i++)

		{
			try {
				WebElement ch = chboxs.get(i);
				Thread.sleep(3000);
				ch.click();
			} catch (Exception name) {

			}
		}

		for (int i = 0; i < chboxs1.size(); i++)

		{
			try {
				WebElement ch1 = chboxs1.get(i);
				Thread.sleep(3000);
				ch1.click();
			} catch (Exception name) {

			}
		}

		for (int i = 0; i < chboxs2.size(); i++)

		{
			try {
				WebElement ch2 = chboxs2.get(i);
				ch2.click();
			} catch (Exception name) {

			}
		}

		//////////////////// ----TEXT-------////////////
		for (int i = 0; i < textboxs.size(); i++)

		{
			try {
				WebElement textarea = textboxs.get(i);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		//////////// ====================///////////////////
		for (int i = 0; i < textboxs1.size(); i++)

		{
			try {
				WebElement textarea = textboxs1.get(i);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		//////////// ====================///////////////////
		for (int i = 0; i < textboxs2.size(); i++)

		{
			try {
				WebElement textarea = textboxs2.get(i);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		//////////////////// ----TEXT-------////////////
		for (int i = 0; i < textboxs3.size(); i++)

		{
			try {
				WebElement textarea = textboxs3.get(i);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		//////////// ====================///////////////////
		// for (int i = 0; i < text.size(); i++)
		//
		// {
		// try {
		// WebElement textarea = text.get(i);
		// textarea.sendKeys("autofield");
		// } catch (Exception name) {
		//
		// }
		// }
		/////////////////////////// ======CHBOXS=====////////////////////

		text.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaa ppppppppppppppppppppppppp");
		next5.click();
	}

}
