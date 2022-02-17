package pages;

import org.openqa.selenium.WebDriver;

public class DashboardsModalPage extends BasePage{
    public DashboardsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Dashboards']
}
