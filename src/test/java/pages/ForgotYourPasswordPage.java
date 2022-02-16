package pages;


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
    public boolean isPageOpen() {
        return isExist(HEADER);
    }


}
