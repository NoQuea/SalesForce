package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import models.Opportunities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class OpportunitiesModalPage extends BasePage{

    public static final By MODAL_TITLE = By.xpath("//a//span[normalize-space()='Opportunities']");


    public OpportunitiesModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Opportunities Modal page")
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
    @Step("Entering data in the Contact fields")
    public OpportunitiesDetailsPage create(Opportunities opportunities)  {
        log.info("Entering data in the Contact fields");

        new DropDown(driver, "Stage").selectOptionContactAndLead(opportunities.getStage());
        new Input(driver, "Opportunity Name").write(opportunities.getOpportunityName());
        new DropDown(driver, "Close Date").selectOptionForDate(opportunities.getCloseDate());
        new DropDown(driver, "Account Name").selectOptionForAccountNameAndReportsTo(opportunities.getAccountName());

        log.info("Click save");
        return clickSave();
    }

    @Step("Click on the 'Save' button")
    public OpportunitiesDetailsPage clickSave() {
        log.info("Click on the 'Save' button");
        driver.findElement(SAVE_BUTTON).click();
        return new OpportunitiesDetailsPage(driver);
    }
}
