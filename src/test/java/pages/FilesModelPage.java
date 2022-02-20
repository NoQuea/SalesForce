package pages;

import org.openqa.selenium.WebDriver;

public class FilesModelPage extends BasePage{
    public FilesModelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
    //a//span[normalize-space()='Files']
}
