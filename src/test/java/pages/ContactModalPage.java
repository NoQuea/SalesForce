package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'slds-modal__title slds-hyphenate slds-text-heading--medium')]");

    public ContactModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }


    @Step("Entering data in the Contact fields")
    public ContactDetailsPage create(Contact contact) {
        new Input(driver, "Last Name").writeContact(contact.getLastName());
        new DropDown(driver, "Salutation").selectOptionContactAndLead(contact.getSalutation());
        new Input(driver, "First Name").writeContact(contact.getFirstName());
        new Input(driver, "Middle Name").writeContact(contact.getMiddleName());
        new Input(driver, "Suffix").writeContact(contact.getSuffix());
        new DropDown(driver, "Account Name").selectOptionForContactsAccountNameAndReportsTo(contact.getAccountName());
        new Input(driver, "Title").writeContact(contact.getTitle());
        new Input(driver, "Email").writeContact(contact.getEmail());
        new Input(driver, "Phone").writeContact(contact.getPhone());
        new Input(driver, "Mobile").writeContact(contact.getMobile());
        new DropDown(driver, "Reports To").selectOptionForContactsAccountNameAndReportsTo(contact.getReportsTo());
        new Input(driver, "Department").writeContact(contact.getDepartment());
        new Input(driver, "Fax").writeContact(contact.getFax());
        new TextArea(driver, "Mailing Street").writeAreaForContactAndLead(contact.getMailingStreet());
        new Input(driver, "Mailing City").writeContact(contact.getMailingCity());
        new Input(driver, "Mailing Zip/Postal Code").writeContact(contact.getMailingZipPostalCode());
        new Input(driver, "Mailing State/Province").writeContact(contact.getMailingStateProvince());
        new Input(driver, "Mailing Country").writeContact(contact.getMailingCountry());

        return clickSave();
    }

    public ContactDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
    }

}
