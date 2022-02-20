package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesforceHelpModalPage extends BasePage{

     public static final By MODAL_TITLE = By.xpath("//div[@class='panel-content scrollable']//h2");

    public SalesforceHelpModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
