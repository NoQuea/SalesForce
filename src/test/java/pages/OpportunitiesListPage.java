package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OpportunitiesListPage extends BasePage{

    public static final By BREADCRUMBS_LABEL = By.xpath("//span[@class='slds-var-p-right_x-small']");

    public OpportunitiesListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(BREADCRUMBS_LABEL);
    }

    @Step("Открытие страницы Contacts")
    public OpportunitiesListPage open() {
        driver.get(baseUrl + "/lightning/o/Opportunity/list");
        return this;
    }

    @Step("Нажатие на кнопку New")
    public OpportunitiesModalPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new OpportunitiesModalPage(driver);
    }
}
