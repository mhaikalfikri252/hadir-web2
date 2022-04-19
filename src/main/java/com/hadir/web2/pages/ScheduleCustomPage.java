package com.hadir.web2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web2.drivers.DriverSingleton;

public class ScheduleCustomPage {
	WebDriver driver;

	public ScheduleCustomPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	WebElement btnScheduleCustom;

	@FindBy(css = "#data-table-responsive > tbody > tr:nth-child(1) > td.sorting_1")
	WebElement btnExpand;

	@FindBy(css = "#data-table-responsive > tbody > tr.child > td > ul > li > span.dtr-data > a")
	WebElement btnAction;

	@FindBy(css = "#content > div.row > div > div > div.panel-body.bg-black.text-white > div > div.col-md-2 > button")
	WebElement btnAdd;

	// Form Add
	@FindBy(css = "#absen_tgl3")
	WebElement addTanggal;

	@FindBy(css = "#shift_masuk3")
	WebElement addJamMasuk;

	@FindBy(css = "#shift_keluar3")
	WebElement addJamKeluar;

	@FindBy(css = "#absen_status3")
	WebElement addStatus;

	@FindBy(css = "#modalAdd > div > div > div.modal-body > form > fieldset > button")
	WebElement btnSave;

	@FindBy(css = "#content > div.row > div > div > div:nth-child(4) > div > div > strong")
	WebElement txtSuccessAdd;

	// Fitur filter
	@FindBy(id = "startdate")
	WebElement inputStartDate;

	@FindBy(id = "enddate")
	WebElement inputEndDate;

	@FindBy(id = "filter")
	WebElement btnFilter;

	public void go_to_menu_schedule_custom() {
		tunggu(2);
		btnScheduleCustom.click();
	}

//	public void fitur_filter() {
//		tunggu(2);
//		inputStartDate.sendKeys("25/04/2022");
//		tunggu(2);
//		inputEndDate.sendKeys("25/04/2022");
//		tunggu(2);
//		btnFilter.click();
//		
//	}

	public void menambah_data_user() {
		tunggu(2);
		btnExpand.click();
		tunggu(2);
		btnAction.click();
		tunggu(2);
		btnAdd.click();
		tunggu(2);

		addTanggal.sendKeys("25/04/2022");
		tunggu(2);
		addJamMasuk.sendKeys("0900");
		tunggu(2);
		addJamKeluar.sendKeys("1700");
		tunggu(2);
		addStatus.click();
		for (int i = 1; i <= 1; i++) {
			addStatus.sendKeys(Keys.DOWN);
		}
		addStatus.sendKeys(Keys.ENTER);
		tunggu(2);
		btnSave.click();

	}

	public String getTextSuccess() {
		return txtSuccessAdd.getText();
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
