package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {

    private List<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson person) {

        if (contactList.contains(person)) {
            System.out.println("Duplicate Contact! Entry Not Allowed.");
            return;
        }

        contactList.add(person);
        System.out.println("Contact Added Successfully!");
    }

    public void displayContacts() {
        for (ContactPerson person : contactList) {
            System.out.println(person);
        }
    }

    public void editContact(String firstName, String newAddress, String newCity,
                            String newState, String newZip,
                            String newPhone, String newEmail) {

        for (ContactPerson person : contactList) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                person.setAddress(newAddress);
                person.setCity(newCity);
                person.setState(newState);
                person.setZip(newZip);
                person.setPhone(newPhone);
                person.setEmail(newEmail);
                System.out.println("Contact Updated Successfully!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public void deleteContact(String firstName) {

        Iterator<ContactPerson> iterator = contactList.iterator();

        while (iterator.hasNext()) {
            ContactPerson person = iterator.next();
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                System.out.println("Contact Deleted Successfully!");
                return;
            }
        }

        System.out.println("Contact not found!");
    }

    // UC6 - Search by City
    public void searchByCity(String city) {
        boolean found = false;
        for (ContactPerson person : contactList) {
            if (person.getCity().equalsIgnoreCase(city)) {
                System.out.println(person);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found in this city.");
        }
    }

    // UC6 - Search by State
    public void searchByState(String state) {
        boolean found = false;
        for (ContactPerson person : contactList) {
            if (person.getState().equalsIgnoreCase(state)) {
                System.out.println(person);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found in this state.");
        }
    }
}