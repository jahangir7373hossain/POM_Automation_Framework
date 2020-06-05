package page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {

	@FindBy(css = "a[id='menu_admin_viewAdminModule']")
	public WebElement adminModule;
	@FindBy(css = "input[id='searchSystemUser_userName']")
	public WebElement uesnameField;
	@FindBy(css = "select[id='searchSystemUser_userType']")
	public WebElement userRoleDropDownBox;
	@FindBy(xpath = "//select[@id='searchSystemUser_userType']//option")
	public List<WebElement> userRoleElements;
	@FindBy(css = "input[id='searchSystemUser_employeeName_empName']")
	public WebElement employeeNameFiled;
	@FindBy(css = "select[id='searchSystemUser_status']")
	public WebElement statusDropDownBox;
	@FindBy(xpath = "//select[@id='searchSystemUser_status']//option")
	public List<WebElement> statusDropDownElement;
	@FindBy(css = "input[id='searchBtn']")
	public WebElement searchButton;
	@FindBy(xpath = "//table[@id='resultTable']//tbody//tr")
	public List<WebElement> listOfUsername;
	@FindBy(css = "td[class='left']")
	public List<WebElement> usernameDetailsFromList;
}
