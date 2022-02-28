package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test(description = "Entering a valid email and password")
    public void validEmailAndPass() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login(email, password);

        assertTrue(homeSalesPage.isPageOpen(), "Page HomePage wasn't opened");
    }

    @Test(description = "Enter a valid email, do not enter a password")
    public void validEmailAndNoPassword() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login(email, "");

        assertEquals(loginPage.getErrorMessage(), "Введите пароль.", "");
    }

    @Test(description = "Entering incorrect data")
    public void incorrectData() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login("awdsawd", "pas1123sword");

        assertEquals(loginPage.getErrorMessage(), "Проверьте имя пользователя и пароль. При неудачном входе обратитесь к администратору Salesforce.", "");
    }

    @Test(description = "Click on the link 'Forgot Your Password?' and check the transition to this page")
    public void clickForgotYourPassword() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.clickForgotYourPasswordLink();

        assertTrue(forgotYourPasswordPage.isPageOpen(), "Page Forgot Your Password wasn't opened");
    }
}
