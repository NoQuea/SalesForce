package pages;

import io.qameta.allure.Step;
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
    @Step("Checking that we are on the View Profile page")
    public boolean isPageOpen() {
        log.info("Checking that we are on the View Profile page");
        return isExist(LOG_OUT_LINK);
    }
    @Step("Click on the 'Settings' link")
    public void clickSettings(){
        log.info("Click on the 'Settings' link");
        driver.findElement(SETTINGS_LINK).click();
    }

    @Step("Click on the 'Log Out' link")
    public void clickLogOutLink(){
        log.info("Click on the 'Log Out' link");
        driver.findElement(LOG_OUT_LINK).click();
    }

    @Step("Click on the 'Comfy' button")
    public void clickComfyButton(){
        log.info("Click on the 'Comfy' button");
        driver.findElement(COMFY_BUTTON).click();
    }

    @Step("Click on the 'Compact' button")
    public void clickCompactButton(){
        log.info("Click on the 'Compact' button");
        driver.findElement(COMPACT_BUTTON).click();
    }
}
