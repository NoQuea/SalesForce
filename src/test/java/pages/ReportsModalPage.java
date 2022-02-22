package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReportsModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//span[@class='slds-p-right--x-small entityName uiOutputText']");

    public ReportsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

}
