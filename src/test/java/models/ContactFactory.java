package models;

import com.github.javafaker.Faker;

public class ContactFactory {
    static Faker faker = new Faker();

    public static Contact get(){
        return Contact.builder()
                .lastName(faker.name().lastName())
                .salutation("Mr.")
                .firstName(faker.name().firstName())
                .middleName(faker.name().lastName())
                .suffix(faker.name().suffix())
                .accountName("TestAccountCheck")
                .title(faker.artist().name())
                .email("pasha123@mailinator.com")
                .phone(faker.phoneNumber().phoneNumber())
                .mobile(faker.phoneNumber().phoneNumber())
                .reportsTo("Test")
                .department(faker.hobbit().thorinsCompany())
                .fax(faker.backToTheFuture().date())
                .mailingStreet(faker.address().streetAddress())
                .mailingCity(faker.address().city())
                .mailingZipPostalCode(faker.address().zipCode())
                .mailingStateProvince(faker.address().state())
                .mailingCountry(faker.address().country())
                .build();

    }
}
