package models;

import com.github.javafaker.Faker;

public class OpportunitiesFactory {

    static Faker faker = new Faker();

    public static Opportunities get(){
        return Opportunities.builder()
                .opportunityName(faker.name().name())
                .closeDate("today")
                .stage("Proposal")
                .accountName("TestAccountCheck")
                .nextStep(faker.name().name())
                .build();
    }
}
