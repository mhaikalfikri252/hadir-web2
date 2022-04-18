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

	@FindBy(css = "#content > h1")
	WebElement textDashboard;

	public void submitLogin(String usernamee, String password) {
		userName.sendKeys(usernamee);
		userPassword.sendKeys(password);
		btnLogin.click();
	}

	public String getTextDashboard() {
		return textDashboard.getText();
	}
}
