package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Contact {
    String salutation;
    String firstName;
    String middleName;
    String lastName;
    String suffix;
    String accountName;
    String title;
    String email;
    String phone;
    String mobile;
    String reportsTo;
    String department;
    String fax;
    String mailingStreet;
    String mailingCity;
    String mailingStateProvince;
    String mailingZipPostalCode;
    String mailingCountry;
}
