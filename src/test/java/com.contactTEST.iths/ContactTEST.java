package com.ProjektArbeteJavaVerktyg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactTEST {

    @BeforeEach
    public void initEach() {
        System.out.println("Checking before every Test");
    }


    @Test
    @DisplayName("Testing the getFullName method")
    public void getFullName() {
        System.out.println("Test for getFullName");
        String FullName = "Murre king";
        assertEquals("Murre king",FullName);
    }
    @Test
    @DisplayName("Testing the getEmail method")
    public void getEmail() {
        System.out.println("Test for getEmail");
        String Email = "Murre@live.se";
        assertEquals("Murre@live.se",Email);
    }

    @Test
    @DisplayName("Testing the getPhoneNumber method")
    public void getPhoneNumber() {
        System.out.println("Test for getPhoneNumber");
        String PhoneNumber = "073123456";
        assertEquals("073123456",PhoneNumber);
    }
    @Test
    @DisplayName("Testing the getAddress method")
    public void getAddress() {
        System.out.println("Test for getAddress");
        String Address = "Boråsvägen";
        assertEquals("Boråsvägen",Address);
    }


}
