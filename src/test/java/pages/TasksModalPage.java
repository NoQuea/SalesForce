package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TasksModalPage extends BasePage{


    public static final By MODAL_TITLE = By.xpath("//div[contains(@class, 'slds-split-view__header')]//img");


    public TasksModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Tasks Modal page")
    public boolean isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_TITLE));
        return isExist(MODAL_TITLE);
    }
}
