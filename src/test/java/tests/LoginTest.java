package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login("pasha_vorobyov-una5@force.com", "1234qqqwwww");

        Assert.assertTrue(homePage.isPageOpen(), "Page HomePage wasn't opened");

    }

}
