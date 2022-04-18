package com.hadir.web2.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web2.config.AutomationFrameworkConfig;
import com.hadir.web2.drivers.DriverSingleton;
import com.hadir.web2.pages.LoginPage;
import com.hadir.web2.pages.ReimbursementPage;
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
public class ReimbursementDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	private ReimbursementPage reimbursementPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportReimbursement.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		reimbursementPage = new ReimbursementPage();
		extentTest = reports.startTest("Testing Reimbursement Page");
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

	@Given("Admin access url hadir2")
	public void admin_access_url_hadir2() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}

	@When("Admin access login page")
	public void admin_access_login_page() {
		loginPage.submitLogin(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "Admin klik login button");
	}

	@When("Admin access reimbursement")
	public void admin_access_reimbursement() {
		reimbursementPage.goToReimbursement();
		extentTest.log(LogStatus.PASS, "Admin access reimbursement");
	}

	@And("Admin access payment")
	public void admin_access_payment() {
		reimbursementPage.goToPayment();
		extentTest.log(LogStatus.PASS, "Admin access payment");
	}

	@When("Admin manage payment")
	public void admin_manage_payment() {
		reimbursementPage.managePayment();
		extentTest.log(LogStatus.PASS, "Admin manage payment");
	}

	@When("Admin access report")
	public void admin_access_report() {
		reimbursementPage.goToReport();
		extentTest.log(LogStatus.PASS, "Admin access report");
	}

	@When("Admin manage report")
	public void admin_manage_report() {
		reimbursementPage.manageReport();
		extentTest.log(LogStatus.PASS, "Admin manage report");
	}

	@Then("Admin success export data report")
	public void admin_success_export_data_report() {
		assertEquals(configurationProperties.getTextApprovalIzin(), reimbursementPage.getTextShowEntries());
		extentTest.log(LogStatus.PASS, "Admin success export data report");
	}

}
