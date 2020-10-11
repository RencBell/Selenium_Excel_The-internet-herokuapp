package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

    private final WebDriver driver;

    private final By hiddenElement = By.xpath("//a[@href='/dynamic_loading/1']");
    private final By renderedElement = By.xpath("//a[@href='/dynamic_loading/2']");
    private final By start = By.xpath("//div[@id='start']/button[.='Start']");
    private final By start2 = By.xpath("//div[@id='start']/button[.='Start']");
    private final By verifyLoadingPage = By.xpath("//div[@id='finish']/h4[.='Hello World!']");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHiddenElement() {
        driver.findElement(hiddenElement).click();
    }

    public void clickStart() {
        driver.findElement(start).click();
    }

    public String verifyText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(verifyLoadingPage));
        return element.getText();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void clickRenderedElement() {
        driver.findElement(renderedElement).click();
    }

    public void clickStart2() {
        driver.findElement(start2).click();
    }
}
