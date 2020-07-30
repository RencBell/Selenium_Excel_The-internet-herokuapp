package login;

import base.BaseTests;
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccesfullLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                .contains("You logged into a secure area!"));
    }

    @Test
    public void testUnsuccessfullLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("smithtom");
        loginPage.setPassword("SuperSecretPassword!Not");
        loginPage.clickLoginButton();

        assertTrue(loginPage.getLoginText().contains("Your username is invalid!"));
    }
}