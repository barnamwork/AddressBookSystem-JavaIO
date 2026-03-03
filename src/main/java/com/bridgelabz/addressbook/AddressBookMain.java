package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        boolean running = true;

        while (running) {

            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. View Persons by City");
            System.out.println("6. View Persons by State");
            System.out.println("7. Count by City");
            System.out.println("8. Count by State");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by City");
            System.out.println("11. Sort by State");
            System.out.println("12. Sort by Zip");
            System.out.println("13. Write to File");
            System.out.println("14. Read from File");
            System.out.println("15. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("Zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    ContactPerson person = new ContactPerson(firstName, lastName,
                            address, city, state, zip, phone, email);
                    addressBook.addContact(person);
                    break;

                case 13:
                    AddressBookIO.writeToFile(addressBook.getContactList());
                    break;

                case 14:
                    addressBook.loadContacts(AddressBookIO.readFromFile());
                    System.out.println("Address Book Loaded from File!");
                    break;

                case 15:
                    running = false;
                    break;
            }
        }

        scanner.close();
    }
}