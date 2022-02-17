package pages;

import org.openqa.selenium.WebDriver;

public class NotesModalPage extends BasePage{
    public NotesModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Notes']
}
