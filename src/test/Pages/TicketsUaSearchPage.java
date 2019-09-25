package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketsUaSearchPage {
    WebDriver webDriver;
    @FindBy(xpath = ".//li[@class='main-form__item'][2]")
    public WebElement railTabElement;

    //    @FindBy(xpath = ".//*[@id='md-input-0esb17cai']")
    @FindBy(xpath = "(.//*[@class='md-input text-input'])[1]")
    public WebElement fromElement;

//    @FindBy(xpath = "(.//*[@class='autocomplete__item-text'])[1]")
    @FindBy(xpath = "((.//div[@class='autocomplete-container'])[1]//li)[1]")
    public WebElement stationFromElement;

    @FindBy(xpath = "(.//*[@class='md-input text-input'])[2]")
    public WebElement toElement;

//    @FindBy(xpath = "(.//*[@class='autocomplete__item-text'])[1]")
    @FindBy(xpath = "((.//div[@class='autocomplete-container'])[2]//li)[1]")
    public WebElement stationToElement;

//    @FindBy(xpath = "(.//*[@class='form-control datepicker-input'])[1]")
    @FindBy(xpath = "(.//*[@class='search-form__field search-form__field--date'])[1]")
    public WebElement dateForvardElement;

//    @FindBy(xpath = "(.//*[@class='form-control datepicker-input'])[2]")
    @FindBy(xpath = "(.//*[@class='search-form__field search-form__field--date'])[2]")
    public WebElement dateBackElement;

        @FindBy(xpath = ".//*[@class='md-button btn btn_border md-theme-default']")
    public WebElement inOneWayElement;

    @FindBy(xpath = ".//*[@class='md-button search-form__button btn md-theme-default']")
    public WebElement searchButtonFindElement;

    public void clickRailTab() {
        railTabElement.click();
    }

    public void clickSearchButton() {
        searchButtonFindElement.click();
    }

    public void putValueInFromField(String value) {
        fromElement.sendKeys(value);
        fromElement.click();
//        webDriver.switchTo().frame(0);
        stationFromElement.click();
    }

    public void putValueInToField(String value) throws InterruptedException {
        toElement.sendKeys(value);
        toElement.click();
        //webDriver.manage().timeouts().;
        Thread.sleep(1000);
        stationToElement.click();
    }

    public void putValueInDateForvardField(String value) {
        dateForvardElement.click();
        WebElement numberOfDateForvardElement = webDriver.findElement(By.xpath(".//*[@data-date='" + value + "']"));
        numberOfDateForvardElement.click();

    }

    public void clickInOneWayButton() {
//        dateBackElement.click();
        inOneWayElement.click();

    }

//    public void clearAllFields() {
//        firstNameField.clear();
//        lastNameField.clear();
//        emailField.clear();
//        passwordField.clear();
//    }

    public TicketsUaSearchPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
