package formyPages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;

public class WebformPage extends BasePage {

    public WebformPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By firstnameField = By.xpath("//input[@id='first-name']");
    private final By lastnameField = By.xpath("//input[@id='last-name']");
    private final By jobTitle = By.xpath("//input[@id='job-title']");
    private final By educationHighSchool = By.xpath("//input[@id='radio-button-1']");
    private final By educationCollege = By.xpath("//input[@id='radio-button-2']");
    private final By educationGradSchool = By.xpath("//input[@id='radio-button-3']");
    private final By genderMale = By.xpath("//input[@id='checkbox-1']");
    private final By genderFemale = By.xpath("//input[@id='checkbox-2']");
    private final By genderUnknown = By.xpath("//input[@id='checkbox-3']");
    private final By yearsOfExperienceDropDown = By.xpath("//select[@id='select-menu']/option[@value='1']");
    private final By yearsOfExperienceDropDown10 = By.xpath("//select[@id='select-menu']/option[@value='4']");
    private final By dateCalendar = By.xpath("//input[@id='datepicker']");
    private final By submitForm = By.xpath("//a[@class='btn btn-lg btn-primary']");
    private final By form = By.xpath("//a[@class='nav-link']");

    private final By hamtaTextenPaSidan = By.xpath("//div[@class='alert alert-success']");
    //private final static String VERIFIERA_SENASTE_ANNONS_HAR_PUBLICERATS_XPATH = "//div[@class='alert alert-success']";

    public void typeFirstname(XSSFRow row) {
        writeText((firstnameField), row.getCell(1).toString());
    }

    public void typeLastName(XSSFRow row) {
        writeText((lastnameField), row.getCell(2).toString());
    }

    public void typeJobTitle(XSSFRow row) {
        writeText((jobTitle), row.getCell(3).toString());
    }

    public void clickEducationRadioButton(XSSFRow row, String education) {
        if (education.equals("College")) {
            click((educationCollege), row.getCell(4).getStringCellValue());
        } else if (education.equals("High School")) {
            click((educationHighSchool), row.getCell(4).getStringCellValue());
        } else if (education.equals("Grad School")) {
            click((educationGradSchool), row.getCell(4).getStringCellValue());
        } else {
            throw new RuntimeException("Unknown education " + education);
        }
    }

    public void clickGenderRadioButton(XSSFRow row, String sex) {
        if (sex.equals("Male")) {
            click((genderMale), row.getCell(5).getStringCellValue());
        } else if (sex.equals("Female")) {
            click((genderFemale), row.getCell(5).getStringCellValue());
        } else if (sex.equals("Prefer not to say")) {
            click((genderUnknown), row.getCell(5).getStringCellValue());
        } else {
            throw new RuntimeException("Uknown gender " + sex);
        }
    }

    public void clickYearsOfExperienceDropDown(XSSFRow row, String experience) {
        if (experience.equals("0-1")) {
            click((yearsOfExperienceDropDown), row.getCell(6).getStringCellValue());
        } else if (experience.equals("10+")) {
            click((yearsOfExperienceDropDown10), row.getCell(6).getStringCellValue());
        } else {
            throw new RuntimeException("Unkown years of experience " + experience);
        }
    }

    public void typeDate(XSSFRow row) {
        writeText((dateCalendar), row.getCell(7).toString());
    }

    public void clickSubmit() {
        //Scrolling down to the page and clicking on Submit
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, 1000)");
        driver.findElement(submitForm).click();
    }

    public void clickForm() {
        driver.findElement(form).click();
    }

    public String verifyTextOnPage() {
        return driver.findElement(hamtaTextenPaSidan).getText();
    }

/*     public boolean verifieraText() {
       return driver.findElement(By.xpath(VERIFIERA_SENASTE_ANNONS_HAR_PUBLICERATS_XPATH)).isDisplayed();
     }*/
}