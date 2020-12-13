package com.contactbook.iths;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class ContactBookTest {

    Contact contact1 = new Contact("Algot Algotsson", "algot@email.com", "0707-111111", "Gatan 1");
    Contact contact2 = new Contact("Bjarne Bjarnesson", "bjarne@email.com", "0707-222222", "Gatan 2");
    Contact contact3 = new Contact("Carl Carlsson", "carl@email.com", "0707-333333", "Gatan 3");

    ArrayList<Contact> ContactBook = new ArrayList<>();

    @BeforeAll
    static void startAllTests(){
        System.out.println("Starting ContactBookTest!");
    }
    @BeforeEach
    void startOfTest(){
        System.out.println("Starting a test!");
    }
    @AfterEach
    void endOfTest(){
        System.out.println("Ending a test.");
    }
    @AfterAll
    static void endAllTests(){
        System.out.println("Ending ContactBookTest! All tests concluded.");
    }

    //Lägger till 3st kontakter. AssertEquals kollar om det finns 3st i arraylistan.
    @Test
    public void testShowContactBook() {
        ContactBook.add(contact1);
        ContactBook.add(contact2);
        ContactBook.add(contact3);
        int noOfContacts = ContactBook.size();

        assertEquals(3, noOfContacts);
    }

    //Kollar om getFullName (som man söker med) stämmer med namnet på ett objekt (contact)
    @Test
    public void testFindContactBook() {
        ContactBook.add(contact1);
        Assert.assertTrue(contact1.getFullName().equals("Algot Algotsson"));
    }

    //Kollar om man kan få en position av object i arraylistan.
    @Test
    public void testQueryContact() {
        ContactBook.add(contact1);
        ContactBook.add(contact2);
        ContactBook.add(contact3);

        ContactBook.get(2);

        assertEquals(contact3, ContactBook.get(2));
    }

    @Test
    public void testQueryContactSearch() {
        ContactBook.add(contact1);
        String nameTest = "Algot Algotsson";
        Assert.assertTrue(contact1.getFullName().equals(nameTest));
    }

    // Looper igenom arraylistan och kollar varje FullName om den stämmer överens med stringen.
    // Utskriften som görs i metoden är borttagen i testet
    private void searchContact() {
        String testcontactName = "Algot Algotsson";
        ContactBook.add(contact3);
        ContactBook.add(contact2);
        ContactBook.add(contact1);

        for(int i = 0;  i < ContactBook.size(); i++) {
            if (contact1.getFullName().equals(testcontactName)) {
                Assert.assertTrue(contact1.getFullName().equals("Algot Algotsson"));
            }
        }
    }

    //Skapar en ny kontakt och testar om denna kontakten är riktig kontakt, med rätt variabler samt finns i arraylistan.
    @Test
    public void testAddContactBook() {
        ContactBook.add(contact1);
        boolean isValidContact = ContactBook.contains((contact1));
        Assert.assertTrue(isValidContact);
    }

    //Lägger till en kontakt. If-sats kollar om den finns och tar bort den sedan. Kontakten ska efter if-satsen inte finnas kvar.
    @Test
    public void testRemoveContactBook() {
        ContactBook.add(contact1);

        if (ContactBook.contains(contact1)) {
            ContactBook.remove(contact1);
        }
        Assert.assertFalse(ContactBook.contains(contact1));
    }
}

