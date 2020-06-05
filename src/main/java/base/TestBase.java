package base;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.relevantcodes.extentreports.ExtentTest;

import page.AdminPage;
import page.LoginPage;
@Listeners(listener.TestListener.class)
public class TestBase extends Driver{
	
	public static LoginPage loginPage;
	public ExtentTest extentTest;
	public static AdminPage adminPage;
	
	@BeforeMethod
	public void setup() {	
		setDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		adminPage = PageFactory.initElements(driver, AdminPage.class);
	}
	

	@AfterMethod
	public void tearDowon(ITestResult result) throws IOException {		
		driver.quit();
	}
	
	/**
	 * Method name:signIntoAppWithParticularUser
	 * Method Description: This method will be used in every test case,because this method will pass username and password based on test case and class
	 * Author: Jahangir Khan
	 * @param testCaseName
	 * @param className
	 */
	public void signIntoAppWithParticularUser(String testCaseName,String className) {	
		try {
		loginPage.usernameField.clear();
		System.out.println("Class name: "+ className);
		loginPage.usernameField.sendKeys(getUsernameAndPasswordBasedUponTestCase(testCaseName,className).get(0));
		System.out.println("Username is: " +getUsernameAndPasswordBasedUponTestCase(testCaseName,className).get(0));
		loginPage.passwordField.clear();
		loginPage.passwordField.sendKeys(getUsernameAndPasswordBasedUponTestCase(testCaseName,className).get(1));
		System.out.println("Password is: " +getUsernameAndPasswordBasedUponTestCase(testCaseName,className).get(1));
		loginPage.submittButton.click();
		}catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
