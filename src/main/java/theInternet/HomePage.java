package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class HomePage {

    private final WebDriver driver;
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By multipleWindows = By.linkText("Multiple Windows");
    private final By forgotPassword = By.linkText("Forgot Password");
    private final By entryAd = By.linkText("Entry Ad");
    private final By contextMenu = By.linkText("Context Menu");
    private final By javaScriptAlerts = By.linkText("JavaScript Alerts");
    private final By dynamicLoading = By.linkText("Dynamic Loading");
    private final By geolocation = By.linkText("Geolocation");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication() {
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindows() {
        driver.findElement(multipleWindows).click();
        return new MultipleWindowsPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        driver.findElement(forgotPassword).click();
        return new ForgotPasswordPage(driver);
    }

    public EntryAdPage clickEntryAd() {
        driver.findElement(entryAd).click();
        return new EntryAdPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingPage() {
        driver.findElement(dynamicLoading).click();
        return new DynamicLoadingPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        driver.findElement(contextMenu).click();
        return new ContextMenuPage(driver);
    }

    public JavaScriptAlertPage clickAlertPopup() {
        driver.findElement(javaScriptAlerts).click();
        return new JavaScriptAlertPage(driver);
    }

    public GeolocationPage clickGeolocation() {
        driver.findElement(geolocation).click();
        return new GeolocationPage(driver);
    }
}