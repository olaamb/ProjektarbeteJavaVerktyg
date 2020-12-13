package com.contactbook.iths;

import java.util.ArrayList;
import com.main.iths.Main;
import com.fileio.iths.FileIO;
public class ContactBook {
    public String myContactBook;
    public static ArrayList<Contact> ContactBook = new ArrayList<>();

public static ContactBook contactBook = new ContactBook();

 /*   public static ContactBook() {
        this.ContactBook = new ArrayList<Contact>();
    } */

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
    public Contact queryContact(String name) {
        int position = findContactBook(name);
        if(position >= 0) {
            return ContactBook.get(position);
        }
        return null;
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
                System.out.println("Contact Found!\nFull Name: " + contact.getFullName() + " - Email: " +
                        contact.getEmail() + " - Phone-Number: " + contact.getPhoneNumber()
                        + " - Address: " + contact.getAddress());
                return;
            }
        }
        System.out.println("Could not find the contact");

//kollar om en contact finns i arraylistan. Loopar igenom listan o kollar om den hittar match
// och returnerar indexpositionen.
//Skapar ett objekt och kollar om ett likadant object finns.
//return -1 returneras om den inte finns (lägre än 0)
    private int findContactBook(String contactName) {
        for (int i = 0; i < this.ContactBook.size(); i++) {
            Contact contact = this.ContactBook.get(i);
            if (contact.getFullName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(Contact contact) {
        return ContactBook.indexOf(contact);
    }

    //Lägger till ny contact, .contains kollar om objectet redan finns i listan.
    public boolean addContactBook(Contact contactInfo) {
        if (ContactBook.contains(contactInfo)) {
            System.out.println("The contact is already on the list.");
            return false;
        }
        ContactBook.add(contactInfo);
        return true;
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
}
