package com.ProjektArbeteJavaVerktyg;
import java.io.Serializable;
import java.util.ArrayList;

public class ContactBook {

    private String myContactBook;
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
                    ContactBook.get(i).getEmail() +  " Phone Number: " + ContactBook.get(i).getPhoneNumber()
                    + " Address: " + ContactBook.get(i).getAddress());
        }
    }

    //  kollar om en contact finns i arraylistan. Loopar igenom listan o kollar om den hittar match
    //  och returnerar indexpositionen.
    //  Skapar ett objekt och kollar om ett likadant object finns.
    //  return -1 returneras om den inte finns (lägre än 0)

    public Serializable findContactBook(String searchContact) {
        for (int i = 0; i < ContactBook.size(); i++) {
            Contact contact = ContactBook.get(i);
            if (contact.getFullName().equals(searchContact)) {
                return ContactBook;
            }
        }
        return -1;
    }
    //  Lägger till ny contact, .contains kollar om objectet redan finns i listan.

    public boolean addContactBook(Contact contact) {
        boolean findContact = ContactBook.contains(contact);
        if (findContact) {
            System.out.println("The contact is already on the list.");
            return false;
        }
        ContactBook.add(contact);
        return true;
    }
    //  Tar bort Contact. .contains kollar om den finns, .remove tar bort den.

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

    private int findMovie(Contact contact) {
        return ContactBook.indexOf(contact);
    }
}
