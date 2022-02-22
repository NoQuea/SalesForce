package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LeadDetailsPage extends BasePage{

    String fieldValue = "//span[text()='%s']//ancestor::div[contains(@class, 'slds-form-element_edit')]//span[contains(@class, 'static slds-grow word-break')]";
    String fieldValueForAccountNameAndReportsTo = "//span[text()='%s']//ancestor::div[@class='slds-grid slds-size_1-of-1 label-inline']//a//span";

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Lead Modal page")
    public boolean isPageOpen() {
        log.info("Checking that we are on the Lead Details page");
        return isExist(DETAILS_LINK);
    }

    @Step("Click on the 'Details' button")
    public LeadDetailsPage clickDetails(){
        log.info("Click on the 'Details' button");
        driver.findElement(DETAILS_LINK).click();
        return this;
    }
    @Step("Replacing words in fields")
    public String getFieldByName(String fieldName) {
        log.info("Values are substituted in string format: " + fieldName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(fieldValue, fieldName))));
        return driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText();
    }
}
