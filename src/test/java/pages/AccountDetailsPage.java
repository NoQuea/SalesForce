package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {

    public static final By DETAILS_LINK = By.xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']//li[@title='Details']");
    String detailsLocator = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//li[@title='Details']";
    String fieldValue = "//span[text()='%s']//ancestor::div[contains(@class, 'slds-form-element_edit')]//span[contains(@class, 'static slds-grow word-break')]";
    String fieldValueWebsite = "//records-lwc-detail-panel//span[text()='%s']//ancestor::force-record-layout-item//lightning-formatted-url/a";
    String fieldValuePhoneFax = "//records-lwc-detail-panel//span[text()='%s']//ancestor::force-record-layout-item//lightning-formatted-phone/a";
    String fieldValueParent = "//span[@id='window']";

    //span[text()='%s']//ancestor::div[contains(@class, 'slds-form-element_edit')]//a
    String fieldValueEmployees = "//records-lwc-detail-panel//span[text()='%s']/ancestor::force-record-layout-item//span//lightning-formatted-number";
    String ButtonEditAddress = "//force-record-layout-section//span[text()='%s']/ancestor::force-record-layout-item//span[@class='inline-edit-trigger-icon slds-button__icon slds-button__icon_hint']";
    String fieldValueAddress = "//lightning-input-address//label[text()='%s']/ancestor::lightning-input[contains(@class, 'slds-form-element')]//input";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }

    @Step("Нажатие на кнопку Details")
    public AccountDetailsPage clickDetails(){
       driver.findElement(By.xpath(detailsLocator)).click();
       return this;
    }

    public String getFieldByName(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }

    public String getFieldByParentAcc(String fieldValueParent) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldValueParent))).getText();
    }

}
