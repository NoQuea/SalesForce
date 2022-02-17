package models;

import com.github.javafaker.Faker;

public class OpportunitiesFactory {

    static Faker faker = new Faker();

    public static Opportunities get(){
        return Opportunities.builder()
                .opportunityName(faker.name().name())
                .accountName("TestAccountCheck")
                .closeDate("today")
                .stage("Proposal")
                .build();
    }
}
