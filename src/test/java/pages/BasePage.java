package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static final String BASE_URL = "https://teachmeskills3.my.salesforce.com/";
    public static final By NEW_BUTTON = By.xpath("//a[@title='New']");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

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
