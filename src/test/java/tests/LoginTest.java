package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test
    public void validEmailAndPass() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login(email, password);

        assertTrue(homeSalesPage.isPageOpen(), "Page HomePage wasn't opened");
    }

    @Test
    public void validEmailAndNoPassword() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login(email, "");

        assertEquals(loginPage.getErrorMessage(), "Please enter your password.", "");
    }

    @Test
    public void incorrectData() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login("awdsawd", "pas1123sword");

        assertEquals(loginPage.getErrorMessage(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.", "");
    }

    @Test
    public void clickForgotYourPassword() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.clickForgotYourPasswordLink();

        assertTrue(forgotYourPasswordPage.isPageOpen(), "Page Forgot Your Password wasn't opened");
    }
}
