package testCases;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        setup("chrome"); // Pass the browser parameter to the setup method

        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered username");

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }
}
