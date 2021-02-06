package base;

import formyPages.WebformPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import theInternet.HomePage;
import utils.WindowManager;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public WebformPage webForm;

    public static final String testDataExcelFileName = "TestData.xlsx";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass(description = "Browser setup")
    @Parameters("browser")
    public void setUpBrowser(String browser) throws Exception {

        if (browser.equals("Chrome")) {
            //   WebDriverManager.chromedriver().setup();
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
            utility.Log.info("Chrome browser started");
        } else if (browser.equals("Firefox")) {
            //   WebDriverManager.chromedriver().setup();
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
            utility.Log.info("Mozilla browser started");
        } else {
            throw new Exception("Incorrect browser");
        }
    }
    //   driver.manage().window().setSize(new Dimension(375, 812)); <-- Size of Iphone X

    @BeforeMethod
    public void goTo() {
        // driver.get("https://formy-project.herokuapp.com/form");
        driver.get("https://the-internet.herokuapp.com/");
        utility.Log.info("Navigating to URL");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        webForm = new WebformPage(driver, wait);
    }

    @AfterClass(description = "Class Level Teardown")
    public void teardown() {
        utility.Log.info("Closing the browser");
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    //*************TAKES SCREENSHOT ON FAILED TEST*************
/*    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(source, new File("screenshots" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
