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
    @Step("Checking that we are on the Leads page")
    public boolean isPageOpen() {
        log.info("Checking that we are on the Leads page");
        return isExist(BREADCRUMBS_LABEL);
    }

    @Step("Opening the Leads page")
    public LeadListPage open() {
        log.info("Opening the Leads page");
        driver.get(baseUrl + "/lightning/o/Lead/list");
        return this;
    }

    @Step("Click on the 'New' button")
    public LeadListPage clickNew() {
        log.info("Click on the 'New' button");
        driver.findElement(NEW_BUTTON).click();
        return new LeadListPage(driver);
    }
}
