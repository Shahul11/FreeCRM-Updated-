package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME_OUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static FileInputStream file;
	public static Workbook wb;

	public void swithToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData() {
		String path = "C:/Users/310259741/Documents/ProjectManagment/FreeCRM/src/main/java/com/crm/qa/testdata/TestData.xlsx";
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("contacts");
		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).toString();

			}
		}

		return data;
	}
	
	
	public static void takeScreenShotAtEndofTest() throws IOException
	{
		File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(currentDir+ "/ScreenShotFolder/"+System.currentTimeMillis()+".png"));
	}

}
