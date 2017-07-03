/**
 * 
 */
package PageObjectReport;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//section/div/div/form/div[1]/div[2]/ol/li[7]")
	WebElement buttonpp;

	@FindBy(xpath = "//button[@class='upload btn btn-primary btn-labeled']")
	WebElement buttonadd;

	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[8]/ul/li[2]/a")
	WebElement next7;


	public void photo() throws InterruptedException, AWTException {
		
		String outputFolder = System.getProperty("user.home") + File.separator  ;
	    String PictureFilePath =  outputFolder +  "/Desktop/Ukraine.png";
	    String file = "Ukraine.png";
	    buttonadd.click();
	    StringSelection ss = new StringSelection(file);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    
	    Robot robot = new Robot();
	    
	    robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);    
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(1000);   
	    robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);        
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
	    Thread.sleep(3000);
	    
		next7.click();
	}

}
