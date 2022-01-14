package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Account {
    String accountName;
    String parentAccount;
    String phone;
    String webSite;
    String type;
    String employees;
    String industry;
    String description;
    String billingStreet;
    String shippingStreet;
    String billingCity;
    String shippingCity;
    String shippingState;
    String billingZip;
    String billingCountry;
    String shippingZip;
    String shippingCountry;
    String billingState;
}