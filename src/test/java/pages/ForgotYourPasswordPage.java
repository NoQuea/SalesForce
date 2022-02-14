package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotYourPasswordPage extends BasePage{

    public static final By HEADER = By.xpath("//h1[@id='header']");

    public ForgotYourPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(HEADER);
    }


}
