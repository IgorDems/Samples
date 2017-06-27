/**
 * 
 */
package PageObjectReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author igor
 *
 */
public class FieldInterviewCard {

	WebDriver driver;

	/**
	 * 
	 * @param ldriver
	 */
	public FieldInterviewCard(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset//span/label/span")
	List<WebElement> chbuttons;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset//input")
	List<WebElement> textboxs;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/ul/li[2]/a")
	WebElement next3;

	public void fieldCard() throws InterruptedException {

		System.out.println("Counts of chackboxses =" + chbuttons.size());
		System.out.println("Counts of textboxses =" + textboxs.size());

		for (int i = 0; i < chbuttons.size(); i++)

		{

			WebElement button = chbuttons.get(i);
			String text = button.getText();
			//System.out.println(text);
			button.click();
		}

		for (int i = 0; i < textboxs.size(); i++)

		{
			try {
				WebElement textarea = textboxs.get(i);
				String text = textarea.getText();
				//System.out.println(text);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}

		next3.click();

	}

}
