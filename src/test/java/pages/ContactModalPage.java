package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ContactModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'slds-modal__title slds-hyphenate slds-text-heading--medium')]");
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
        new DropDown(driver, "Salutation").selectOptionContactAndLead(contact.getSalutation());
        new Input(driver, "Last Name").writeContactAndLead(contact.getLastName());
        new Input(driver, "First Name").writeContactAndLead(contact.getFirstName());
        new Input(driver, "Middle Name").writeContactAndLead(contact.getMiddleName());
        new Input(driver, "Suffix").writeContactAndLead(contact.getSuffix());
        new DropDown(driver, "Account Name").selectOptionForContactsAccountNameAndReportsTo(contact.getAccountName());
        new Input(driver, "Title").writeContactAndLead(contact.getTitle());
        new Input(driver, "Email").writeContactAndLead(contact.getEmail());
        new Input(driver, "Phone").writeContactAndLead(contact.getPhone());
        new Input(driver, "Mobile").writeContactAndLead(contact.getMobile());
        new DropDown(driver, "Reports To").selectOptionForContactsAccountNameAndReportsTo(contact.getReportsTo());
        new Input(driver, "Department").writeContactAndLead(contact.getDepartment());
        new Input(driver, "Fax").writeContactAndLead(contact.getFax());
        new TextArea(driver, "Mailing Street").writeAreaForContactAndLead(contact.getMailingStreet());
        new Input(driver, "Mailing City").writeContactAndLead(contact.getMailingCity());
        new Input(driver, "Mailing Zip/Postal Code").writeContactAndLead(contact.getMailingZipPostalCode());
        new Input(driver, "Mailing State/Province").writeContactAndLead(contact.getMailingStateProvince());
        new Input(driver, "Mailing Country").writeContactAndLead(contact.getMailingCountry());

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
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", driver.findElement(SAVE_BUTTON));
    }
}
