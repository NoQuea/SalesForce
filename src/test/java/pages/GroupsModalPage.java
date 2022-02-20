package pages;

import org.openqa.selenium.WebDriver;

public class GroupsModalPage extends BasePage{
    public GroupsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Groups']
}
