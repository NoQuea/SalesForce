package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupsModalPage extends BasePage {
    public static final By MODAL_TITLE = By.xpath("//span[@class='slds-var-p-right_x-small']");

    public GroupsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
