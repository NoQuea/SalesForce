package tests;


import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest {

    @Test(description = "The lead must be created and checked for compliance with the entered data")
    public void contactShouldBeCreated() throws InterruptedException {
        loginPage.open();
        loginPage.login(email, password);

        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop up wasn't opened");


        Contact contact = ContactFactory.get();

        boolean isDetailsPageOpen = contactModalPage
                .create(contact)
                .clickDetails()
                .isPageOpen();

        assertTrue(isDetailsPageOpen, "Details page wasn't opened");


        assertEquals(contactDetailsPage.getFieldByName("Name"),
                String.format(contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName() + " " + contact.getSuffix()),
                "Name is not correct");
        assertEquals(contactDetailsPage.getFieldByAccAndRep("Account Name"), contact.getAccountName(), "");
        assertEquals(contactDetailsPage.getFieldByName("Title"), contact.getTitle(), "");
        assertEquals(contactDetailsPage.getFieldByName("Email"), contact.getEmail(), "");
        assertEquals(contactDetailsPage.getFieldByName("Phone"), contact.getPhone(), "");
        assertEquals(contactDetailsPage.getFieldByName("Mobile"), contact.getMobile(), "");
        assertEquals(contactDetailsPage.getFieldByAccAndRep("Reports To"), contact.getReportsTo(), "");
        assertEquals(contactDetailsPage.getFieldByName("Department"), contact.getDepartment(), "");
        assertEquals(contactDetailsPage.getFieldByName("Fax"), contact.getFax(), "");
        assertEquals(contactDetailsPage.getFieldByName("Mailing Address"),
                String.format(contact.getMailingStreet() + "\n" + contact.getMailingCity() + ", " + contact.getMailingStateProvince() + " " + contact.getMailingZipPostalCode() + "\n" + contact.getMailingCountry()),
                "Адресс неверный");
    }
}