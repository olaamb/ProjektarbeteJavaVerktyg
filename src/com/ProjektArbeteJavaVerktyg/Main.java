package com.ProjektArbeteJavaVerktyg;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static final ContactBook contactBook = new ContactBook(); // uppdatera när alla klasser finns

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean quit = false;
        startProgram();

        while (!quit) {

            FileIO.messages_Title();
            printMenu();

            System.out.println("Press 4 to show this menu  again.");

            int option = scan.nextInt();
            scan.nextLine();


            switch (option) {
                case 0:
                    contactBook.showContactBook(); // uppdatera när alla klasser finns
                    break;

                case 1:
                    findExistingContact(); // uppdatera när alla klasser finns
                    break;
                case 2:
                    addNewContact(); // uppdatera när alla klasser finns
                    break;

                case 3:
                    removeContact(); // uppdatera när alla klasser finns
                    break;
                case 4:
                    printMenu();
                    break;

                case 5:
                    FileIO.clearMenu();
                    FileIO.fileOptions();
                    break;

                case 6:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
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
                        "0 - Show contactlist \n" +
                        "1 - Search for a specific contact\n" +
                        "2 - Add a new contact\n" +
                        "3 - Remove an existing contact\n" +
                        "4 - Show this menu again\n" +
                        "5 - Save/Load contact files\n" +
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

        if (contactBook.addContactBook(contactInfo)) {
            System.out.println("A new contact has been added!");
        } else {
            System.out.println("The contact already exists.");
        }
    }

    // ej klar

    public static void findExistingContact() {
        System.out.println("Write the full name of the contact you'd like to find.");
        String contactName = scan.nextLine();

    }

    public static void removeContact() { // fixa
        System.out.println("Write the full name of the contact you'd like to remove");
        String contactRemoval = scan.nextLine();

        Contact removeContact = contactBook.queryContact(contactRemoval);

        if (contactBook.removeContactBook(removeContact)) {
            System.out.println("The contact " + contactRemoval + " has been removed!");
        } else {
            System.out.println("Couldn't remove the movie");
        }

    }
}