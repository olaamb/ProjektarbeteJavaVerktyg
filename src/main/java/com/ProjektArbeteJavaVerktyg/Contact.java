package com.ProjektArbeteJavaVerktyg;

import java.io.Serializable;

public class Contact implements Serializable {

    private final String FullName;
    private final String Email;
    private final String PhoneNumber;
    private final String Address;


    public Contact(String Fullname, String Email, String PhoneNumber, String Address) {

        this.FullName = Fullname;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;

    }

    public String getFullName(){return FullName;}

    public String getEmail(){return Email;}

    public String getPhoneNumber(){return PhoneNumber;}

    public String getAddress(){return Address;}


}