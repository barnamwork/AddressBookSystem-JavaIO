package com.bridgelabz.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

            System.out.println("Address Book Written to File Successfully!");
            System.out.println("File Location: " + path.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}