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
	@FindBy(xpath = "//input[@value='Add']")
	public WebElement addButton;
	@FindBy(css = "select[id='systemUser_userType']")
	public WebElement addUserRoleDropDown;
	@FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
	public WebElement addUserEmployeeName;
	@FindBy(xpath = "//input[@id='systemUser_userName']")
	public WebElement addUserUsername;
	@FindBy(css = "//select[@id='systemUser_status']")
	public WebElement addUserStatusDropDown;
	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement addUserSaveButton;
	@FindBy(css = "input[type='checkbox']")
	public List<WebElement> usernameCheckBox;
	@FindBy(css = "input[type='submit']")
	public WebElement deleteUser;
	@FindBy(xpath = "//input[@id='dialogDeleteBtn']")
	public WebElement confirmDeleteButton;
}
