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

        assertEquals(leadDetailsPage.getFieldByName("Lead Status"), lead.getLeadStatus(), "Lead Status is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Name"),
                String.format(lead.getSalutation() + " " + lead.getFirstName() + " " + lead.getMiddleName() + " " + lead.getLastName() + " " + lead.getSuffix()),
                "Name is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Title"), lead.getTitle(), "Title is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Email"), lead.getEmail(), "Email is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Phone"), lead.getPhone(), "Phone is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Mobile"), lead.getMobile(), "Mobile is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Rating"), lead.getRating(), "Rating is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Website"), lead.getWebSite(), "Website is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Company"), lead.getCompany(), "Company is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Industry"), lead.getIndustry(), "Industry is not correct");
        assertEquals(leadDetailsPage.getFieldByName("No. of Employees"), lead.getNoOfEmployees(), "No. of Employees is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Lead Source"), lead.getLeadSource(), "Lead Source is not correct");
        assertEquals(leadDetailsPage.getFieldByName("Address"),
                String.format(lead.getStreet() + "\n" + lead.getCity() + ", " + lead.getStateProvince() + " " + lead.getZipPostalCode() + "\n" + lead.getCountry()),
                "Address is not correct");

    }

    @Test(description = "Press the save button without entering data in the Leads fields")
    public void pressTheSaveButtonWithoutEnteringDataInTheLeadsFields() {

        loginPage.open();
        loginPage.login(email, password);


        boolean isLeadModalOpen = leadListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isLeadModalOpen, "Pop up wasn't opened");

        leadModalPage.clickSaveForError();
        assertTrue(leadModalPage.getErrorMassage(), "Massage is not correct");


    }
}
