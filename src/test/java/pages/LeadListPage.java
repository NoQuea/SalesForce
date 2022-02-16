package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.baseUrl;
@Log4j2
public class LeadListPage extends BasePage{
    public static final By BREADCRUMBS_LABEL = By.xpath("//span[@class='slds-var-p-right_x-small']");

    public LeadListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Проверка на то что мы находимся на старнице Leads")
    public boolean isPageOpen() {
        return isExist(BREADCRUMBS_LABEL);
    }

    @Step("Открытие страницы Leads")
    public LeadListPage open() {
        driver.get(baseUrl + "lightning/o/Lead/list");
        return this;
    }

    @Step("Нажатие на кнопку New")
    public LeadListPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new LeadListPage(driver);
    }
}
