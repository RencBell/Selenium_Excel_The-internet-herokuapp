package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pageObjects.ContextMenuPage;

public class ContextMenuTest extends BaseTests {

    @Test
    public void rightClickContextMenu() throws InterruptedException {
        ContextMenuPage contextMenuPage = homePage.clickContextMenuLink();
        contextMenuPage.rightClickOnBox();
        Thread.sleep(2000);
    }
}
