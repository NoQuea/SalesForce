package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearningPathsModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//div[contains(@class, 'sidebarHeader')]/h2");

    public LearningPathsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }
}