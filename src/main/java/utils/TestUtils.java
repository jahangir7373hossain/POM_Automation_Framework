package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Driver;

public class TestUtils{
	
	static String projectPath;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	/**
	 * Method name: getUsernameAndPasswordBasedUponTestCase
	 * Method Description: This method will fetch user name and password based on class name and test case requirement from excel
	 * Author: Jahangir Khan
	 * @param testCase
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	public List<String> getUsernameAndPasswordBasedUponTestCase(String testCase,String sheetName) throws IOException {
		String strExecFlag;
		Row row;
		projectPath = System.getProperty("user.dir");
		workBook = new XSSFWorkbook(projectPath+"/excel/loginData.xlsx");
		Sheet sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		List<String> usernamePasswordList = new ArrayList<String>();
		String username = null;
		String password= null;
		for(int i = 0; i <= rowCount; i++) {
			row = sheet.getRow(i);
			Cell valueCell = row.getCell(0);
			strExecFlag = valueCell.getStringCellValue();
			if(strExecFlag.equalsIgnoreCase(testCase)) {
				Cell usernameCell = row.getCell(1);
				username = usernameCell.getStringCellValue();
				Cell passwordCell = row.getCell(2);
				password = passwordCell.getStringCellValue();
			}
		}
		usernamePasswordList.add(username);
		usernamePasswordList.add(password);
		return usernamePasswordList;
	}

	
	public static String getProperty(String key) {
		String value = null;
		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);
		if (value == null) {
			String env = prop.getProperty("testEnv");
			prop = loadProperty(env);
			value = prop.getProperty(key);
		}

		return value;
	}

	public static Properties loadProperty(String propFileName) {
		Properties prop = new Properties();
		String filePath = ".\\src\\main\\resources\\properties\\"+ propFileName +".properties";
		try {
			File file = new File(filePath);
			FileInputStream stream = new FileInputStream(file);
			prop.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}

	/**
	 * Method name :getRandomBetweenRange
	 * @param min
	 * @param max
	 * @return
	 */
	public int getRandomBetweenRange(int min, int max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return (int) x;
	}

	public void dropDown(WebElement element) {
		try {
			Select select = new Select(element);
			if (element.isDisplayed()) {
				select.deselectByValue(element.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
