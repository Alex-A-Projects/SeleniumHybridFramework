package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login_username")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(id = "login_password" )
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[@value='Login' and @type='submit' and contains(@class, 'ant-btn-primary')]" )
    @CacheLookup
    WebElement btnLogin;



    public void setUserName(String uname)
    {
        txtUserName.sendKeys(uname);
    }

    public void setPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit()
    {
        btnLogin.click();
    }

}









