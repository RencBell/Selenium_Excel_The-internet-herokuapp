package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;
    private final By typeEmail = By.xpath("//input[@id='email']");
    private final By retrievePasswordButton = By.xpath("//i[@class='icon-2x icon-signin']");

    private final By verifyTextOnPage = By.xpath("//div[@id='content']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        driver.findElement(typeEmail).sendKeys(email);
    }

    public void clickRetrieveButton() {
        driver.findElement(retrievePasswordButton).click();
    }

    public String verifyText() {
       return driver.findElement(verifyTextOnPage).getText();
    }
}