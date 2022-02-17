package pages;

import org.openqa.selenium.WebDriver;

public class TasksModalPage extends BasePage{
    public TasksModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Tasks']
}
