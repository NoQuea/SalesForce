package pages;

import org.openqa.selenium.WebDriver;

public class LeadListPage extends BasePage{
    @Override
    public boolean isPageOpen() {
        return false;
    }

    public LeadListPage(WebDriver driver) {
        super(driver);
    }
}
