package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    public static final By NEW_BUTTON = By.xpath("//a[@title='New']");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    public static final By SUBSCRIBE_NOW = By.xpath("//a[@id='trial-subscribe-now']");
    public static final By FEEDBACK = By.xpath("//a[@id='trial-feedback']");
    public static final By CHECK_OUT_TOP_FEATURES = By.xpath("//button[@class='slds-button']");
    public static final By GET_STARTED = By.xpath("//a[@id='trials-explore-link']");
    public static final By VIEW_PROFILE = By.xpath("//span[@role='tooltip'][text()='View Profile']//ancestor::li");
    public static final By NOTIFICATIONS = By.xpath("//span[@role='tooltip'][text()='Notifications']//ancestor::li");
    public static final By SETUP = By.xpath("//span[@role='tooltip'][text()='Setup']//ancestor::li");
    public static final By SALESFORCE_HELP = By.xpath("//span[@role='tooltip'][text()='Salesforce Help']//ancestor::li");
    public static final By GLOBAL_ACTIONS = By.xpath("//span[@role='tooltip'][text()='Global Actions']//ancestor::li");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean isPageOpen();

    protected boolean isExist(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex){
            System.out.println(">>> !!! " + ex.getMessage());
            return false;
        }
    }

}
