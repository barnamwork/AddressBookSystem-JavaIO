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
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
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

                    ContactPerson person = new ContactPerson(firstName, lastName,
                            address, city, state, zip, phone, email);

                    addressBook.addContact(person);
                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter First Name of Contact to Edit: ");
                    String editName = scanner.nextLine();

                    System.out.print("New Address: ");
                    String newAddress = scanner.nextLine();

                    System.out.print("New City: ");
                    String newCity = scanner.nextLine();

                    System.out.print("New State: ");
                    String newState = scanner.nextLine();

                    System.out.print("New Zip: ");
                    String newZip = scanner.nextLine();

                    System.out.print("New Phone: ");
                    String newPhone = scanner.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();

                    addressBook.editContact(editName, newAddress, newCity,
                            newState, newZip, newPhone, newEmail);
                    break;

                case 3:
                    addressBook.displayContacts();
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}