package test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.Pages.WorkUALoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class WorkUaLoginTest {

    WebDriver webDriver;

    @BeforeTest
    public void beforeSuite() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver", "D:\\Programs\\webdrivers\\chromedriver.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        webDriver = new RemoteWebDriver(new URL("http://10.65.146.77:5556/wd/hub"), capabilities);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("https://www.work.ua/jobseeker/login/");
        webDriver.manage().window().maximize();
    }

    @Test
    public void CheckLoginWithEmptyFields() {
        //WorkUALoginPage loginPage = new WorkUALoginPage(webDriver);
        WorkUALoginPage loginPage = openLoginPage(webDriver);
        loginPage.clickInputButton();
        String emailErrorMessage = loginPage.getEmailErrorMessage();
        String passwordErrorMessage = loginPage.getPasswordErrorMessage();
        System.out.println("emailErrorMessage:" + emailErrorMessage);
        System.out.println("passwordErrorMessage" + passwordErrorMessage);
        Assert.assertEquals(emailErrorMessage,"Будь ласка, введіть вашу ел. пошту.");
        Assert.assertEquals(passwordErrorMessage,"Будь ласка, введіть ваш пароль.");
    }

    @Step
    public WorkUALoginPage openLoginPage(WebDriver webDriver){
        WorkUALoginPage loginPage = new WorkUALoginPage(webDriver);
        attachBrowserScreenShot(webDriver);
        return loginPage;
    }

    @Attachment()
    public static byte[] attachBrowserScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Test
    public void setRightEmailAndemptyPassword() {
        //WorkUALoginPage loginPage = new WorkUALoginPage(webDriver);
        WorkUALoginPage loginPage = openLoginPage(webDriver);
        loginPage.putValueInEmailField("av-pochta-j@ukr.net");
        loginPage.clickInputButton();
        String emailErrorMessage = loginPage.getEmailErrorMessage();
        String passwordErrorMessage = loginPage.getPasswordErrorMessage();
        System.out.println("emailErrorMessage: " + emailErrorMessage);
        System.out.println("passwordErrorMessage: " + passwordErrorMessage);
        Assert.assertTrue(emailErrorMessage.isEmpty());
        Assert.assertEquals(passwordErrorMessage,"Будь ласка, введіть ваш пароль.");
    }

//    @Test
//    public void checkSuccessfulLogin() {
//        WorkUALoginPage loginPage = new WorkUALoginPage(webDriver);
//        loginPage.putValueInEmailField("av-pochta-j@ukr.net");
//        loginPage.putValueInPasswordField("AVqaz01");
//        loginPage.clickInputButton();
////        Assert.assertTrue(emailErrorMessage.isEmpty());
//
//    }

    @AfterTest
    public void AfterSuite() {
        webDriver.quit();
    }
}
