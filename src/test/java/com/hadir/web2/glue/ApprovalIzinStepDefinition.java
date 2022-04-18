package com.hadir.web2.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web2.config.AutomationFrameworkConfig;
import com.hadir.web2.drivers.DriverSingleton;
import com.hadir.web2.pages.ApprovallzinPage;
import com.hadir.web2.pages.LoginPage;
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
public class ApprovalIzinStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ApprovallzinPage approvallzinPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportApproveIzin.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		approvallzinPage = new ApprovallzinPage();
		extentTest = reports.startTest("Testing Approval Izin Page");
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

	@Given("Admin access url")
	public void customer_access_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin akses login")
	public void customer_akses_login() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");
	}

	@When("Admin akses approval izin")
	public void admin_akses_approval_izin_button() {
		approvallzinPage.goToApprovalIzinPage();
		extentTest.log(LogStatus.PASS, "Admin akses approval izin");
	}

	@And("Admin search data izin")
	public void admin_search_data_izin() {
		approvallzinPage.filterData();
		extentTest.log(LogStatus.PASS, "Admin search data izin");
	}

	@When("Admin view photo izin")
	public void admin_view_photo_izin() {
		approvallzinPage.viewPhoto();
		extentTest.log(LogStatus.PASS, "Admin view photo izin");
	}

	@When("Admin reject izin")
	public void admin_reject_izin() {
		approvallzinPage.rejectIzin();
		extentTest.log(LogStatus.PASS, "Admin reject izin");
	}

	@When("Admin approve izin")
	public void admin_approve_izin() {
		approvallzinPage.approveIzin();
		extentTest.log(LogStatus.PASS, "Admin approve izin");
	}

	@Then("Admin Success reject, approve, and view photo izin")
	public void admin_success_reject_approve_and_view_photo_izin() {
		assertEquals(configurationProperties.getTextApprovalIzin(), approvallzinPage.getTextIzin());
		extentTest.log(LogStatus.PASS, "Admin Success reject, approve, and view photo izin");
	}

}
