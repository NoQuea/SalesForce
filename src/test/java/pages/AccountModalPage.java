package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class AccountModalPage extends BasePage{

    public static final By MODAL_TITLE = By.xpath("//span[normalize-space()='Account Information']");
    public static final By GENERIC_ERROR_AFTER_SAVE = By.xpath("//span[@class='genericError uiOutputText']");

    public AccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("We check that we are in the Account filling window")
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    @Step("Entering data in the Account fields")
    public AccountDetailsPage create(Account account) {

        new Input(driver, "Account Name").writeAccount(account.getAccountName());
        new Input(driver, "Website").writeAccount(account.getWebSite());
        new DropDown(driver, "Type").selectOption(account.getType());
        new Input(driver, "Phone").writeAccount(account.getPhone());
        new DropDown(driver, "Parent Account").selectOptionParent(account.getParentAccount());
        new Input(driver, "Employees").writeAccount(account.getEmployees());
        new DropDown(driver, "Industry").selectOption(account.getIndustry());
        new TextArea(driver, "Description").writeArea(account.getDescription());
        new TextArea(driver, "Billing Street").writeArea(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").writeArea(account.getShippingStreet());
        new Input(driver, "Billing City").writeAccount(account.getBillingCity());
        new Input(driver, "Billing State/Province").writeAccount(account.getBillingState());
        new Input(driver, "Shipping City").writeAccount(account.getShippingCity());
        new Input(driver, "Shipping State/Province").writeAccount(account.getShippingState());
        new Input(driver, "Billing Zip/Postal Code").writeAccount(account.getBillingZip());
        new Input(driver, "Billing Country").writeAccount(account.getBillingCountry());
        new Input(driver, "Shipping Zip/Postal Code").writeAccount(account.getShippingZip());
        new Input(driver, "Shipping Country").writeAccount(account.getShippingCountry());

        return clickSave();
    }
    @Step("Clicking on the Save button")
    public AccountDetailsPage clickSave(){
        log.info("Clicking on the Save button");
        driver.findElement(SAVE_ACCOUNT_BUTTON).click();
        return new AccountDetailsPage(driver);
    }



}
