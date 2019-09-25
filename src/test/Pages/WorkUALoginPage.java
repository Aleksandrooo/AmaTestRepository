package test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkUALoginPage {
    public WebDriver webDriver;

    @FindBy(xpath = ".//*[@id='email']")
    public WebElement emailElement;

    @FindBy(xpath = ".//*[@id='email-error']")
    public WebElement emailErrorElement;

    @FindBy(xpath = ".//*[@id='password']")
    public WebElement passwordElement;

    @FindBy(xpath = ".//*[@id='password-error']")
    public WebElement passwordErrorElement;

    @FindBy(xpath = ".//*[@class='btn btn-default btn-block' and @type='submit']")
    public WebElement inputButtonElement;


    public void clickInputButton() {
        inputButtonElement.click();
    }

    public String getEmailErrorMessage() {
        return emailErrorElement.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorElement.getText();
    }

    public void putValueInEmailField(String value) {
        emailElement.sendKeys(value);
        //firstNameField.submit();
    }

    public void putValueInPasswordField(String value) {
        passwordElement.sendKeys(value);
        //firstNameField.submit();
    }

    public WorkUALoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
