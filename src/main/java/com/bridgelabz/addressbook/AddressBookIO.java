package com.bridgelabz.addressbook;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIO {

    private static final String FILE_PATH = "AddressBook.txt";

    public static void writeToFile(List<ContactPerson> contactList) {

        Path path = Paths.get(FILE_PATH);

        try {
            Files.write(path,
                    contactList.stream()
                            .map(ContactPerson::toString)
                            .toList());

            System.out.println("Address Book Written Successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static List<ContactPerson> readFromFile() {

        List<ContactPerson> contacts = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return contacts;
        }

        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                String[] parts = line.split(", ");

                if (parts.length == 8) {

                    String[] nameParts = parts[0].split(" ");

                    ContactPerson person = new ContactPerson(
                            nameParts[0],
                            nameParts[1],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            parts[6]
                    );

                    contacts.add(person);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return contacts;
    }
}