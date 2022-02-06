package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest{

    @Test
    public void contactShouldBeCreated(){
        loginPage.open();
        loginPage.login(email, password);

        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop up wasn't opened");

    }
}
