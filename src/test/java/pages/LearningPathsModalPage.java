package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearningPathsModalPage extends BasePage {

    public static final By MODAL_TITLE = By.xpath("//div/ancestor::section//h2[text()='Learning Paths']");

    public LearningPathsModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    public String getText(){
        return driver.findElement(MODAL_TITLE).getText();
    }
}
