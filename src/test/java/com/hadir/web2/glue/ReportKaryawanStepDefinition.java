package com.hadir.web2.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web2.config.AutomationFrameworkConfig;
import com.hadir.web2.drivers.DriverSingleton;
import com.hadir.web2.pages.LoginPage;
import com.hadir.web2.pages.ReportKaryawanPage;
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
public class ReportKaryawanStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ReportKaryawanPage reportKaryawanPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportKaryawan.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		reportKaryawanPage = new ReportKaryawanPage();
		extentTest = reports.startTest("Testing Report Karyawan Page");
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

	@Given("Admin access url hadir 2")
	public void admin_access_url_hadir_2() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin access login url")
	public void admin_access_login_url() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin access login url");
	}

	@And("Admin access report karyawan")
	public void admin_access_report_karyawan() {
		reportKaryawanPage.goToReportKaryawan();
		extentTest.log(LogStatus.PASS, "Admin access report karyawan");
	}

	@And("Admin manage report karyawan")
	public void admin_manage_report_karyawan() {
		reportKaryawanPage.manageReportKaryawan();
		extentTest.log(LogStatus.PASS, "Admin manage report karyawan");
	}

	@And("Admin access view detail report")
	public void admin_access_view_detail_report() {
		reportKaryawanPage.viewDetailReport();
		extentTest.log(LogStatus.PASS, "Admin access view detail report");
	}

	@Then("Admin success export data report karyawan")
	public void admin_success_export_data_report_karyawan() {
		assertEquals(configurationProperties.getTextShowEntries(), reportKaryawanPage.getTextShowEntries());
		extentTest.log(LogStatus.PASS, "Admin success export data report karyawan");
	}

}
