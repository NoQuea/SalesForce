package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseElements{


    String inputLocatorAccount = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String inputLocatorContactAndLead = "//div[contains(@class, 'modal-body')]//label[text()='%s']//ancestor::lightning-input[contains(@class, 'slds-form-element')]//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text){
        System.out.printf("Writing text '%s' into input with label '%s' \n",text, this.label);
        driver.findElement(By.xpath(String.format(inputLocatorAccount, this.label))).sendKeys(text);
    }

    public void writeContactAndLead(String text){
        System.out.printf("Writing text '%s' into input with label '%s' \n",text, this.label);
        driver.findElement(By.xpath(String.format(inputLocatorContactAndLead, this.label))).sendKeys(text);
    }

//    public void selectOptionForParent(String option) {
//        System.out.printf("Select option '%s' into input with label '%s' \n", option, this.label);
//        driver.findElement(By.xpath(String.format(inputForParent, this.label))).click();
//        driver.findElement(By.xpath(String.format(inputDownForParent, option))).click();
//    }

}
