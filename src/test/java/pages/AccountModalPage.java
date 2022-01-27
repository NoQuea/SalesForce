package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountModalPage extends BasePage{

    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'inlineTitle')]");

    public AccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Проверка на то что мы на ходимся в окне заполнения Account")
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    @Step("Создание аккаунта")
    public AccountDetailsPage create(Account account) {

        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebSite());
        new DropDown(driver, "Type").selectOption(account.getType());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Parent Account").selectOptionForParent(account.getParentAccount());
        new Input(driver, "Employees").write(account.getEmployees());
        new DropDown(driver, "Industry").selectOption(account.getIndustry());
        new TextArea(driver, "Description").writeArea(account.getDescription());
        new TextArea(driver, "Billing Street").writeArea(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").writeArea(account.getShippingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZip());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());

        return clickSave();
    }
    @Step("Нажатие на кнопку Save")
    public AccountDetailsPage clickSave(){
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}
