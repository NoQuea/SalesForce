package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LeadModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//span[@class='slds-var-p-right_x-small']");
    public static final By ERROR_ICON = By.xpath("//lightning-icon[contains(@title,'Error')]//lightning-primitive-icon//*[name()='svg']");
    public LeadModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Lead Modal page")
    public boolean isPageOpen() {
        log.info("Checking that we are on the Lead Modal page");
        return isExist(MODAL_TITLE);
    }

    @Step("Entering data in the Lead fields")
    public LeadDetailsPage create(Lead lead) {
        log.info("Entering data in the Lead fields");
        new DropDown(driver, "Lead Status").selectOptionContactAndLead(lead.getLeadStatus());
        new DropDown(driver, "Salutation").selectOptionContactAndLead(lead.getSalutation());
        new Input(driver, "Last Name").write(lead.getLastName());
        new Input(driver, "First Name").write(lead.getFirstName());
        new Input(driver, "Middle Name").write(lead.getMiddleName());
        new Input(driver, "Suffix").write(lead.getSuffix());
        new Input(driver, "Website").write(lead.getWebSite());
        new Input(driver, "Title").write(lead.getTitle());
        new Input(driver, "Email").write(lead.getEmail());
        new Input(driver, "Phone").write(lead.getPhone());
        new Input(driver, "Mobile").write(lead.getMobile());
        new Input(driver, "Company").write(lead.getCompany());
        new DropDown(driver, "Industry").selectOptionContactAndLead(lead.getIndustry());
        new Input(driver, "No. of Employees").write(lead.getNoOfEmployees());
        new DropDown(driver, "Lead Source").selectOptionContactAndLead(lead.getLeadSource());
        new TextArea(driver, "Street").writeAreaForContactAndLead(lead.getStreet());
        new Input(driver, "City").write(lead.getCity());
        new Input(driver, "State/Province").write(lead.getStateProvince());
        new Input(driver, "Zip/Postal Code").write(lead.getZipPostalCode());
        new Input(driver, "Country").write(lead.getCountry());
        new DropDown(driver, "Rating").selectOptionContactAndLead(lead.getRating());
        log.info("Click save");
        return clickSave();
    }
    @Step("Click on the 'Save' button")
    public LeadDetailsPage clickSave() {
        log.info("Click on the 'Save' button");
        driver.findElement(SAVE_BUTTON).click();
        return new LeadDetailsPage(driver);
    }
    @Step("Getting Error Massage after click Save button")
    public boolean getErrorMassage(){
        log.info("Getting Error Massage after click Save button");
        return driver.findElement(ERROR_ICON).isDisplayed();
    }
    @Step("Clicking on the Save button")
    public void clickSaveForError(){
        log.info("Clicking on the Save button");
        driver.findElement(SAVE_BUTTON).click();
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", driver.findElement(SAVE_BUTTON));
    }
}
