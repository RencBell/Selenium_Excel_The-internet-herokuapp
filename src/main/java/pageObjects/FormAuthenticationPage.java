package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthenticationPage {

    private final WebDriver driver;

    private final By usernameField = By.xpath("//input[@id='username']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//i[@class='fa fa-2x fa-sign-in']");
    private final By alertText = By.id("flash");

    public FormAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public String getLoginText() {
        return driver.findElement(alertText).getText();
    }
}