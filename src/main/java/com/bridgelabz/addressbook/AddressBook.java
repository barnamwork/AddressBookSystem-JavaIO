package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBook {

    private List<ContactPerson> contactList = new ArrayList<>();

    private Map<String, List<ContactPerson>> cityMap = new HashMap<>();
    private Map<String, List<ContactPerson>> stateMap = new HashMap<>();

    public void addContact(ContactPerson person) {

        if (contactList.contains(person)) {
            System.out.println("Duplicate Contact! Entry Not Allowed.");
            return;
        }

        contactList.add(person);

        // Add to city dictionary
        cityMap.computeIfAbsent(person.getCity(), k -> new ArrayList<>())
                .add(person);

        // Add to state dictionary
        stateMap.computeIfAbsent(person.getState(), k -> new ArrayList<>())
                .add(person);

        System.out.println("Contact Added Successfully!");
    }

    public void displayContacts() {
        contactList.forEach(System.out::println);
    }

    public void editContact(String firstName, String newAddress, String newCity,
                            String newState, String newZip,
                            String newPhone, String newEmail) {

        for (ContactPerson person : contactList) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {

                // Remove from old maps
                cityMap.get(person.getCity()).remove(person);
                stateMap.get(person.getState()).remove(person);

                person.setAddress(newAddress);
                person.setCity(newCity);
                person.setState(newState);
                person.setZip(newZip);
                person.setPhone(newPhone);
                person.setEmail(newEmail);

                // Add to new maps
                cityMap.computeIfAbsent(newCity, k -> new ArrayList<>()).add(person);
                stateMap.computeIfAbsent(newState, k -> new ArrayList<>()).add(person);

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

                cityMap.get(person.getCity()).remove(person);
                stateMap.get(person.getState()).remove(person);

                iterator.remove();
                System.out.println("Contact Deleted Successfully!");
                return;
            }
        }

        System.out.println("Contact not found!");
    }

    // UC7 - View Persons by City
    public void viewPersonsByCity(String city) {
        List<ContactPerson> list = cityMap.get(city);
        if (list == null || list.isEmpty()) {
            System.out.println("No persons found in this city.");
            return;
        }
        list.forEach(System.out::println);
    }

    // UC7 - View Persons by State
    public void viewPersonsByState(String state) {
        List<ContactPerson> list = stateMap.get(state);
        if (list == null || list.isEmpty()) {
            System.out.println("No persons found in this state.");
            return;
        }
        list.forEach(System.out::println);
    }
}