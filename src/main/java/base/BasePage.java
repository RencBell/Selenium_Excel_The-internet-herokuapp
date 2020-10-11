package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Constructor
    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    protected void click(By elementLocation, String s) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    protected void type(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    protected String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
