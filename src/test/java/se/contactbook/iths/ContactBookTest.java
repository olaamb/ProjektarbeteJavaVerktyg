package se.contactbook.iths;

import java.util.ArrayList;


public class ContactBookTest {

    ContactTest contact1 = new ContactTest("Algot Algotsson", "0707-111111", "bjarne@email.com");
    ContactTest contact2 = new ContactTest("Bjarne Bjarnesson", "0707-222222", "algot@email.com");
    ContactTest contact3 = new ContactTest("Carl Carlsson", "0707-333333", "carl@email.com");

    ArrayList<ContactTest> ContactBook = new ArrayList<>();
    
@Test
    void testShowContactBook() {
        ContactBook.add(contact1);
        ContactBook.add(contact2);
        ContactBook.add(contact3);



    }

    void testFindContactBook() {
        ContactBook.add(contact1);
        ContactBook.add(contact2);
        ContactBook.add(contact3);

    }

    void testAddContactBook() {


    }

    void testRemoveContactBook() {


    }

}
