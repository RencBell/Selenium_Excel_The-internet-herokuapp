package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.GeolocationPage;

public class GeoLocationTest extends BaseTests {

    @Test
    public void clickWhereAmIButton() {
        GeolocationPage geolocationPage = homePage.clickGeolocationLink();
        geolocationPage.clickWhereAmIButton();
        geolocationPage.clickLink();
    }
}
