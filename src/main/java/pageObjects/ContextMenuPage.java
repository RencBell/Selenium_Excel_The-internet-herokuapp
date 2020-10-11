package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private final WebDriver driver;

    private final By rightClickMenu = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickOnBox() {
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(rightClickMenu);
        actions.contextClick(elementLocator).perform();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
}