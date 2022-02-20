package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationsModalPage extends BasePage{

    public static final By MODAL_TITLE = By.xpath("//div[@class='unsNotificationsPanel']//h2");

    public NotificationsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
