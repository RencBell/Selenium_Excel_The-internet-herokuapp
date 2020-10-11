package login;

import base.BaseTests;
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import pageObjects.FormAuthenticationPage;
import pageObjects.SecureAreaPage;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccesfullLogin() {
        FormAuthenticationPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"));
    }

    @Test
    public void testUnsuccessfullLogin() {
        FormAuthenticationPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("smithtom");
        loginPage.setPassword("SuperSecretPassword!Not");
        loginPage.clickLoginButton();

        assertTrue(loginPage.getLoginText().contains("Your username is invalid!"));
    }

/*    @Test (dataProvider = "logInData")
    public void logIn (String username, String password, boolean success)
    {
        System.out.println("Log In Credentials: " + "\n" +
                "  Username = " + username + "\n" +
                "  Password = " + password + "\n" +
                "  Successful Log In = " + success + "\n" );
    }

    @DataProvider
    public Object [] [] logInData ()
    {
        Object [][] data = new Object [3][3];

        data [0][0] = "TestNG@Framework.com";		data [0][1] = "TestNG1234";		data [0][2] = true;
        data [1][0] = "Joe@Doe.com";			    data [1][1] = "DoeDoe34";		data [1][2] = false;
        data [2][0] = "Test@AutomationU.com";		data [2][1] = "TAU1234";		data [2][2] = true;

        return data;
    }*/
    }