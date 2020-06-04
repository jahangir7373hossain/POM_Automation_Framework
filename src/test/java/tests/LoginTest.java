package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class LoginTest extends TestBase{
	
	@Test(description = "Verify if log in is successful")
	public void testLoginWithValidCredentials() {
		signIntoAppWithParticularUser("testLoginWithValidCredentials","LoginTest");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");		
	}
	
	@Test(description = "Verify if log in should not be successful")
	public void testLoginWithInvalidCredentials() {
		signIntoAppWithParticularUser("testLoginWithInvalidCredentials","LoginTest");
		Assert.assertEquals(loginPage.errorMessage.getText(), "Invalid credentials");		
	}

}
