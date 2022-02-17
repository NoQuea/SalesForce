package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea extends BaseElements{

    String textAreaLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//textarea";
    String textAreaLocatorForContactAndLead = "//div[contains(@class, 'modal-body')]//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeArea(String text) {
        System.out.printf("Select option '%s' into textArea with label '%s' \n", text, this.label);
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).sendKeys(text);
    }

    public void writeAreaForContactAndLead(String text) {
        System.out.printf("Select option '%s' into textArea with label '%s' \n", text, this.label);
        driver.findElement(By.xpath(String.format(textAreaLocatorForContactAndLead, this.label))).sendKeys(text);
    }
}


