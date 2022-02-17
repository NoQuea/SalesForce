package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpportunitiesDetailsPage extends BasePage{
    String fieldValue = "//span[text()='%s']//ancestor::div[contains(@class, 'slds-form-element_edit')]//span[contains(@class, 'static slds-grow word-break')]";
    String fieldValueForAccountNameAndReportsTo = "//span[text()='%s']//ancestor::div[@class='slds-grid slds-size_1-of-1 label-inline']//a//span";

    public OpportunitiesDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(DETAILS_LINK);
    }

    @Step("Нажатие на кнопку Details")
    public OpportunitiesDetailsPage clickDetails(){
        driver.findElement(DETAILS_LINK).click();
        return this;
    }

    public String getFieldByName(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }
    public String getFieldByAccAndRep(String fieldName) {
        return driver.findElement(By.xpath(String.format(fieldValueForAccountNameAndReportsTo, fieldName))).getText();
    }
}