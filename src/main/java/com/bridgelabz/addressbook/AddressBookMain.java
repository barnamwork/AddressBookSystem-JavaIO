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
            System.out.println("9. Exit");
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

                case 7:
                    System.out.print("Enter City: ");
                    addressBook.countByCity(scanner.nextLine());
                    break;

                case 8:
                    System.out.print("Enter State: ");
                    addressBook.countByState(scanner.nextLine());
                    break;

                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("Use previous options for other operations.");
            }
        }

        scanner.close();
    }
}