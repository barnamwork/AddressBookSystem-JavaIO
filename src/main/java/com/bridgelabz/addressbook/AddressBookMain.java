package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        boolean continueAdding = true;

        while (continueAdding) {

            System.out.println("\nEnter Contact Details:");

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

            ContactPerson person = new ContactPerson(firstName, lastName, address,
                    city, state, zip, phone, email);

            addressBook.addContact(person);

            System.out.print("\nDo you want to add another contact? (yes/no): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                continueAdding = false;
            }
        }

        System.out.println("\nAll Contacts:");
        addressBook.displayContacts();

        scanner.close();
    }
}