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

        //Denna strängen är den som styr vilka filer som sparas eller laddas.
        
        private static String fileName;


    //Sparar en lista med ett namn från scanner.
    //Den gör det genom write-metoden som finns längre ned. Skillnaden är bara att den ändrar den statiska stringen fileName.
    public static void save() throws IOException {

            System.out.println("Choose a filename for your ContactList!");
            fileName = fileScanner.nextLine();
            write();
        }

        //Metod som körs vid start för att kolla att mappen för sparade listor finns.
        //Skapar mappen om så inte är fallet.

    public static void checkDataFiles()  {

        File directory = new File("SavedLists");
        if (!directory.exists()) { directory.mkdir(); }
    }

    //Load-metoden, denna metoden läser innehållet i mappen SavedLists.
    //Detta gör den genom files.Walk-utilityn. Innehållet skrivs ut i en sträng.
    //Varje filnamn skrivs ut på ny genom "result.forEach"-delen.
    //Själv laddningen görs av read()-metoden som finns längre ned. Här ändrar man dock filnamn, så att man pekar read() åt rätt håll.
        
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
        
        //write är tillsammans med read ryggraden i klassen. Denna metoden gör själva skrivandet till en fil.
        //FileOutputStream sköter själva filskrivningen. ObjectOutputStream är det som lämnar över information till ovanstående.
        //Hela arraylistan "ContactList" skrivs in i innehållet i råformat. Det blir alltså ingen snygg textfil av filen.
        //objectOut-close "avslutar" filskrivningen.
        //Här finns också try/catch metoder som ska hålla felen i styr.

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

     //read() är filläsningen. Den är som ovanstående metod fast i princip omvänd. Istället för output, så är det input.
     //Innehållet i filen skriver över ContactLists stora Arraylista.
     //Även här finns catch/try för att hålla felen så få som möjligt.
        
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

        //Metod som målar 20 svarta rader. Det blir svårt att få översikt över den här funktionen om skärmen inte rensas först.
        
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
        //Här ligger en if/else-sats som håller koll på om det finns någon sparad fil för arraylistan.
        //Det är också snyggare än att det står "Filename = null" i användargränssnittet
        
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

