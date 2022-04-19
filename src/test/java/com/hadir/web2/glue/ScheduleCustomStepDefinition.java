package com.hadir.web2.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web2.config.AutomationFrameworkConfig;
import com.hadir.web2.drivers.DriverSingleton;
import com.hadir.web2.pages.LoginPage;
import com.hadir.web2.pages.ScheduleCustomPage;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class ScheduleCustomStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ScheduleCustomPage scheduleCustomPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportScheduleCustom.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		scheduleCustomPage = new ScheduleCustomPage();
		extentTest = reports.startTest("Testing Schedule Custom Page");
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

	@Given("Admin mengakses url web astro")
	public void admin_mengakses_url_web_astro() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin login ke web astro")
	public void admin_login_ke_web_astro() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin login ke web astro");
	}

	@And("Admin mengakses menu schedule custom")
	public void admin_mengakses_menu_schedule_custom() {
		scheduleCustomPage.goToScheduleCustom();
		extentTest.log(LogStatus.PASS, "Admin mengakses menu schedule custom");
	}

//	@And("Admin mengakses fitur filter")
//	public void admin_mengakses_fitur_filter() {
//		scheduleCustomPage.fitur_filter();
//		extentTest.log(LogStatus.PASS, "Admin mengakses fitur filter");
//	}
//	
	@And("Admin menambah data absen user")
	public void admin_menambah_data_absen_user() {
		scheduleCustomPage.menambahDataUser();
		extentTest.log(LogStatus.PASS, "Admin menambah data absen user");
	}

	@Then("Data berhasil terupdate")
	public void data_berhasil_terupdate() {
		assertEquals(configurationProperties.getTextSuccessAdd(), scheduleCustomPage.getTextSuccess());
		extentTest.log(LogStatus.PASS, "Data berhasil terupdate");
	}

}
