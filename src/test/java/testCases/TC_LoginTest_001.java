package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {

        // Log message indicating that the URL has been opened
        logger.info("URL is opened");
        Thread.sleep(2000);

        // Create an instance of LoginPage to interact with the login page elements
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(2000);

        // Set the username in the login form
        lp.setUserName(username);
        logger.info("Entered username");
        Thread.sleep(2000);

        // Set the password in the login form
        lp.setPassword(password);
        logger.info("Entered password");
        Thread.sleep(2000);

        // Click the submit button to attempt login
        lp.clickSubmit();
        Thread.sleep(2000);

        // Assertion 1: Verify successful login by checking if the heading text on the home page matches the expected value
        HomePage hp = new HomePage(driver);
        String headingText = hp.getHeadingText();

        // Check if the heading text is as expected
        if (headingText.equals("Institutes")) {
            // If the heading text is correct, the login test is considered successful
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else {
            // If the heading text is not correct, capture a screenshot and mark the test as failed
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }
}
