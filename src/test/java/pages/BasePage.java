package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;


@Log4j2
public abstract class BasePage {

    public static final By NEW_BUTTON = By.xpath("//ancestor::ul[contains(@class, 'slds-m-left--xx-small oneActionsRibbon forceActionsContainer')]//a[@title='New']");
    public static final By SAVE_ACCOUNT_BUTTON = By.xpath("//button[@title='Save']");
    public static final By SAVE_BUTTON = By.xpath("//button[text()='Save']");
    public static final By DETAILS_LINK = By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']//li[@title='Details']");
    public static String baseUrl;


    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
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
