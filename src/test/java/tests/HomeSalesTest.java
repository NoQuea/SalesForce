package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeSalesTest extends BaseTest {

    @Test
    public void viewProfileShouldBeOpened(){
            loginPage.open();
            loginPage.login(email, password);
            loginPage.isPageOpen();
            homeSalesPage.clickViewProfile();

            assertTrue(viewProfilePage.isPageOpen(), "View Profile Page doesn't open");
        }

    @Test
    public void enterUserSettings(){
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.clickViewProfile();
        viewProfilePage.clickSettings();

        assertTrue(settingsPage.isPageOpen(), "Settings Page doesn't open");
    }

    @Test
    public void logOut(){
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.clickViewProfile();
        viewProfilePage.clickLogOutLink();

        assertTrue(loginPage.isPageOpen(), "Login Page doesn't open");
    }

    @Test
    public void changeDensityDisplay(){
        loginPage.open();
        loginPage.login(email, password);
        homeSalesPage.clickViewProfile();
        viewProfilePage.clickComfyButton();

//        assertTrue(, "Login Page doesn't open");
    }

}
