package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


@Log4j2
public class HomeSalesPage extends BasePage {


    public static final By TITLE_SALES = By.xpath("//span[@title='Quarterly Performance']");
    public static final By VIEW_PROFILE = By.xpath("//div[@class='profileTrigger branding-user-profile bgimg slds-avatar slds-avatar_profile-image-small circular forceEntityIcon']//span[@class='uiImage']");
    public static final By NOTIFICATIONS = By.xpath("//span[@role='tooltip'][text()='Notifications']//ancestor::li");
    public static final By SETUP = By.xpath("//span[@role='tooltip'][text()='Setup']//ancestor::li");
    public static final By SALESFORCE_HELP = By.xpath("//span[@role='tooltip'][text()='Salesforce Help']//ancestor::li");
    public static final By LEARNING_PATHS = By.xpath("//span[@role='tooltip'][text()='Learning Paths']//ancestor::li");
    public static final By CLOSE_SUBSCRIBE_BUTTON = By.xpath("//section[@role='dialog']/button");
    String linkNavBar = "//one-app-nav-bar-item-root/ancestor::one-app-nav-bar//a[@title='%s']";

    public HomeSalesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the Home page")
    public void open() {
        log.info("Opening the Home page");
        driver.get(baseUrl + "/lightning/page/home");
    }

    @Override
    @Step("Checking that we are on the Home Sales page")
    public boolean isPageOpen() {
        return isExist(TITLE_SALES);
    }

    @Step("Click on View Profile")
    public void clickViewProfile() {
        log.info("Click on View Profile");
        driver.findElement(VIEW_PROFILE).click();
    }

    @Step("Click on Notifications")
    public void clickNotifications() {
        log.info("Click on Notifications");
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATIONS));
        driver.findElement(NOTIFICATIONS).click();
    }

    @Step("Click on Setup")
    public void clickSetup() {
        log.info("Click on Setup");
        driver.findElement(SETUP).click();
    }

    @Step("Click on Salesforce Help")
    public void clickSalesforceHelp() {
        log.info("Click on Salesforce Help");
        driver.findElement(SALESFORCE_HELP).click();
    }
    @Step("Click on Learning Paths")
    public void clickLearningPaths() {
        log.info("Click on Learning Paths");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LEARNING_PATHS));
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(LEARNING_PATHS)).build().perform();
    }
    @Step("Click on Subscribe Button")
    public void closeSubscribeButton() {
        log.info("Click on Subscribe Button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_SUBSCRIBE_BUTTON));
        driver.findElement(CLOSE_SUBSCRIBE_BUTTON).click();
    }

    @Step("Click on Link")
    public void clickLink(String label){
        log.info("Click on Link");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(linkNavBar, label))));
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath(String.format(linkNavBar, label)))).build().perform();
    }

}
