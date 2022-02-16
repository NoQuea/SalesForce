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
    @Step("Проверка на то что мы на ходимся на странице Login")
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }

    @Step("Открытие страницы Login")
    public void open() {
        driver.get(baseUrl);
    }

    public void login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void clickForgotYourPasswordLink(){
        driver.findElement(FORGOT_YOUR_PASSWORD_LINK).click();
    }
}
