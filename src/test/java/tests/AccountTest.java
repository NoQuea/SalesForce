package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AccountTest extends BaseTest {

    @Test(description = "The account must be created and checked for compliance with the entered data")
    public void accountShouldBeCreated() {

        loginPage.open();
        loginPage.login(email, password);


        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isAccountModalOpen, "Pop up wasn't opened");

        Account account = AccountFactory.get();

        boolean isDetailsPageOpen = accountModalPage
                .create(account)
                .clickDetails()
                .isPageOpen();

        assertTrue(isDetailsPageOpen, "Details page wasn't opened");

        assertEquals(accountDetailsPage.getFieldByName("Account Name"),account.getAccountName(),"Account Name is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Website"),account.getWebSite(),"Website is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Type"),account.getType(),"Type is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Phone"),account.getPhone(),"Phone is not correct");
        assertEquals(accountDetailsPage.getFieldByParent("Parent Account"),account.getParentAccount(),"Parent Account is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Employees"),account.getEmployees(),"Employees is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Industry"),account.getIndustry(),"Industry is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Billing Address"),
                String.format(account.getBillingStreet() + "\n" + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingZip() + "\n" + account.getBillingCountry()),
                "Billing Address is not correct");
        assertEquals(accountDetailsPage.getFieldByName("Shipping Address"),
                String.format(account.getShippingStreet() + "\n" + account.getShippingCity() + ", " + account.getShippingState() + " " + account.getShippingZip() + "\n" + account.getShippingCountry()),
                "Shipping Address is not correct");

    }


}
