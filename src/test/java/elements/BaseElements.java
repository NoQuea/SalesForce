package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
@Log4j2
public class BaseElements {
    WebDriver driver;
    String label;
    WebDriverWait wait;
}
