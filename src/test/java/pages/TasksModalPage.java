package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksModalPage extends BasePage{


    public static final By MODAL_TITLE = By.xpath("//div[@class='entityNameTitle slds-line-height_reset']");


    public TasksModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Tasks Modal page")
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}
