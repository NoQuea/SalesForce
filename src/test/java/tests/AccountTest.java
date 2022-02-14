package tests;

import models.Account;
import models.AccountFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners
public class AccountTest extends BaseTest {
    @Test
    public void createTestAccount(){

    }

    @Test
    public void accountShouldBeCreated(){

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
        assertEquals(accountDetailsPage.getFieldByWebsite("Website"),account.getWebSite(),"");
        assertEquals(accountDetailsPage.getFieldByName("Type"),account.getType(),"");
        assertEquals(accountDetailsPage.getFieldByPhoneFax("Phone"),account.getPhone(),"");
        assertEquals(accountDetailsPage.getFieldByParent("Parent Account"),account.getParentAccount(),"");
        assertEquals(accountDetailsPage.getFieldByEmployees("Employees"),account.getEmployees(),"");
        assertEquals(accountDetailsPage.getFieldByName("Industry"),account.getIndustry(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Billing Street"),account.getBillingStreet(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Shipping Street"),account.getShippingStreet(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Billing City"),account.getBillingCity(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Billing State/Province"),account.getBillingState(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Shipping City"),account.getShippingCity(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Shipping State/Province"),account.getShippingState(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Billing Zip/Postal Code"),account.getBillingZip(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Billing Country"),account.getBillingCountry(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Shipping Zip/Postal Code"),account.getShippingZip(),"");
//        assertEquals(accountDetailsPage.getFieldByName("Shipping Country"),account.getShippingCountry(),"");
        assertEquals(accountDetailsPage.getFieldByName("Billing Street"),
                String.format(account.getBillingStreet() + "\n" + account.getBillingCity() + ", " + account.getBillingState() + " " + account.getBillingZip() + "\n" + account.getBillingCountry()),
                "Адресс неверный");


    }
}
