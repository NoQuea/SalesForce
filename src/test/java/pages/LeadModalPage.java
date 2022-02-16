package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'slds-modal__title slds-hyphenate slds-text-heading--medium')]");

    public LeadModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    @Step("Entering data in the Lead fields")
    public LeadDetailsPage create(Lead lead) {

        new DropDown(driver, "Lead Status").selectOptionContactAndLead(lead.getLeadStatus());
        new DropDown(driver, "Salutation").selectOptionContactAndLead(lead.getSalutation());
        new Input(driver, "Last Name").writeContactAndLead(lead.getLastName());
        new Input(driver, "First Name").writeContactAndLead(lead.getFirstName());
        new Input(driver, "Middle Name").writeContactAndLead(lead.getMiddleName());
        new Input(driver, "Suffix").writeContactAndLead(lead.getSuffix());
        new Input(driver, "Website").writeContactAndLead(lead.getWebSite());
        new Input(driver, "Title").writeContactAndLead(lead.getTitle());
        new Input(driver, "Email").writeContactAndLead(lead.getEmail());
        new Input(driver, "Phone").writeContactAndLead(lead.getPhone());
        new Input(driver, "Mobile").writeContactAndLead(lead.getMobile());
        new DropDown(driver, "Rating").selectOptionContactAndLead(lead.getRating());
        new Input(driver, "Company").writeContactAndLead(lead.getCompany());
        new DropDown(driver, "Industry").selectOptionContactAndLead(lead.getIndustry());
        new Input(driver, "No. of Employees").writeContactAndLead(lead.getNoOfEmployees());
        new DropDown(driver, "Lead Source").selectOptionContactAndLead(lead.getLeadSource());
        new TextArea(driver, "Street").writeAreaForContactAndLead(lead.getStreet());
        new Input(driver, "City").writeContactAndLead(lead.getCity());
        new Input(driver, "State/Province").writeContactAndLead(lead.getStateProvince());
        new Input(driver, "Zip/Postal Code").writeContactAndLead(lead.getZipPostalCode());
        new Input(driver, "Country").writeContactAndLead(lead.getCountry());

        return clickSave();
    }

    public LeadDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new LeadDetailsPage(driver);
    }
}
