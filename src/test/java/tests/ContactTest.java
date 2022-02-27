package tests;


import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest {

    @Test(description = "The contact must be created and checked for compliance with the entered data")
    public void contactShouldBeCreated()  {
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
        assertEquals(contactDetailsPage.getFieldByAccAndRep("Account Name"), contact.getAccountName(), "Account Name is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Title"), contact.getTitle(), "Title is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Email"), contact.getEmail(), "Email is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Phone"), contact.getPhone(), "Phone is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Mobile"), contact.getMobile(), "Mobile is not correct");
        assertEquals(contactDetailsPage.getFieldByAccAndRep("Reports To"), contact.getReportsTo(), "Reports To is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Department"), contact.getDepartment(), "Department is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Fax"), contact.getFax(), "Fax is not correct");
        assertEquals(contactDetailsPage.getFieldByName("Mailing Address"),
                String.format(contact.getMailingStreet() + "\n" + contact.getMailingCity() + ", " + contact.getMailingStateProvince() + " " + contact.getMailingZipPostalCode() + "\n" + contact.getMailingCountry()),
                "Mailing Address is not correct");
    }

    @Test(description = "Press the save button without entering data in the Contact fields")
    public void pressTheSaveButtonWithoutEnteringDataInTheContactFields() {

        loginPage.open();
        loginPage.login(email, password);


        boolean isContactModalOpen = contactListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isContactModalOpen, "Pop up wasn't opened");

        contactModalPage.clickSaveForError();
        assertTrue(contactModalPage.getErrorMassage(), "Massage is not correct");


    }
}