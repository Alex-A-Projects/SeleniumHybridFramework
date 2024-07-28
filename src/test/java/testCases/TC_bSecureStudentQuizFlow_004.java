package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LauncherPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class TC_bSecureStudentQuizFlow_004 extends BaseClass {
    @Test
    public void loginTest() throws IOException, InterruptedException {

        // Log message indicating that the URL has been opened
        logger.info("URL is opened");

        // Create an instance of LoginPage to interact with the login page elements
        LoginPage loginPage = new LoginPage(driver);

        // Set the username in the login form
        loginPage.setUserName(username);
        logger.info("Entered username");
        Thread.sleep(2000);

        // Set the password in the login form
        loginPage.setPassword(password);
        logger.info("Entered password");
        Thread.sleep(2000);

        // Click the submit button to attempt login
        loginPage.clickSubmit();
        logger.info("clicked Submit");
        Thread.sleep(2000);

        // Create an instance of HomePage to interact with the home page elements
        HomePage hP = new HomePage(driver);
        Thread.sleep(2000);
        hP.selectCourse();
        logger.info("Course Selected");
        Thread.sleep(2000);

        hP.selectLaunch();
        logger.info("Selected Launch");
        Thread.sleep(2000);

        // Create an instance of LauncherPage to interact with the launcher page elements
        LauncherPage lP = new LauncherPage(driver);
        Thread.sleep(2000);

        // Interact with the checkbox
        lP.interactWithCheckbox();
        logger.info("interacted With Checkbox");
        Thread.sleep(2000);

        lP.selectNextButton();
        logger.info("selected Next Button");
        Thread.sleep(2000);

        lP.selectAgreeExamRulesCheckbox();
        logger.info("selected AgreeExamRulesCheckbox");

        Thread.sleep(2000);
        lP.selectStartProctoringButton();
        logger.info("selected Start Proctoring Button");

        Thread.sleep(2000);
        lP.goToMeetingButton();
        logger.info("Selected go To Meeting Button");

        Thread.sleep(2000);
        lP.setEndButton();
        logger.info("Selected set End Button");

        Thread.sleep(2000);
        lP.endProctoringButton();
        logger.info(" Selected end Proctoring Button");

        // Validate if the specified element is present on the completion page
        Assert.assertTrue(lP.isSuccessMessageDisplayed(), "Success message is not displayed.");
        Assert.assertEquals(lP.getSuccessMessageText(), "Proctoring has finished. Redirecting to home.", "Success message text does not match.");
        logger.info("the specified element is present");
    }
}
