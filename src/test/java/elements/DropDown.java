package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class DropDown extends BaseElements{


    String dropDownLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]/div[@class='uiMenu']";
    String optionsLocator = "//div[contains(@class, 'visible')]//a[text()='%s']";
    String dropDownLocatorParentAccount = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String optionsLocatorParentAccount = "//div[@title='%s']";
    String dropDownLocatorForContactsAndLeads = "//div[contains(@class, 'modal-body')]//label[text()='%s']//ancestor::div[contains(@class, 'slds-grid')]//div[contains(@class, 'slds-combobox slds-dropdown')]//button";
    String optionsDropDownLocatorForContactsAndLeads = "//span[text()='%s'][@title]";
    String dropDownLocatorForContactsAccountNameAndReportsTo = "//div[contains(@class, 'modal-body')]//label[text()='%s']//ancestor::div[contains(@class, 'slds-grid')]//input";
    String optionsDropDownLocatorForContactsAccountNameAndReportsTo = "//span[@title='%s']";



    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver,3);
    }

    public void selectOption(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        driver.findElement(By.xpath(String.format(dropDownLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionsLocator, option))).click();
    }

    public void selectOptionParent(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(dropDownLocatorParentAccount)));
        driver.findElement(By.xpath(String.format(dropDownLocatorParentAccount, this.label))).click();
        driver.findElement(By.xpath(String.format(optionsLocatorParentAccount, option))).click();
    }

    public void selectOptionContactAndLead(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropDownLocatorForContactsAndLeads)));
        driver.findElement(By.xpath(String.format(dropDownLocatorForContactsAndLeads, this.label))).click();
        driver.findElement(By.xpath(String.format(optionsDropDownLocatorForContactsAndLeads, option))).click();
    }
    public void selectOptionForContactsAccountNameAndReportsTo(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        driver.findElement(By.xpath(String.format(dropDownLocatorForContactsAccountNameAndReportsTo, this.label))).click();
        driver.findElement(By.xpath(String.format(optionsDropDownLocatorForContactsAccountNameAndReportsTo, option))).click();
    }

}
