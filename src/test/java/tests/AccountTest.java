package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners
public class AccountTest extends BaseTest {

    @Test(description = "The account must be created and checked for compliance with the entered data")
    public void accountShouldBeCreated() throws InterruptedException {

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

        assertEquals(accountDetailsPage.getFieldByName("Account Name"),account.getAccountName(),"");
        assertEquals(accountDetailsPage.getFieldByName("Website"),account.getWebSite(),"");
        assertEquals(accountDetailsPage.getFieldByName("Type"),account.getType(),"");
        assertEquals(accountDetailsPage.getFieldByName("Phone"),account.getPhone(),"");
        assertEquals(accountDetailsPage.getFieldByParent("Parent Account"),account.getParentAccount(),"");
        assertEquals(accountDetailsPage.getFieldByName("Employees"),account.getEmployees(),"");
        assertEquals(accountDetailsPage.getFieldByName("Industry"),account.getIndustry(),"");
        assertEquals(accountDetailsPage.getFieldByName("Billing Address"),
                String.format(account.getBillingStreet() + "\n" + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingZip() + "\n" + account.getBillingCountry()),
                "Адресс неверный");
        assertEquals(accountDetailsPage.getFieldByName("Shipping Address"),
                String.format(account.getShippingStreet() + "\n" + account.getShippingCity() + ", " + account.getShippingState() + " " + account.getShippingZip() + "\n" + account.getShippingCountry()),
                "Адресс неверный");

    }
}
