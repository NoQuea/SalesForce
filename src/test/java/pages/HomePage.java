package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.BaseTest.BASE_URL;

public class HomePage extends BasePage {
    public static final By MENU_LINK = By.xpath("//span[@class='slds-truncate'][text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/lightning/page/home");
    }

    @Override
    public boolean isPageOpen() {
        return isExit(MENU_LINK);
    }
}
