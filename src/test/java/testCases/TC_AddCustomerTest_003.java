//package testCases;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import pageObjects.AddCustomerPage;
//import pageObjects.LoginPage;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.io.IOException;
//
//public class TC_AddCustomerTest_003 extends BaseClass {
//
//    @Test
//    public void addNewCustomer() throws InterruptedException, IOException {
//        // Create an instance of LoginPage to interact with the login page elements
//        LoginPage lp = new LoginPage(driver);
//
//        // Set the username in the login form
//        lp.setUserName(username);
//        logger.info("User name is provided");
//
//        // Set the password in the login form
//        lp.setPassword(password);
//        logger.info("Password is provided");
//
//        // Click the submit button to attempt login
//        lp.clickSubmit();
//
//        // Wait for 3 seconds to ensure that the login process completes
//        Thread.sleep(3000);
//
//        // Create an instance of AddCustomerPage to interact with the add customer page elements
//        AddCustomerPage addcust = new AddCustomerPage(driver);
//
//        // Click the button to add a new customer
//        addcust.clickAddNewCustomer();
//        logger.info("Providing customer details....");
//
//        // Fill in customer details with pauses between actions to simulate realistic interaction and ensure stability
//        Thread.sleep(3000);
//        addcust.custName("Alex");
//
//        Thread.sleep(3000);
//        addcust.custgender("male");
//
//        addcust.custdob("19", "11", "1985");
//        addcust.custaddress("USA");
//        addcust.custcity("CHT");
//        addcust.custstate("NC");
//        addcust.custpinno("2333242");
//        addcust.custtelephoneno("77777777");
//
//        // Generate a random email to ensure uniqueness and set it
//        String email = randomestring() + "@gmail.com";
//        addcust.custemailid(email);
//        addcust.custpassword("abcdef");
//
//        // Submit the new customer form
//        addcust.custsubmit();
//
//        // Wait for 3 seconds to allow the submission process to complete
//        Thread.sleep(3000);
//
//        logger.info("Validation started....");
//
//        // Validate the success message on the page to confirm customer registration
//        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
//
//        if (res) {
//            // If the success message is found, the test is considered successful
//            Assert.assertTrue(true);
//            logger.info("Test case passed....");
//        } else {
//            // If the success message is not found, capture a screenshot and mark the test as failed
//            logger.info("Test case failed....");
//            captureScreen(driver, "addNewCustomer");
//            Assert.assertTrue(false);
//        }
//    }
//}
