package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class ForgotYourPasswordPage extends BasePage{

    public static final By HEADER = By.xpath("//h1[@id='header']");

    public ForgotYourPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Checking that we are on the 'Forgot Your Password?' page")
    public boolean isPageOpen() {
        return isExist(HEADER);
    }


}
