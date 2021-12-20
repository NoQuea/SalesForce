package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest{

    @Test
    public void contactShouldBeCreated(){
        loginPage.open();
        loginPage.login("pasha_vorobyov-una5@force.com", "1234qqqwwww");

        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        Assert.assertTrue(isContactModalOpen, "Pop up wasn't opened");
    }
}
