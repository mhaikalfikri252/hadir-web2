package com.hadir.web2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hadir.web2.drivers.DriverSingleton;

public class ReportKaryawanPage {

	WebDriver driver;
	Actions act;

	public ReportKaryawanPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(10) > a")
	WebElement btnReportKaryawan;

	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	WebElement btnMaximize;

	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	WebElement btnMinimize;

	@FindBy(css = "#data-table-responsive_length > label > select")
	WebElement showEntries;

	@FindBy(css = "#data-table-responsive_filter > label > input")
	WebElement search;

	@FindBy(css = "#data-table-responsive > tbody > tr > td.sorting_1")
	WebElement btnPlus;

	// View Detail

	@FindBy(css = "#data-table-responsive > tbody > tr.child > td > ul > li:nth-child(3) > span.dtr-data > a")
	WebElement btnViewDetail;

	@FindBy(id = "startdate")
	WebElement startDate;

	@FindBy(id = "enddate")
	WebElement endDate;

	@FindBy(id = "filter")
	WebElement btnGo;

	@FindBy(css = "#content > div.row > div > div > div.panel-body.bg-black.text-white > div > div.col-md-10 > div > form > div > div > label.label > a")
	WebElement btnExport;

	@FindBy(css = "#data-table-responsive > thead > tr > th:nth-child(1)")
	WebElement sortNo;

	@FindBy(css = "#data-table-responsive > tbody > tr:nth-child(1) > td.f-s-600.text-inverse.sorting_1")
	WebElement btnPlusDetail;

	@FindBy(css = "#data-table-responsive > tbody > tr.child > td > ul > li:nth-child(3) > span.dtr-data > a")
	WebElement btnViewDetailAgain;

	@FindBy(css = "#modalview > div > div > div.modal-header > button")
	WebElement btnClosePopUp;

	@FindBy(css = "#data-table-responsive_next > a")
	WebElement btnNext;

	@FindBy(css = "body > a")
	WebElement btnScrollUp;

	@FindBy(id = "data-table-responsive_info")
	WebElement textShowEntries;

	public void goToReportKaryawan() {
		tunggu(2);
		btnReportKaryawan.click();
		tunggu(2);
	}

	public void manageReportKaryawan() {
		btnMinimize.click();
		tunggu(2);
		btnMinimize.click();
		tunggu(2);
		btnMaximize.click();
		tunggu(2);
		btnMaximize.click();
		tunggu(2);
		for (int i = 1; i <= 1; i++) {
			showEntries.sendKeys(Keys.DOWN);
		}
		showEntries.sendKeys(Keys.ENTER);
		tunggu(2);
		search.sendKeys("Aldo");
		tunggu(2);
		btnPlus.click();
		tunggu(2);
		btnPlus.click();
		tunggu(1);
		btnPlus.click();

	}

	public void viewDetailReport() {
		tunggu(2);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(btnViewDetail));
//		btnViewDetail.click();
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
