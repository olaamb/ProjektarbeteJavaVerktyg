package com.contact.iths;

import java.io.Serializable;

public class Contact
        implements Serializable
{

    private String FullName;
    private String Email;
    private String PhoneNumber;
    private String Address;


    public Contact(String FullName, String Email, String PhoneNumber, String Address) {

        this.FullName;
        this.Email;
        this.PhoneNumber;
        this.Address;
    }
    public String getFullName(){return FullName;}

    public String getEmail(){return Email;}

    public String getPhoneNumber(){return PhoneNumber;}

    public String getAddress(){return Address;}


}
