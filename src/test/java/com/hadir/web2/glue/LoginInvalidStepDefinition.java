package com.hadir.web2.glue;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hadir.web2.config.AutomationFrameworkConfig;
import com.hadir.web2.drivers.DriverSingleton;
import com.hadir.web2.pages.LoginPage;
import com.hadir.web2.utils.ConfigurationProperties;
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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class LoginInvalidStepDefinition {

	private static WebDriver driver;
	private LoginPage loginPage;
	ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/main/resources/TestReportLoginInvalid.html");

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		extentTest = reports.startTest("Testing User Login Invalid");

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

	@When("User melakukan logout")
	public void user_melakukan_logout() {
		loginPage.logoutAction();
		extentTest.log(LogStatus.PASS, "User melakukan logout");
	}

	@And("User kembali melakukan login")
	public void user_kembali_melakukan_login() {
		loginPage.submitLogin("user", "user1234");
		extentTest.log(LogStatus.PASS, "User kembali melakukan login");
	}

	@Then("User tidak berhasil login")
	public void user_tidak_berhasil_login() {
		tunggu();
		assertEquals(configurationProperties.getTextInvalidLogin(), loginPage.getTextInvalidLogin());
		extentTest.log(LogStatus.PASS, "User tidak berhasil login");
	}

	public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scroll() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}

}
