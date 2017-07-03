package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	// System.setProperty("webdriver.chrome.driver","/Volumes/HDD/SeleniumWebDrv/chromedriver");

	public static WebDriver driver;

	@Given("^Open web browser and start app$")
	public void Open_web_browser_and_start_app() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://qabidder.net/testwave/#/page/login");

	}

	@When("^I enter valid \"(.*)\" and valid \"(.*)\"$")
	public void I_enter_valid_uname_and_valid_passwd(String uname, String passwd) throws InterruptedException {

		WebElement usernameTextBox = driver.findElement(By.id("exampleInputEmail1"));
		usernameTextBox.sendKeys(uname);
		WebElement passwordTextBox = driver.findElement(By.id("exampleInputPassword1"));
		passwordTextBox.sendKeys(passwd);

	}

	@And("^Push login button$")
	public void Push_login_button() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.tagName("button"));
		Thread.sleep(2000);
		loginButton.click();
	}

	@Then("^User sould be able to login successfully$")
	public void User_sould_be_able_to_login_successfully() throws InterruptedException {

		System.out.println("User logined successfully");

	}

	//////////////////////// =====================//////////////////////////
	@Given("^Main page start app$")
	public void Main_page_start_app() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Navigated to Main page successfully. Title = " + driver.getTitle());

	}

	@When("^Navigate to entity page$")
	public void Navigate_to_entity_page() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement reports = driver.findElement(By.linkText("Add Report"));
		Thread.sleep(1000);
		reports.click();

	}

	@Then("^We are on entity page$")
	public void We_are_on_entity_page() throws InterruptedException {

		System.out.println("Navigated to Entity page successfully. Title = " + driver.getTitle());

	}

	@When("^Make a choice the department \"(.*)\"$")
	public void Make_choice_department_dep11(String dep) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement radiobutt = driver.findElement(By.xpath("//label[contains(.,'" + dep + "')]"));

		Thread.sleep(1000);
		radiobutt.click();

	}

	@Then("^Subject Information page$")
	public void Subject_Information_page() throws InterruptedException {

		WebElement next1 = driver
				.findElement(By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[2]/ul/li/a"));
		next1.click();

		System.out.println("Navigated to Subject Information page successfully");

	}

	@When("^Fill in all fields of Subject Information$")
	public void Fill_in_all_fields_of_Subject_Information() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement caseid = driver.findElement(By.xpath("//input[@name='caseNumber']"));
		caseid.sendKeys("123456");

		WebElement lname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lname.sendKeys("Test");

		WebElement fname = driver.findElement(By.xpath("//input[@name='firstName']"));
		fname.sendKeys("Test");

		WebElement mname = driver.findElement(By.xpath("//input[@name='middleName']"));
		mname.sendKeys("BBBBBBBB");

		WebElement nname = driver.findElement(By.xpath("//input[@name='Nickname']"));
		nname.sendKeys("CCCCCCCC");

		WebElement age = driver.findElement(By.xpath("//input[@name='Age']"));
		age.clear();
		age.sendKeys("100");

		WebElement height = driver.findElement(By.xpath("//input[@name='Height']"));
		height.clear();
		height.sendKeys("7.5");

		WebElement weight = driver.findElement(By.xpath("//input[@name='Weight']"));
		weight.clear();
		weight.sendKeys("100.5");
		////// ====================BIRTHDAY==========================
		WebElement bdb = driver
				.findElement(By.xpath("//button[@class='btn btn-default'][@ng-click='dp.open()'][@type='button']"));
		bdb.click();

		WebElement bdb1 = driver.findElement(By.xpath("//button[@tabindex='-1']"));
		bdb1.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement bdb2 = driver.findElement(By.xpath("//span[@class='ng-binding'][text()='1999']"));
		bdb2.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement bdb3 = driver.findElement(By.xpath("//span[text()='July']"));
		bdb3.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement bdb4 = driver.findElement(By.xpath("//span[text()='14']"));
		bdb4.click();
		///// =====================================================
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement sex = driver.findElement(By.xpath("//option[text()='M']"));
		sex.click();

		WebElement sustype = driver
				.findElement(By.xpath("//select[@ng-model='wizard.report.suspectType']/option[text()='Other']"));
		sustype.click();

		WebElement race = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.race']/option[text()='Other']"));
		race.click();

		WebElement build = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.build']/option[text()='Medium']"));
		build.click();

		WebElement hair1 = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.hairColor']/option[text()='Blue']"));
		hair1.click();

		WebElement hair2 = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.hairLength']/option[text()='Long']"));
		hair2.click();

		WebElement hair3 = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.hairStyle']/option[text()='Short']"));
		hair3.click();

		WebElement eye = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.eyeColor']/option[text()='Blue']"));
		eye.click();

		WebElement compl = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.complexion']/option[text()='Medium']"));
		compl.click();

		WebElement teeth = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.teeth']/option[text()='Gold']"));
		teeth.click();

		WebElement hend = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.handPreference']/option[text()='Left']"));
		hend.click();

		WebElement country = driver
				.findElement(By.xpath(".//select[@ng-model='wizard.report.country']/option[text()='Canada']"));
		country.click();

		WebElement langv = driver.findElement(By.xpath("//input[@name='primary-language']"));
		langv.sendKeys("Eng");

		WebElement str = driver.findElement(By.xpath("//input[@name='street-address']"));
		str.sendKeys("7474 Asdfg");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Qwerty");

		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.sendKeys("CA");

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("12345");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("1234533339");

		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Contact E-Mail']"));
		email.sendKeys("1234@hghgh.kjn");

		WebElement radio = driver.findElement(By.xpath("//label[contains(.,'Driver')]"));

		Thread.sleep(1000);
		radio.click();

	}

	@Then("^Go to Identifiers page$")
	public void Go_to_Identifiers_page() throws InterruptedException {
		System.out.println("To fill Identifiers page was finished successfully");

		WebElement next2 = driver.findElement(By.xpath("//li[2]/a[text()='Next']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Thread.sleep(1000);
		next2.click();

		System.out.println("Navigated to Identifiers page successfully");

	}

	@When("^Fill in all fields of Identifiers$")
	public void Fill_in_all_fields_of_Identifiers() throws InterruptedException {

		System.out.println("Start to fill the Identifiers page successfully. Title =" + driver.getTitle());

		List<WebElement> chbuttons33 = driver.findElements(
				By.xpath("" + "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset//label"));
		System.out.println(chbuttons33.size());
		for (int i = 0; i < chbuttons33.size(); i++)

		{
			WebElement radiobutton = chbuttons33.get(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Thread.sleep(1000);
			radiobutton.click();
		}

		List<WebElement> texts33 = driver.findElements(
				By.xpath("" + "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[4]/fieldset//input"));
		System.out.println(texts33.size());
		for (int i = 0; i < texts33.size(); i++)

		{
			WebElement radiobutton = texts33.get(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Thread.sleep(1000);
			radiobutton.sendKeys("autofilling");
		}

	}

	@Then("^Go to ID Information page$")
	public void Go_to_ID_Information_page() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement next3 = driver.findElement(By.xpath("//a[@ng-click='wizard.go(4)']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		next3.click();

		System.out.println("ID Information page opened successfully. Title =" + driver.getTitle());

	}

	@When("Fill in all fields of ID Information$")
	public void Fill_in_all_fields_of_ID_Information() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("ID Information start to fill successfully. Title =" + driver.getTitle());
		///////////// ==============ID
		///////////// Information======================/////////////

		List<WebElement> texts1 = driver.findElements(
				By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[1]//input"));

		System.out.println(texts1.size());
		for (int i = 0; i < texts1.size(); i++)

		{

			WebElement on = texts1.get(i);
			on.sendKeys("autofilling");

		}

		WebElement dropfieldc = driver
				.findElement(By.xpath(".//fieldset[1]/div[2]/div[2]/div/div/select/*[text()='Albania']"));
		dropfieldc.click();

		WebElement dropfields = driver
				.findElement(By.xpath("//fieldset[1]/div[1]/div[3]/div/div/select/*[text()='Alaska']"));
		dropfields.click();
		///////////// ==============School
		///////////// Information======================/////////////

		List<WebElement> textfields = driver.findElements(
				By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[5]/fieldset[2]//input"));

		System.out.println(textfields.size());
		for (int i = 0; i < textfields.size(); i++)

		{

			WebElement textfield = textfields.get(i);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			textfield.sendKeys("autofilling");

		}

		WebElement dropfields1 = driver
				.findElement(By.xpath("//fieldset[2]/div[2]/div[2]/div/div/select/*[text()='Alaska']"));
		dropfields1.click();
		//////// ++++++++++++++++++++Parent
		//////// Information+++++++++++++++++++++++++//////////
		List<WebElement> textfields1 = driver.findElements(By.xpath("//div[5]/fieldset[3]//input"));

		System.out.println(textfields1.size());
		for (int i = 0; i < textfields1.size(); i++)

		{

			WebElement textfield = textfields1.get(i);
			textfield.sendKeys("autofilling");

		}

		WebElement dropfields2 = driver
				.findElement(By.xpath("//fieldset[3]/div[2]/div[2]/div/div/select/*[text()='Alaska']"));
		dropfields2.click();

		//////// ++++++++++++++++++++Employer
		//////// Information+++++++++++++++++++++++++//////////
		List<WebElement> chbuttons11 = driver.findElements(By.xpath("//div[2]/div[5]/fieldset[4]//input"));

		System.out.println(chbuttons11.size());
		for (int i = 0; i < chbuttons11.size(); i++)

		{

			WebElement chbutton = chbuttons11.get(i);
			chbutton.sendKeys("autofilling");

		}

		WebElement dropfields3 = driver
				.findElement(By.xpath("//div[5]/fieldset[4]/div[3]/div[2]/div/div/select/*[text()='Alaska']"));
		dropfields3.click();
	}

	@Then("^Go to Gang Membership page$")
	public void Go_to_Gang_Membership_page() throws InterruptedException {
		WebElement next4 = driver.findElement(By.xpath("//a[@ng-click='wizard.go(5)']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		next4.click();
		System.out.println("Navigated to 'Gang Membership' page successfully. Title = " + driver.getTitle());

	}

	@When("Fill in all fields of Gang Membership$")
	public void Fill_in_all_fields_of_Gang_Membership() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> gmchbox = driver
				.findElements(By.xpath("//div/div/form/div[1]/div[2]/div[6]/fieldset[1]//span"));
		for (int i = 0; i < gmchbox.size() - 1; i++) {

			WebElement gmchbox0 = gmchbox.get(i);
			gmchbox0.click();

		}

		WebElement textadd = driver
				.findElement(By.xpath("//form/div[1]/div[2]/div[6]/fieldset[1]/div[2]/div/div/input"));
		textadd.sendKeys("autofilling");
		///////////// ------------Stop Information-------------///////////
		List<WebElement> textfields = driver
				.findElements(By.xpath("//div/div/form/div[1]/div[2]/div[6]/fieldset[2]//input"));

		for (int i = 0; i < textfields.size(); i++)

		{

			WebElement textfield = textfields.get(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			textfield.sendKeys("autofilling");
		}

		////// ==========Gang Membership Criteria========//////

		WebElement textfield1 = driver.findElement(By.xpath(
				"html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[3]/div[1]/div[1]/div/div/input"));
		Thread.sleep(1000);
		textfield1.sendKeys("autofilling");
		WebElement textfield2 = driver.findElement(By.xpath(
				"html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[3]/div[1]/div[2]/div/div/input"));
		Thread.sleep(1000);
		textfield2.sendKeys("autofilling");

		List<WebElement> gmchbox1 = driver.findElements(By.xpath("//fieldset[3]//div/label[@class='needsclick']"));
		Thread.sleep(1000);
		System.out.println(gmchbox1.size());
		for (int i = 0; i < gmchbox1.size(); i++) {
			try {
				WebElement gmchbox0 = gmchbox1.get(i);
				Thread.sleep(1000);
				gmchbox0.click();
			} catch (Exception name) {

			}
		}
		//////////// ==Parole / Probation
		//////////// Status==========///////////////

		WebElement gmchbox01 = driver.findElement(By.xpath(
				"html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[4]/div[1]/div[1]/div/label/span"));
		Thread.sleep(3000);
		gmchbox01.click();
		WebElement gmchbox02 = driver.findElement(By.xpath(
				"html/body/div[2]/section/div/div/form/div[1]/div[2]/div[6]/fieldset[4]/div[2]/div[1]/div/label/span"));
		Thread.sleep(3000);
		gmchbox02.click();

		List<WebElement> textfieldsgmc31 = driver
				.findElements(By.xpath("//div/form/div[1]/div[2]/div[6]/fieldset[4]//div/input"));

		System.out.println(textfieldsgmc31.size());
		for (int i = 0; i < textfieldsgmc31.size(); i++)

		{

			WebElement textfield = textfieldsgmc31.get(i);
			textfield.sendKeys("autofilling");
		}

		///////// ===========Other Information===========//////////
		List<WebElement> textfieldsgmc3 = driver.findElements(By.xpath("//div[2]/div[6]/fieldset[5]//*[@ng-model]"));

		System.out.println(textfieldsgmc3.size());
		for (int i = 0; i < textfieldsgmc3.size(); i++)

		{

			WebElement textfield = textfieldsgmc3.get(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			textfield.clear();
			textfield.sendKeys("autofilling");
		}

	}

	@Then("^Go to Vehicle page$")
	public void Go_to_Vehicle_page() throws InterruptedException {
		WebElement next5 = driver.findElement(By.xpath("//a[@ng-click='wizard.go(6)']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		next5.click();
		System.out.println("Navigated to Vehicle page successfully. Title = " + driver.getTitle());

	}

	@When("Fill in all fields of Vehicle$")
	public void Fill_in_all_fields_of_Vehicle() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Vehicle page started to fill successfully. Title = " + driver.getTitle());

		List<WebElement> textfields11 = driver.findElements(
				By.xpath("" + "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[7]/fieldset/div//input"));
		System.out.println(textfields11.size());
		for (int i = 0; i < textfields11.size(); i++) {

			WebElement textfield = textfields11.get(i);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			textfield.sendKeys("automated fielded");

		}
	}

	@Then("^Go to Photos page$")
	public void Go_to_Photos_page() throws InterruptedException {
		WebElement next6 = driver.findElement(By.xpath("//a[@ng-click='wizard.go(7)']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		next6.click();
		System.out.println("Navigated to Photos page successfully. Title = " + driver.getTitle());

	}

	@When("^Adding Photos by link$")
	public void Adding_Photos() throws InterruptedException, AWTException {

		Thread.sleep(6000);
		WebElement addphoto = driver.findElement(By
				.xpath("html/body/div[2]/section/div[1]/div/form/div[1]/div[2]/div[8]/fieldset/div/div[2]/div/div/button"
						+ ""));
		Thread.sleep(6000);
		addphoto.click();

		String file = "Ukraine.png";

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
		System.out.println("PICTURE WAS ATTACHED SUCCESSEFULL");
		// Thread.sleep(1000);

	}

	@Then("^Go to finish page")
	public void Go_to_finish_page() throws InterruptedException {

		WebElement finbutt = driver
				.findElement(By.xpath("html/body/div[2]/section/div/div/form/div[1]/div[2]/div[8]/ul/li[2]/a"));
		Thread.sleep(2000);
		finbutt.click();

		// WebElement click =
		// driver.findElement(By.xpath("//*[@id='ngdialog1']/div[2]/div/div")).click();

	}

	@Given("^Filled fillds")
	public void Filled_fillds() throws InterruptedException {

		System.out.println("REPORT IS CREATED AND READY FOR SUBMITION");
		
	}

	@When("^Adding report")
	public void Adding_report() throws InterruptedException {

		WebElement report = driver.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		report.click();

		WebElement okbutt = driver
				.findElement(By.xpath(".//*[@id='ngdialog1']/div[2]/div/div/button[1][text()='YES']"));
		okbutt.click();
		System.out.println("REPORT WAS SUBMITED SUCCESSEFULL");
		Thread.sleep(3000);
	}

	@Then("^Check the report")
	public void Check_the_report() throws InterruptedException {

		WebElement finalcheck = driver.findElement(
				By.xpath("html/body/div[2]/section/div/div[3]/div[2]/table/tbody/tr[1]/td/div/div/div[1]/div/h4"));
		Thread.sleep(3000);
		String text = finalcheck.getText();
		System.out.println(text);
		Thread.sleep(3000);

		if (text.contains("Test Test") == true) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case NOTPASSED");
		}

		driver.close();

	}

}
