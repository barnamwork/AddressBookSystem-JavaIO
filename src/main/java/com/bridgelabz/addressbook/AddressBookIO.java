package com.bridgelabz.addressbook;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIO {

    private static final String FILE_PATH = "AddressBook.csv";

    public static void writeToCSV(List<ContactPerson> contactList) {

        Path path = Paths.get(FILE_PATH);

        try {
            List<String> lines = contactList.stream()
                    .map(ContactPerson::toCSV)
                    .toList();

            Files.write(path, lines);

            System.out.println("Address Book Written to CSV Successfully!");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    public static List<ContactPerson> readFromCSV() {

        List<ContactPerson> contacts = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return contacts;
        }

        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                String[] parts = line.split(",");

                if (parts.length == 8) {
                    ContactPerson person = new ContactPerson(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            parts[6],
                            parts[7]
                    );

                    contacts.add(person);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        return contacts;
    }
}