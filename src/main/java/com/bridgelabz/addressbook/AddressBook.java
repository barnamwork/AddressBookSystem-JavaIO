package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<ContactPerson> contactList = new ArrayList<>();

    public void addContact(ContactPerson person) {
        contactList.add(person);
    }

    public void displayContacts() {
        for (ContactPerson person : contactList) {
            System.out.println(person);
        }
    }
}