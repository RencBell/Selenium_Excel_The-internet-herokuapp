package accessibility;

import com.github.lkkushan101.accessilenium.accessilenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutomatedAccessibility {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     //   driver.get("google.se");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws IOException {
           accessilenium.TheAccessibilityReport.testAccessibility("https://www.northstarclinic.se");
    }
}
