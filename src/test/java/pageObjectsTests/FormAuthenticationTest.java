package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.FormAuthenticationPage;
import pageObjects.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class FormAuthenticationTest extends BaseTests {

    @Test(priority = 1)
    public void testSuccesfullLogin() {
        FormAuthenticationPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"));
    }

    @Test(priority = 2)
    public void loginWithWrongUsername() {
        FormAuthenticationPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("smithtom");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        assertTrue(loginPage.getLoginText().contains("Your username is invalid!"));
    }

    @Test(priority = 3)
    public void loginWithWrongPassword() {
        FormAuthenticationPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!Not");
        loginPage.clickLoginButton();

        assertTrue(loginPage.getLoginText().contains("Your password is invalid!"));
    }
}