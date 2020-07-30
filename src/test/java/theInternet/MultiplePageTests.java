package theInternet;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class MultiplePageTests extends BaseTests {

    //  private static Logger logger = Logger.getLogger(MultiplePageTests.class.getName());

    @Test(priority = 1)
    public void multipleWindows() throws InterruptedException {
        MultipleWindowsPage multipleWindowsPage = homePage.clickMultipleWindows();
        multipleWindowsPage.clickClickHere();
        Thread.sleep(2000);
        getWindowManager().switchToTab("New window");
    }

    @Test(priority = 2)
    public void forgotPassword() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.inputEmail("hej@gmail.com");
        forgotPasswordPage.clickRetrieveButton();
        Thread.sleep(2000);

        Assert.assertTrue(forgotPasswordPage.verifyText().contains("Your e-mail's been sent!"));
    }

    @Test(priority = 3)
    public void entryAd() throws InterruptedException {
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        Thread.sleep(2000);
        entryAdPage.clickCloseAd();
    }

    @Test(priority = 4)
    public void rightClickContextMenu() throws InterruptedException {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnBox();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void clickAlertPopup() throws InterruptedException {
        JavaScriptAlertPage javaScriptAlertPage = homePage.clickAlertPopup();
        javaScriptAlertPage.clickJsAlert();
        javaScriptAlertPage.clickJsConfirm();
        javaScriptAlertPage.clickJsPrompt("Test");
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void clickDynamicLoading1() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        dynamicLoadingPage.clickHiddenElement();
        dynamicLoadingPage.clickStart();
        Assert.assertTrue(dynamicLoadingPage.verifyText().contains("Hello World!"));

        dynamicLoadingPage.goBack();

        dynamicLoadingPage.clickRenderedElement();
        dynamicLoadingPage.clickStart2();
        Assert.assertTrue(dynamicLoadingPage.verifyText().contains("Hello World!"));
    }

    @Test(priority = 7)
    public void clickWhereAmIButton() {
        GeolocationPage geolocationPage = homePage.clickGeolocation();
        geolocationPage.clickWhereAmIButton();
        geolocationPage.clickLink();
    }
}