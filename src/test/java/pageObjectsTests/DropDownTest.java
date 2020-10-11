package pageObjectsTests;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends BaseTests {

    @Test(priority = 8)
    public void clickDropdownOption1() {
        //  DropDownPage dropDownPage = homePage.clickDropDownLink();
        var dropDownPage = homePage.clickDropDownLink();
        dropDownPage.selectFromDropdown("Option 1");
        var selectedOtions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOtions.size(), 1, "Incorrect number of selections");
    }
}