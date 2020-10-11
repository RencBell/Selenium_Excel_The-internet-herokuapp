package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.MultipleWindowsPage;

public class MultipleWindowsTest extends BaseTests {

    @Test
    public void multipleWindows() throws InterruptedException {
        MultipleWindowsPage multipleWindowsPage = homePage.clickMultipleWindowsLink();
        multipleWindowsPage.clickClickHere();
        Thread.sleep(2000);
        getWindowManager().switchToTab("New window");
    }
}
