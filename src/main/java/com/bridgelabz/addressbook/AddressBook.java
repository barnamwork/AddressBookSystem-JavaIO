package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBook {

    private List<ContactPerson> contactList = new ArrayList<>();
    private Map<String, List<ContactPerson>> cityMap = new HashMap<>();
    private Map<String, List<ContactPerson>> stateMap = new HashMap<>();

    public List<ContactPerson> getContactList() {
        return contactList;
    }

    public void loadContacts(List<ContactPerson> contacts) {
        contactList.clear();
        cityMap.clear();
        stateMap.clear();

        for (ContactPerson person : contacts) {
            addContact(person);
        }
    }

    public void addContact(ContactPerson person) {

        if (contactList.contains(person)) {
            System.out.println("Duplicate Contact! Entry Not Allowed.");
            return;
        }

        contactList.add(person);

        cityMap.computeIfAbsent(person.getCity(), k -> new ArrayList<>()).add(person);
        stateMap.computeIfAbsent(person.getState(), k -> new ArrayList<>()).add(person);
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        contactList.forEach(System.out::println);
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
        System.out.println("Count: " + ((list == null) ? 0 : list.size()));
    }

    public void countByState(String state) {
        List<ContactPerson> list = stateMap.get(state);
        System.out.println("Count: " + ((list == null) ? 0 : list.size()));
    }

    public void sortByName() {
        contactList.sort(Comparator.comparing(ContactPerson::getFirstName,
                String.CASE_INSENSITIVE_ORDER));
        displayContacts();
    }

    public void sortByCity() {
        contactList.sort(Comparator.comparing(ContactPerson::getCity,
                String.CASE_INSENSITIVE_ORDER));
        displayContacts();
    }

    public void sortByState() {
        contactList.sort(Comparator.comparing(ContactPerson::getState,
                String.CASE_INSENSITIVE_ORDER));
        displayContacts();
    }

    public void sortByZip() {
        contactList.sort(Comparator.comparing(ContactPerson::getZip));
        displayContacts();
    }
}