package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunitiesDetailsPage extends BasePage{
    String fieldValue = "//span[text()='%s']//ancestor::div[contains(@class, 'slds-form-element_edit')]//span[contains(@class, 'static slds-grow word-break')]";
    String fieldValueForAccountName = "//span[text()='%s']//ancestor::div[@class='slds-grid slds-size_1-of-1 label-inline']//a//span";
    String day = "//span[text()='Close Date']/ancestor::div[@class='slds-grid slds-size_1-of-1 label-inline']//lightning-formatted-text";

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(fieldValue, fieldName))));
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }
    public String getFieldAccountName(String fieldName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(fieldValueForAccountName, fieldName))));
        return driver.findElement(By.xpath(String.format(fieldValueForAccountName, fieldName))).getText();
    }
    public String getDay(){
        return driver.findElement(By.xpath(day)).getText();
    }
}
