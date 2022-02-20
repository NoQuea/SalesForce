package pages;

import org.openqa.selenium.WebDriver;

public class ForecastsModalPage extends BasePage{
    public ForecastsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Forecasts']
}
