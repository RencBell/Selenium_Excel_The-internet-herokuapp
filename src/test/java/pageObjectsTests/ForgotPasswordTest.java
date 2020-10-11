package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTest extends BaseTests {

    @Test
    public void forgotPassword() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.inputEmail("hej@gmail.com");
        forgotPasswordPage.clickRetrieveButton();
        Thread.sleep(2000);
        assertEquals(forgotPasswordPage.verifyText(), "Your e-mail's been sent!", "Email is incorrect");
    }
}