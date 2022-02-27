package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import models.Contact;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
@Log4j2
public class ContactModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//span[@class='slds-var-p-right_x-small']");
    public static final By ERROR_ICON = By.xpath("//lightning-icon[contains(@title,'Error')]//lightning-primitive-icon//*[name()='svg']");


    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Contact Modal page")
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }


    @Step("Entering data in the Contact fields")
    public ContactDetailsPage create(Contact contact)  {
        log.info("Entering data in the Contact fields");
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write(contact.getMiddleName());
        new DropDown(driver, "Salutation").selectOptionContactAndLead(contact.getSalutation());
        new Input(driver, "Suffix").write(contact.getSuffix());
        new DropDown(driver, "Account Name").selectOptionForAccountNameAndReportsTo(contact.getAccountName());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new DropDown(driver, "Reports To").selectOptionForAccountNameAndReportsTo(contact.getReportsTo());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new TextArea(driver, "Mailing Street").writeAreaForContactAndLead(contact.getMailingStreet());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZipPostalCode());
        new Input(driver, "Mailing State/Province").write(contact.getMailingStateProvince());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());

        log.info("Click save");
        return clickSave();
    }

    @Step("Click on the 'Save' button")
    public ContactDetailsPage clickSave() {
        log.info("Click on the 'Save' button");
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
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
    }
}
