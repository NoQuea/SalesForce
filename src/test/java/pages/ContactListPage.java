package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactListPage extends BasePage {

    public static final By BREADCRUMBS_LABEL = By.xpath("//span[@class='slds-var-p-right_x-small']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(BREADCRUMBS_LABEL);
    }

    @Step("Открытие страницы Contacts")
    public ContactListPage open() {
        driver.get(baseUrl + "/lightning/o/Contact/list");
        return this;
    }

    @Step("Нажатие на кнопку New")
    public ContactModalPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new ContactModalPage(driver);
    }
}
