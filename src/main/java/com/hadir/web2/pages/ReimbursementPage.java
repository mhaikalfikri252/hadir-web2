package com.hadir.web2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web2.drivers.DriverSingleton;

public class ReimbursementPage {

	WebDriver driver;

	public ReimbursementPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub > a")
	WebElement btnReimbursement;

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(1) > a")
	WebElement btnPayment;

	@FindBy(css = "#content > div.row > div > div > div:nth-child(3) > form > button")
	WebElement btnApprove;

	@FindBy(css = "#data-table-responsive > thead > tr > th.sorting_asc > input[type=checkbox]")
	WebElement checkBox;

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.active > ul > li:nth-child(2) > a")
	WebElement btnReport;

	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	WebElement btnMaximize;

	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	WebElement btnMinimize;

	@FindBy(css = "#data-table-responsive_length > label > select")
	WebElement showEntries;

	@FindBy(id = "startdate")
	WebElement startDate;

	@FindBy(id = "enddate")
	WebElement endDate;

	@FindBy(id = "filter")
	WebElement btnGo;

	@FindBy(css = "#content > div.row > div > div > div.panel-body.bg-black.text-white > div > div.col-md-10 > div > form > div > div > label.label > a")
	WebElement btnExport;

	@FindBy(css = "#data-table-responsive_filter > label > input")
	WebElement search;

	@FindBy(css = "#data-table-responsive > thead > tr > th:nth-child(1)")
	WebElement sortNo;

	@FindBy(css = "#data-table-responsive > thead > tr > th.sorting_desc")
	WebElement sortNoDesc;

	@FindBy(css = "#data-table-responsive > tbody > tr:nth-child(1) > td.f-s-600.text-inverse.sorting_1")
	WebElement btnPlus;

	@FindBy(css = "#data-table-responsive_next > a")
	WebElement btnNext;

	@FindBy(css = "body > a")
	WebElement btnScrollUp;

	@FindBy(id = "data-table-responsive_info")
	WebElement textShowEntries;

	public void goToReimbursement() {
		tunggu(2);
		btnReimbursement.click();
		tunggu(2);
	}

	public void goToPayment() {
		tunggu(2);
		btnPayment.click();
		tunggu(2);
	}

	public void managePayment() {
		btnMinimize.click();
		tunggu(1);
		btnMinimize.click();
		tunggu(3);
		btnMaximize.click();
		tunggu(4);
		btnMaximize.click();
		tunggu(2);
		startDate.sendKeys("01/01/2022");
		tunggu(2);
		startDate.sendKeys("18/04/2022");
		tunggu(1);
		btnGo.click();
		tunggu(2);
		for (int i = 1; i <= 2; i++) {
			showEntries.sendKeys(Keys.DOWN);
		}
		showEntries.sendKeys(Keys.ENTER);
		tunggu(2);
		search.sendKeys("test");
		tunggu(2);
		checkBox.click();
		tunggu(2);
		sortNo.click();
		tunggu(2);
		btnApprove.click();
		tunggu(2);
		driver.switchTo().alert().dismiss();
	}

	public void goToReport() {
		tunggu(2);
		btnReport.click();
		tunggu(2);
	}

	public void manageReport() {
		btnMinimize.click();
		tunggu(1);
		btnMinimize.click();
		tunggu(3);
		btnMaximize.click();
		tunggu(4);
		btnMaximize.click();
		tunggu(2);
		startDate.sendKeys("02/02/2022");
		tunggu(2);
		startDate.sendKeys("18/04/2022");
		tunggu(1);
		btnGo.click();
		tunggu(3);
		btnExport.click();
		tunggu(4);
		for (int i = 1; i <= 1; i++) {
			showEntries.sendKeys(Keys.DOWN);
		}
		showEntries.sendKeys(Keys.ENTER);
		tunggu(2);
		search.sendKeys("septianyono");
		tunggu(2);
		sortNo.click();
		tunggu(2);
		btnPlus.click();
		tunggu(3);
		btnNext.click();
		tunggu(3);
		btnScrollUp.click();
	}

	public String getTextShowEntries() {
		return textShowEntries.getText();
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
