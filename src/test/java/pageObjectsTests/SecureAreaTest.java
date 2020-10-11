package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class SecureAreaTest extends BaseTests {

    @Test
    public void testSuccesfullLogin() {
        LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"));
    }
}