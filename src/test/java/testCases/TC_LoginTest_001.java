package testCases;

import java.io.IOException;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.AllureListener;

@Listeners({AllureListener.class})
@Epic("EP001")
@Feature("Feature1: Login")
public class TC_LoginTest_001 extends BaseClass {

    @Test(priority = 1, description = "Verify that user can successfully login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify login functionality with valid username and password")
    @Story("Story: Valid Login Functionality")
    public void loginTest() throws IOException {

        logger.info("********** Starting Login Test **********");

        // Create page objects
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);

        // ✅ Selenium 3-compatible WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        openLoginPage();
        performLogin(lp);
        verifyLoginSuccess(hp, wait);

        logger.info("********** Finished Login Test **********");
    }

    @Step("Open the login page")
    private void openLoginPage() {
        logger.info("Opening application URL...");
        driver.get(baseURL); // baseURL should be initialized in BaseClass
    }

    @Step("Login with username and password")
    private void performLogin(LoginPage lp) {
        logger.info("Entering username and password...");
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();
        logger.info("Clicked login button");
    }

    @Step("Verify that user is logged in successfully")
    private void verifyLoginSuccess(HomePage hp, WebDriverWait wait) throws IOException {
        logger.info("Verifying login result...");

        // Wait for heading element to appear on home page
        wait.until(ExpectedConditions.visibilityOf(hp.getHeadingElement()));

        String headingText = hp.getHeadingText().trim();
        logger.info("Heading text found: " + headingText);

        try {
            Assert.assertEquals(headingText, "Institutes", "Login verification failed — unexpected heading.");
            logger.info("Login test passed ✅");
        } catch (AssertionError e) {
            captureScreen(driver, "loginTestFailed");
            logger.error("Login test failed ❌", e);
            throw e;
        }
    }
}
