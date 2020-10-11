package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTest extends BaseTests {

    @Test
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
}
