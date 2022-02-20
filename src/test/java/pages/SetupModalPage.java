package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SetupModalPage extends BasePage{

    public static final By MODAL_TITLE = By.xpath("//a[@title='Setup']//div[contains(@class, 'slds-col slds-size')]");

    public SetupModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
