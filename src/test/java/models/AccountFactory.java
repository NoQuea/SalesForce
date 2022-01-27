package models;

import com.github.javafaker.Faker;


public class AccountFactory {

    static Faker faker = new Faker();

    public static Account get(){
        return Account.builder()
                .accountName(faker.pokemon().name())
                .parentAccount("Test")
                .phone(faker.phoneNumber().phoneNumber())
                .webSite(faker.app().author())
                .type("Investor")
                .employees(faker.numerify("2,341"))
                .industry("Chemicals")
                .description(faker.letterify("read"))
                .billingStreet(faker.address().streetAddress())
                .shippingStreet(faker.address().streetAddress())
                .billingCity(faker.address().city())
                .shippingCity(faker.address().city())
                .shippingState(faker.address().state())
                .billingZip(faker.address().zipCode())
                .billingCountry(faker.address().country())
                .shippingZip(faker.address().zipCode())
                .shippingCountry(faker.address().country())
                .billingState(faker.address().state())
                .build();
    }

}
