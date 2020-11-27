package se.contactbook.iths;

import java.util.ArrayList;

public class ContactBook {
    private String myContactBook;
    private ArrayList<Contact> ContactBook = new ArrayList<>();

    public ContactBook(String myContactBook) {
        this.myContactBook = myContactBook;
        this.ContactBook = new ArrayList<Contact>();
    }


    //Loopar igenom arrayen. getContact skriver ut titlarna som finns i.
    public void showContactBook() {
        System.out.println("Contacts in list: ");
        int noOfContacts = ContactBook.size();
        for (int i = 0; i < noOfContacts; i++) {
            System.out.println(ContactBook.get(i).getContact());
        }
    }

    //kollar om en contact finns i arraylistan. Loopar igenom listan o kollar om den hittar match
// och returnerar indexpositionen.
//Skapar ett objekt och kollar om ett likadant object finns.
//return -1 returneras om den inte finns (lägre än 0)
    private int findContactBook(String searchContact) {
        for (int i = 0; i < this.ContactBook.size(); i++) {
            Contact contact = this.ContactBook.get(i);
            if (contact.getContact().equals(searchContact)) {
                return i;
            }
        }
        return -1;
    }
    //Lägger till ny contact, .contains kollar om objectet redan finns i listan.
    public boolean addContactBook(Contact contact) {
        if (ContactBook.contains(Contact)) {
            System.out.println("The contact is already on the list.");
            return false;
        }
        ContactBook.add(contact);
        return true;
    }
    //Tar bort Contact. .contains kollar om den finns, .remove tar bort den.
    public boolean removeContactBook(Contact removedContact) {
        if (ContactBook.contains(removedContact)) {
            ContactBook.remove(removedContact);
            return true;
        } else {
            return false;
        }

    }
}
}
