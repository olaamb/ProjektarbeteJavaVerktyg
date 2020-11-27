package com.ProjektArbeteJavaVerktyg;

import java.io.*;
import java.util.ArrayList;

    public class FileIO {

        public static void write() throws IOException {

            FileOutputStream fileOut = new FileOutputStream("output");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(ContactBook.ContactBook);
            objectOut.close();

        }

        static void read() throws IOException, ClassNotFoundException {

            FileInputStream fileIn = new FileInputStream("output");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ContactBook.ContactBook = (ArrayList <Contact>)objectIn.readObject();
            objectIn.close();

        }
    }
