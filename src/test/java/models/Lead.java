package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Lead {

    String leadStatus;
    String salutation;
    String firstName;
    String middleName;
    String lastName;
    String suffix;
    String webSite;
    String title;
    String email;
    String phone;
    String mobile;
    String rating;
    String company;
    String industry;
    String noOfEmployees;
    String leadSource;
    String street;
    String city;
    String stateProvince;
    String zipPostalCode;
    String country;
}
