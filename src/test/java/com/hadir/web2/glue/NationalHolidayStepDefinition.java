package com.hadir.web2.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web2.config.AutomationFrameworkConfig;
import com.hadir.web2.drivers.DriverSingleton;
import com.hadir.web2.pages.LoginPage;
import com.hadir.web2.pages.NationalHolidayPage;
import com.hadir.web2.utils.ConfigurationProperties;
import com.hadir.web2.utils.Constants;
import com.hadir.web2.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class NationalHolidayStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private NationalHolidayPage nationalHolidayPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportNationalHoliday.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		nationalHolidayPage = new NationalHolidayPage();
		extentTest = reports.startTest("Testing National Holiday Page");
	}

	@AfterStep
	public void getResult(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:/n" + extentTest.addScreenCapture(screenshotPath));
		}
	}

	@After
	public void closeObject() {
		reports.endTest(extentTest);
		reports.flush();
	}

	@AfterAll
	public static void closeBrowser() {
//		driver.quit();
	}

	@Given("Admin akses url")
	public void admin_access_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin access login")
	public void admin_akses_login() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");
	}

	@When("Admin access National Holiday")
	public void admin_akses_national_holiday() {
		nationalHolidayPage.goToNationalHolidayPage();
		extentTest.log(LogStatus.PASS, "Admin access National Holiday page");
	}

	@When("Admin search data Holiday")
	public void admin_search_data_holiday() {
		nationalHolidayPage.searchData();
		extentTest.log(LogStatus.PASS, "Admin search data Holiday");
	}

	@When("Admin click maximize and minimize layout")
	public void admin_maximize_and_minimize_layout() {
		nationalHolidayPage.maxMinLayout();
		extentTest.log(LogStatus.PASS, "Admin click maximize and minimize layout");
	}

	@When("Admin add national holiday")
	public void admin_add_national_holiday() {
		nationalHolidayPage.addNationalHoliday();
		extentTest.log(LogStatus.PASS, "Admin add national holiday");
	}

	@When("Admin Edit data national holiday")
	public void admin_edit_data_national_holiday() {
		nationalHolidayPage.editData();
		extentTest.log(LogStatus.PASS, "Admin Edit data national holiday");
	}

	@When("Admin delete data national holiday")
	public void admin_delete_data_national_holiday() {
		nationalHolidayPage.deleteData();
		extentTest.log(LogStatus.PASS, "Admin delete data national holiday");
	}

	@Then("Admin Success add, edit, and delete national holiday")
	public void admin_success_add_edit_and_delete_national_holiday() {
		assertEquals(configurationProperties.getTextNationalHoliday(), nationalHolidayPage.getTextNationalHoliday());
		extentTest.log(LogStatus.PASS, "Admin Success add, edit, and delete national holiday");
	}

}
