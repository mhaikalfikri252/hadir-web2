package com.hadir.web2.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web2.drivers.DriverSingleton;

public class Approval_lzin {

	WebDriver driver;

	public Approval_lzin() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Approval Izin")
	WebElement btnAprIzin;
//	Filter day
	@FindBy(id = "startdate")
	WebElement startDate;
	@FindBy(id = "enddate")
	WebElement endDate;
	@FindBy(id = "filter")
	WebElement btnGo;
	
//	search data
	@FindBy(css = "#data-table-responsive_filter > label > input")
	WebElement searchData;
	
//	Approve Izin
	@FindBy(css = "#data-table-responsive > tbody > tr:nth-child(1) > td.sorting_1 > input")
	WebElement checkBox;
	@FindBy(css = "#content > div.row > div > div > div:nth-child(3) > form > button.btn.btn-primary")
	WebElement btnApprove;
	
//	Reject Izin
	@FindBy(css = "#content > div.row > div > div > div:nth-child(3) > form > button.btn.btn-danger")
	WebElement btnReject;
	
//	view foto
	@FindBy(linkText = "Lihat foto")
	WebElement viewPhoto;
//	text
	@FindBy(css = "#content > h1")
	WebElement getTextIzin;
	
	
	public void go_to_approval_izin_pages() {
		tunggu(2);
		btnAprIzin.click();
		tunggu(2);
	}
	
	public void filterData() {
		startDate.sendKeys("03202022");
		tunggu(2);
		endDate.sendKeys("04122022");
		tunggu(2);
		btnGo.click();
		tunggu(2);
		searchData.sendKeys("sakit");
	}
	
	public void approveIzin() {
		driver.navigate().refresh();
		tunggu(3);
		searchData.sendKeys("04");
		checkBox.click();
		tunggu(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnApprove);
//		js.executeScript("window.scrollBy(0,300)");
		tunggu(2);
		btnApprove.click();
		tunggu(2);
		driver.switchTo().alert().accept();	
	}
	
	public void rejectIzin() {
		driver.navigate().refresh();
		tunggu(3);
		searchData.sendKeys("04");
		checkBox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnReject);
		tunggu(2);
		btnReject.click();
		tunggu(2);
		driver.switchTo().alert().accept();	
	}
	
	public void viewPhoto() {
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("Lihat foto")).sendKeys(selectLinkOpeninNewTab);

	}
	
	public String getTxtIzin() {
		return getTextIzin.getText();
	}
	
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
