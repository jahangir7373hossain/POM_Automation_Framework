package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utils.TestUtils;

public class AdminModuleTest extends TestBase{
	TestUtils ts = new TestUtils();
	
	String [] userDetailsArray;
	@Test(priority = 1)
	public void validateIfAdminPageOpenSuccessfully() {
		signIntoAppWithParticularUser("validateIfAdminPageOpenSuccessfully","AdminModuleTest");
		adminPage.adminModule.click();
		String urlValidation = driver.getCurrentUrl();
		assertTrue(urlValidation.contains("admin"));
	}
	
	@Test(priority = 2)
	public void searchSystemUsersBasedOnUserDetails() {		
		try {
		signIntoAppWithParticularUser("searchSystemUsersBasedOnUserDetails","AdminModuleTest");
		ts.explicitWait(adminPage.adminModule);
		adminPage.adminModule.click();
		int systemUser = ts.getRandomBetweenRange(1, adminPage.listOfUsername.size()-1);
		String getUserDetails = adminPage.listOfUsername.get(systemUser).getText();
		System.out.println("getUserDetails: "+ getUserDetails);
		userDetailsArray = getUserDetails.split(" ");
		adminPage.uesnameField.sendKeys(userDetailsArray[0]);
		
//		for(int i = 0; i < adminPage.userRoleElements.size(); i++) {
//			if(adminPage.userRoleElements.get(i).getText().equals(userDetailsArray[1])) {
////				ts.dropDown(adminPage.userRoleElements.get(i));
//				System.out.println(adminPage.userRoleDropDownBox.getText());
//				Select select = new Select(adminPage.userRoleDropDownBox);
//				select.selectByVisibleText(adminPage.userRoleDropDownBox.getText());
//			}
//		}
		adminPage.employeeNameFiled.sendKeys(userDetailsArray[2]);		
//		for(int i = 0; i < adminPage.statusDropDownElement.size(); i++) {
//			if(adminPage.statusDropDownElement.get(i).getText().equals(userDetailsArray[3])) {
//				ts.dropDown(adminPage.statusDropDownElement.get(i));
//			}
//		}
		adminPage.searchButton.click();		
		assertEquals(adminPage.listOfUsername.get(0).getText(), getUserDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	
	@Test(priority = 3)
	public void verifyAddAndDeleteUserOnAddUserPage() {
		try {
			signIntoAppWithParticularUser("verifyAddAndDeleteUserOnAddUserPage","AdminModuleTest");
			adminPage.adminModule.click();
			System.out.println(adminPage.addButton.getText());
			//assertEquals(adminPage.addButton.getAttribute("value"), "Add");
			adminPage.addButton.click();
			String userRole = "ESS";
			//	ts.dropDown(adminPage.addUserRoleDropDown, userRole);
			adminPage.addUserEmployeeName.sendKeys(userDetailsArray[2]+" "+userDetailsArray[3]);
			adminPage.addUserEmployeeName.click();
			String usrName = ts.getRandomString();
			adminPage.addUserUsername.sendKeys(usrName);
			adminPage.addUserUsername.click();
			String statusDropDown = "Enabled";
			adminPage.addUserSaveButton.click();
			String addUserInfo = usrName+" "+userRole+" "+userDetailsArray[2]+" "+userDetailsArray[3]+" "+statusDropDown;
			int indexOfaddUserInfo = 0;
			for(int i = 0; i < adminPage.listOfUsername.size(); i++) {
				String txt =adminPage.listOfUsername.get(i).getText();
				System.out.println(txt);
				if(txt.equalsIgnoreCase(addUserInfo)) {
					assertEquals(adminPage.listOfUsername.get(i).getText(), addUserInfo);
					indexOfaddUserInfo = i;
					break;
				}
			}

			adminPage.usernameCheckBox.get(indexOfaddUserInfo).click();
			adminPage.deleteUser.click();
			adminPage.confirmDeleteButton.click();
		}catch(Exception e) {
			e.printStackTrace();

		}
	}
	
	

}
