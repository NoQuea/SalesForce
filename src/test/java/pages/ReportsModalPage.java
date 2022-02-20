package pages;

import org.openqa.selenium.WebDriver;

public class ReportsModalPage extends BasePage{
    public ReportsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Reports']
}
