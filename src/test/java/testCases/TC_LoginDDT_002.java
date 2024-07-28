package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

    // This test method will run using the data provided by the LoginData data provider
    @Test(dataProvider="LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException
    {
        LoginPage lp = new LoginPage(driver);

        // Refresh the page before each test
        driver.navigate().refresh();

        // Perform login
        lp.setUserName(user);
        Thread.sleep(2000);

        lp.setPassword(pwd);
        Thread.sleep(2000);


        lp.clickSubmit();
        Thread.sleep(2000); // don't delete

        // Check if the login error message is present
        if (lp.isLoginErrorMessagePresent()) {
            logger.info("Login failed");
            Assert.fail("Login error message is present");
        } else {
            logger.info("Login passed");
            Assert.assertTrue(true, "Login was successful");
        }
    }

    // Data provider method to supply login data from an Excel file
    @DataProvider(name="LoginData")
    String [][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/testData/LoginData.xlsx";
        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }
        }
        return logindata;
    }

}
