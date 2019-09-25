package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import test.Pages.TicketsUaSearchPage;
import test.Pages.TicketsUaSearchResults;

import java.util.concurrent.TimeUnit;


public class TicketsUaTest {
    WebDriver webDriver;

    @BeforeTest
    public void beforeSuite() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Programs\\webdrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("https://tickets.ua/?refid=272&gclid=Cj0KCQjw2K3rBRDiARIsAOFSW_5X9qERJlqMf7JTvCZgmZrhokRCOYqbmJ5KWJ4EOXgDuZCpJPAf8b4aAhzJEALw_wcB");
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkTypeOfClassIn705train() throws InterruptedException {
        TicketsUaSearchPage searchPage = new TicketsUaSearchPage(webDriver);
        searchPage.clickRailTab();

        searchPage.putValueInFromField("Киев");
        searchPage.putValueInToField("Львов");
        searchPage.putValueInDateForvardField("24.09.2019");
        Thread.sleep(10000);
        searchPage.clickInOneWayButton();
        searchPage.clickSearchButton();

        TicketsUaSearchResults searchResultsPage = new TicketsUaSearchResults(webDriver);
        searchResultsPage.getTrainByName("          1705К ИНТЕРСИТИ +        ");

    }

}
