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
            System.out.println("13. Write Address Book to File");
            System.out.println("14. Exit");
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

                case 2:
                    System.out.print("Enter First Name to Edit: ");
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
                    System.out.print("Enter First Name to Delete: ");
                    addressBook.deleteContact(scanner.nextLine());
                    break;

                case 4:
                    addressBook.displayContacts();
                    break;

                case 5:
                    System.out.print("Enter City: ");
                    addressBook.viewPersonsByCity(scanner.nextLine());
                    break;

                case 6:
                    System.out.print("Enter State: ");
                    addressBook.viewPersonsByState(scanner.nextLine());
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
                    addressBook.sortByName();
                    break;

                case 10:
                    addressBook.sortByCity();
                    break;

                case 11:
                    addressBook.sortByState();
                    break;

                case 12:
                    addressBook.sortByZip();
                    break;

                case 13:
                    AddressBookIO.writeToFile(addressBook.getContactList());
                    break;

                case 14:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}