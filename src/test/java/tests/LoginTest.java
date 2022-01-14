package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login("pavel123-211q@force.com", "1234qqqwwww");

        assertTrue(homePage.isPageOpen(), "Page HomePage wasn't opened");

    }

}
