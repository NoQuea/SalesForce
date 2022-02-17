package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;


public class LeadFactory {
    static Faker faker = new Faker();

    public static Lead get(){
        return Lead.builder()
                .leadStatus("Working")
                .salutation("Mr.")
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .middleName(faker.name().lastName())
                .suffix(faker.name().suffix())
                .webSite(faker.random().hex())
                .title(faker.artist().name())
                .email("pasha123@mailinator.com")
                .phone(faker.phoneNumber().phoneNumber())
                .mobile(faker.phoneNumber().phoneNumber())
                .rating("Warm")
                .company(faker.company().name())
                .industry("Banking")
                .noOfEmployees(faker.number().digit())
                .leadSource("Advertisement")
                .street(faker.address().streetAddress())
                .city(faker.address().city())
                .stateProvince(faker.address().state())
                .zipPostalCode(faker.address().zipCode())
                .country(faker.address().country())
                .build();
    }
}
