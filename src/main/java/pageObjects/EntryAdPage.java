package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {

    private final WebDriver driver;

    private final By closeAd = By.xpath("//p[contains(text(),'Close')]");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCloseAd() {
        driver.findElement(closeAd).click();
    }
}