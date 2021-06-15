package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddPatientPage {

	private By patFrameLocator = By.xpath("//iframe[@name='pat']");
	private By fnameLocator = By.xpath("//input[@id='form_fname']");
	private By lnameLocator = By.xpath("//input[@id='form_lname']");
	private By DOBLocator = By.xpath("//input[@id='form_DOB']");

	private By genderLocator = By.xpath("//input[@id='form_sex']");
	private By newpatientLocator = By.xpath("//button[normalize-space()='Create New Patient']");
	private By frameLocator = By.xpath("//iframe[@id='modalframe']");

	private By confirmnewpatientLocator = By.xpath("//input[@value='Confirm Create New Patient']");
	private By closeframeLocator = By.xpath("//div[@class='closeDlgIframe']");
	private WebDriver driver;

	

	public AddPatientPage(WebDriver driver) {

		this.driver = driver;

	}

	public void switchToFrame() {

		driver.switchTo().frame(driver.findElement(patFrameLocator));
	}

	public void firstName(String first) {

		driver.findElement(fnameLocator).sendKeys(first);
	}

	public void LastName(String last) {

		driver.findElement(lnameLocator).sendKeys(last);
	}

	public void dob(String dob) {

		driver.findElement(DOBLocator).sendKeys(dob);

	}

	public void gender(String formsex) {

		Select gender = new Select(driver.findElement(genderLocator));
		gender.selectByVisibleText(formsex);

	}

	public void createNewPatient() {

		driver.findElement(newpatientLocator).click();

	}

	public void switchoutofFrame() {

		driver.switchTo().defaultContent();

	}

	public void switchFrame() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(frameLocator));

	}

	public void confirmNewPatient() {
		driver.findElement(confirmnewpatientLocator).click();
	}

	public String alertpatient() throws InterruptedException {
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		return alert;

	}

	public void closeframe() {
		driver.findElement(closeframeLocator).click();
	}

}
