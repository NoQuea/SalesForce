package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage{

    public static final By PERSONAL_INFORMATION = By.xpath("//h1[@class='setup-header-title'][text()='Personal Information']");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PERSONAL_INFORMATION);
    }
}
