package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewProfilePage extends BasePage{

    public static final By LOG_OUT_LINK = By.xpath("//a[normalize-space()='Log Out']");
    public static final By SETTINGS_LINK = By.xpath("//a[normalize-space()='Settings']");
    public static final By COMFY_BUTTON = By.xpath("//button[@name='Comfy']");
    public static final By COMPACT_BUTTON = By.xpath("//button[@name='Compact']");
    public static final By SWITCH_TO_SALESFORCE_CLASSIC_LINK = By.xpath("//a[@class='profile-link-label switch-to-aloha uiOutputURL']");
    public static final By ADD_USERNAME_LINK = By.xpath("//a[@class='uiOutputURL']");


    public ViewProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOG_OUT_LINK);
    }
    public void clickSettings(){
        driver.findElement(SETTINGS_LINK).click();
    }
    public void clickLogOutLink(){
        driver.findElement(LOG_OUT_LINK).click();
    }
    public void clickComfyButton(){
        driver.findElement(COMFY_BUTTON).click();
    }
    public void clickCompactButton(){
        driver.findElement(COMPACT_BUTTON).click();
    }
    public void clickSwitchToSalesforceClassicLink(){
        driver.findElement(SWITCH_TO_SALESFORCE_CLASSIC_LINK).click();
    }
    public void clickAddUsernameLink(){
        driver.findElement(ADD_USERNAME_LINK).click();
    }
}
