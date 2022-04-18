package com.hadir.web2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web2.drivers.DriverSingleton;

public class LoginPage {
	WebDriver driver;

	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#page-container > div > div.right-content > div.login-content > form > div:nth-child(1) > input")
	WebElement userName;

	@FindBy(css = "#page-container > div > div.right-content > div.login-content > form > div:nth-child(2) > input")
	WebElement userPassword;

	@FindBy(css = "#page-container > div > div.right-content > div.login-content > form > div.login-buttons > button")
	WebElement btnLogin;

	@FindBy(css = "#gritter-item-1 > div.gritter-item > a")
	WebElement closePopUp;

	@FindBy(css = "#header > ul > li > a")
	WebElement btnProfile;

	@FindBy(css = "#header > ul > li > div > a:nth-child(3)")
	WebElement btnLogout;

	@FindBy(css = "#content > h1")
	WebElement textDashboard;


	@FindBy(css = "#page-container > div > div.right-content > div.login-content > div > strong")
	WebElement textInvalidLogin;

	public void submitLogin(String usernamee, String password) {
		userName.sendKeys(usernamee);
		userPassword.sendKeys(password);
		btnLogin.click();
	}

	public void logoutAction() {
		closePopUp.click();
		tunggu(2);
		btnProfile.click();
		tunggu(2);
		btnLogout.click();
	}

	public String getTextDashboard() {
		return textDashboard.getText();
	}

	public String getTextInvalidLogin() {
		return textInvalidLogin.getText();
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
