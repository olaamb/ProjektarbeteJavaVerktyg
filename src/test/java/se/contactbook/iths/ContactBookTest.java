package se.contactbook.iths;

import java.util.ArrayList;
import static java.util.Arrays.asList;

public class ContactBookTest {

    Contact contact1 = new Contact("Algot Algotsson", "0707-111111", "bjarne@email.com", "Gatan 1");
    Contact contact2 = new Contact("Bjarne Bjarnesson", "0707-222222", "algot@email.com", "Gatan 2");
    Contact contact3 = new Contact("Carl Carlsson", "0707-333333", "carl@email.com", "Gatan 3");

    ArrayList<Contact> ContactBook = new ArrayList<>();
    
@Test
    void testShowContactBook() {
        ContactBook.add(contact1);
        ContactBook.add(contact2);
        ContactBook.add(contact3);

    System.out.println("Contacts in list: ");
    int noOfContacts = ContactBook.size();
    for (int i = 0; i < noOfContacts; i++) {
        System.out.println((i+1) + "." +
            ContactBook.get(i).getFullName() + " | " +
            ContactBook.get(i).getPhoneNumber() + " | " +
            ContactBook.get(i).getEmail() + " | " +
            ContactBook.get(i).getAddress());


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
