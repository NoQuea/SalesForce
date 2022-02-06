package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test
    public void login() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login(email, password);

        assertTrue(homePage.isPageOpen(), "Page HomePage wasn't opened");

    }

}
