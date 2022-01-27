package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage {
    public static final By MENU_LINK = By.xpath("//span[@class='slds-truncate'][text()='Home']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Home")
    public void open() {
        driver.get(BASE_URL + "/lightning/page/home");
    }

    @Override
    @Step("Проверка на то что мы на ходимся на странице Home")
    public boolean isPageOpen() {
        return isExist(MENU_LINK);
    }
}
