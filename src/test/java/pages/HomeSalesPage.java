package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.baseUrl;

public class HomeSalesPage extends BasePage {

    public static final By TITLE_SALES = By.xpath("//span[@title='Sales']");

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


}
