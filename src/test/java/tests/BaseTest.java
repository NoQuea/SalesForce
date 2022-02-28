package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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
    OpportunitiesListPage opportunitiesListPage;
    OpportunitiesModalPage opportunitiesModalPage;
    OpportunitiesDetailsPage opportunitiesDetailsPage;
    ForgotYourPasswordPage forgotYourPasswordPage;
    ViewProfileModalPage viewProfileModalPage;
    NotificationsModalPage notificationsModalPage;
    SetupModalPage setupModalPage;
    SalesforceHelpModalPage salesforceHelpModalPage;
    LearningPathsModalPage learningPathsModalPage;
    CalendarModalPage calendarModalPage;
    DashboardsModalPage dashboardsModalPage;
    FilesModelPage filesModelPage;
    ForecastsModalPage forecastsModalPage;
    GroupsModalPage groupsModalPage;
    NotesModalPage notesModalPage;
    ReportsModalPage reportsModalPage;
    TasksModalPage tasksModalPage;
    SettingsPage settingsPage;
    String email, password;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context, @Optional("chrome") String browser) {
        log.info("Start test");
        log.info(browser);

        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);

        } else if (browser.contains("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().setSize(new Dimension(1920, 1080));
        }

        loginPage = new LoginPage(driver);
        homeSalesPage = new HomeSalesPage(driver);
        forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
        viewProfileModalPage = new ViewProfileModalPage(driver);
        notificationsModalPage = new NotificationsModalPage(driver);
        setupModalPage = new SetupModalPage(driver);
        salesforceHelpModalPage = new SalesforceHelpModalPage(driver);
        learningPathsModalPage = new LearningPathsModalPage(driver);
        calendarModalPage = new CalendarModalPage(driver);
        dashboardsModalPage = new DashboardsModalPage(driver);
        filesModelPage = new FilesModelPage(driver);
        forecastsModalPage = new ForecastsModalPage(driver);
        groupsModalPage = new GroupsModalPage(driver);
        notesModalPage = new NotesModalPage(driver);
        reportsModalPage = new ReportsModalPage(driver);
        tasksModalPage = new TasksModalPage(driver);
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

        opportunitiesListPage = new OpportunitiesListPage(driver);
        opportunitiesModalPage = new OpportunitiesModalPage(driver);
        opportunitiesDetailsPage = new OpportunitiesDetailsPage(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);

        BasePage.baseUrl = System.getenv().getOrDefault("SALESFORCE_URL", PropertyReader.getProperty("salesforce.url"));
        email = System.getenv().getOrDefault("SALESFORCE_EMAIL", PropertyReader.getProperty("salesforce.email"));
        password = System.getenv().getOrDefault("SALESFORCE_PASSWORD", PropertyReader.getProperty("salesforce.password"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }
}


