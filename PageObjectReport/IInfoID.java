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
public class IInfoID {

	WebDriver driver;

	public IInfoID(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = "/html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[1]//input")
	List<WebElement> textboxs1;

	@FindBy(xpath = "//html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[2]//input")
	List<WebElement> textboxs2;

	@FindBy(xpath = "//html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[3]//input")
	List<WebElement> textboxs3;

	@FindBy(xpath = "//html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[4]//input")
	List<WebElement> textboxs4;

	@FindBy(xpath = "//html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]//option[text()='Alaska']")
	List<WebElement> stats;

	@FindBy(xpath = "//html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[1]/div[2]/div[2]/div/div/select/*[text()='Ukraine']")
	WebElement country;

	@FindBy(xpath = "html/body/div[2]/section/div[1]/div/form/div[1]/div[2]/div[5]/ul/li[2]/a")
	WebElement next4;

	public void Info() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Counts of textboxses =" + textboxs1.size());
		System.out.println("Counts of textboxses =" + textboxs2.size());
		System.out.println("Counts of textboxses =" + textboxs3.size());
		System.out.println("Counts of textboxses =" + textboxs4.size());
		System.out.println("Counts of stats =" + stats.size());
	

		for (int i = 0; i < textboxs1.size(); i++)

		{
			try {
				WebElement textarea = textboxs1.get(i);
				String text = textarea.getText();
				//System.out.println(text);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}

		for (int i = 0; i < textboxs2.size(); i++)

		{
			try {
				WebElement textarea = textboxs2.get(i);
				String text = textarea.getText();
				//System.out.println(text);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		for (int i = 0; i < textboxs3.size(); i++)

		{
			try {
				WebElement textarea = textboxs3.get(i);
				String text = textarea.getText();
				//System.out.println(text);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}
		
		for (int i = 0; i < textboxs4.size(); i++)

		{
			try {
				WebElement textarea = textboxs4.get(i);
				String text = textarea.getText();
				//System.out.println(text);
				textarea.sendKeys("autofield");
			} catch (Exception name) {

			}
		}

		for (int i = 0; i < stats.size(); i++)

		{
			try {
				WebElement textarea = stats.get(i);
				String text = textarea.getText();
				System.out.println(text);
				textarea.click();
			} catch (Exception name) {

			}
		}
		
		country.click();

		next4.click();

	}

}
