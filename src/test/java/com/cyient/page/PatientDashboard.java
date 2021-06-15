package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientDashboard {
  private By frameLocator=By.xpath("//iframe[@name='pat']");
  private By medicalRecordLocator=By.xpath("//h2[contains(text(),'Medical Record')]");
  private WebDriver driver;
  
	public PatientDashboard(WebDriver driver) {

		this.driver = driver;

	}

	public void SwitchToFrame() {

		 driver.switchTo().frame(driver.findElement(frameLocator));
	}

  public String medicalRecord() {
	  return driver.findElement(medicalRecordLocator).getText().trim();
  }
}
