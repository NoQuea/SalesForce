package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilesModelPage extends BasePage{
    public static final By MODAL_TITLE = By.xpath("//span[@class='slds-p-right--x-small uiOutputText']");
    public FilesModelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

}
