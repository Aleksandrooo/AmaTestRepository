package test.Pages;

//import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkUaRegisterPage {

    WebDriver webDriver;

    @FindBy(xpath = ".//*[@id='first_name']")
    public WebElement firstNameField;

    @FindBy(xpath = ".//*[@id='last_name']")
    public WebElement lastNameField;

    @FindBy(xpath = ".//*[@id='email']")
    public WebElement emailField;

    @FindBy(xpath = ".//*[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[@id='first_name-error']")
    public WebElement firstNameError;

    @FindBy(xpath = ".//*[@id='last_name-error']")
    public WebElement lastNameError;

    @FindBy(xpath = ".//*[@id='email-error']")
    public WebElement emailError;

    @FindBy(xpath = ".//*[@id='password-error']")
    public WebElement passwordError;

    @FindBy(xpath = ".//input[@class='btn btn-default btn-block']")
    public WebElement registrationButton;

    public void clickRegistrationButton() {
        registrationButton.click();
    }

    public String getMessageFromFirstNameField() {
        return firstNameError.getText();
    }

    public String getMessageFromLastNameField() {
        return lastNameError.getText();
    }

    public String getMessageFromEmailField() {
        return emailError.getText();
    }

    public String getMessageFromPasswordField() {
        return passwordError.getText();
    }

    public void putValueInFirstNameField(String value) {
        firstNameField.sendKeys(value);
    }

    public void putValueInLastNameField(String value) {
        lastNameField.sendKeys(value);
    }

    public void putValueInEmailField(String value) {
        emailField.sendKeys(value);
    }

    public void putValueInPasswordField(String value) {
        passwordField.sendKeys(value);
    }

    public void clearAllFields() {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        passwordField.clear();
    }

    public WorkUaRegisterPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
