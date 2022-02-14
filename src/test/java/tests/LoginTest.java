package tests;


import org.testng.annotations.Test;

import java.rmi.server.UnicastRemoteObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    public void UnicastRemoteObject(){

    }
    @Test
    public void validEmailAndPass() {
        loginPage.open();
        loginPage.isPageOpen();
        loginPage.login(email, password);

        assertTrue(homePage.isPageOpen(), "Page HomePage wasn't opened");
    }
//
//    @Test
//    public void validEmailAndNoPassword() {
//        loginPage.open();
//        loginPage.isPageOpen();
//        loginPage.login(email, "");
//
//        assertEquals();
//    }
//
//    @Test
//    public void noEmailAndValidPassword() {
//        loginPage.open();
//        loginPage.isPageOpen();
//        loginPage.login("", password);
//
//        assertEquals();
//    }
//
//    @Test
//    public void noEmailAndNoPassword() {
//        loginPage.open();
//        loginPage.isPageOpen();
//        loginPage.login("", password);
//
//        assertEquals();
//    }
}
