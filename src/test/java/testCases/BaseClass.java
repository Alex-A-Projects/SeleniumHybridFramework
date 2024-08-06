package testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass {

    // Create an instance of ReadConfig to read configuration properties
    ReadConfig readconfig = new ReadConfig();

    // Retrieve configuration values
    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUsername();
    public String password = readconfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String br) {
        // Initialize the logger for the project
        logger = Logger.getLogger("whatever project");   //
        PropertyConfigurator.configure("Log4j.properties");

        // Uncomment the following block to add ad-blocker extension in Chrome
        /*
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("/path/to/1Block.crx"));  // Update the path as needed
        */

        // Set up the WebDriver based on the specified browser
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
            // Uncomment to use Chrome with ad-blocker
            // driver = new ChromeDriver(opt);
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        } else if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
            driver = new InternetExplorerDriver();
        }

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();

        ////send fake video
        // options.addArguments("--use-file-for-fake-video-capture=/Users/alexander.anderson/IdeaProjects/bSecurePro/MicrosoftTeams-video.mp4");

        // Add additional arguments to automatically grant screen sharing permission
        options.addArguments("--auto-select-desktop-capture-source=Entire screen");
        options.addArguments("--use-fake-ui-for-media-stream");

        // Set implicit wait time for WebDriver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Open the base URL
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver after test execution
        driver.quit();
    }

//    // Method to capture a screenshot
//    public void captureScreen(WebDriver driver, String tname) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
//        FileUtils.copyFile(source, target);
//        System.out.println("Screenshot taken");
//    }

    // Method to capture a screenshot and attach it to Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken and saved to Allure report");
        return screenshot;
    }




    // Method to generate a random alphanumeric string
    public String randomestring() {
        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }

    // Method to generate a random numeric string
    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }

    // Method to get the WebDriver instance
    public static WebDriver getDriver() {
        return driver;
    }
}
