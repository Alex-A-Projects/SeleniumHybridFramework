package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LauncherPage {
    WebDriver driver;
    JavascriptExecutor js;

    // Constructor
    public LauncherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    // Define WebElement for scrollable container
    @FindBy(className = "overflow-y-scroll")
    WebElement scrollableContainer;

    // Checkbox
    @FindBy(xpath = "//input[@class='w-5 h-5 cursor-pointer']")
    @CacheLookup
    WebElement SelectCheckbox;

    // Next button
    @FindBy(xpath = "//button[@class='ant-btn css-1m62vyb ant-btn-primary']")
    @CacheLookup
    WebElement SelectNextButton;

    // Agree Exam Rules Checkbox
    @FindBy(xpath = "//input[@class='w-5 h-5 cursor-pointer']")
    @CacheLookup
    WebElement selectAgreeExamRulesCheckbox;

    // Start Proctoring button
    @FindBy(xpath = "//button[@type='button' and contains(@class, 'ant-btn-primary')]/span[text()='Start proctoring']")
    @CacheLookup
    WebElement SelectStartProctoringButton;

    // Go To Meeting Button
    @FindBy(xpath = "//button[@type='button' and contains(@class, 'ant-btn-primary')]/span[text()='Go to Meeting']")
    @CacheLookup
    WebElement GoToMeetingButton;

    // End Button
    @FindBy(xpath = "//button[@type='button' and contains(@class, 'ant-btn-primary') and contains(@class, 'bg-red-400')]/span[text()='End']")
    @CacheLookup
    WebElement EndButton;

    // End Proctoring Button
    @FindBy(xpath = "//button[@class='ant-btn css-1m62vyb ant-btn-primary' and span[text()='End Proctoring']]")
    @CacheLookup
    WebElement EndProctoringButton;

    // Define WebElement for the success message
    @FindBy(xpath = "//p[@class='text-xl font-semibold text-green-500' and text()='Proctoring has finished. Redirecting to home.']")
    @CacheLookup
    WebElement successMessage;

    // Method to perform the scroll and interact with the checkbox
    public void interactWithCheckbox() {

        // Scroll within the container
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollableContainer);

        // Scroll the element into view and interact with it
        js.executeScript("arguments[0].scrollIntoView(true);", SelectCheckbox);
        SelectCheckbox.click();
    }

    // Method to Next button
    public void selectNextButton() {
        SelectNextButton.click();
    }

    // Method to select Agree Exam Rules Checkbox
    public void selectAgreeExamRulesCheckbox() {
        selectAgreeExamRulesCheckbox.click();
    }

    // Method to Next button
    public void selectStartProctoringButton() {
        SelectStartProctoringButton.click();
    }

    // Method to select Go To Meeting Button
    public void goToMeetingButton() {
        GoToMeetingButton.click();
    }

    // Method to select End Button
    public void setEndButton() {
        EndButton.click();
    }

    // Method to select End Proctoring Button
    public void endProctoringButton() {
        EndProctoringButton.click();
    }

    // Method to get the success message text
    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    // Method to check if the success message is displayed
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }




}
