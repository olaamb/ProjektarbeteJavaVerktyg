package com.ProjektArbeteJavaVerktyg;

import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.*;
import java.io.Serializable;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class FileIOTest implements Serializable{

    static char getRandom() {
        return (char) (Math.random() * 26 + 'A');
    }

    public String randomChar = "Test " + getRandom();

    public static File TestData = new File("TestData");

    private static String ExpectedFile = "ExpectedFile.txt";

    private static String ActualFile = null;

    private static ArrayList<Contact> TestContactBook = new ArrayList<>();

    Contact TempContact = new Contact("Test Testson", "test@test.cjb.net" , "00112233" , "1 Test Street");

    Contact TempContact_R = new Contact(randomChar, randomChar , randomChar , randomChar);

    @Test
    @Order(0)
    @DisplayName("Running test")
    void StartTest() {
    }

    @Test
    @Order(1)
    @DisplayName("Checking Test file directory")
    void checkDataFiles() {

        File directory = new File(String.valueOf(TestData));
        if (!directory.exists()) {
            directory.mkdir();
        }
        assertTrue(FileUtils.fileExists("TestData"));
    }

    @Test
    @Order(2)
    @DisplayName("Testing file writer!")

    void write() throws IOException {

        // Lägger till två kontakter i arraylistan.
        //

        TestContactBook.add(TempContact);

        System.out.println("Added test contact info:");
        System.out.println ("\nEmail: "+(TestContactBook.get(0).getEmail() +
                            "\nName: "+TestContactBook.get(0).getFullName() +
                            "\nPhone: "+TestContactBook.get(0).getPhoneNumber() +
                            "\nAdress: "+TestContactBook.get(0).getAddress()));

        TestContactBook.add(TempContact_R);
        System.out.println("\nAdded test contact with random char:");
        System.out.println ("\nEmail: "+ (TestContactBook.get(1).getEmail() +
                            "\nName: "+ TestContactBook.get(1).getFullName() +
                            "\nPhone: "+ TestContactBook.get(1).getPhoneNumber() +
                            "\nAdress: "+ TestContactBook.get(1).getAddress()));

        ActualFile = "" + randomChar;

        FileOutputStream fileOut_A = new FileOutputStream("TestData/" + ExpectedFile);

            ObjectOutputStream objectOutExpected = new ObjectOutputStream(fileOut_A);
            objectOutExpected.writeObject(TestContactBook);
            objectOutExpected.close();

        FileOutputStream fileOut_B = new FileOutputStream("TestData/" + ActualFile);

            ObjectOutputStream objectOutActual = new ObjectOutputStream(fileOut_B);
            objectOutActual.writeObject(TestContactBook);
            objectOutActual.close();

        System.out.println("\nContact List file generated: "+ ExpectedFile);
        System.out.println("\nContact List file"+ ActualFile);
    }

    @Test
    @Order(3)
    @DisplayName("Testing file reader and matching contents")

    void read() throws IOException, ClassNotFoundException {

        // Här skrivs kontaktlistan/arraylisten över till en tillfällig klon.
        // Sedan laddar vi in den genererad filen i TestContaktbook.
        // Om "temp" stämmer överens med TestContactBook så vet vi att filen läses korrekt.
        // Samt att filen sparar det den skall.

        ArrayList<Contact> Temp = (ArrayList) TestContactBook.clone();

        FileInputStream fileIn;

        fileIn = new FileInputStream("TestData/" + ActualFile);

        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Kollar första kontakten i arraylistan. Stämmer den i filen och den i minnet överens?

            TestContactBook = (ArrayList <Contact>)objectIn.readObject();

            assertEquals(TestContactBook.get(0).getEmail(), Temp.get(0).getEmail());

            assertEquals(TestContactBook.get(0).getAddress(), Temp.get(0).getAddress());

            assertEquals(TestContactBook.get(0).getFullName(), Temp.get(0).getFullName());

            assertEquals(TestContactBook.get(0).getPhoneNumber(), Temp.get(0).getPhoneNumber());

            // Kollar andra kontakten i arraylistan. Stämmer den i filen och den i minnet överens?

            assertEquals(TestContactBook.get(1).getEmail(), Temp.get(1).getEmail());

            assertEquals(TestContactBook.get(1).getAddress(), Temp.get(1).getAddress());

            assertEquals(TestContactBook.get(1).getFullName(), Temp.get(1).getFullName());

            assertEquals(TestContactBook.get(1).getPhoneNumber(), Temp.get(1).getPhoneNumber());


            //Jämför två likadana filer med olika namn , då vet vi att den skriver rätt och konsekvent.

            assertEquals(FileUtils.fileRead("TestData/" + ExpectedFile, "utf-8"),

            (FileUtils.fileRead("TestData/" + ActualFile, "utf-8")));

    }

    //Spara till ny fil-funktionen. Vi ändrar filnamnsvariablen till ett nytt namn.
    //Kör sedan write()-metoden - vips! Ny fil, fast med annat namn.

    @Test
    @Order(4)
    @DisplayName("Save with filename TestSaveFunction - OK!")
    void save() throws IOException {

        ExpectedFile = "TestSaveFunction";
        write();

    }

    //Testar att ladda den nya filen vi sparat. Kör samma process som i read.
    //Denna gången med nya filnamn. Sedan stämmer vi av den nya filen mot en av de tidigare.
    //dom borde vara likadana inuti - fast ha olika filnamn.

    @Test
    @Order(5)
    @DisplayName("Load filename TestSaveFunction - OK!")

    void load() throws IOException, ClassNotFoundException {

        ActualFile = "TestSaveFunction";

        FileInputStream fileIn;
        fileIn = new FileInputStream("TestData/" + ActualFile);

        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        TestContactBook = (ArrayList <Contact>)objectIn.readObject();

        assertEquals(FileUtils.fileRead("TestData/" + "TestSaveFunction", "utf-8"),

        (FileUtils.fileRead("TestData/" + ActualFile, "utf-8")));

    }

    //Testet är slut, dumpar alla filer som skapats under testet.

    @Test
    @Order(6)
    @DisplayName("Test complete! Purging test files")
    void TestComplete() throws IOException {

        FileUtils.deleteDirectory("TestData");
    }
}