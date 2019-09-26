package test;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import test.Pages.WorkUaRegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WorkUaRegisterTest {

    WebDriver webDriver;

    @BeforeTest
    public void beforeSuite() throws MalformedURLException {
       // System.setProperty("webdriver.chrome.driver", "D:\\Programs\\webdrivers\\chromedriver.exe");

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        webDriver = new RemoteWebDriver(new URL("http://10.65.146.77:5556/wd/hub"), capabilities);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get("https://www.work.ua/jobseeker/register/");
        webDriver.manage().window().maximize();
    }

    @Test(dataProvider = "dp1")
    public void CheckValidationOfRegisterForm(String name, String lastName, String email, String password, String errorName, String errorLastName, String errorEmail, String errorPassword) {
        WorkUaRegisterPage registerPage = new WorkUaRegisterPage(webDriver);
        registerPage.clearAllFields();

        registerPage.putValueInFirstNameField(name);
        registerPage.putValueInLastNameField(lastName);
        registerPage.putValueInEmailField(email);
        registerPage.putValueInPasswordField(password);
        registerPage.clickRegistrationButton();
//        String message = registerPage.getMessageFromFirstNameField();
//        System.out.println(message);
        Assert.assertEquals(registerPage.getMessageFromFirstNameField(),errorName);
        Assert.assertEquals(registerPage.getMessageFromLastNameField(),errorLastName);
        Assert.assertEquals(registerPage.getMessageFromEmailField(),errorEmail);
//        Assert.assertTrue(registerPage.getMessageFromPasswordField().contains(errorPassword));
        Assert.assertEquals(registerPage.getMessageFromPasswordField(), errorPassword);
    }

    @DataProvider(name = "dp1")
    public Object[][] testData(){
        return  new Object[][]{
                {"", "", "", "", "Будь ласка, вкажіть ім’я.","Будь ласка, вкажіть прізвище.","Будь ласка, введіть вашу ел. пошту.","Будь ласка, введіть ваш пароль."},
                {"Alex", "", "", "", "", "Будь ласка, вкажіть прізвище.", "Будь ласка, введіть вашу ел. пошту.","Будь ласка, введіть ваш пароль."},
                {"Alex", "B", "", "", "", "", "Будь ласка, введіть вашу ел. пошту.","Будь ласка, введіть ваш пароль."},
                {"Alex", "B", "we", "", "", "", "Будь ласка, виправте помилку в ел. пошті.","Будь ласка, введіть ваш пароль."},
        };

    }


//    @Test
//    public void CheckRegisterWithEmptyFields() {
//        WorkUaRegisterPage registerPage = new WorkUaRegisterPage(webDriver);
//        registerPage.clickRegistrationButton();
//        String message = registerPage.getMessageFromFirstNameField();
//        System.out.println(message);
//        Assert.assertTrue(message.contains("Будь ласка, вкажіть ім’я."));
//        Assert.assertTrue(!message.isEmpty());
//    }
//
//    @Test
//    public void putFirstName() {
//        WorkUaRegisterPage registerPage = new WorkUaRegisterPage(webDriver);
//        registerPage.putValueInFirstNameField("Alex");
//        registerPage.clickRegistrationButton();
//        String message = registerPage.getMessageFromFirstNameField();
//        System.out.println("message:" + message);
//        Assert.assertTrue(message.isEmpty());
////        Assert.assertTrue(message.equals(""));
//    }

//    @Test  Что делать с капчей ??!
//    public void checkSuccessfulRegistration() {
//        WorkUaRegisterPage registerPage = new WorkUaRegisterPage(webDriver);
//        registerPage.putValueInFirstNameField("Alex");
//        registerPage.putValueInLastNameField("B");
//        registerPage.putValueInEmailField("av-pochta-j@ukr.net");
//        registerPage.putValueInPasswordField("AVqaz01");
//        registerPage.clickRegistrationButton();
//
//    }

    @AfterTest
    public void AfterSuite() {
        webDriver.quit();
    }


}
