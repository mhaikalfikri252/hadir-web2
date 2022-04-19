package com.hadir.web2.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hadir.web2.drivers.DriverSingleton;

public class NationalHolidayPage {

	WebDriver driver;

	public NationalHolidayPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "National Holiday")
	WebElement btnNtnlHoliday;

//	Search
	@FindBy(css = "#data-table-responsive_filter > label > input")
	WebElement searchData;

//	Max Min Layout
	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")

	WebElement minimize;
	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	WebElement maximize;

//	Add Data
	@FindBy(css = "#content > div.row > div > div > div.panel-heading.ui-sortable-handle > button")
	WebElement btnAdd;
	@FindBy(id = "tanggal")
	WebElement date;
	@FindBy(id = "ket")
	WebElement description;
	@FindBy(css = "#modal_add > div > div > form > div.modal-footer > button.btn.btn-primary")
	WebElement btnSave;

//	Edit Data
	@FindBy(css = "#data-table-responsive > tbody > tr > td:nth-child(3) > a.btn.btn-success.btn-xs")
	WebElement btnEdit;
	@FindBy(id = "tanggal1")
	WebElement editdate;
	@FindBy(id = "ket1")
	WebElement editDescription;
	@FindBy(css = "#modal_edit > div > div > form > div.modal-footer > button.btn.btn-primary")
	WebElement btnSaveEdit;

//	Delete Data
	@FindBy(css = "#data-table-responsive > tbody > tr > td:nth-child(3) > a.btn.btn-danger.btn-xs")
	WebElement btnDelete;
	@FindBy(css = "#modal_dlt > div > div > form > div.modal-footer > button:nth-child(1)")
	WebElement btnSubmitDelete;

	@FindBy(css = "#content > div.row > div > div > div:nth-child(3) > div > div > strong")
	WebElement getText;

	public void goToNationalHolidayPage() {
		tunggu(3);
		btnNtnlHoliday.click();
	}

	public void searchData() {
		searchData.sendKeys("Rabu");
	}

	public void maxMinLayout() {
		tunggu(2);
		for (int i = 1; i <= 2; i++) {
			minimize.click();
			tunggu(3);
		}

		tunggu(2);
		for (int i = 1; i <= 2; i++) {
			maximize.click();
			tunggu(3);
		}
	}

	public void addNationalHoliday() {
		tunggu(1);
		btnAdd.click();
		tunggu(2);
		date.sendKeys("12032022");
		tunggu(2);
		description.sendKeys("Hari Raya Idul Adha");
		tunggu(2);
		btnSave.click();
	}

	public void editData() {
		searchData.sendKeys("adha");
		tunggu(2);
		btnEdit.click();
		tunggu(2);
		editDescription.sendKeys(Keys.CONTROL + "a");
		tunggu(2);
		editDescription.sendKeys("Hari Raya Idul Fitri");
		tunggu(2);
		editdate.sendKeys("11032022");
		tunggu(2);
		btnSaveEdit.click();
	}

	public void deleteData() {
		tunggu(2);
		searchData.sendKeys("fitri");
		tunggu(2);
		btnDelete.click();
		tunggu(2);
		btnSubmitDelete.click();
		tunggu(2);
	}

	public String getTextNationalHoliday() {
		return getText.getText();
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(detik * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
