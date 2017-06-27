/**
 * 
 */
package PageObjectReport;

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
public class SubjInfo {
	WebDriver driver;

	/**
	 * 
	 * @param ldriver
	 */
	public SubjInfo(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = "//input[@name='caseNumber']")
//	@CacheLookup
	WebElement caseid;

	@FindBy(xpath = "//input[@name='lastName']")
//	@CacheLookup
	WebElement lname;

	@FindBy(xpath = "//input[@name='firstName']")
//	@CacheLookup
	WebElement fname;

	@FindBy(xpath = "//input[@name='middleName']")
//	@CacheLookup
	WebElement mname;

	@FindBy(xpath = "//input[@name='Nickname']")
//	@CacheLookup
	WebElement nname;

	@FindBy(xpath = "//input[@name='Age']")
//	@CacheLookup
	WebElement age;

	@FindBy(xpath = "//input[@name='Height']")
//	@CacheLookup
	WebElement height;

	@FindBy(xpath = "//input[@name='Weight']")
//	@CacheLookup
	WebElement weight;

	////// ====================BIRTHDAY==========================
	@FindBy(xpath = "//button[@class='btn btn-default'][@ng-click='dp.open()'][@type='button']")
//	@CacheLookup
	WebElement bdb;
	@FindBy(xpath = "//button[@tabindex='-1']")
//	@CacheLookup
	WebElement bdb1;

	@FindBy(xpath = "//span[@class='ng-binding'][text()='1999']")
//	@CacheLookup
	WebElement bdb2;

	@FindBy(xpath = "//span[text()='July']")
//	@CacheLookup
	WebElement bdb3;

	@FindBy(xpath = "//span[text()='14']")
//	@CacheLookup
	WebElement bdb4;
	///// =====================================================
	@FindBy(xpath = "//option[text()='M']")
//	@CacheLookup
	WebElement sex;

	@FindBy(xpath = "//select[@ng-model='wizard.report.suspectType']/option[text()='Other']")
//	@CacheLookup
	WebElement sustype;

	@FindBy(xpath = ".//select[@ng-model='wizard.report.race']/option[text()='Other']")
//	@CacheLookup
	WebElement race;

	@FindBy(xpath = ".//select[@ng-model='wizard.report.build']/option[text()='Medium']")
//	@CacheLookup
	WebElement build;

	@FindBy(xpath = ".//select[@ng-model='wizard.report.hairColor']/option[text()='Blue']")
//	@CacheLookup
	WebElement hair1;

	@FindBy(xpath = "//select[@ng-model='wizard.report.hairLength']/option[text()='Long']")
//	@CacheLookup
	WebElement hair2;

	@FindBy(xpath = "//select[@ng-model='wizard.report.hairStyle']/option[text()='Short']")
//	@CacheLookup
	WebElement hair3;

	@FindBy(xpath = "//select[@ng-model='wizard.report.eyeColor']/option[text()='Blue']")
//	@CacheLookup
	WebElement eye;

	@FindBy(xpath = "//select[@ng-model='wizard.report.complexion']/option[text()='Medium']")
//	@CacheLookup
	WebElement compl;

	@FindBy(xpath = "//select[@ng-model='wizard.report.teeth']/option[text()='Gold']")
//	@CacheLookup
	WebElement teeth;

	@FindBy(xpath = "//select[@ng-model='wizard.report.handPreference']/option[text()='Left']")
//	@CacheLookup
	WebElement hend;

	@FindBy(xpath = "//select[@ng-model='wizard.report.country']/option[text()='Canada']")
//	@CacheLookup
	WebElement country;

	@FindBy(xpath = "//input[@name='primary-language']")
//	@CacheLookup
	WebElement langv;

	@FindBy(xpath = "//input[@name='street-address']")
//	@CacheLookup
	WebElement str;

	@FindBy(xpath = "//input[@name='city']")
//	@CacheLookup
	WebElement city;

	@FindBy(xpath = "//input[@name='state']")
//	@CacheLookup
	WebElement state;

	@FindBy(xpath = "//input[@name='zip']")
//	@CacheLookup
	WebElement zip;

	@FindBy(xpath = "//input[@name='phone']")
//	@CacheLookup
	WebElement phone;

	@FindBy(xpath = "//input[@placeholder='Contact E-Mail']")
//	@CacheLookup
	WebElement email;

	@FindBy(xpath = "//label[contains(.,'Driver')]")
//	@CacheLookup
	WebElement radio;
	
	@FindBy(xpath = "html/body/div[2]/section/div/div/form/div[1]/div[2]/div[3]/ul/li[2]/a")
//	@CacheLookup
	WebElement next2;

	// Thread.sleep(6000);


	public void subjectInfo(String id, String name, String a,  String b, String c,String eng,String s,  String e,
			String CA, String f, String tel, String email1) {

		caseid.sendKeys(id);
		fname.sendKeys(name);
		lname.sendKeys(name);
		mname.sendKeys(name);
		nname.sendKeys(name);
		age.sendKeys(a);
		height.clear();
		height.sendKeys(b);
		weight.clear();
		weight.sendKeys(c);
		bdb.click();
		bdb1.click();
		bdb2.click();
		bdb3.click();
		bdb4.click();
		sex.click();
		sustype.click();
		race.click();
		build.click();
		hair1.click();
		hair2.click();
		hair3.click();
		eye.click();
		compl.click();
		teeth.click();
		hend.click();
		country.click();
		langv.sendKeys(eng);
		str.sendKeys(s);
		city.sendKeys(e);
		state.sendKeys(CA);
		zip.sendKeys(f);
		phone.sendKeys(tel);
		email.sendKeys(email1);
		radio.click();
		next2.click();
	}
}
