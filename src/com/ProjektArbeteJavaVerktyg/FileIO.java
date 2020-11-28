package com.ProjektArbeteJavaVerktyg;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileIO {

        private static Scanner fileScanner = new Scanner(System.in);
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
            if (!directory.exists()) {
                directory.mkdir();

            }
        }

        public static void load() throws IOException, ClassNotFoundException {

            System.out.println("Available lists: ");

                try (Stream<Path> walk = Files.walk(Paths.get("SavedLists/"))) {

                List<String> result = walk.filter(Files::isRegularFile).map

                        (Path::toString).collect(Collectors.toList());

                            result.forEach(System.out::println);
                }
                    System.out.println("Type name of file (without SavedLists/)");
                    fileName = fileScanner.nextLine();
                    read();
        }

        public static void write() throws IOException {

                FileOutputStream fileOut = new FileOutputStream("SavedLists/" + fileName);

                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

                objectOut.writeObject(ContactBook.ContactBook);

                objectOut.close();
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

                try { ContactBook.ContactBook = (ArrayList <Contact>)objectIn.readObject(); }

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


    public static void fileOptions() throws IOException, ClassNotFoundException {

            System.out.println("Current file: "+ fileName);

            System.out.println(
                    "1 - Save all changes to current file \n" +
                    "2 - Save all changes to NEW file\n" +
                    "3 - Load existing file\n" +
                    "4 - Back to menu (No changes)");

            int options = fileScanner.nextInt();
            fileScanner.nextLine();

            switch(options)

                {
                case 1:
                    write();
                    break;

                case 2:
                    save();
                    break;

                case 3:
                    load();
                    break;

                case 4:
                    break;
        }
    }
}

