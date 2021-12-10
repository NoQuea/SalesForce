package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    public static final String BASE_URL = "https://teachmeskills3.my.salesforce.com/";

    @BeforeMethod
    public void setUp () {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown () {
        driver.quit();
    }

}


