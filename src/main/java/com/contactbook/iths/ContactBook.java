package com.contactbook.iths;

import java.util.ArrayList;
import com.fileio.iths.FileIO;
import com.contactbook.iths.Contact;
import com.main.iths.Main;
import com.fileio.iths.FileIO;
public class ContactBook {
    public static ArrayList<Contact> ContactBook = new ArrayList<>();
    public ContactBook() {
        ContactBook = new ArrayList<Contact>();
    }

    //Loopar igenom arrayen. getContact skriver ut titlarna som finns i.
    public void showContactBook() {
        System.out.println("Contacts in list: ");
        int noOfContacts = ContactBook.size();
        for (int i = 0; i < noOfContacts; i++) {
            System.out.println((i+1) + " Full Name: " + ContactBook.get(i).getFullName() + " Email: " +
                    ContactBook.get(i).getEmail() +  " Phone-Number: " + ContactBook.get(i).getPhoneNumber()
                    + " Address: " + ContactBook.get(i).getAddress());
        }
    }
    //Lägger till ny contact, .contains kollar om objectet redan finns i listan.
    public boolean addContactBook(Contact contact) {
        boolean findContact = ContactBook.contains(contact);
        if (!findContact) {
            ContactBook.add(contact);
            return true;
        }
        return false;
    }
    //Tar bort Contact. .contains kollar om den finns, .remove tar bort den.
    public boolean removeContactBook(Contact removeContact) {
        if (ContactBook.contains(removeContact)) {
            ContactBook.remove(removeContact);
            return true;
        } else {
            return false;
        }
    }
    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return ContactBook.get(position);
        }
        return null;
    }
    private int findContact(String contactName) {
        for(int i = 0;  i < ContactBook.size(); i++) {
            Contact contact = ContactBook.get(i);
            if(contact.getFullName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    // metoden kallas i main klassen, och den kallar sen på searchContact nedanför.
    public void queryContactSearch(String name) {
        searchContact(name);
    }
    // metoden looper igenom arraylistan och kollar varje FullName om den stämmer överens med stringen.
    // Skriver ut all information om namnet stämmer
    public void searchContact(String contactName) {
        for(int i = 0;  i < ContactBook.size(); i++) {
            Contact contact = ContactBook.get(i);
            if (contact.getFullName().equals(contactName)) {
                System.out.println("Contact Found!\nFull Name: " + contact.getFullName() + " Email: " +
                        contact.getEmail() + " Phone-Number: " + contact.getPhoneNumber()
                        + " Address: " + contact.getAddress());
                return;
            }
        }
        System.out.println("Could not find the contact");
    }
}