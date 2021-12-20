package models;

public class Contact {
    String salutation;
    String firstName;
    String lastName;
    String accountName;
    String phone;
    String mobile;
    String email;
    String title;
    String reportsTo;
    String mailingStreet;
    String otherStreet;
    String mailingCity;
    String mailingStateProvince;
    String otherCity;
    String otherStateProvince;
    String mailingZipPostalCode;
    String mailingCountry;
    String otherZipPostalCode;
    String otherCountry;
    String fax;
    String homePhone;
    String otherPhone;
    String asstPhone;
    String assistant;
    String department;
    String leadSource;
    String birthdate;
    String description;

    public Contact(String salutation, String firstName, String lastName, String accountName, String phone, String mobile, String email, String title, String reportsTo, String mailingStreet, String otherStreet, String mailingCity, String mailingStateProvince, String otherCity, String otherStateProvince, String mailingZipPostalCode, String mailingCountry, String otherZipPostalCode, String otherCountry, String fax, String homePhone, String otherPhone, String asstPhone, String assistant, String department, String leadSource, String birthdate, String description) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountName = accountName;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.title = title;
        this.reportsTo = reportsTo;
        this.mailingStreet = mailingStreet;
        this.otherStreet = otherStreet;
        this.mailingCity = mailingCity;
        this.mailingStateProvince = mailingStateProvince;
        this.otherCity = otherCity;
        this.otherStateProvince = otherStateProvince;
        this.mailingZipPostalCode = mailingZipPostalCode;
        this.mailingCountry = mailingCountry;
        this.otherZipPostalCode = otherZipPostalCode;
        this.otherCountry = otherCountry;
        this.fax = fax;
        this.homePhone = homePhone;
        this.otherPhone = otherPhone;
        this.asstPhone = asstPhone;
        this.assistant = assistant;
        this.department = department;
        this.leadSource = leadSource;
        this.birthdate = birthdate;
        this.description = description;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public String getOtherStreet() {
        return otherStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public String getMailingStateProvince() {
        return mailingStateProvince;
    }

    public String getOtherCity() {
        return otherCity;
    }

    public String getOtherStateProvince() {
        return otherStateProvince;
    }

    public String getMailingZipPostalCode() {
        return mailingZipPostalCode;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public String getOtherZipPostalCode() {
        return otherZipPostalCode;
    }

    public String getOtherCountry() {
        return otherCountry;
    }

    public String getFax() {
        return fax;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public String getAsstPhone() {
        return asstPhone;
    }

    public String getAssistant() {
        return assistant;
    }

    public String getDepartment() {
        return department;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getDescription() {
        return description;
    }
}
