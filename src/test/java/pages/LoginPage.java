package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.baseUrl;

@Log4j2
public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");
    public static final By ERROR_MESSAGE = By.xpath("//div[@id='error']");
    public static final By FORGOT_YOUR_PASSWORD_LINK = By.xpath("//a[@id='forgot_password_link']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the Login page")
    public boolean isPageOpen() {
        log.info("Checking that we are on the Login page");
        return isExist(LOGIN_BUTTON);
    }

    @Step("Opening the Login page")
    public void open() {
        log.info("Opening the Login page");
        driver.get(baseUrl);
    }

    @Step("Login Data input")
    public void login(String userName, String password) {
        log.info("Login Data input");
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Getting an error message")
    public String getErrorMessage(){
        log.info("Getting an error message");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Click on the 'Forgot Your Password?' link")
    public void clickForgotYourPasswordLink(){
        log.info("Click on the 'Forgot Your Password?' link");
        driver.findElement(FORGOT_YOUR_PASSWORD_LINK).click();
    }
}
