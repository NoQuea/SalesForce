package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;

    String inputLocatorAccount = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String inputLocatorContact = "//div[contains(@class, 'modal-body')]//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input";

    String inputForParent = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";
    String inputDownForParent = "//div[@title='Test']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text){
        System.out.printf("Writing text '%s' into input with label '%s' \n",text, this.label);
        driver.findElement(By.xpath(String.format(inputLocatorAccount, this.label))).sendKeys(text);
    }

//    public void selectOptionForParent(String option) {
//        System.out.printf("Select option '%s' into input with label '%s' \n", option, this.label);
//        driver.findElement(By.xpath(String.format(inputForParent, this.label))).click();
//        driver.findElement(By.xpath(String.format(inputDownForParent, option))).click();
//    }

}
