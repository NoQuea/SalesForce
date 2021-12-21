package pages;

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

    public ContactDetailsPage create(Contact contact){
        return clickSave();
    }

    public ContactDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new ContactDetailsPage(driver);
    }

}
