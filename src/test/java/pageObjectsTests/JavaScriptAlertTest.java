package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.JavaScriptAlertPage;

public class JavaScriptAlertTest extends BaseTests {

    @Test
    public void clickAlertPopup() throws InterruptedException {
        JavaScriptAlertPage javaScriptAlertPage = homePage.clickAlertPopupLink();
        javaScriptAlertPage.clickJsAlert();
        javaScriptAlertPage.clickJsConfirm();
        javaScriptAlertPage.clickJsPrompt("Test");
        Thread.sleep(2000);
    }
}
