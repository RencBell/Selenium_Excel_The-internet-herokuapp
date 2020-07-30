package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeolocationPage {

    private final WebDriver driver;

    private final By button = By.xpath("//*[contains(text(),'Where am I?')]");
    private final By linkToGoogleMaps = By.xpath("//div[@id='content']//button[.='Where am I?']");

    public GeolocationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWhereAmIButton() {
        driver.findElement(button).click();
    }

    public void clickLink() {
        driver.findElement(linkToGoogleMaps).click();
        driver.navigate().to("https://www.google.com/maps/place/59%C2%B022'23.3%22N+17%C2%B049'24.6%22E/@59.3731372,17.8213048,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d59.3731372!4d17.8234935");
    }
}