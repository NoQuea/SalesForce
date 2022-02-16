package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

//@Listeners(TestListener.class)
public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomeSalesPage homeSalesPage;
    AccountListPage accountListPage;
    AccountModalPage accountModalPage;
    AccountDetailsPage accountDetailsPage;
    ContactListPage contactListPage;
    ContactModalPage contactModalPage;
    ContactDetailsPage contactDetailsPage;
    LeadListPage leadListPage;
    LeadModalPage leadModalPage;
    LeadDetailsPage leadDetailsPage;
    ForgotYourPasswordPage forgotYourPasswordPage;
    ViewProfilePage viewProfilePage;
    SettingsPage settingsPage;
    String email, password;


    @BeforeMethod(alwaysRun = true)
    public void setUp () {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homeSalesPage = new HomeSalesPage(driver);
        forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
        viewProfilePage = new ViewProfilePage(driver);
        settingsPage = new SettingsPage(driver);

        accountListPage = new AccountListPage(driver);
        accountModalPage = new AccountModalPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);

        contactListPage = new ContactListPage(driver);
        contactModalPage = new ContactModalPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);

        leadDetailsPage = new LeadDetailsPage(driver);
        leadListPage = new LeadListPage(driver);
        leadModalPage = new LeadModalPage(driver);

        Configuration.baseUrl = System.getenv().getOrDefault("SALESFORCE_URL", PropertyReader.getProperty("salesforce.url"));
        email = System.getenv().getOrDefault("SALESFORCE_EMAIL", PropertyReader.getProperty("salesforce.email"));
        password = System.getenv().getOrDefault("SALESFORCE_PASSWORD", PropertyReader.getProperty("salesforce.password"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown () {
        driver.quit();
    }
}


