package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
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

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp (ITestContext context, @Optional("chrome") String browser) {
//        options.addArguments("--headless");
        log.info("start test");
        log.info(browser);

        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);

        } else if (browser.contains("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

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

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);

        Configuration.baseUrl = System.getenv().getOrDefault("SALESFORCE_URL", PropertyReader.getProperty("salesforce.url"));
        email = System.getenv().getOrDefault("SALESFORCE_EMAIL", PropertyReader.getProperty("salesforce.email"));
        password = System.getenv().getOrDefault("SALESFORCE_PASSWORD", PropertyReader.getProperty("salesforce.password"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown () {
        driver.quit();
    }
}


