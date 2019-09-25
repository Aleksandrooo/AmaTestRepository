package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TicketsUaSearchResults {
    WebDriver webDriver;

    @FindBy(xpath = ".//*[@class='results js-result-item js-one_offer ']")
    public List<WebElement> trainsFromSearchResultElement;


//    public List<WebElement> getTrainsFromSearchResult() {
//        //ArrayList<WebElement> trains = webDriver.findElements(trainsFromSearchResultElement);
//        ArrayList<WebElement> trains = webDriver.findElements(FindBy);
////        List<WebElement> trains = webDriver.findElements(By.xpath(".//*[@class='results js-result-item js-one_offer ']"));
//        return trains;
//    }

    public WebElement getTrainByName(String numberOfTrain){
        for(WebElement el: this.trainsFromSearchResultElement){
            String actualNumberOfTrain = el.findElement(By.xpath(".//*[@class='results__item-info']")).getText();
            if(actualNumberOfTrain.contains(numberOfTrain))
                return el;
        }
        Assert.assertTrue(false,"Поезд " + numberOfTrain + "не найден");
        return null;
    }

    public TicketsUaSearchResults(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
}
