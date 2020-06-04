package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.Driver;



public class LoginPage extends Driver {

	@FindBy(name = "txtUsername")
	public WebElement usernameField;
	
	@FindBy(name = "txtPassword")
	public WebElement passwordField;
	
	@FindBy(name = "Submit")
	public WebElement submittButton;
	
	@FindBy(xpath = "//span[contains(text(),'Invalid credentials')]")
	public WebElement errorMessage;
	
}
