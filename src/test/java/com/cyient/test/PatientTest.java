package com.cyient.test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.AddPatientPage;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.page.PatientDashboard;
import com.cyient.page.PatientFinderPage;

public class PatientTest extends WebDriverWrapper {

	@Test
	public void allPatientTest() throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.sendUsername("admin");
		login.sendPassword("pass");
		login.selectLanaguageByText("English (Indian)");
		login.clickOnLogin();

		// DashboardPage
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.getDashboardPageTitle();
		dashboard.mousehoverOnPatientClient();
		dashboard.patientDetails();;

		// patient finder
		PatientFinderPage patientFinder = new PatientFinderPage(driver);
		patientFinder.switchToFinFrame();
		patientFinder.clickOnAddNewPatient();
		patientFinder.switchOutOfFrame();

		// AddPatientPage
		AddPatientPage addPatient = new AddPatientPage(driver);
		addPatient.switchFrame();
		addPatient.firstName("shraddha");
		addPatient.LastName("Hiwarkar");
		addPatient.dob("1998-04-28");
		addPatient.gender("female");
		addPatient.createNewPatient();
		addPatient.switchoutofFrame();
		Thread.sleep(3000);
          addPatient.switchFrame();
          addPatient.confirmNewPatient();
          addPatient.switchoutofFrame();
          Thread.sleep(3000);
          addPatient.alertpatient();
          addPatient.closeframe();

	
        //patientDashboad
          PatientDashboard record = new PatientDashboard(driver);
          record.SwitchToFrame();
          String actualValue = record.medicalRecord();
  		System.out.println(actualValue);
  	    Assert.assertEquals(actualValue,record.medicalRecord());
  	
	

	}

}
