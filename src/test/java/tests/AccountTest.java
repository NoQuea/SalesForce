package tests;

import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest{
    @Test
    public void accountShouldBeCreated(){


        loginPage.open();
        loginPage.login("pasha_vorobyov-una5@force.com", "1234qqqwwww");


        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();
        Assert.assertTrue(isAccountModalOpen, "Pop up wasn't opened");

        Account account = new Account(
                "TestAccountName",
                "TestAccountName",
                "+375259346523",
                "1321",
                "www.onliner.by",
                "Investor",
                "123,123",
                "Banking",
                "$123,342",
                "please mind the closing doors",
                "green",
                "fork",
                "board",
                "Need",
                "For",
                "Speed",
                "Must",
                "wanted",
                "remastered",
                "yet"
        );

        boolean isDetailsPageOpen = accountModalPage
                .create(account)
                .isPageOpen();
        Assert.assertTrue(isDetailsPageOpen, "Details page wasn't opened");

        Assert.assertEquals(accountDetailsPage.getFieldByName("Account Name"),account.getAccountName(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByWebsite("Website"),account.getWebSite(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Type"),account.getType(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByPhoneFax("Phone"),account.getPhone(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByPhoneFax("Fax"),account.getFax(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByParent("Parent Account"),account.getParentAccount(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByEmployees("Employees"),account.getEmployees(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Industry"),account.getIndustry(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Annual Revenue"),account.getAnnualRevenue(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Billing Street"),account.getBillingStreet(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Shipping Street"),account.getShippingStreet(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Billing City"),account.getBillingCity(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Billing State/Province"),account.getBillingState(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Shipping City"),account.getShippingCity(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Shipping State/Province"),account.getShippingState(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Billing Zip/Postal Code"),account.getBillingZip(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Billing Country"),account.getBillingCountry(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Shipping Zip/Postal Code"),account.getShippingZip(),"");
        Assert.assertEquals(accountDetailsPage.getFieldByName("Shipping Country"),account.getShippingCountry(),"");


    }
}
