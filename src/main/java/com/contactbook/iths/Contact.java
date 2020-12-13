package com.contactbook.iths;

import java.io.Serializable;

public class Contact implements Serializable {

    private final String FullName;
    private final String Email;
    private final String PhoneNumber;
    private final String Address;

       //Konstruktorn
    public Contact(String FullName, String Email, String PhoneNumber, String Address) {

        this.FullName = FullName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
    }
    public String getFullName(){return FullName;}

    public String getEmail(){return Email;}

    public String getPhoneNumber(){return PhoneNumber;}

    public String getAddress(){return Address;}


}
