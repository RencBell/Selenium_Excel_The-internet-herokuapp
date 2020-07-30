package formy;

import base.BaseTests;
import utility.ExcelUtil;
import extentreports.ExtentTestManager;
import formyPages.WebformPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Log;

import static org.testng.Assert.assertTrue;

public class WebformTests extends BaseTests {

    @BeforeTest
    public void setupTestData() {
        //Set Test Data Excel and Sheet
        utility.Log.info("************Setup Test Data Excel**********");
        ExcelUtil.setExcelFileSheet("Credentials2");
    }

    @Test(priority = 1, description = "Happy Case")
    public void fill_webform_with_valid_data() {
        Log.startTestCase("Starting Selenium TestCase_001");

        ExtentTestManager.getTest().setDescription("Fill in the webform with valid data");

        //*************PAGE INSTANTIATIONS*************
        WebformPage webformPage = new WebformPage(driver, wait);

        //*************PAGE METHODS********************
        webformPage.typeFirstname(ExcelUtil.getRowData(1));
        utility.Log.info("Firstname picked from Excel row number 1");

        webformPage.typeLastName(ExcelUtil.getRowData(1));
        utility.Log.info("Lastname picked from Excel row number 1");

        webformPage.typeJobTitle(ExcelUtil.getRowData(1));
        utility.Log.info("Jobtitle picked from Excel row number 1");

        webformPage.clickEducationRadioButton(ExcelUtil.getRowData(1), "Grad School");
        utility.Log.info("Education radio-button picked from Excel row number 1");

        webformPage.clickGenderRadioButton(ExcelUtil.getRowData(1), "Male");
        utility.Log.info("Gender radio-button picked from Excel row number 1");

        webformPage.clickYearsOfExperienceDropDown(ExcelUtil.getRowData(1), "10+");
        utility.Log.info("Years of experience radio-button picked from Excel row number 1");

        webformPage.typeDate(ExcelUtil.getRowData(1));
        utility.Log.info("Typing date from Excel row number 1");

        webformPage.clickSubmit();
        driver.navigate().refresh();
        webformPage.clickForm();
        utility.Log.info("Submitting webform");

        //Set [Status] column number to 8 (PASS/FAIL)
        ExcelUtil.setColumnNumber(8);

        //Set test row number to 1 (PASS/FAIL)
        ExcelUtil.setRowNumber(1);
        utility.Log.info("Set status PASSED/FAILED to column number 8 and row number 1");

        assertTrue(webformPage.verifyTextOnPage().contains("The form was successfully submitted!"));

        Log.endTestCase("Ending Selenium TestCase_001");
    }

    @Test(priority = 2, description = "Negative Case")
    public void fill_webform_with_invalid_data() throws InterruptedException {
        Log.startTestCase("Starting Selenium TestCase_002");

        ExtentTestManager.getTest().setDescription("Fill in the webform with invalid data");

        //*************PAGE INSTANTIATIONS*************
        WebformPage webformPage = new WebformPage(driver, wait);

        //*************PAGE METHODS********************
        webformPage.typeFirstname(ExcelUtil.getRowData(5));
        utility.Log.info("Firstname picked from Excel row number 5");

        webformPage.typeLastName(ExcelUtil.getRowData(5));
        utility.Log.info("Lastname picked from Excel row number 5");

        webformPage.typeJobTitle(ExcelUtil.getRowData(5));
        utility.Log.info("Jobtitle picked from Excel row number 5");

        webformPage.clickEducationRadioButton(ExcelUtil.getRowData(5), "Grad School");
        utility.Log.info("Education radio-button picked from Excel row number 5");

        webformPage.clickGenderRadioButton(ExcelUtil.getRowData(5), "Male");
        utility.Log.info("Gender radio-button picked from Excel row number 5");

        webformPage.clickYearsOfExperienceDropDown(ExcelUtil.getRowData(5), "0-1");
        utility.Log.info("Years of experience radio-button picked from Excel row number 5");

        webformPage.typeDate(ExcelUtil.getRowData(5));
        utility.Log.info("Typing date from Excel row number 5");

        Thread.sleep(3000);
        webformPage.clickSubmit();
        driver.navigate().refresh();
        webformPage.clickForm();
        utility.Log.info("Submitting webform");

        //Set Test (Status) column number to 8 (PASS/FAIL)
        ExcelUtil.setColumnNumber(8);

        //Set test row number to 6 (PASS/FAIL)
        ExcelUtil.setRowNumber(5);
        utility.Log.info("Set status PASSED/FAILED to column number 8 and row number 5");

        assertTrue(webformPage.verifyTextOnPage().contains("The form was successfully submitted!"));
        Log.endTestCase("Ending Selenium TestCase 002");
    }

    @Test(priority = 3, description = "Negative Case")
    public void fill_webform_with_empty_data() throws InterruptedException {
        Log.startTestCase("Starting Selenium TestCase_003");

        ExtentTestManager.getTest().setDescription("Fill in the webform with empty data");

        //*************PAGE INSTANTIATIONS*************
        WebformPage webformPage = new WebformPage(driver, wait);

        //*************PAGE METHODS********************
        webformPage.typeFirstname(ExcelUtil.getRowData(7));
        utility.Log.info("Firstname picked from Excel row number 7");

        webformPage.typeLastName(ExcelUtil.getRowData(7));
        utility.Log.info("Lastname picked from Excel row number 7");

        webformPage.typeJobTitle(ExcelUtil.getRowData(7));
        utility.Log.info("Jobtitle picked from Excel row number 7");

        Thread.sleep(3000);
        webformPage.clickSubmit();
        utility.Log.info("Submitting webform");

        //Set Test (Status) column number to 8 (PASS/FAIL)
        ExcelUtil.setColumnNumber(8);

        //Set test row number to 7 (PASS/FAIL)
        ExcelUtil.setRowNumber(7);
        utility.Log.info("Set status PASSED/FAILED to column number 8 and row number 7");

        assertTrue(webformPage.verifyTextOnPage().contains("The form was successfully submitted!"));

        Log.endTestCase("Ending Selenium TestCase 003");

        //*************ANOTHER EXCEL READER METHOD*************

        /*String xl = "./src/test/java/resources/TestData.xlsx";
        String Sheet = "Credentials2";*/

      /*  int rowCount = ReadDataExcel.getRowCount(xl, Sheet);
        for (int i = 1; i <= rowCount; i++) {

            String FirstName = ReadDataExcel.getCellValue(xl, Sheet, i, 0);
            String LastName = ReadDataExcel.getCellValue(xl, Sheet, i, 1);
            String JobTitle = ReadDataExcel.getCellValue(xl, Sheet, i, 2);
            String Education = ReadDataExcel.getCellValue(xl, Sheet, i, 3);
            String Sex = ReadDataExcel.getCellValue(xl, Sheet, i, 4);
            String Experience = ReadDataExcel.getCellValue(xl, Sheet, i, 5);
            String Date = ReadDataExcel.getCellValue(xl, Sheet, i, 6);

            webformPage.typeFirstname(FirstName);
            webformPage.typeLastName(LastName);
            webformPage.typeJobTitle(JobTitle);
            webformPage.clickEducationRadioButton(Education);
            webformPage.clickGenderRadioButton(Sex);
            webformPage.clickYearsOfExperienceDropDown(Experience);
            webformPage.typeDate(Date);
            webformPage.clickSubmit();
            driver.navigate().refresh();
            webformPage.clickForm();*/

        //    Assert.assertTrue(webformPage.verifyTextOnPage().contains("The form was successfully submitted!"));
    }
}