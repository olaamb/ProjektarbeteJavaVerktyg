package com.main.iths;
import com.contactbook.iths.Contact;
import com.contactbook.iths.ContactBook;
import com.fileio.iths.FileIO;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Skapar  scanner  för att mata in data
    // Skapar instans av ContactBook så det går använda dens metoder i main-klassen
    private static final Scanner scan = new Scanner(System.in);
    private static final ContactBook contactBook = new ContactBook();
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        boolean quit = false;
        startProgram();
        while (!quit) {
            
            FileIO.messages_Title();
            printMenu();
            System.out.println("Press 4 to show this menu  again.");
            
            // switch-sats som tar hand om inmatning av data och visar menyn
            String option = scan.nextLine();
            switch (option) {
                case "0":
                    contactBook.showContactBook();
                    break;
                case "1":
                    addNewContact();
                    break;
                case "2":
                    findExistingContact();
                    break;
                case "3":
                    removeContact();
                    break;
                case "4":
                    FileIO.clearMenu();
                    FileIO.fileOptions();
                    break;
                case "5":
                    printMenu();
                    break;
                case "6":
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                default:
                    System.out.println("Something went wrong here. Just type the number of the action you want to do.");
            }
        }
        FileIO.write();
    }
    private static void startProgram() {
        FileIO.checkDataFiles();
        System.out.println("Program starting...");
    }
    private static void printMenu() {
        System.out.println(
                "0 - Show contacts \n" +
                        "1 - Add a new contact\n" +
                        "2 - Search for a specific contact\n" +
                        "3 - Remove an existing contact\n" +
                        "4 - Save/Load contact files\n" +
                        "5 - Show this menu again\n" +
                        "6 - Shut down\n");
    }
    public static void addNewContact() {
        System.out.println("Write the full name of the contact: ");
        String contactName = scan.nextLine();
        System.out.println("Write the email");
        String contactEmail = scan.nextLine();
        System.out.println("Write the phone number");
        String contactNumber = scan.nextLine();
        System.out.println("Write the full address");
        String contactAddress = scan.nextLine();
        
        Contact contactInfo = new Contact(contactName, contactEmail, contactNumber, contactAddress);
        // Kallar efter addContactBook i ContactBook-klassen och skickar in contactInfo
        // metoden avgör sen om det redan finns ett identitisk kontakt, om inte så läggs den in som ny kontakt.
        if (contactBook.addContactBook(contactInfo)) {
            System.out.println("A new contact has been added!");
        } else {
            System.out.println("The contact already exists.");
        }
    }
    public static void removeContact() {
        System.out.println("Write the full name of the contact you'd like to remove");
        String contactRemoval = scan.nextLine();
        Contact removeContact = contactBook.queryContact(contactRemoval);
        
        // kallar efter removeContactBook i ContactBook-klassen och skickar med removeContact
        // metoden avgör om det finns en kontakt med identisk namn med contains, om den gör det så tas den bort mha remove
        if (contactBook.removeContactBook(removeContact)) {
            System.out.println("The contact " + contactRemoval + " has been removed!");
        } else {
            System.out.println("Couldn't remove the contact");
        }
    }
    
    public static void findExistingContact() {
        System.out.println("Write the full name of the contact you'd like to find.");
        String contactName = scan.nextLine();
        // kallar efter searchContact i ContactBook-klassen och skickar med contactName strängen
        // metoden looper igenom hela arraylistan och kollar om ett identisk namn finns. 
        // Hittar den det så skrivs hela kontakten ut med relevant information
        contactBook.searchContact(contactName);
    }
}
