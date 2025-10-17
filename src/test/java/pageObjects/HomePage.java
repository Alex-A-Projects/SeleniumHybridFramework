package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // heading: "Institutes"
    @FindBy(css = "h2.text-lg.text-left.w-full.font-semibold")
    @CacheLookup
    WebElement heading;

    // User Icon
    @FindBy(xpath = "//span[@class='anticon anticon-user text-2xl text-blue-400']")
    @CacheLookup
    WebElement userIcon;

    // Logout button
    @FindBy(xpath = "//div[@class='flex flex-row h-full w-auto items-center justify-start gap-2']")
    @CacheLookup
    WebElement logout;

    // Select a course
    @FindBy(xpath = "(//input[@class='ant-radio-input'])[3]")
    @CacheLookup
    WebElement selectCourse;

    // Launch
    @FindBy(xpath = "//button[@class='ant-btn css-1m62vyb ant-btn-primary w-auto inline-flex items-center']")
    @CacheLookup
    WebElement selectLaunch;

    // ✅ Return the heading element for explicit wait in test
    public WebElement getHeadingElement() {
        return heading;
    }

    // ✅ Return heading text for assertions
    public String getHeadingText() {
        return heading.getText();
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void clickLogout() {
        logout.click();
    }

    public void selectCourse() {
        selectCourse.click();
    }

    public void selectLaunch() {
        selectLaunch.click();
    }
}
