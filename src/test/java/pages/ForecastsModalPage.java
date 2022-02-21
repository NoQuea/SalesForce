package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForecastsModalPage extends BasePage{
    public static final By MODAL_TITLE = By.xpath("//lightning-formatted-text[text()='Forecasts > Opportunity Revenue']");
    public ForecastsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
