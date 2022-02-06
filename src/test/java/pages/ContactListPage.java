package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.baseUrl;

public class ContactListPage extends BasePage {

    public static final By BREADCRUMBS_LABEL = By.xpath("//nav[@aria-label='Breadcrumbs']//span");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(BREADCRUMBS_LABEL);
    }

    public ContactListPage open() {
        driver.get(baseUrl + "lightning/o/Contact/list");
        return this;
    }

    public ContactModalPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new ContactModalPage(driver);
    }
}
