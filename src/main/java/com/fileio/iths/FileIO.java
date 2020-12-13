package com.fileio.iths;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.contactbook.iths.Contact;
import com.contactbook.iths.ContactBook;

public class FileIO {

        private static final Scanner fileScanner = new Scanner(System.in);

        private static String fileName;


    //Sparar en lista med ett namn från scanner.
    //
    public static void save() throws IOException {

            System.out.println("Choose a filename for your ContactList!");
            fileName = fileScanner.nextLine();
            write();
        }

        //Metod som körs vid start för att kolla att mappen för sparade listor finns.
        //Skapar mappen om inte.

    public static void checkDataFiles()  {

        File directory = new File("SavedLists");
        if (!directory.exists()) { directory.mkdir(); }
    }

    public static void load() throws IOException, ClassNotFoundException {

    clearMenu();
    System.out.println("Available files: ");
    System.out.println("══════════════════════════════════");

        try (Stream<Path> fileWalk = Files.walk(Paths.get("SavedLists/"))) {

         List<String> result = fileWalk.filter(Files::isRegularFile).map
         (Path::toString).collect(Collectors.toList());

         result.forEach(System.out::println);
         }
                    System.out.println("\nType name of file (without SavedLists/)");
                    fileName = fileScanner.nextLine();
                    read();
                    clearMenu();

                    }

    public static void write()   {

        FileOutputStream fileOut = null;
        try { fileOut = new FileOutputStream("SavedLists/" + fileName); } catch (FileNotFoundException e)
        { System.out.println("Error while writing to file!");

        }
        ObjectOutputStream objectOut = null;

        try { objectOut = new ObjectOutputStream(fileOut); } catch (IOException e) {
            System.out.println("Error while writing to file!");
        }
        try { objectOut.writeObject(ContactBook.ContactBook); } catch (IOException e) {
            System.out.println("Error while writing contact list to file!");
        }
        try { objectOut.close(); } catch (IOException e) { e.printStackTrace();
        }
    }

    static void read() throws  ClassNotFoundException {

        FileInputStream fileIn;

        try { fileIn = new FileInputStream("SavedLists/" + fileName); } catch (FileNotFoundException e) {
            System.out.println("File not found!");

            return;
            }

                ObjectInputStream objectIn = null;
                try { objectIn = new ObjectInputStream(fileIn); }

                catch (IOException e) {
                    System.out.println("Error! Could not read file!"); }

                try {
                    assert objectIn != null;
                    ContactBook.ContactBook = (ArrayList<Contact>)objectIn.readObject(); }

                    catch (IOException e) {
                        System.out.println("Error! Could not read file!");
                            return; }

                try { objectIn.close(); } catch (IOException e) {
                    e.printStackTrace();
            }
        }

        public static void clearMenu() {
            for (int i = 0; i < 20; ++i) System.out.println();
        }

        public static void messages_Title() {

            System.out.println();
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║     A-Team presents ContactMaster 3000     ║");
            System.out.println("║             Choose menu option             ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println();
    }


        //Sub-meny för hela filsystemet. Kallar på metoderna ovan.
        public static void fileOptions() throws IOException, ClassNotFoundException {

            if (fileName == null) {
                System.out.println("Warning! No file selected. Select option 2 to save contact list.");
            }
                 else  {
                        System.out.println("Current file: "+ fileName);
                 }

            System.out.println("══════════════════════════════════");
            System.out.println(
                    "1 - Save changes to current file \n" +
                    "2 - Save changes to NEW file\n" +
                    "3 - Load existing file\n" +
                    "4 - Back to menu without changes)");

            String options = fileScanner.nextLine();
            fileScanner.nextLine();

            switch(options) {

                case "1":
                    write();
                    break;

                case "2":
                    save();
                    break;

                case "3":
                    load();
                    break;

                case "4":
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
        }
    }
}

