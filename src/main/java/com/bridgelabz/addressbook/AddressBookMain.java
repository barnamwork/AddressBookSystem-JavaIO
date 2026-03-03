package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        System.out.println("Enter Contact Details:");

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

        System.out.println("\nContact Added Successfully!");
        addressBook.displayContacts();

        scanner.close();
    }
}