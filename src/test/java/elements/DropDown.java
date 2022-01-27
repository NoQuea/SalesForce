package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    String dropDownLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]/div[@class='uiMenu']";
            //label[text()='%s']/ancestor::lightning-combobox//div//input

    String optionsLocator = "//div[contains(@class, 'visible')]//a[text()='%s']";
            //label[text()='%s']/ancestor::lightning-combobox//div[contains(@class, 'slds-is-open')]"

    String dropdownLocatorForContactModalFieldAccountName = "//label[text()='%s']/ancestor::lightning-grouped-combobox//div//input";
    String optionLocatorForContactFieldAccountName = "//label[text()='%s']/ancestor::lightning-grouped-combobox//div[contains(@class, 'slds-is-open')]";



    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        System.out.printf("Select option '%s' into dropdown with label '%s' \n", option, this.label);
        driver.findElement(By.xpath(String.format(dropDownLocator, this.label))).click();
        driver.findElement(By.xpath(String.format(optionsLocator, option))).click();
    }


}
