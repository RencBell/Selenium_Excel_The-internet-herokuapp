package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.EntryAdPage;

public class EntryAdTest extends BaseTests {

    @Test
    public void entryAd() throws InterruptedException {
        EntryAdPage entryAdPage = homePage.clickEntryAdLink();
        Thread.sleep(2000);
        entryAdPage.clickCloseAd();
    }
}
