package tests;

import models.Opportunities;
import models.OpportunitiesFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OpportunitiesTest extends BaseTest{

    @Test(description = "The opportunities must be created and checked for compliance with the entered data")
    public void opportunitiesShouldBeCreated()  {
        loginPage.open();
        loginPage.login(email, password);

        boolean isOpportunitiesModalPage = opportunitiesListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isOpportunitiesModalPage, "Pop up wasn't opened");


        Opportunities opportunities = OpportunitiesFactory.get();

        boolean isOpportunitiesPageOpen = opportunitiesModalPage
                .create(opportunities)
                .clickDetails()
                .isPageOpen();

        assertTrue(isOpportunitiesPageOpen, "Details page wasn't opened");

        assertEquals(opportunitiesDetailsPage.getFieldByName("Opportunity Name"), opportunities.getOpportunityName(), "Opportunity Name is not correct");
        assertEquals(opportunitiesDetailsPage.getFieldAccountName("Account Name"), opportunities.getAccountName(), "Account Name is not correct");
        assertEquals(opportunitiesDetailsPage.getFieldByName("Close Date"), opportunitiesDetailsPage.getDay(), "Close Date is not correct");
        assertEquals(opportunitiesDetailsPage.getFieldByName("Stage"), opportunities.getStage(), "Stage is not correct");

    }
}
