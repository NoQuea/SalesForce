package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;

    String inputLocator = "//div[contains(@class, 'modal-body')]//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text){

        System.out.printf("Writing text '%s' into input with label '%s' \n",text, this.label);
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);

    }

}
