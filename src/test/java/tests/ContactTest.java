package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest{

    @Test
    public void contactShouldBeCreated(){
        loginPage.open();
        loginPage.login("pasha_vorobyov-una5@force.com", "1234qqqwwww");

        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop up wasn't opened");

    }
}
