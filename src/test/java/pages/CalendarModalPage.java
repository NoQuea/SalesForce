package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarModalPage extends BasePage{


    public static final By MODAL_TITLE = By.xpath("//p[@class='slds-line-height_reset']");


    public CalendarModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

}
