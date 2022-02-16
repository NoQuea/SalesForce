package pages;

import org.openqa.selenium.WebDriver;

public class LeadDetailsPage extends BasePage{


    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
