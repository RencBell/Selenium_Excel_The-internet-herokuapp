package pageObjectsTests;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EntirePageTest extends BaseTests {

    //  private static Logger logger = Logger.getLogger(EntirePageTest.class.getName());

    @Test(priority = 1)
    public void multipleWindows() throws InterruptedException {
        MultipleWindowsPage multipleWindowsPage = homePage.clickMultipleWindowsLink();
        multipleWindowsPage.clickClickHere();
        Thread.sleep(2000);
        getWindowManager().switchToTab("New window");
    }

    @Test(priority = 2)
    public void forgotPassword() throws InterruptedException {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.inputEmail("hej@gmail.com");
        forgotPasswordPage.clickRetrieveButton();
        Thread.sleep(2000);
        assertEquals(forgotPasswordPage.verifyText(), "Your e-mail's been sent!", "Email is incorrect");
    }

    @Test(priority = 3)
    public void entryAd() throws InterruptedException {
        EntryAdPage entryAdPage = homePage.clickEntryAdLink();
        Thread.sleep(2000);
        entryAdPage.clickCloseAd();
    }

    @Test(priority = 4)
    public void rightClickContextMenu() throws InterruptedException {
        ContextMenuPage contextMenuPage = homePage.clickContextMenuLink();
        contextMenuPage.rightClickOnBox();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void clickAlertPopup() throws InterruptedException {
        JavaScriptAlertPage javaScriptAlertPage = homePage.clickAlertPopupLink();
        javaScriptAlertPage.clickJsAlert();
        javaScriptAlertPage.clickJsConfirm();
        javaScriptAlertPage.clickJsPrompt("Test");
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void clickDynamicLoading1() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingPageLink();
        dynamicLoadingPage.clickHiddenElement();
        dynamicLoadingPage.clickStart();
        assertEquals(dynamicLoadingPage.verifyText(), "Hello World!", "Loaded text incorrect");

        dynamicLoadingPage.goBack();

        dynamicLoadingPage.clickRenderedElement();
        dynamicLoadingPage.clickStart2();
        assertEquals(dynamicLoadingPage.verifyText(), "Hello World!", "Loaded text incorrect");
    }

    @Test(priority = 7)
    public void clickWhereAmIButton() {
        GeolocationPage geolocationPage = homePage.clickGeolocationLink();
        geolocationPage.clickWhereAmIButton();
        geolocationPage.clickLink();
    }

    @Test(priority = 8)
    public void clickDropdownOption1() {
        //  DropDownPage dropDownPage = homePage.clickDropDownLink();
        var dropDownPage = homePage.clickDropDownLink();
        dropDownPage.selectFromDropdown("Option 1"); // Select Option 1 or Option 2 from the list
        var selectedOtions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOtions.size(), 1, "Incorrect number of selections");
    }
}