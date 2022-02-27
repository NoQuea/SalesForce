package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class Input extends BaseElements{


    String inputLocatorAccount = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String inputLocator = "//div[contains(@class, 'modal-body')]//label[text()='%s']//ancestor::lightning-input[contains(@class, 'slds-form-element')]//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeAccount(String text){
        System.out.printf("Writing text '%s' into input with label '%s' \n",text, this.label);
        driver.findElement(By.xpath(String.format(inputLocatorAccount, this.label))).sendKeys(text);
    }

    public void write(String text){
        System.out.printf("Writing text '%s' into input with label '%s' \n",text, this.label);
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
    }

}
