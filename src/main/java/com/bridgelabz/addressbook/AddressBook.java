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

        cityMap.computeIfAbsent(person.getCity(), k -> new ArrayList<>()).add(person);
        stateMap.computeIfAbsent(person.getState(), k -> new ArrayList<>()).add(person);

        System.out.println("Contact Added Successfully!");
    }

    public void displayContacts() {
        contactList.forEach(System.out::println);
    }

    // UC9
    public void sortByName() {
        contactList.sort(Comparator.comparing(ContactPerson::getFirstName,
                String.CASE_INSENSITIVE_ORDER));
        System.out.println("Sorted by Name:");
        displayContacts();
    }

    // UC10
    public void sortByCity() {
        contactList.sort(Comparator.comparing(ContactPerson::getCity,
                String.CASE_INSENSITIVE_ORDER));
        System.out.println("Sorted by City:");
        displayContacts();
    }

    public void sortByState() {
        contactList.sort(Comparator.comparing(ContactPerson::getState,
                String.CASE_INSENSITIVE_ORDER));
        System.out.println("Sorted by State:");
        displayContacts();
    }

    public void sortByZip() {
        contactList.sort(Comparator.comparing(ContactPerson::getZip));
        System.out.println("Sorted by Zip:");
        displayContacts();
    }

    public void editContact(String firstName, String newAddress, String newCity,
                            String newState, String newZip,
                            String newPhone, String newEmail) {

        for (ContactPerson person : contactList) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {

                cityMap.get(person.getCity()).remove(person);
                stateMap.get(person.getState()).remove(person);

                person.setAddress(newAddress);
                person.setCity(newCity);
                person.setState(newState);
                person.setZip(newZip);
                person.setPhone(newPhone);
                person.setEmail(newEmail);

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

    public void viewPersonsByCity(String city) {
        List<ContactPerson> list = cityMap.get(city);
        if (list == null || list.isEmpty()) {
            System.out.println("No persons found.");
            return;
        }
        list.forEach(System.out::println);
    }

    public void viewPersonsByState(String state) {
        List<ContactPerson> list = stateMap.get(state);
        if (list == null || list.isEmpty()) {
            System.out.println("No persons found.");
            return;
        }
        list.forEach(System.out::println);
    }

    public void countByCity(String city) {
        List<ContactPerson> list = cityMap.get(city);
        int count = (list == null) ? 0 : list.size();
        System.out.println("Count in City " + city + ": " + count);
    }

    public void countByState(String state) {
        List<ContactPerson> list = stateMap.get(state);
        int count = (list == null) ? 0 : list.size();
        System.out.println("Count in State " + state + ": " + count);
    }
}