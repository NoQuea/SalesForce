package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ViewProfilePage extends BasePage{

    public static final By LOG_OUT_LINK = By.xpath("//a[normalize-space()='Log Out']");
    public static final By SETTINGS_LINK = By.xpath("//a[normalize-space()='Settings']");
    public static final By COMFY_BUTTON = By.xpath("//button[@name='Comfy']");
    public static final By COMPACT_BUTTON = By.xpath("//button[@name='Compact']");


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
}
