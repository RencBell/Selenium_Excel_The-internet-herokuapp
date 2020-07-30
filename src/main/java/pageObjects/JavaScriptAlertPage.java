package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage {

    WebDriver driver;
    private By jsAlert = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private By jsConfirm = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private By jsPrompt = By.xpath("//button[contains(text(),'Click for JS Prompt')]");

    public JavaScriptAlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJsAlert() {
        driver.findElement(jsAlert).click();
        driver.switchTo().alert().accept();
    }

    public void clickJsConfirm() {
        driver.findElement(jsConfirm).click();
        driver.switchTo().alert().accept();
    }

    public void clickJsPrompt(String text) {
        driver.findElement(jsPrompt).click();
        Alert alert=driver.switchTo().alert();
        driver.switchTo().alert().sendKeys(text);
        alert.accept();
    }
}