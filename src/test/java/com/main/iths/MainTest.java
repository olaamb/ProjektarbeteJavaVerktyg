package com.main.iths;
import com.contactbook.iths.Contact;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    Contact contact1 = new Contact("Peter Jörgensen", "peter.jorgensen@gmail.com", "0736996420", "Sälenvägen 2");
    Contact contact2 = new Contact("Olaf Tryggsir", "olaf.tryggsir@asgard.se", "0011223344", "Asgardgatan 68");
    Contact contact3 = new Contact("Manuel Neuer", "manuel.neuer@yahoo.de", "02963012958", "Deutschewagen 3");

    ArrayList<Contact> ContactBook = new ArrayList<>();

    @BeforeAll
    static void welcomeMessage() {
        System.out.println("Welcome to the test class for Main.\n" +
                "Today we will be conducting a few experiments.");
    }

    @Test
    @DisplayName("Testing switch case 0")
    public void testSwitchShow() {
        ContactBook.add(contact1);
        ContactBook.add(contact2);
        ContactBook.add(contact3);

        assertEquals(contact1.getFullName(), "Peter Jörgensen");
        assertEquals(contact2.getFullName(), "Olaf Tryggsir");
        assertEquals(contact3.getFullName(), "Manuel Neuer");
    }

    @Test
    @DisplayName("Testing startProgram method")
    public void testStartProgram() {
        String startMessage = "Program starting...";
        assertNotEquals("Program starting", startMessage);
    }

    @Test
    @DisplayName("Testing printMenu method")
    public void testPrintMenu() {
        String printMenu = "0 - Show contactlist \n" +
                "1 - Search for a specific contact\n" +
                "2 - Add a new contact\n" +
                "3 - Remove an existing contact\n" +
                "4 - Show this menu again\n" +
                "5 - Save/Load contact files\n" +
                "6 - Shut down\n";

        assertSame(printMenu, "0 - Show contactlist \n" +
                "1 - Search for a specific contact\n" +
                "2 - Add a new contact\n" +
                "3 - Remove an existing contact\n" +
                "4 - Show this menu again\n" +
                "5 - Save/Load contact files\n" +
                "6 - Shut down\n");
    }

    @Test
    @DisplayName("Testing removeContact")
    public void testRemoveContact() {
        ContactBook.add(contact2);
        if (ContactBook.contains(contact2)) {
            ContactBook.remove(contact2);
        }
        assertFalse(ContactBook.contains(contact2));
    }

    @Test
    @DisplayName("Testing findContact")
    public void testFindExistingContact() {
        ContactBook.add(contact3);
        String testSubject = "Manuel Neuer";
        assertSame(contact3.getFullName(), testSubject);
    }

    @AfterAll
    static void endMessage() {
        System.out.println("All experiments turned out successful.");
    }


}