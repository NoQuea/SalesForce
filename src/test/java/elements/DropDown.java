package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Log4j2
public class DropDown extends BaseElements{


    String dropDownLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]/div[@class='uiMenu']";
    String optionsLocator = "//div[contains(@class, 'visible')]//a[text()='%s']";
    String dropDownLocatorParentAccount = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String optionsLocatorParentAccount = "//div[@title='%s']";
    String dropDownLocatorForContactsAndLeads = "//div[contains(@class, 'modal-body')]//label[text()='%s']//ancestor::div[contains(@class, 'slds-grid')]//div[contains(@class, 'slds-combobox slds-dropdown')]//button";
    String optionsDropDownLocatorForContactsAndLeads = "//span[text()='%s'][@title]";
    String dropDownLocatorForAccountNameAndReportsToAndDate = "//div[contains(@class, 'modal-body')]//label[text()='%s']//ancestor::div[contains(@class, 'slds-grid')]//input";
    String optionsDropDownLocatorForAccountNameAndReportsTo = "//span[@title='%s']";
    String optionsDropDownLocatorForDate = "//button[@name='%s']";



    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver,40);
    }

    public void selectOption(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownLocator, this.label))));
        driver.findElement(By.xpath(String.format(dropDownLocator, this.label))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionsLocator, option))));
        driver.findElement(By.xpath(String.format(optionsLocator, option))).click();
    }

    public void selectOptionParent(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownLocatorParentAccount, this.label))));
        driver.findElement(By.xpath(String.format(dropDownLocatorParentAccount, this.label))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionsLocatorParentAccount, option))));
        driver.findElement(By.xpath(String.format(optionsLocatorParentAccount, option))).click();
    }

    public void selectOptionContactAndLead(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownLocatorForContactsAndLeads, this.label))));
        driver.findElement(By.xpath(String.format(dropDownLocatorForContactsAndLeads, this.label))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionsDropDownLocatorForContactsAndLeads, option))));
        driver.findElement(By.xpath(String.format(optionsDropDownLocatorForContactsAndLeads, option))).click();
    }
    public void selectOptionForAccountNameAndReportsTo(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);


        driver.findElement(By.xpath(String.format(dropDownLocatorForAccountNameAndReportsToAndDate, this.label))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionsDropDownLocatorForAccountNameAndReportsTo, option))));
        driver.findElement(By.xpath(String.format(optionsDropDownLocatorForAccountNameAndReportsTo, option))).click();
    }

    public void selectOptionForDate(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dropDownLocatorForAccountNameAndReportsToAndDate, this.label))));
        driver.findElement(By.xpath(String.format(dropDownLocatorForAccountNameAndReportsToAndDate, this.label))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(optionsDropDownLocatorForDate, option))));
        driver.findElement(By.xpath(String.format(optionsDropDownLocatorForDate, option))).click();
    }
}
