package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class SettingsPage extends BasePage{

    public static final By PERSONAL_INFORMATION = By.xpath("//h1[@class='setup-header-title'][text()='Personal Information']");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Settings page")
    public boolean isPageOpen() {
        return isExist(PERSONAL_INFORMATION);
    }
}
