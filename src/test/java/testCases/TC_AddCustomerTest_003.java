package testCases;


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

        logger.info("providing customer details....");


        addcust.custName("Alex");
        addcust.custgender("male");
        addcust.custdob("19","11","1985");
        Thread.sleep(5000);
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
