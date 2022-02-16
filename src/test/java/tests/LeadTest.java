package tests;

import models.Lead;
import models.LeadFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LeadTest extends BaseTest {

    @Test(description = "The lead must be created and checked for compliance with the entered data")
    public void leadShouldBeCreated() {

        loginPage.open();
        loginPage.login(email, password);


        boolean isLeadModalOpen = leadListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isLeadModalOpen, "Pop up wasn't opened");

        Lead lead = LeadFactory.get();

        boolean isDetailsPageOpen = leadModalPage
                .create(lead)
                .clickDetails()
                .isPageOpen();

        assertTrue(isDetailsPageOpen, "Details page wasn't opened");

        assertEquals(leadDetailsPage.getFieldByName("Lead Status"), lead.getLeadStatus(), "");
        assertEquals(leadDetailsPage.getFieldByName("Name"),
                String.format(lead.getSalutation() + " " + lead.getFirstName() + " " + lead.getMiddleName() + " " + lead.getLastName() + " " + lead.getSuffix()),
                "Name is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Title"), lead.getTitle(), "");
        assertEquals(leadDetailsPage.getFieldByName("Email"), lead.getEmail(), "");
        assertEquals(leadDetailsPage.getFieldByName("Phone"), lead.getPhone(), "");
        assertEquals(leadDetailsPage.getFieldByName("Mobile"), lead.getMobile(), "");
        assertEquals(leadDetailsPage.getFieldByName("Rating"), lead.getRating(), "");
        assertEquals(leadDetailsPage.getFieldByName("Website"), lead.getWebSite(), "");
        assertEquals(leadDetailsPage.getFieldByName("Company"), lead.getCompany(), "");
        assertEquals(leadDetailsPage.getFieldByName("Industry"), lead.getIndustry(), "");
        assertEquals(leadDetailsPage.getFieldByName("No. of Employees"), lead.getNoOfEmployees(), "");
        assertEquals(leadDetailsPage.getFieldByName("Lead Source"), lead.getLeadSource(), "");
        assertEquals(leadDetailsPage.getFieldByName("Address"),
                String.format(lead.getStreet() + "\n" + lead.getCity() + ", " + lead.getStateProvince() + " " + lead.getZipPostalCode() + "\n" + lead.getCountry()),
                "Адресс неверный");

    }
}
