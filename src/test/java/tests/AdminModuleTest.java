package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

public class AdminModuleTest extends TestBase{
	
	@Test(priority = 1)
	public void validateIfAdminPageOpenSuccessfully() {
		signIntoAppWithParticularUser("validateIfAdminPageOpenSuccessfully","AdminModuleTest");
		adminPage.adminModule.click();
		String urlValidation = driver.getCurrentUrl();
		assertTrue(urlValidation.contains("admin"));
	}
	
	@Test
	public void searchSystemUsersBasedOnBelowNames() {		
		try {
		signIntoAppWithParticularUser("searchSystemUsersBasedOnBelowNames","AdminModuleTest");
		adminPage.adminModule.click();
		int systemUser = getRandomBetweenRange(1, adminPage.listOfUsername.size());
		String getUserDetails = adminPage.listOfUsername.get(systemUser).getText();
		System.out.println("getUserDetails: "+ getUserDetails);
		String [] userDetailsArray = getUserDetails.split(" ");
		adminPage.uesnameField.sendKeys(userDetailsArray[0]);
		
		for(int i = 0; i < adminPage.userRoleElements.size(); i++) {
			if(adminPage.userRoleElements.get(i).getText().equals(userDetailsArray[1])) {
				dropDown(adminPage.userRoleElements.get(i));
			}
		}
		adminPage.employeeNameFiled.sendKeys(userDetailsArray[2]);
		
		for(int i = 0; i < adminPage.statusDropDownElement.size(); i++) {
			if(adminPage.statusDropDownElement.get(i).getText().equals(userDetailsArray[3])) {
				dropDown(adminPage.statusDropDownElement.get(i));
			}
		}
		adminPage.searchButton.click();		
		assertEquals(adminPage.listOfUsername.get(0).getText(), getUserDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
