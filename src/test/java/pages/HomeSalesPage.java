package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Configuration.baseUrl;

public class HomeSalesPage extends BasePage {

    public static final By TITLE_SALES = By.xpath("//span[@title='Quarterly Performance']");
    public static final By VIEW_PROFILE = By.xpath("//div[@class='profileTrigger branding-user-profile bgimg slds-avatar slds-avatar_profile-image-small circular forceEntityIcon']//span[@class='uiImage']");
    public static final By NOTIFICATIONS = By.xpath("//span[@role='tooltip'][text()='Notifications']//ancestor::li");
    public static final By SETUP = By.xpath("//span[@role='tooltip'][text()='Setup']//ancestor::li");
    public static final By SALESFORCE_HELP = By.xpath("//span[@role='tooltip'][text()='Salesforce Help']//ancestor::li");
    public static final By GLOBAL_ACTIONS = By.xpath("//span[@role='tooltip'][text()='Global Actions']//ancestor::li");
    public static final By LEARNING_PATHS = By.xpath("//span[@role='tooltip'][text()='Learning Paths']//ancestor::li");

    public HomeSalesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Home")
    public void open() {
        driver.get(baseUrl + "/lightning/page/home");
    }

    @Override
    @Step("Проверка на то что мы на ходимся на странице Home")
    public boolean isPageOpen() {
        return isExist(TITLE_SALES);
    }

    public void clickViewProfile(){
        driver.findElement(VIEW_PROFILE).click();
    }
    public void clickNotifications(){
        driver.findElement(NOTIFICATIONS).click();
    }
    public void clickSetup(){
        driver.findElement(SETUP).click();
    }
    public void clickSalesforceHelp(){
        driver.findElement(SALESFORCE_HELP).click();
    }
    public void clickLearningPaths(){
        driver.findElement(LEARNING_PATHS).click();
    }
    public void clickGlobalActions(){
        driver.findElement(GLOBAL_ACTIONS).click();
    }

}
