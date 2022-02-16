package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LeadDetailsPage extends BasePage{

    String fieldValue = "//span[text()='%s']//ancestor::div[contains(@class, 'slds-form-element_edit')]//span[contains(@class, 'static slds-grow word-break')]";
    String fieldValueForAccountNameAndReportsTo = "//span[text()='%s']//ancestor::div[@class='slds-grid slds-size_1-of-1 label-inline']//a//span";

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }

    @Step("Нажатие на кнопку Details")
    public LeadDetailsPage clickDetails(){
        driver.findElement(DETAILS_LINK).click();
        return this;
    }

    public String getFieldByName(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }
}
