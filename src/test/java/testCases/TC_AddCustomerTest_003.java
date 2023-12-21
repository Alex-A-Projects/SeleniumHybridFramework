package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class TC_AddCustomerTest_003 extends BaseClass
{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException
    {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust=new AddCustomerPage(driver);

        addcust.clickAddNewCustomer();

        //first of all you will need to switch to the iFrame within which the ad is displayed.
        //After you switch to the iFrame you can locate the "Close" button (it's actually a Span tag) an then click() it.
        //sendKeys("Close") won't work as it isn't a text input element.
        WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.id("ad_iframe"));
        driver.switchTo().frame(frame2);
        WebElement dismissButton = driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span"));
        dismissButton.click();

        logger.info("providing customer details....");

        Thread.sleep(3000);
        addcust.custName("Alex");
        addcust.custgender("male");
        addcust.custdob("19","11","1985");
        addcust.custaddress("USA");
        addcust.custcity("CHT");
        addcust.custstate("NC");
        addcust.custpinno("2333242");
        addcust.custtelephoneno("77777777");

        String email=randomestring()+"@gmail.com";
        addcust.custemailid(email);
        addcust.custpassword("abcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        logger.info("validation started....");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        }
        else
        {
            logger.info("test case failed....");
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }
    }
}
